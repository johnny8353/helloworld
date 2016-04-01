/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：DA_PU2010101_MenuResourceVO 
 * 文件名称：MenuResourceVO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJ201
 * 组件名称：MCRM_CJ201_Privilege
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-26
 * 设计文档：MCRM_CJ201_Privilege 权限管理 组件设计模型.cat
 * 内容摘要：菜单资源VO。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-10-26
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.privilege.access.privilege.vo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 类 编 号：DA_PU2010101_MenuResourceVO
 * 类 名 称：MenuResourceVO
 * 内容摘要：菜单资源VO
 * 完成日期：2015-10-26
 * 编码作者：JohnnyHuang 黄福强
 */
public class MenuResourceVO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9065042959797359732L;

//	ID	ID	序号	BIGINT	TRUE	FALSE	TRUE
	private BigInteger id;
//	RESOURCE_ID	RESOURCE_ID	资源ID	BIGINT	FALSE	FALSE	FALSE
	private BigInteger resourceId;
//	RESOURCE_NAME	RESOURCE_NAME	名称	VARCHAR(100)	FALSE	FALSE	TRUE
	private String resourceName;
//	MENU_SORT	MENU_SORT	排序	int(10)	FALSE	FALSE	FALSE
	private int menuSort;
//	URL	URL	绑定路径	VARCHAR(200)	FALSE	FALSE	FALSE
	private String url;
//	菜单层级	MENU_LEVEL	菜单层级目前只有 1 、2、3级菜单	int(5)	FALSE	FALSE	FALSE
	private int menuLevel;
//	RESOURCE_TYPE	RESOURCE_TYPE	资源类型：M:菜单;F:功能;V:页面	VARCHAR(30)	FALSE	FALSE	TRUE
	private String resourceType;

//	是否需要效验Session	NEED_SESSOION_FLAG	是否需要效验Session(Y:需要,N:不需要)	VARCHAR(1)	FALSE	FALSE	FALSE
	private String needSessionFlag;
//	PARENT_RES_ID	PARENT_RES_ID	父资源标识符	BIGINT	FALSE	FALSE	FALSE
	private String parentResId;
//	CREATED_BY	CREATED_BY	创建人	VARCHAR(100)	FALSE	FALSE	TRUE
	private String createdBy;
//	CREATED_DATE	CREATED_DATE	创建时间	TIMESTAMP	FALSE	FALSE	TRUE
	private String createdDate;
//	LAST_UPDATED_BY	LAST_UPDATED_BY	最后修改人	VARCHAR(100)	FALSE	FALSE	TRUE
	private String lastUpdatedBy;
//	LAST_UPDATED_DATE	LAST_UPDATED_DATE	最后修改时间	TIMESTAMP	FALSE	FALSE	TRUE
	private String lastUpdatedDate;
//	ENABLE_FLAG	ENABLE_FLAG	记录是否可用(Y:可用,N:禁用)	VARCHAR(1)	FALSE	FALSE	FALSE
	private String enableFlag;
//	父项ID串，比如：3006432的父项是：3006428,3000880	PARENT_IDS	父项ID串，比如：3006432的父项是：3006428,3000880	VARCHAR(500)	FALSE	FALSE	FALSE
	private String parentIds;
	//	RESOURCE_NAME_EN	RESOURCE_NAME_EN	菜单英文名	VARCHAR(100)	FALSE	FALSE	FALSE
	private String resourceNameEn;
//	MEMO	MEMO	备注	VARCHAR(200)	FALSE	FALSE	FALSE
	private String memo;
	public BigInteger getId()
	{
		return id;
	}
	public void setId(BigInteger id)
	{
		this.id = id;
	}
	public BigInteger getResourceId()
	{
		return resourceId;
	}
	public void setResourceId(BigInteger resourceId)
	{
		this.resourceId = resourceId;
	}
	public String getResourceName()
	{
		return resourceName;
	}
	public void setResourceName(String resourceName)
	{
		this.resourceName = resourceName;
	}
	public int getMenuSort()
	{
		return menuSort;
	}
	public void setMenuSort(int menuSort)
	{
		this.menuSort = menuSort;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public int getMenuLevel()
	{
		return menuLevel;
	}
	public void setMenuLevel(int menuLevel)
	{
		this.menuLevel = menuLevel;
	}
	public String getResourceType()
	{
		return resourceType;
	}
	public void setResourceType(String resourceType)
	{
		this.resourceType = resourceType;
	}

	public String getNeedSessionFlag()
	{
		return needSessionFlag;
	}
	public void setNeedSessionFlag(String needSessionFlag)
	{
		this.needSessionFlag = needSessionFlag;
	}
	public String getParentResId()
	{
		return parentResId;
	}
	public void setParentResId(String parentResId)
	{
		this.parentResId = parentResId;
	}
	public String getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	public String getCreatedDate()
	{
		return createdDate;
	}
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}
	public String getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy)
	{
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public String getLastUpdatedDate()
	{
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate)
	{
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getEnableFlag()
	{
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag)
	{
		this.enableFlag = enableFlag;
	}
	public String getParentIds()
	{
		return parentIds;
	}
	public void setParentIds(String parentIds)
	{
		this.parentIds = parentIds;
	}
	public String getResourceNameEn()
	{
		return resourceNameEn;
	}
	public void setResourceNameEn(String resourceNameEn)
	{
		this.resourceNameEn = resourceNameEn;
	}
	public String getMemo()
	{
		return memo;
	}
	public void setMemo(String memo)
	{
		this.memo = memo;
	}
	
}
