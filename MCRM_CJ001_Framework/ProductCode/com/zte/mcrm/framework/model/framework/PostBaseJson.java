/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_PostBaseJson 
 * 文件名称：PostBaseJson.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-11-17
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-11-17
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.model.framework;

import java.io.Serializable;

/**
 * 类 编 号：BL_PU2010101_PostBaseJson
 * 类 名 称：PostBaseJson
 * 内容摘要：XXX 
 * 完成日期：2014-11-17
 * 编码作者：JohnnyHuang 黄福强
 */
public class PostBaseJson implements Serializable
{
   //服务方法名
   public static final String COMMAND_NAME="C";
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7972299924520854855L;
	//服务方法值
	private String C;
	/**
	 * @return the c
	 */
	public String getC()
	{
		return C;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(String c)
	{
		C = c;
	}

}
