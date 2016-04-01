package com.zte.mcrm.project.access.projweekreportlist.vo;
/**   
 * 类 编 号：
 * 类 名 称：ProjWeekReportVO.java
 * 内容摘要：
 * 完成日期：2016-1-20  
 * 编码作者：QunLi
 */
public class ProjWeekReportListVO{
	private String id;//周报行id
	private String createBy;//创家人工号
	private String prjId;//项目Id
	private String prjName;//项目名称
	private String createDate;//创建时间
	private String prjCode;//项目编号
	private String objStatus;//项目状态
	private String prjStatus;//周报状态灯
	private String title;//周报标题
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getPrjCode() {
		return prjCode;
	}
	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}
	public String getObjStatus() {
		return objStatus;
	}
	public void setObjStatus(String objStatus) {
		this.objStatus = objStatus;
	}
	public String getPrjStatus() {
		return prjStatus;
	}
	public void setPrjStatus(String prjStatus) {
		this.prjStatus = prjStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

