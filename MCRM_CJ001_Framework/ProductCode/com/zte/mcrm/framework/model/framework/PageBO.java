/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_PageBO 
 * 文件名称：PageBO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-11-17
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-11-17
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.model.framework;

import java.io.Serializable;

/**
 * 类 编 号：BL_PU2010101_PageBO 类 名 称：PageBO 内容摘要：分页对象 完成日期：2014-11-17
 * 编码作者：JohnnyHuang 黄福强
 */
public class PageBO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1316050912554775467L;

	/** S:开始时间，要大于该时间一般为本地最后一次更新时间 */
	public static final String START_TIME = "S";
	/** E:结束时间，一般为服务器第一次获取时取得的本地时间传回客户端 */
	public static final String END_TIME = "E";
	/** L:本地最后一次更新时间，当有这个参数的时候要额外计算一个更新总数，即L到E的记录总数 */
	public static final String LAST_TIME = "L";
	/** T:记录总数 */
	public static final String TOTAL_NUM = "T";
	/** TOTAL_PAGE:总页数 */
	public static final String TOTAL_PAGE = "TP";
	/** PNO:页数 */
	public static final String P_NO = "PNO";
	/** PSIZE:每页记录数,<=0的时候表示不分页，返回所有数据 */
	public static final String PAGE_SIZE = "PSIZE";

	/** S:开始时间，要大于该时间一般为本地最后一次更新时间 */
	private String S;
	/** E:结束时间，一般为服务器第一次获取时取得的本地时间传回客户端 */
	private String E;
	/** L:本地最后一次更新时间，当有这个参数的时候要额外计算一个更新总数，即L到E的记录总数 */
	private String L;
	/** T:记录总数 */
	private String T;
	/** PNO:页数 */
	private int PNO;
	/** TP:总页数 */
	private int TP;
	/** PSIZE:每页记录数,<=0的时候表示不分页，返回所有数据 */
	private int PSIZE;
	/** 更新总数 */
	private String U;
	/** 查询起始点 */
	private int startNo;

	public int getStartNo() {

		return (PNO - 1) * PSIZE;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	/**
	 * @return the s
	 */
	public String getS() {
		return S;
	}

	/**
	 * @param s
	 *            the s to set
	 */
	public void setS(String s) {
		S = s;
	}

	/**
	 * @return the e
	 */
	public String getE() {
		return E;
	}

	/**
	 * @param e
	 *            the e to set
	 */
	public void setE(String e) {
		E = e;
	}

	/**
	 * @return the l
	 */
	public String getL() {
		return L;
	}

	/**
	 * @param l
	 *            the l to set
	 */
	public void setL(String l) {
		L = l;
	}

	/**
	 * @return the t
	 */
	public String getT() {
		return T;
	}

	/**
	 * @param t
	 *            the t to set
	 */
	public void setT(String t) {
		T = t;
	}

	/**
	 * @return the pNO
	 */
	public int getPNO() {
		return PNO;
	}

	/**
	 * @param pNO
	 *            the pNO to set
	 */
	public void setPNO(int pNO) {
		PNO = pNO;
	}

	/**
	 * @return the pSIZE
	 */
	public int getPSIZE() {
		return PSIZE;
	}

	/**
	 * @param pSIZE
	 *            the pSIZE to set
	 */
	public void setPSIZE(int pSIZE) {
		PSIZE = pSIZE;
	}

	public String getU() {
		return U;
	}

	public void setU(String u) {
		U = u;
	}

	public int getTP() {
		return TP;
	}

	public void setTP(int tP) {
		TP = tP;
	}
	
}
