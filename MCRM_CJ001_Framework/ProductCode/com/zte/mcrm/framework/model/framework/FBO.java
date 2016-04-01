package com.zte.mcrm.framework.model.framework;

import java.io.Serializable;

public class FBO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	// F对象Key的值
	public static final String ID_STRING="id";
	public static final String LSTUPD_STRING="lstupd";
	public static final String DATAID_STRING="dataId";
	public static final String ORDERBY_STRING="orderby";
	public static final String QUICKLEVEL_STRING="quickLevel";
	public static final String QUICKTYPE_STRING="quickType";
	public static final String SEARCHTYPE_STRING="searchType";
	public static final String SELECTCODE_STRING="selectCode";
	public static final String SPESEARCHTYPE_STRING="speSearchType";
	public static final String STR_STRING="str";
	


	private String K;
	private Object V;
	
	public String getK() {
		return K;
	}
	public void setK(String k) {
		K = k;
	}
	public Object getV() {
		return V;
	}
	public void setV(Object v) {
		V = v;
	}
	
	
}
