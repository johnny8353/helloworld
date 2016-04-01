package com.zte.mcrm.project.ui.mobile.projweekreportlist;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zte.itp.ssb.framework.common.exception.JSONServiceException;
import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.mcrm.basedata.business.log.service.ILogService;
import com.zte.mcrm.compSearch.model.CompSearchSiebelException;
import com.zte.mcrm.compSearch.model.compSearch.CompSearchBO;
import com.zte.mcrm.framework.model.framework.FBO;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.framework.model.framework.SiebelExceptionComm;
import com.zte.mcrm.framework.ui.framework.controller.SiebelBaseController;
import com.zte.mcrm.project.business.projweekreportlist.service.IProjWeekReportListService;
import com.zte.mcrm.project.model.projweekreportlist.ProjWeekReportListBO;
 
/**   
 * 类 编 号：
 * 类 名 称：ProjWeekReportListContorller.java
 * 内容摘要：
 * 完成日期：2016-1-21  
 * 编码作者：QunLi
 */
@Controller("projweekreportlist")
public class ProjWeekReportListContorller extends SiebelBaseController{
	protected Log log = LogFactory.getLog(getClass());
	
	@Resource
	IProjWeekReportListService reportService;
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ILogService logService;
	
	@Override
	public String doCustom(String commandName, String requestJsonObject)
			throws JSONServiceException {
		String message = "";
		log.info(SiebelBaseBO.LOG_PREFIX + "请求参数" + requestJsonObject);
		String beginTime = DateUtil.getNowDateTimeMMM();
		ProjWeekReportListBO boBean = new ProjWeekReportListBO();
		try {
			log.info(SiebelBaseBO.LOG_PREFIX + "请求时间"
					+ DateUtil.getNowDateTime());
			// 获取返回对象Map
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			boBean = getBO(requestJsonObject);
			boBean.setName("查看项目周报列表");
			jsonMap = getProjWeekReportListJsonMap(boBean);
			message = getGsonStr(jsonMap);
			log.info(SiebelBaseBO.LOG_PREFIX + "返回结果：" + message);
		} catch (Exception e) {
			e.printStackTrace();
			boBean.setErrorCode( SiebelBaseBO.FAIL);
			boBean.setErrorMsg(e.getMessage());
			return exception(CompSearchSiebelException.generateSiebelException("","",SiebelExceptionComm.ERROR_LAYER_CONTROLER, this.getClass().getName(), e),requestJsonObject);
		}finally{
			//记录日志信息到数据库
			boBean.setRequestBegin(beginTime);
			boBean.setRequestParam(requestJsonObject);
			boBean.setRequestEnd(DateUtil.getNowDateTimeMMM());
			try {
				logService.insert(boBean.getLogVO());
			} catch (Exception e) {
				e.printStackTrace();
				log.info("记录日志信息到数据库出错");
			}
		}
		return message;
	}
	
	public void setLog(Log log) {
		this.log = log;
	}

	public void setReportService(IProjWeekReportListService reportService) {
		this.reportService = reportService;
	}

	
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}

	/**
	 * 根据json串获取BO
	 * @param requestJsonObject
	 * @return
	 */
	private ProjWeekReportListBO getBO(String requestJsonObject){
		
		Type type = new TypeToken<ProjWeekReportListBO>() {
		}.getType();
		return (ProjWeekReportListBO) GSONUtil.getJavaFromGsonStr(type,
				requestJsonObject);
	}
	
	/**
	 * 业务描述：调用service服务获取 结果 
	 * 作 者：QunLi 
	 * 完成日期：
	 * @param 
	 * @param 
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getProjWeekReportListJsonMap(ProjWeekReportListBO boBean) {
		reportService.getProjWeekReportListBO(boBean);
		Map<String, Object> jsonMap = boBean.getOutputMap();
		jsonMap.put(ProjWeekReportListBO.SEARCHINFOLIST_STRING, boBean.getReportVos());
		jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
		return jsonMap;
	}
}

