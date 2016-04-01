package com.zte.mcrm.project.model.projweekreportlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.project.access.projweekreportlist.vo.ProjWeekReportListVO;

/**   
 * 类 编 号：
 * 类 名 称：ProjWeekReportListBO.java
 * 内容摘要：
 * 完成日期：2016-1-21  
 * 编码作者：QunLi
 */
public class ProjWeekReportListBO extends SiebelBaseBO implements Serializable{
	
	public static final String SEARCHINFOLIST_STRING = "prjWeeklyReportList";
	
	private List<ProjWeekReportListVO> reportVos = new ArrayList<ProjWeekReportListVO>();

	public List<ProjWeekReportListVO> getReportVos() {
		
		
		ProjWeekReportListVO reportVo2 = null;
		List<ProjWeekReportListVO> reportVos2 = new ArrayList<ProjWeekReportListVO>();
		for (ProjWeekReportListVO reportVo : reportVos) {
			reportVo2 = new ProjWeekReportListVO();
			
			reportVo2.setCreateBy(StringUtil.retBlankIfNull(reportVo.getCreateBy()));
			reportVo2.setCreateDate(StringUtil.retBlankIfNull(reportVo.getCreateDate().substring(0, reportVo.getCreateDate().lastIndexOf(":"))));
			reportVo2.setId(StringUtil.retBlankIfNull(reportVo.getId()));
			reportVo2.setObjStatus(StringUtil.retBlankIfNull(reportVo.getObjStatus()));
			reportVo2.setPrjCode(StringUtil.retBlankIfNull(reportVo.getPrjCode()));
			reportVo2.setPrjId(StringUtil.retBlankIfNull(reportVo.getPrjId()));
			reportVo2.setPrjName(StringUtil.retBlankIfNull(reportVo.getPrjName()));
			reportVo2.setPrjStatus(StringUtil.retBlankIfNull(reportVo.getPrjStatus()));
			reportVo2.setTitle(StringUtil.retBlankIfNull(reportVo.getTitle()));
			
			reportVos2.add(reportVo2);
		}
		return reportVos2;
	}

	public void setReportVos(List<ProjWeekReportListVO> reportVos) {
		this.reportVos = reportVos;
	}
}

