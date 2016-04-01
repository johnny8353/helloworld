package com.zte.mcrm.compSearch.model.compSearch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.basedata.access.log.vo.LogVO;
import com.zte.mcrm.basedata.access.lov.vo.LOV;
import com.zte.mcrm.compSearch.access.compSearch.vo.CompSearchVO;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;

public class CompSearchBO extends SiebelBaseBO implements Serializable{
	/**综合查询详细信息*/
	public static final String COMPSEARCH_STRING = "CompSearch";
	public static final String JUDGESINGLEDATAVISIBILITY_STRING = "JudgeSingleDataVisibility";
	
	public static final String ORGVISIBLEORGSTR_STRING = "orgVisibleOrgStr";
	public static final String MTOVISIBLEORGSTR_STRING = "mtoVisibleOrgStr";
	public static final String PRODVISIBLEORGSTR_STRING = "prodVisibleOrgStr";
	public static final String TRADEVISIBLEORGSTR_STRING = "tradeVisibleOrgStr";
	public static final String ACCTYPEVISIBLEORGSTR_STRING = "accTypeVisibleOrgStr";
	public static final String ACCTYPEVISIBLESQLSTR_STRING = "accTypeVisibleSQLStr";
	public static final String PROJCODE_STRING = "04";
	public static final String OPTYCODE_STRING = "03";
	public static final String LEADCODE_STRING = "02";
	public static final String ACCOUNTCODE_STRING = "01";
	//【查询对象】数组
	public static final String SEARCHINFOLIST_STRING = "searchInfoList";
	
	public List<CompSearchVO> searchVOs = new ArrayList<CompSearchVO>();

	public List<CompSearchVO> getSearchVOs() {
		List<CompSearchVO> nSearchVOs = new ArrayList<CompSearchVO>();
		for (CompSearchVO vo : searchVOs) {
			CompSearchVO vo2 = new CompSearchVO();
			vo2.setAttr1(StringUtil.retBlankIfNull(vo.getAttr1()));
			vo2.setAttr2(StringUtil.retBlankIfNull(vo.getAttr2()));
			vo2.setAttr3(StringUtil.retBlankIfNull(vo.getAttr3()));
			vo2.setAttr4(StringUtil.retBlankIfNull(vo.getAttr4()));
			vo2.setAttr5(StringUtil.retBlankIfNull(vo.getAttr5()));
			vo2.setAttr6(StringUtil.retBlankIfNull(vo.getAttr6()));
			vo2.setDeptId(StringUtil.retBlankIfNull(vo.getDeptId()));
			vo2.setInfoCode(StringUtil.retBlankIfNull(vo.getInfoCode()));
			
			vo2.setBizId(StringUtil.retBlankIfNull(vo.getBizId()));
			vo2.setType(StringUtil.retBlankIfNull(vo.getType()));
			vo2.setLpdDate(StringUtil.retBlankIfNull(vo.getLpdDate()));
			vo2.setObjectStatus(StringUtil.retBlankIfNull(vo.getObjectStatus()));
			vo2.setMyType(StringUtil.retBlankIfNull(vo.getMyType()));
			vo2.setGroupFlag(StringUtil.retBlankIfNull(vo.getGroupFlag()));
			vo2.setObjectStatus(StringUtil.retBlankIfNull(vo.getObjectStatus()));
			nSearchVOs.add(vo2);
		}
		return nSearchVOs;
	}

	public void setSearchVOs(List<CompSearchVO> searchVOs) {
		this.searchVOs = searchVOs;
	}
	
}
