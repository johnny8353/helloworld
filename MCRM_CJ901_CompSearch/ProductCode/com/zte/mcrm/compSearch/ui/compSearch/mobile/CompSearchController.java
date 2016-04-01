package com.zte.mcrm.compSearch.ui.compSearch.mobile;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.basedata.business.log.service.ILogService;
import com.zte.mcrm.compSearch.business.compSearch.service.ICompSearchService;
import com.zte.mcrm.compSearch.model.CompSearchSiebelException;
import com.zte.mcrm.compSearch.model.compSearch.CompSearchBO;
import com.zte.mcrm.framework.model.framework.FBO;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.framework.model.framework.SiebelExceptionComm;
import com.zte.mcrm.framework.ui.framework.controller.SiebelBaseController;

/**
 * 类 编 号：SCRM_Controller_001
 * 类 名 称：CompSearchController
 * 内容摘要：综合查询 控制层 
 * 完成日期：2016-12-27 
 * 编码作者：JohnnyHuang
 */
@Controller("compsearch")
public class CompSearchController extends SiebelBaseController {
	protected Log log = LogFactory.getLog(getClass());

	@Resource
	private ICompSearchService compSearchService;

	@Resource
	private ILogService logService;
	private static final long serialVersionUID = 1L;

	@Override
	public String doCustom(String commandName, String requestJsonObject) {
		log.info(SiebelBaseBO.LOG_PREFIX + "请求参数" + requestJsonObject);
		String message = "";
		String beginTime = DateUtil.getNowDateTimeMMM();
		CompSearchBO boBean = new CompSearchBO();
		try {
			log.info(SiebelBaseBO.LOG_PREFIX + "请求时间" + DateUtil.getNowDateTime());
			// 获取返回对象Map
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			boBean = getBO(requestJsonObject);
			if (CompSearchBO.COMPSEARCH_STRING.equalsIgnoreCase(commandName)) {
				boBean.setName(getLogName(boBean.getfMap().get(FBO.SPESEARCHTYPE_STRING), boBean
						.getfMap().get(FBO.SEARCHTYPE_STRING), boBean
						.getfMap().get(FBO.QUICKTYPE_STRING)));
				jsonMap = CompSearch(boBean);
			}else if (CompSearchBO.JUDGESINGLEDATAVISIBILITY_STRING.equalsIgnoreCase(commandName)) {
				boBean.setName("业务数据-权限判断");
				jsonMap = judgeSingleDataVisibility(boBean);
			}
			
			else {
				jsonMap = boBean.getOutputNoCommandNameMap();
			}
			message = getGsonStr(jsonMap);
//			log.info(SiebelBaseBO.LOG_PREFIX + "返回结果：" + message);
		} catch (Exception ex) {
			boBean.setErrorCode( SiebelBaseBO.FAIL);
			boBean.setErrorMsg(ex.getMessage());
			return exception(CompSearchSiebelException.generateSiebelException("","",SiebelExceptionComm.ERROR_LAYER_CONTROLER, this.getClass().getName(), ex),requestJsonObject);
		}finally{
			//记录日志信息到数据库
			try {
				boBean.setRequestBegin(beginTime);
				boBean.setRequestParam(requestJsonObject);
				boBean.setRequestEnd(DateUtil.getNowDateTimeMMM());
				logService.insert(boBean.getLogVO());
			} catch (Exception e) {
				e.printStackTrace();
				log.info("记录日志信息到数据库出错");
			}
		}
		return message;
	}
	public  Map<String, Object> judgeSingleDataVisibility(CompSearchBO boBean) {
		compSearchService.judgeSingleDataVisibility(boBean);
		Map<String, Object> jsonMap = boBean.getOutputMap();
		jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
		return jsonMap;
	}
	
	/**
	 * 业务描述：调用service服务获取 结果 
	 * 作 者：Johnny Huang 
	 * 完成日期：2016-1-11 下午03:43:06
	 * @param @param boBean
	 * @param @return
	 * @return Map<String,Object>
	 */
	public Map<String, Object> CompSearch(CompSearchBO boBean) {
		compSearchService.CompSearch(boBean);
		Map<String, Object> jsonMap = boBean.getOutputMap();
		jsonMap.put(CompSearchBO.SEARCHINFOLIST_STRING, boBean.getSearchVOs());
		jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
		return jsonMap;
	}

	/**
	 * 
	 * 业务描述：获取接口服务参数对象 
	 * 作 者：Johnny Huang 
	 * 完成日期：2015-12-23
	 * 
	 * @return
	 */
	public CompSearchBO getBO(String requestJsonObject) {
		if(!StringUtil.checkStrIsEmpty(requestJsonObject)){
			Type type = new TypeToken<CompSearchBO>() {
			}.getType();
			return (CompSearchBO) GSONUtil.getJavaFromGsonStr(type,
					requestJsonObject);
		}
		return new CompSearchBO();
	}

	public void setCompSearchService(ICompSearchService compSearchService) {
		this.compSearchService = compSearchService;
	}

	public void setLogService(ILogService logService) {
		this.logService = logService;
	}

	/**
	 * 
	 * 业务描述：获取日志名称 
	 * 作 者：Johnny Huang 
	 * 完成日期：2015-12-30 上午09:00:14
	 * @param @param speSearchType
	 * @param @param searchType
	 * @param @param quickType
	 * @param @return
	 * @return String
	 */
	public String getLogName(String speSearchType, String searchType,
			String quickType) {
		String logName = "";
		if (speSearchType.equals("01")) {
			logName += "客户";
		} else if (speSearchType.equals("02")) {
			logName += "线索";
		} else if (speSearchType.equals("03")) {
			logName += "商机";
		} else if (speSearchType.equals("04")) {
			logName += "项目";
		}

		if (searchType.equals("01")) {
			logName += "-关键字查询";
		} else if (searchType.equals("02")) {
			logName += "-快捷查询";
		}

		if (quickType.equals("01")) {
			logName += "-营销";
		} else if (quickType.equals("02")) {
			logName += "-产品";
		} else if (quickType.equals("03")) {
			logName += "-MTO";
		} else if (quickType.equals("04")) {
			logName += "-行业";
		}
		return logName;
	}
}
