package com.zte.mcrm.compSearch.access.compSearch.vo;

/**
 * 类 编 号：
 * 类 名 称：CompSearchVO2
 * 内容摘要：综合查询VO--旧VO，不再使用
 * 完成日期：2015-12-30
 * 编码作者：JohnnyHuang
 */
public class CompSearchVO2 {
	private String infoId;//信息ID
	private String infoType;//信息类型
	private String infoCode;//信息类型
	private String infoName;//信息名称
	private String deptId;//所属代表处
	private String infoDeptName;//所属代表处
	private String attr1;
	/**
	 * 客户-客户类型(如 运营商)
		线索-客户类型（如 运营商）
		商机-客户类型(如 运营商)
		项目-客户类型（如 政企网）
	 */
	private String attr2;
	/**
	 * 客户-所在国家地区(如美国)
		线索-销售模式（如 直销）
		商机-销售模式（如 直销）
		项目-销售模式(如 直销)
	 */
	private String attr3;
	/**
	 * 客户-客户状态(如 审核通过)
		线索-状态（如 待分配）
		商机-状态（如 草稿）
		项目-项目审批状态(如 项目进行中)
	 */
	private String ObjectStatus;
	private String lpdDate;//最后更新时间
	private String reverse1;//是否子商机、子项目群
	/**
	 * 业务进展红黄绿灯状态
	 * 返回值列表为:
		9-红灯
		6-黄灯
		3-绿灯
		0-灰灯
	 */
	private String reverse2;
	private String reverse3;
	private String reverse4;
	private String reverse5;
	private String myType;
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getInfoCode() {
		return infoCode;
	}
	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getInfoDeptName() {
		return infoDeptName;
	}
	public void setInfoDeptName(String infoDeptName) {
		this.infoDeptName = infoDeptName;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	public String getObjectStatus() {
		return ObjectStatus;
	}
	public void setObjectStatus(String objectStatus) {
		ObjectStatus = objectStatus;
	}
	public String getLpdDate() {
		return lpdDate;
	}
	public void setLpdDate(String lpdDate) {
		this.lpdDate = lpdDate;
	}
	public String getReverse1() {
		return reverse1;
	}
	public void setReverse1(String reverse1) {
		this.reverse1 = reverse1;
	}
	public String getReverse2() {
		return reverse2;
	}
	public void setReverse2(String reverse2) {
		this.reverse2 = reverse2;
	}
	public String getReverse3() {
		return reverse3;
	}
	public void setReverse3(String reverse3) {
		this.reverse3 = reverse3;
	}
	public String getReverse4() {
		return reverse4;
	}
	public void setReverse4(String reverse4) {
		this.reverse4 = reverse4;
	}
	public String getReverse5() {
		return reverse5;
	}
	public void setReverse5(String reverse5) {
		this.reverse5 = reverse5;
	}
	public String getMyType() {
		return myType;
	}
	public void setMyType(String myType) {
		this.myType = myType;
	}


	
	
	
}
