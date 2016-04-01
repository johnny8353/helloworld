/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：DA_PU2010101_UserLoginLogVO 
 * 文件名称：UserLoginLogVO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJ201
 * 组件名称：MCRM_CJ201_Privilege
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-27
 * 设计文档：MCRM_CJ201_Privilege 权限管理 组件设计模型.cat
 * 内容摘要：登陆日志操作。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-27
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.privilege.access.privilege.vo;

/**
 * 类 编 号：DA_PU2010101_UserLoginLogVO
 * 类 名 称：UserLoginLogVO
 * 内容摘要：登陆日志
 * 完成日期：2014-10-27
 * 编码作者：JohnnyHuang 黄福强
 */
public class UserLoginLogVO
{
	//id
	private int  loginId;
	
	//员工电脑号
    private String empNo;
    //日期
    private String loginDate;
    //启用记录标志
    private String enableFlag;

/**
	 * @return the loginId
	 */
	public int getLoginId()
	{
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(int loginId)
	{
		this.loginId = loginId;
	}

	/**
	 * @return the loginDate
	 */
	public String getLoginDate()
	{
		return loginDate;
	}

	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(String loginDate)
	{
		this.loginDate = loginDate;
	}

	/**
	 * @return the enableFlag
	 */
	public String getEnableFlag()
	{
		return enableFlag;
	}

	/**
	 * @param enableFlag the enableFlag to set
	 */
	public void setEnableFlag(String enableFlag)
	{
		this.enableFlag = enableFlag;
	}

/**
 * @return the empNo
 */
public String getEmpNo()
{
	return empNo;
}

/**
 * @param empNo the empNo to set
 */
public void setEmpNo(String empNo)
{
	this.empNo = empNo;
}
}
