package com.zte.mcrm.basedata.access.log.vo;

public class LogVO {
	
	private Long rowId;
	private String ROW_ID;
	private String ATT05;//数量
	private String METHOD;//方法
	private String DESCS;//说明
	private String SPEND_TIME;//花费时间
	private String INV_USER;//调用用户
	private String ATT02;//结束时间
	private String ATT01;//开始时间
	private String NAME;//名称
	private String ATT03;//错误
	public String getATT05() {
		return ATT05;
	}
	public void setATT05(String aTT05) {
		ATT05 = aTT05;
	}
	public String getMETHOD() {
		return METHOD;
	}
	public void setMETHOD(String mETHOD) {
		METHOD = mETHOD;
	}
	public String getDESCS() {
		return DESCS;
	}
	public void setDESCS(String dESCS) {
		DESCS = dESCS;
	}
	public String getSPEND_TIME() {
		return SPEND_TIME;
	}
	public void setSPEND_TIME(String sPEND_TIME) {
		SPEND_TIME = sPEND_TIME;
	}
	public String getINV_USER() {
		return INV_USER;
	}
	public void setINV_USER(String iNV_USER) {
		INV_USER = iNV_USER;
	}
	public String getATT02() {
		return ATT02;
	}
	public void setATT02(String aTT02) {
		ATT02 = aTT02;
	}
	public String getATT01() {
		return ATT01;
	}
	public void setATT01(String aTT01) {
		ATT01 = aTT01;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getATT03() {
		return ATT03;
	}
	public void setATT03(String aTT03) {
		ATT03 = aTT03;
	}
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getROW_ID() {
		return String.valueOf(rowId);
	}
	public void setROW_ID(String rOW_ID) {
		ROW_ID = rOW_ID;
	}
	

}
