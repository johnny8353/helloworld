/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_SysConst 
 * 文件名称：SysConst.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-13
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-13
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.pcframework.common.util;

import com.zte.mcrm.framework.common.run.ConfigResource;

/**
 * 类 编 号：BL_PU2010101_SysConst
 * 类 名 称：SysPcConst
 * 内容摘要：系统PC端常量Key定义在该常量类 
 * 完成日期：2014-10-13
 * 编码作者：JohnnyHuang 黄福强
 */
public class SysPcConst 
{
	public static final String YES="Y";
	public static final String NO="N";
	public static final String NO_SESSION="/nosession/";
	public static final String SPLIT_FLAG="/";
	public static final String ZH_SYS_FILE="pcserver_resource_ZH.properties";
	public static final String EN_SYS_FILE="pcserver_resource_EN.properties";
	public static final String SESSION_LAN="lan";
	/** 语言标志L：2052中文1033英文 */
	public static final String LAN_CHINESE = "2052";
	/** 语言标志L：2052中文1033英文 */
	public static final String LAN_ENGLISH = "1033";
	/** 语言标志L：2052,1033中文,英文适用于邮件发送语言判断 */
	public static final String LAN_ZH_EN="2052,1033";
	//效验开关打开
	public static final String HAVE_FILTER_FLAG="Y";
	// /** 是否成功S:true,false */
	public static final String IS_SUCCESS = "success";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	//操作成功key
	public static final String SUCCESS_KEY="0000";
	/** 异常信息 **/
	// 服务器内部错误
	public static final String ERROR_SERVER_FAILE = "1000";
	// 帐户或密码不正确
	public static final String ERROR_TOKEN_FAILE = "1001";
	//不存在该用户信息
	public static final String ERROR_NO_USER="1002";
	//客户端没有传入方法名
	public static final String ERROR_CNAME_EMPTY="1005";
	//服务端无该服务方法
	public static final String ERROR_SERVER_NOCOMMAND = "1006";
	//亲，你还没有权限操作该功能哦，请向该系统管理员申请该功能的操作权限。
	public static final String ERROR_NOT_AUTH="1007";
	// 提示编码
	public static final String TIP_CODE = "code";
	// 描述
	public static final String TIP_MSG = "msg";

	//跳转路径标志
	public static final String TARGET_URL="url";
	//登陆界面
	public static final String LOGIN_VIEW_URL="app/login.jsp";
	//系统首页
	public static final String INDEX_VIEW_URL="app/index.jsp";
	//异常提示界面
	public static final String ERROR_VIEW_URL="app/error.jsp";
	//登陆用户对象key
	public static final String SESSION_USER="SESSION_USER";
	//用户登陆帐号
	public static final String USER_ACCOUNT="USER_ACCOUNT";
	//UDS的帐号key
	public static final String SSO_USER="SsoUser";
	//请求方法
	public static final String ACTION_NAME="actionName";
	
	/**
	 * 从配置文件获取提示信息
	 * @param key
	 * @param lan
	 * @return
	 */
	public static String getMsgTip(String key,String lan)
	{
		String msgTip=null;
		lan=(!LAN_CHINESE.equals(lan) || !LAN_ENGLISH.equals(lan))?LAN_CHINESE:lan;
		if(SysPcConst.LAN_CHINESE.equals(lan))
		{
			msgTip=ConfigResource.getInstance().getZhSysResourceConfig().getProperty(key);
		}
		else
		{
			msgTip=ConfigResource.getInstance().getEnSysResourceConfig().getProperty(key);
		}
		return msgTip;
	}
}
