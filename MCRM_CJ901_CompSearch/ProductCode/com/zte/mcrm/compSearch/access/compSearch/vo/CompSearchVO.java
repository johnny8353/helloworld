package com.zte.mcrm.compSearch.access.compSearch.vo;

/**
 * 类 编 号：
 * 类 名 称：CompSearchVO
 * 内容摘要：综合查询VO--旧VO，不再使用
 * 完成日期：2015-12-30
 * 编码作者：JohnnyHuang
 */
public class CompSearchVO {
	private String bizId;//infoId;//信息ID
	private String type;//infoType;//信息类型
	private String infoCode;//信息类型
	private String attr1;//infoName;//信息名称
	private String deptId;//所属代表处
	private String attr2;//infoDeptName;//所属代表处
	private String attr3;//attr1;
	/**
	 * 客户-客户类型(如 运营商)
		线索-客户类型（如 运营商）
		商机-客户类型(如 运营商)
		项目-客户类型（如 政企网）
	 */
	private String attr4;//attr2;
	/**
	 * 客户-所在国家地区(如美国)
		线索-销售模式（如 直销）
		商机-销售模式（如 直销）
		项目-销售模式(如 直销)
	 */
	private String attr5;//attr3;
	/**
	 * 客户-客户状态(如 审核通过)
		线索-状态（如 待分配）
		商机-状态（如 草稿）
		项目-项目审批状态(如 项目进行中)
	 */
	private String attr6;//ObjectStatus;
	private String lpdDate;//最后更新时间
	private String groupFlag;//reverse1;//是否子商机、子项目群
	/**
	 * 业务进展红黄绿灯状态
	 * 返回值列表为:
		9-红灯
		6-黄灯
		3-绿灯
		0-灰灯
	 */
	private String objectStatus;//reverse2;
//	private String reverse3;
//	private String reverse4;
//	private String reverse5;
	private String myType;

	
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfoCode() {
		return infoCode;
	}
	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
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
	public String getAttr4() {
		return attr4;
	}
	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}
	public String getAttr5() {
		return attr5;
	}
	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}
	public String getAttr6() {
		return attr6;
	}
	public void setAttr6(String attr6) {
		this.attr6 = attr6;
	}
	public String getLpdDate() {
		return lpdDate;
	}
	public void setLpdDate(String lpdDate) {
		this.lpdDate = lpdDate;
	}
	public String getGroupFlag() {
		return groupFlag;
	}
	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}
	public String getObjectStatus() {
		return objectStatus;
	}
	public void setObjectStatus(String objectStatus) {
		this.objectStatus = objectStatus;
	}
//	public String getReverse3() {
//		return reverse3;
//	}
//	public void setReverse3(String reverse3) {
//		this.reverse3 = reverse3;
//	}
//	public String getReverse4() {
//		return reverse4;
//	}
//	public void setReverse4(String reverse4) {
//		this.reverse4 = reverse4;
//	}
//	public String getReverse5() {
//		return reverse5;
//	}
//	public void setReverse5(String reverse5) {
//		this.reverse5 = reverse5;
//	}
	public String getMyType() {
		return myType;
	}
	public void setMyType(String myType) {
		this.myType = myType;
	}

	
	
	
}
