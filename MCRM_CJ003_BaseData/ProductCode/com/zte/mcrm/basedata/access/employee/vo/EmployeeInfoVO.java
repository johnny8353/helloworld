/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_EmployeeInfoVO 
 * 文件名称：EmployeeInfoVO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：ServiceSrc
 * 设计作者：10144901
 * 完成日期：2015年1月24日
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：10144901
 * 修改日期：2015年1月24日
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.basedata.access.employee.vo;

import java.io.Serializable;

/**
 * 类 编 号：BL_PU2010101_EmployeeInfoVO
 * 类 名 称：EmployeeInfoVO
 * 内容摘要：XXX 
 * 完成日期：2015年1月24日
 * 编码作者：10144901
 */
public class EmployeeInfoVO implements Serializable
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5562096714803957432L;
	//员工主键
	private String id;
	//创建时间
    private String ceatedCalc;
    //创建人
    private String createdBy;
    //修改时间
    private String updatedCalc;
    //修改人
    private String updatedBy;
    //长工号
    private String employeeNum14;
    //短工号
    private String employeeNum8;
    //状态
    private String employmentStatus;
    //中文名
    private String firstName;
    //电脑号
    private String integrationId;
    //英文名
    private String lastName;
    //组织ID
    private String zTEOrganizationId;
    //当前页
    private int currentPage;
    //页大小
    private int pageSize;
    //总页数
    private int totalPage;
    //保留字段1
    private String zteReverse1;
    //保留字段2
    private String zteReverse2;
    //保留字段3
    private String zteReverse3;
    //保留字段4
    private String zteReverse4;
    //保留字段5
    private String zteReverse5;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCeatedCalc()
	{
		return ceatedCalc;
	}

	public void setCeatedCalc(String ceatedCalc)
	{
		this.ceatedCalc = ceatedCalc;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getUpdatedCalc()
	{
		return updatedCalc;
	}

	public void setUpdatedCalc(String updatedCalc)
	{
		this.updatedCalc = updatedCalc;
	}

	public String getUpdatedBy()
	{
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	public String getEmployeeNum14()
	{
		return employeeNum14;
	}

	public void setEmployeeNum14(String employeeNum14)
	{
		this.employeeNum14 = employeeNum14;
	}

	public String getEmployeeNum8()
	{
		return employeeNum8;
	}

	public void setEmployeeNum8(String employeeNum8)
	{
		this.employeeNum8 = employeeNum8;
	}

	public String getEmploymentStatus()
	{
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus)
	{
		this.employmentStatus = employmentStatus;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getIntegrationId()
	{
		return integrationId;
	}

	public void setIntegrationId(String integrationId)
	{
		this.integrationId = integrationId;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getzTEOrganizationId()
	{
		return zTEOrganizationId;
	}

	public void setzTEOrganizationId(String zTEOrganizationId)
	{
		this.zTEOrganizationId = zTEOrganizationId;
	}

	public String getZteReverse1()
	{
		return zteReverse1;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	public void setZteReverse1(String zteReverse1)
	{
		this.zteReverse1 = zteReverse1;
	}

	public String getZteReverse2()
	{
		return zteReverse2;
	}

	public void setZteReverse2(String zteReverse2)
	{
		this.zteReverse2 = zteReverse2;
	}

	public String getZteReverse3()
	{
		return zteReverse3;
	}

	public void setZteReverse3(String zteReverse3)
	{
		this.zteReverse3 = zteReverse3;
	}

	public String getZteReverse4()
	{
		return zteReverse4;
	}

	public void setZteReverse4(String zteReverse4)
	{
		this.zteReverse4 = zteReverse4;
	}

	public String getZteReverse5()
	{
		return zteReverse5;
	}

	public void setZteReverse5(String zteReverse5)
	{
		this.zteReverse5 = zteReverse5;
	} 
}
