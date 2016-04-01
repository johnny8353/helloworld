/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_LoginController 
 * 文件名称：LoginController.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJ201
 * 组件名称：MCRM_CJ201_Privilege
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-21
 * 设计文档：MCRM_CJ201_Privilege 权限管理 组件设计模型.cat
 * 内容摘要：登陆相关业务功能。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-21
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.privilege.ui.privilege.web;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.zte.ldap.client.util.IdentityUtil;
import com.zte.mcrm.basedata.access.employee.vo.EmployeeInfoVO;
import com.zte.mcrm.basedata.model.employee.EmployeeInfoBO;
import com.zte.mcrm.framework.common.util.StringUtils;
import com.zte.mcrm.framework.model.framework.FrameMcrmException;
import com.zte.mcrm.framework.model.framework.McrmException;
import com.zte.mcrm.framework.model.framework.McrmExceptionComm;
import com.zte.mcrm.pcframework.common.secure.DecodeAndEncode;
import com.zte.mcrm.pcframework.common.util.SysPcConst;
import com.zte.mcrm.pcframework.ui.pcframework.web.McrmPCBaseAction;

/**
 * 类 编 号：BL_PU2010101_LoginController
 * 类 名 称：LoginController
 * 内容摘要：登陆相关业务功能
 * 完成日期：2014-10-21
 * 编码作者：JohnnyHuang 黄福强
 */
@Controller("loginAction")
public class LoginAction extends McrmPCBaseAction 
{
	private static Log log = LogFactory.getLog(LoginAction.class);
//    * 0000;令牌-验证密码成功
	private final static String LDAP_CHECK_PASS="0000";
//    * 0003-用户不存在  
	private final static String USER_NOT_EXISTS="0003";
//    * 0004-帐号已经冻结 
	private final static String USER_FREEZE="0004";
//    * 0008-密码错误
	private final static String PASSWORD_ERROR="0008";
//    * 0009-该帐号没有访问该应用的权限 
	private final static String NO_ACCESS_AUTH_FOR_USER="0009";
//    * 0006-访问LDAP异常
	private final static String LDAP_EXCEPTION="0006";
//    * 9001-参数值不对
	private final static String PARAM_VAL_ERROR="9001";
//    * 9002-参数个数不匹配
	private final static String PARAM_NUM_ERROR="9002";
	//LDAP返回的提示编码
	private final static String RTN_CODE="code";
	//LDAP返回具体的中文提示信息key
	private final static String ZH_LDAP_TIP="cnMessage";
	//LDAP返回具体的英文提示信息key
	private final static String EN_LDAP_TIP="enMessage";
	
	/**
	 * 登陆
	 */
	public String doLogin(HttpServletRequest request, EmployeeInfoBO loginBO)
	{
		try
		{
			HttpSession userSession = request.getSession(true);
			// 返回对象
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			// 帐户
			String userno = loginBO.getUserno();
			// 密码
			String passwd = loginBO.getPasswd();
			passwd=(passwd==null)?"":passwd;
			// 语言
			String lan = loginBO.getLan();
			lan = (lan == null || "".equals(lan)) ? SysPcConst.LAN_CHINESE:lan;
			// 设置session语言标志
			userSession.setAttribute(SysPcConst.SESSION_LAN, lan);

			//////Ldap验证////////////////////////////////
			// 调用新统一认证包的获取ip的方法来获取调用方的ip
			String strRemoteAddr = com.zte.ldap.client.util.LdapUtil.getClientIP(request);
			log.info("Remote Address=" + strRemoteAddr);
			// 调用新统一认证包的获取令牌的方法来获取调令牌登陆UDS后存在统一认证服务器上的令牌
			String encryptToken = com.zte.ldap.client.util.LdapUtil.getToken(request);// 令牌
			// 密码解密处理
			passwd = new String(DecodeAndEncode.decode(passwd.toCharArray()));
			// 调用Ldap验证方法
			Map<String, String> retCodeMap = checkUser(userno, passwd,strRemoteAddr, encryptToken, "", "Y");
			// 取返回编号
			String rtnCode = retCodeMap.get(RTN_CODE);
			// 按语言环境获取返回提示信息
			String tipMsg = "";
			if (SysPcConst.LAN_CHINESE.equals(lan))
			{
				tipMsg = retCodeMap.get(ZH_LDAP_TIP);
			}
			else
			{
				tipMsg = retCodeMap.get(EN_LDAP_TIP);
			}
			// 验证通过
			if (LDAP_CHECK_PASS.equals(retCodeMap.get(RTN_CODE)))
			{
				// 如果存在UDS帐号，如果该值存在则证明SSO单点已经成功，可以直接进入系统初始化逻辑
				EmployeeInfoBO userSessionBO = initUserInfo(userno);
				if (userSessionBO != null&& !StringUtils.checkStrIsEmpty(userSessionBO.getEmployeeInfoVo().getEmployeeNum8()))
				{
					// 用户初始化成功,记录用户session
					userSession.setAttribute(SysPcConst.SESSION_USER,userSessionBO);
					userSession.setAttribute(SysPcConst.SSO_USER, userno);
					userSession.setAttribute(SysPcConst.USER_ACCOUNT, userno);
					// 记录用户登陆成功日志
					// ...
					loginBO.setUrl(request.getContextPath()+ SysPcConst.SPLIT_FLAG + SysPcConst.INDEX_VIEW_URL);
					loginBO.setKey(SysPcConst.SUCCESS_KEY);
					// 初始化登陆首页
					jsonMap = getMsgSuccessTipMap(loginBO);
				}
				else
				{
					// 用户不存在,转发到用户登陆首页
					loginBO.setUrl(request.getContextPath()+ SysPcConst.SPLIT_FLAG + SysPcConst.LOGIN_VIEW_URL);
					loginBO.setKey(SysPcConst.ERROR_NO_USER);
					jsonMap = getMsgErrorTipMap(loginBO);
				}
			}
			else
			{
				// 先消除session
				this.removeSession(request.getSession(true));
				// 验证不通过,从新返回登陆界面
				// 用户不存在,转发到用户登陆首页
				loginBO.setUrl(request.getContextPath() + SysPcConst.SPLIT_FLAG+ SysPcConst.LOGIN_VIEW_URL);
				loginBO.setKey(SysPcConst.ERROR_TOKEN_FAILE);
				jsonMap = getMsgErrorTipMap(loginBO);
			}
			///////////////
			return getGsonStr(jsonMap);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return pcException(FrameMcrmException.generateMcrmException(McrmExceptionComm.ERROR_LAYER_CONTROLER, this.getClass().getName(), ex), loginBO);
		}
	}

	/**
	 * 注销
	 */
	public String doLogOut(HttpServletRequest request, EmployeeInfoBO loginBO)
	{
		try
		{
			loginBO.setUserno((String)request.getSession(true).getAttribute(SysPcConst.USER_ACCOUNT));
			// 先消除session
			this.removeSession(request.getSession(true));
			// 组装参数map
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			// 操作失败标志false
			jsonMap.put(SysPcConst.IS_SUCCESS, SysPcConst.TRUE);
			// 需要跳转的路径
			jsonMap.put(SysPcConst.TARGET_URL, request.getContextPath()+ SysPcConst.SPLIT_FLAG + SysPcConst.INDEX_VIEW_URL);
			//
			return getGsonStr(jsonMap);
		}
		catch (Exception ex)
		{
			return pcException(FrameMcrmException.generateMcrmException(McrmExceptionComm.ERROR_LAYER_CONTROLER, this.getClass().getName(), ex), loginBO);
		}
	}

   /**
     * 验证用户名和密码
     * 
     * 0000;令牌-验证密码成功
     * 0003-用户不存在  
     * 0004-帐号已经冻结 
     * 0008-密码错误
     * 0009-该帐号没有访问该应用的权限 
     * 0006-访问LDAP异常
     * 9001-参数值不对
     * 9002-参数个数不匹配
     */
    @SuppressWarnings("unchecked")
	private Map<String,String> checkUser(String uid, String pass, String ip, String encryptToken, String mac, String isReturnHtml)
    {
        Map<String,String> map = new HashMap<String,String>();

        String retCode =LDAP_EXCEPTION;//访问LDAP异常

        try
        {
        	/*
        	 * uid:员工工号，必传参数
        	 * pass:密码，必传参数
        	 * ip：客户端IP地址，必传参数
        	 * encryptToken：令牌信息，可传参数
        	 * mac  预留参数，可以为空
        	 * isReturnHtml  指定服务器端返回的提示信息格式，Y返回HTML格式的提示信息，否则返回文本格式的提示信息  
        	 */
            map = IdentityUtil.serverIdentity(uid, pass, ip, encryptToken, "", "Y");
            
            log.debug("LoginAction.checkUser(String,String,HttpServletRequest):retCode=" + "<" + map.get("code") + ">");
        }
        catch (Exception e)
        {
            map.put(RTN_CODE, retCode);//访问LDAP异常
            log.error("LoginAction.checkUser(String,String,HttpServletRequest):error=" + e.toString() + "<" + uid + ">");
        }

        return map;
    }
    /**
     * 用户退出时 使SESSION失效
     */

    private void removeSession(HttpSession session)
    {
        Enumeration sessionNames = session.getAttributeNames();
        String sessionName = "";
        while (sessionNames.hasMoreElements())
        {
            sessionName = (String) sessionNames.nextElement();
            session.removeAttribute(sessionName);
            log.debug(this.getClass().getName() + " session remove object" + sessionName);
        }
        session.invalidate();
    }
    
	/**
	 * 根据登陆帐号初始化用户信息
	 * @param userId
	 * @return
	 */
    private EmployeeInfoBO initUserInfo(String empShortNo) throws McrmException
	{
		EmployeeInfoVO employeeInfoVo = new EmployeeInfoVO();
		employeeInfoVo.setEmployeeNum8(empShortNo);
		//获取用户基本信息
		EmployeeInfoBO emBO=null;//employeeInfoService.getEmployeeInfo(employeeInfoVo);
//		if(emBO!=null && !StringUtils.checkStrIsEmpty(emBO.getEmployeeInfoVo().getIntegrationId()))
//		{
//	        //获取用户权限信息
//			List<BigInteger> userResAuthIds=menuResourceService.queryUserAuthResIdsList(emBO.getEmployeeInfoVo().getIntegrationId());
//			emBO.setUserResAuthIds(userResAuthIds);
//		}
		return emBO;
	}
}
