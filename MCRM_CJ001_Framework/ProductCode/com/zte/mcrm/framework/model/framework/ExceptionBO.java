/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_ExceptionBO 
 * 文件名称：ExceptionBO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-11-18
 * 设计文档：XXX
 * 内容摘要：异常返回对象 。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-11-18
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.model.framework;

import java.io.Serializable;

import com.zte.itp.ssb.framework.base.BaseJSON;

/**
 * 类 编 号：BL_PU2010101_ExceptionBO
 * 类 名 称：ExceptionBO
 * 内容摘要：异常返回对象 
 * 完成日期：2014-11-18
 * 编码作者：JohnnyHuang 黄福强
 */
public class ExceptionBO extends BaseJSON implements Serializable
{
	/**
	 * serialVersionUID
	 */
	   private static final long serialVersionUID = 538072049820420491L;
	   /**语言标志L：2052中文1033英文*/
	   public static final String LAN_CHINESE="2052";
	   
	   public static final String LAN_ENGLISH="1033";
	  // 1000服务器内部错误
	   public static final String ERROR_1000="1000";
	  // 999未知的CommandName
	   public static final String ERROR_999="999";
	   //Token失效
	   public static final String ERROR_TOKEN_FAILE="1001";
		///** 是否成功S:true,false */
		public static final String SUCCESS="true";
		public static final String FALSE="false";
		
		//异常信息ID,对应保存在数据库异常表的id
		public static final String ERROR_MSG="该请求操作在服务端出现异常,异常ID为:";

	   
	  /**是否成功S:true,false*/
	   public String S;
		/**输出的消息编码:errorCode*/
	   public String errorCode;
	   
	   /**输出的具体信息提示:errorMsg*/
	   public String errorMsg;

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	
	

}
