package com.zte.mcrm.report.model.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.report.access.server.vo.ReportVO;

/**
 * 类 编 号：
 * 类 名 称：ReportBO
 * 内容摘要：XXX 
 * 完成日期：2016-2-25
 * 编码作者：JohnnyHuang
 */
public class ReportBO  extends SiebelBaseBO implements Serializable{

	/**
	 * 类 编 号：
	 * 类 名 称：
	 * 内容摘要：XXX 
	 * 完成日期：2016-2-25
	 * 编码作者：JohnnyHuang
	 */
	private ArrayList<ReportVO> reportVOs;

	public ArrayList<Map<String, Object>> getServerReportMap(){
		ArrayList<Map<String, Object>> maps = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < this.reportVOs.size(); i++) {
			Map<String, Object> tmp = new HashMap<String, Object>();
			ReportVO reportVO = reportVOs.get(i);
			tmp.put("年月",reportVO.getGroup1());
			tmp.put("登陆十次及以上",Integer.parseInt(reportVO.getData1()));
			tmp.put("登陆五次及以上",Integer.parseInt(reportVO.getData2()));
			tmp.put("登陆三次及以上",Integer.parseInt(reportVO.getData3()));
			tmp.put("登陆一次及以上",Integer.parseInt(reportVO.getData4()));
			maps.add(tmp);
		}
		return maps;
	}
	
	public ArrayList<ReportVO> getReportVOs() {
		return reportVOs;
	}

	public void setReportVOs(ArrayList<ReportVO> reportVOs) {
		this.reportVOs = reportVOs;
	}
	
	
}
