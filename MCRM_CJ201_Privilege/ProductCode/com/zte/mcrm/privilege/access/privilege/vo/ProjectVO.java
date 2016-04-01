package com.zte.mcrm.privilege.access.privilege.vo;
/**   
 * 类 编 号：
 * 类 名 称：ProjectVo.java
 * 内容摘要：
 * 完成日期：2016-1-26  
 * 编码作者：QunLi
 */
public class ProjectVO {
	public String id;//Id
	public String parentId;//项目群id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "ProjectVo [id=" + id + ", parentId=" + parentId + "]";
	}
}

