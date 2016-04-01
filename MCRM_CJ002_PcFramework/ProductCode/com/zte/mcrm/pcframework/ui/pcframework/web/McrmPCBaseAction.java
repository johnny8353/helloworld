/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2020101_McrmPCBaseAction 
 * 文件名称：McrmPCBaseAction.java
 * 系统编号：100000201191
 * 系统名称：SmartSales智慧销售
 * 组件编号：MCRM_CJ002
 * 组件名称：MCRM_CJ002_PcFramework
 * 设计作者：肖浪JohnnyHuang 黄福强
 * 完成日期：2015-9-28
 * 设计文档：XXX
 * 内容摘要：控制层基类，所有控制层Action均需要继承它来拓展业务。 
 *
 * 修改记录：01
 * 修   改  人：肖浪JohnnyHuang 黄福强
 * 修改日期：2015-9-28
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.pcframework.ui.pcframework.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.util.JSONUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zte.itp.ssb.framework.base.BaseJSONService;
import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.mcrm.framework.business.framework.service.IMcrmExceptionInfoService;
import com.zte.mcrm.framework.model.framework.McrmException;
import com.zte.mcrm.pcframework.common.util.SysPcConst;
import com.zte.mcrm.pcframework.model.pcframework.BasePcBO;

/**
 * 
 * @author JohnnyHuang 黄福强
 *
 */
@Controller("pcBaseAction")
public class McrmPCBaseAction extends BaseJSONService
{
	private static Log log = LogFactory.getLog(McrmPCBaseAction.class);

	//统一异常处理服务
	@Autowired
	private IMcrmExceptionInfoService mcrmExceptionInfoService;

   /**
    * 父类总入口方法
    */
	@Override
	public String doPcCustom(HttpServletRequest request,String requestJsonObject)
	{
		 //请求方法名
		 String actionName=request.getParameter(SysPcConst.ACTION_NAME);
		// 返回值
		String result = null;
		try
		{
			// 公共业务BO,所有的具体业务BO都继承它进行扩展
			BasePcBO baseBO = (BasePcBO) getJavaFromStrJson(BasePcBO.class,requestJsonObject);
			baseBO = (baseBO == null) ? new BasePcBO() : baseBO;
			// 获取Session对象
			HttpSession httpSession = request.getSession(true);
			String lan=(String)httpSession.getAttribute(SysPcConst.SESSION_LAN);
			if(lan==null || "".equals(lan))
			{
				lan=baseBO.getLan();
				lan=(lan==null || "".equals(lan))?SysPcConst.LAN_CHINESE:lan;
				//设置session语言标志
				httpSession.setAttribute(SysPcConst.SESSION_LAN, lan);
			}

				// 请求的服务方法,方法名不能为空
				if (actionName == null || "".equals(actionName))
				{
					baseBO.setKey(SysPcConst.ERROR_CNAME_EMPTY);
					Map<String, Object> jsonMap = getMsgErrorTipMap(baseBO);
					return getGsonStr(jsonMap);
				}
				else
				{
					actionName="do"+actionName;
				}
				// 利用反射处理读取类的方法列表
				Class<?> clss = getClass();
				// 方法列表
				Method[] methods = clss.getDeclaredMethods();
				// 从方法列表中查询是否存在将在调用的方法(注意没有特别考虑重载的情况，业务中不要使用方法重载)
				boolean existMethod = false;
				// 最终确定的调用方法
				Method method = null;
				// 方法参数数组
				Object[] paras = null;

				for (int i = 0; i < methods.length; i++)
				{
					method = methods[i];

					if (method.getName().equals(actionName))
					{
						Class<?>[] parameterTypes = method.getParameterTypes();
						// 参数附值
						paras = new Object[parameterTypes.length];
						int k = 0;
						for (Class<?> clas : parameterTypes)
						{
							if (JSONUtils.getInnerComponentType(clas).equals(
									HttpServletRequest.class))
							{
								paras[k] = request;
							}
							else
							{
								// 如果定义的为控制层自定义的业务BO，那么就再转一次JSON字符串到自定义业务BO对象
								paras[k] = getJavaFromStrJson(clas,requestJsonObject);
							}
							k++;
						}
						existMethod = true;
						break;
					}
				}
				// 存在相应的方法
				if (existMethod)
				{
					result = method.invoke(this, paras).toString();
				}
				else
				{
					// 服务端没有该服务方法
					baseBO.setKey(SysPcConst.ERROR_SERVER_NOCOMMAND);
					// 统一异常界面的路径
					baseBO.setUrl(request.getContextPath()+ SysPcConst.SPLIT_FLAG + SysPcConst.ERROR_VIEW_URL);
					return getGsonStr(getMsgErrorTipMap(baseBO));
				}
		}// try
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		//
		return result;
	}
  
	/**
	 * 请求操作失败后的提示
	 * @param bbo
	 * @return
	 */
	public Map<String,Object> getMsgErrorTipMap(BasePcBO bbo)
	{
		//必需
		String key=bbo.getKey();
		//必需
		String lan=bbo.getLan();
		lan=(lan==null || "".equals(lan))?SysPcConst.LAN_CHINESE:lan;

		//必需
		String actionName=bbo.getActionName();
		//非必需
		String url=bbo.getUrl();

		//获取提示信息
		String messageTip= SysPcConst.getMsgTip(key,lan)+ actionName;
        bbo.setMsgTip(bbo.getMsgTip()+messageTip);
		//组装参数map
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		//操作失败标志false
		jsonMap.put(SysPcConst.IS_SUCCESS,SysPcConst.FALSE);
		//异常编码
		jsonMap.put(SysPcConst.TIP_CODE,key);
		//异常提示信息
		jsonMap.put(SysPcConst.TIP_MSG, bbo.getMsgTip());
		//需要跳转的路径
		jsonMap.put(SysPcConst.TARGET_URL,url);
		//返回
		return jsonMap;
	}
	
	/**
	 * 请求操作成功后的提示
	 * @param bbo
	 * @return
	 */
	public Map<String,Object> getMsgSuccessTipMap(BasePcBO bbo)
	{
		//必需
		String key=bbo.getKey();
		//必需
		String lan=bbo.getLan();
		lan=(lan==null || "".equals(lan))?lan:SysPcConst.LAN_CHINESE;

		//必需
		String actionName=bbo.getActionName();
		//非必需
		String url=bbo.getUrl();

		//获取提示信息
		String messageTip= SysPcConst.getMsgTip(key,lan)+ actionName;

		//组装参数map
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		//操作标志
		jsonMap.put(SysPcConst.IS_SUCCESS,SysPcConst.TRUE);
		//提示编码
		jsonMap.put(SysPcConst.TIP_CODE,key);
		//提示信息
		jsonMap.put(SysPcConst.TIP_MSG, messageTip);
		//需要跳转的路径
		jsonMap.put(SysPcConst.TARGET_URL,url);
		//返回
		return jsonMap;
	}
	
  /**
   * 将json字符串转化为java对象
   * @param clas 需要转化的目标类
   * @param requestJsonObject json字符串
   * @return
   */
	public  Object  getJavaFromStrJson(Class<?> clas ,String requestJsonObject)
	{ 
		 return  GSONUtil.getJavaFromGsonStr(clas,requestJsonObject);
	}
	
    /**
     * 同步控制JSON转换
     * 业务描述：XXX 
     * 作          者：Administrator
     * 完成日期：2014-12-15
     * @param jsonMap
     * @return
     */
    public  String getGsonStr(Object obj)
    {	
    	return GSONUtil.getGsonStr(obj); 	
    }

    /**
     * 统一处理异常情况
     * @param mcrmException
     * @param requestJsonObject
     * @return
     */
    public String pcException(McrmException mcrmException,BasePcBO basePcBO) 
    {  
		String errorJson="";
		BasePcBO bbo=new BasePcBO();
    	try
    	{
    		//
            mcrmException.getMcrmExceptionBO().getMcrmExceptionVO().setCreatedBy(basePcBO.getUserno());
		    mcrmException.getMcrmExceptionBO().getMcrmExceptionVO().setLastUpdatedBy(basePcBO.getUserno());
			 //保存异常信息到数据库表 
		    this.saveExceptionInfo(mcrmException);
		    //异常ID
		    int errorId=mcrmException.getMcrmExceptionBO().getMcrmExceptionVO().getExceptionInfoId();
            bbo.setMsgTip("(ErrorCode:"+errorId+")");
			bbo.setKey(SysPcConst.ERROR_SERVER_FAILE);

			errorJson=getGsonStr(getMsgErrorTipMap(bbo));
    	}
    	catch(Exception ex)
    	{ 
    		ex.printStackTrace();
    		bbo.setMsgTip("(Other error)");
			bbo.setKey(SysPcConst.ERROR_SERVER_FAILE);
			errorJson=getGsonStr(getMsgErrorTipMap(bbo));
    	} 
    	return errorJson;
    }  
	/**
	 * 
	 * 业务描述：保存异常信息 
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-10-14
	 * @param mcrmException
	 * @return
	 */
	private boolean saveExceptionInfo(McrmException mcrmException)
	{
		//保存一条异常信息
		return mcrmExceptionInfoService.saveExceptionInfo(mcrmException.getMcrmExceptionBO());
	}
}
