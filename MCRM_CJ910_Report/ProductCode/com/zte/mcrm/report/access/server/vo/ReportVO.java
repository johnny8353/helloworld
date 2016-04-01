package com.zte.mcrm.report.access.server.vo;

/**
 * 类 编 号：
 * 类 名 称：reportVO
 * 内容摘要：XXX 
 * 完成日期：2016-2-25
 * 编码作者：JohnnyHuang
 */
public class ReportVO {

	private String group1;
	private String data1;
	private String data2;
	private String data3;
	private String data4;
	public String getGroup1() {
		return group1;
	}
	public void setGroup1(String group1) {
		this.group1 = group1;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}
	public String getData4() {
		return data4;
	}
	public void setData4(String data4) {
		this.data4 = data4;
	}
	public ReportVO(String group1, String data1, String data2, String data3,
			String data4) {
		super();
		this.group1 = group1;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	}

	
	
	
}
