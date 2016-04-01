/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_Organization 
 * 文件名称：Organization.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：ServiceSrc
 * 设计作者：10144901
 * 完成日期：2015年1月27日
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：10144901
 * 修改日期：2015年1月27日
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.basedata.access.dept.vo;

import java.io.Serializable;

/**
 * 类 编 号：BL_PU2010101_Organization
 * 类 名 称：Organization
 * 内容摘要：XXX 
 * 完成日期：2015年1月27日
 * 编码作者：10144901
 */
public class DeptInfoVO implements Serializable
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3897286664343900393L;
	//主键ID
    private String id;
    //创建人
    private String createdBy;
    //更新人
    private String updatedBy;
    //国内/国际 
    private String area;
    //创建时间
    private String createdCalc;
    //
    private String currencyCode;
    //组织全路径
    private String hROrgNamePath;
    //组织全英文路径 
    private String hROrgNamePathEnu;
    //组织名称
    private String name;
    //
    private String organizationBUName;
    //组织编码
    private String organizationNumber;
    //父组织
    private String parentOrganizationName;
    //父组织编码
    private String parentOrganizationNumber;
    //父组织ID
    private String parentOrganizationId;
    //不共享
    private String privateFlag;
    //状态1
    private String status;
    //组织类型
    private String type;
    //更新时间
    private String updatedCalc;
    //ZTE Country
    private String zTECountry;
    //是否业绩归属单位
    private String zTEIsYjtj;
    //组织名称[中文]
    private String zTEOrgCHSName;
    //组织名称[英文]
    private String zTEOrgENUName;
    //当前页
    private int currentPage;
    //页大小
    private int pageSize;
    //总页数
    private int totalPage;
    //保留字段1
    private String reserve1;
    //保留字段2
    private String reserve2;
    //保留字段3
    private String reserve3;
    //保留字段4
    private String reserve4;
    //保留字段5
    private String reserve5;

	public String gethROrgNamePathEnu()
	{
		return hROrgNamePathEnu;
	}

	public void sethROrgNamePathEnu(String hROrgNamePathEnu)
	{
		this.hROrgNamePathEnu = hROrgNamePathEnu;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getUpdatedBy()
	{
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getCreatedCalc()
	{
		return createdCalc;
	}

	public void setCreatedCalc(String createdCalc)
	{
		this.createdCalc = createdCalc;
	}

	public String getCurrencyCode()
	{
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode)
	{
		this.currencyCode = currencyCode;
	}

	public String gethROrgNamePath()
	{
		return hROrgNamePath;
	}

	public void sethROrgNamePath(String hROrgNamePath)
	{
		this.hROrgNamePath = hROrgNamePath;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOrganizationBUName()
	{
		return organizationBUName;
	}

	public void setOrganizationBUName(String organizationBUName)
	{
		this.organizationBUName = organizationBUName;
	}

	public String getOrganizationNumber()
	{
		return organizationNumber;
	}

	public void setOrganizationNumber(String organizationNumber)
	{
		this.organizationNumber = organizationNumber;
	}

	public String getParentOrganizationName()
	{
		return parentOrganizationName;
	}

	public void setParentOrganizationName(String parentOrganizationName)
	{
		this.parentOrganizationName = parentOrganizationName;
	}

	public String getParentOrganizationNumber()
	{
		return parentOrganizationNumber;
	}

	public String getParentOrganizationId()
	{
		return parentOrganizationId;
	}

	public void setParentOrganizationId(String parentOrganizationId)
	{
		this.parentOrganizationId = parentOrganizationId;
	}

	public void setParentOrganizationNumber(String parentOrganizationNumber)
	{
		this.parentOrganizationNumber = parentOrganizationNumber;
	}

	public String getPrivateFlag()
	{
		return privateFlag;
	}

	public void setPrivateFlag(String privateFlag)
	{
		this.privateFlag = privateFlag;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getUpdatedCalc()
	{
		return updatedCalc;
	}

	public void setUpdatedCalc(String updatedCalc)
	{
		this.updatedCalc = updatedCalc;
	}

	public String getzTECountry()
	{
		return zTECountry;
	}

	public void setzTECountry(String zTECountry)
	{
		this.zTECountry = zTECountry;
	}

	public String getzTEIsYjtj()
	{
		return zTEIsYjtj;
	}

	public void setzTEIsYjtj(String zTEIsYjtj)
	{
		this.zTEIsYjtj = zTEIsYjtj;
	}

	public String getzTEOrgCHSName()
	{
		return zTEOrgCHSName;
	}

	public void setzTEOrgCHSName(String zTEOrgCHSName)
	{
		this.zTEOrgCHSName = zTEOrgCHSName;
	}

	public String getzTEOrgENUName()
	{
		return zTEOrgENUName;
	}

	public void setzTEOrgENUName(String zTEOrgENUName)
	{
		this.zTEOrgENUName = zTEOrgENUName;
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

	public String getReserve1()
	{
		return reserve1;
	}

	public void setReserve1(String reserve1)
	{
		this.reserve1 = reserve1;
	}

	public String getReserve2()
	{
		return reserve2;
	}

	public void setReserve2(String reserve2)
	{
		this.reserve2 = reserve2;
	}

	public String getReserve3()
	{
		return reserve3;
	}

	public void setReserve3(String reserve3)
	{
		this.reserve3 = reserve3;
	}

	public String getReserve4()
	{
		return reserve4;
	}

	public void setReserve4(String reserve4)
	{
		this.reserve4 = reserve4;
	}

	public String getReserve5()
	{
		return reserve5;
	}

	public void setReserve5(String reserve5)
	{
		this.reserve5 = reserve5;
	}
}
