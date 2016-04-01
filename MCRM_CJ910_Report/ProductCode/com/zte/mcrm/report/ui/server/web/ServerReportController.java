package com.zte.mcrm.report.ui.server.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.compSearch.model.CompSearchSiebelException;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.framework.model.framework.SiebelExceptionComm;
import com.zte.mcrm.framework.ui.framework.controller.SiebelBaseController;
import com.zte.mcrm.report.access.server.vo.ReportVO;
import com.zte.mcrm.report.model.server.ReportBO;

/**
 * 类 编 号：
 * 类 名 称：ServerReportController
 * 内容摘要：XXX 
 * 完成日期：2016-2-25
 * 编码作者：JohnnyHuang
 */
@Controller("serverReport")
public class ServerReportController   extends SiebelBaseController{
protected Log log = LogFactory.getLog(getClass());
	
	@Override
	public String doPcCustom(HttpServletRequest request) {
		
		log.info(SiebelBaseBO.LOG_PREFIX + "请求参数" + request);
		log.info(SiebelBaseBO.LOG_PREFIX + "请求时间" + DateUtil.getNowDateTime());
		
		String message = "";
		ReportBO boBean = new ReportBO();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			
			//
			ArrayList<ReportVO> vos = new ArrayList<ReportVO>();
			vos.add(new ReportVO("2015年12月","1253","1668","2033","2834"));
			vos.add(new ReportVO("2015年11月","896","1324","1704","2654"));
			vos.add(new ReportVO("2015年10月","785","1203","1685","2790"));
			vos.add(new ReportVO("2015年9月","864","1289","1752","2879"));
			vos.add(new ReportVO("2015年8月","832","1314","1760","2876"));
			vos.add(new ReportVO("2015年7月","824","1364","1879","3022"));
			vos.add(new ReportVO("2015年6月","836","1359","1877","3143"));
			vos.add(new ReportVO("2015年5月","766","1288","1845","3173"));
			vos.add(new ReportVO("2015年4月","825","1441","2022","3556"));
			vos.add(new ReportVO("2015年3月","1071","1710","2265","3851"));
			vos.add(new ReportVO("2015年2月","1134","1682","2178","3588"));
			vos.add(new ReportVO("2015年1月","1328","1853","2377","3842"));
			boBean.setReportVOs(vos);
			if(StringUtil.retBlankIfNull(getMethod()).equalsIgnoreCase("getPage")){
				jsonMap.put(SiebelBaseBO.DATA_OBJ, boBean.getServerReportMap());
				jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
			}else if(StringUtil.retBlankIfNull(getMethod()).equalsIgnoreCase("search")){
				HttpSession session = request.getSession();
				//相关操作后
				session.setAttribute("obj", getObj());
				jsonMap.put(SiebelBaseBO.IS_SUCCESS, "true");
			}
			else{
				jsonMap = boBean.getOutputNoCommandNameMap();
			}
			message = getGsonStr(jsonMap);
		} catch (Exception ex) {
			boBean.setErrorCode( SiebelBaseBO.FAIL);
			boBean.setErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return exception(CompSearchSiebelException.generateSiebelException("","",SiebelExceptionComm.ERROR_LAYER_CONTROLER, this.getClass().getName(), ex),GSONUtil.getGsonStr(boBean));
		}finally{
			//记录日志信息到数据库
		}
		return message;
	}
}
