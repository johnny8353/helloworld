/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_BasePcBO 
 * 文件名称：BasePcBO.java
 * 系统编号：100000201191
 * 系统名称：MSM市场营销管理
 * 组件编号：MSM_CJXXX
 * 组件名称：MCRM_CJ002_PcFramework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-9-29
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-9-29
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.pcframework.model.pcframework;

import java.io.Serializable;

/**
 * @author JohnnyHuang 黄福强
 * 
 */
public class BasePcBO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2492163223207441123L;

	//用户登陆帐号
    private String userno;
    //用户密码
    private String passwd;
	//跳转路径
	private String url;
	//请求方法名
	private String actionName;
   //语言标志：2052中文1033英文 
	private String lan;
	//资源文件key
	private String key;
	//资源文件定义的key对应的提示
	private String msgTip;
	
	//分页对象
	private PagePcBO pbo=new PagePcBO();

	public PagePcBO getPbo()
	{
		return pbo;
	}

	public void setPbo(PagePcBO pbo)
	{
		this.pbo = pbo;
	}

	public String getMsgTip()
	{
		return msgTip;
	}

	public String getActionName()
	{
		return actionName;
	}

	public void setActionName(String actionName)
	{
		this.actionName = actionName;
	}

	public void setMsgTip(String msgTip)
	{
		this.msgTip = msgTip;
	}

	public String getKey()
	{
		return key;
	}

	public String getUserno()
	{
		return userno;
	}

	public void setUserno(String userno)
	{
		this.userno = userno;
	}

	public String getPasswd()
	{
		return passwd;
	}

	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getLan()
	{
		return lan;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public void setLan(String lan)
	{
		this.lan = lan;
	}
}
