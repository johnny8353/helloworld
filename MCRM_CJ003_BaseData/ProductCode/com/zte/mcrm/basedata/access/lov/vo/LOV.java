package com.zte.mcrm.basedata.access.lov.vo;

import java.math.BigDecimal;
import java.util.Date;

public class LOV {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIEBEL.S_LST_OF_VAL.ROW_ID
     *
     * @mbggenerated Wed Mar 06 10:54:27 CST 2013
     */
    private String rowId;

   

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIEBEL.S_LST_OF_VAL.PAR_ROW_ID
     *
     * @mbggenerated Wed Mar 06 10:54:27 CST 2013
     */
    private String parRowId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIEBEL.S_LST_OF_VAL.LANG_ID
     *
     * @mbggenerated Wed Mar 06 10:54:27 CST 2013
     */
    private String langId;

   
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIEBEL.S_LST_OF_VAL.NAME
     *
     * @mbggenerated Wed Mar 06 10:54:27 CST 2013
     */
    private String name;


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIEBEL.S_LST_OF_VAL.TYPE
     *
     * @mbggenerated Wed Mar 06 10:54:27 CST 2013
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIEBEL.S_LST_OF_VAL.VAL
     *
     * @mbggenerated Wed Mar 06 10:54:27 CST 2013
     */
    private String val;
    private String descText;
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getParRowId() {
		return parRowId;
	}

	public void setParRowId(String parRowId) {
		this.parRowId = parRowId;
	}

	public String getLangId() {
		return langId;
	}

	public void setLangId(String langId) {
		this.langId = langId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getDescText() {
		return descText;
	}

	public void setDescText(String descText) {
		this.descText = descText;
	}

}