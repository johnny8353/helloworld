/**
 * CommonWSSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.compSearch.business.compSearch.webservice.server.common;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.reflect.TypeToken;
import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.basedata.business.log.service.ILogService;
import com.zte.mcrm.compSearch.business.compSearch.service.ICompSearchService;
import com.zte.mcrm.compSearch.model.CompSearchSiebelException;
import com.zte.mcrm.compSearch.model.compSearch.CompSearchBO;
import com.zte.mcrm.compSearch.ui.compSearch.mobile.CompSearchController;
import com.zte.mcrm.framework.model.framework.SiebelExceptionComm;
import com.zte.mcrm.framework.ui.framework.controller.SiebelBaseWSController;

public class CommonWSSoapBindingImpl extends SiebelBaseWSController implements com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_PortType{
	private ICompSearchService compSearchService;
	private ILogService logService;
	protected Log log = LogFactory.getLog(getClass());
    public com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.WSServiceResponse WSService(com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.WSServiceRequest parameters) throws java.rmi.RemoteException {
    	String message = "";
    	String jsonStr = "";
    	//获取上下文请求
		MessageContext mc = MessageContext.getCurrentContext();
		HttpServletRequest request = (HttpServletRequest) mc.getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
		HttpServletResponse response =(HttpServletResponse)mc.getProperty(HTTPConstants.MC_HTTP_SERVLETRESPONSE);
		Map<String, Object> jsonMap = new HashMap<String,Object>();
		
		try{
			jsonStr =doDecryptRequest(parameters.getJsonStr());
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
			log.info("输入参数："+jsonStr);
			Type type = new TypeToken<CompSearchBO>() {}.getType();
			CompSearchBO boBean = (CompSearchBO) GSONUtil.getJavaFromGsonStr(type,jsonStr);
			if(!StringUtil.checkStrIsEmpty(boBean.getC())){
				compSearchService = (ICompSearchService)wac.getBean("compSearchService");
				logService = (ILogService)wac.getBean("logService");
				CompSearchController compSearchController = new CompSearchController();
				compSearchController.setCompSearchService(compSearchService);
				compSearchController.setLogService(logService);
				message = compSearchController.doCustom("CompSearch",jsonStr);
//				ICompSearchService compSearchService = (ICompSearchService) wac.getBean("compSearchService"); 
//				compSearchService.CompSearch(boBean);
//				jsonMap = boBean.getOutputMap();
//				jsonMap.put(SiebelBaseBO.DATA_OBJ, boBean.getSearchVOs());
//				jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
			}
		}catch (Exception ex) {
			message = exception(CompSearchSiebelException.generateSiebelException("","",SiebelExceptionComm.ERROR_LAYER_CONTROLER, this.getClass().getName(), ex),jsonStr);
		}
    	WSServiceResponse response1 = new WSServiceResponse();
    	response1.setReturnStr(message);
        return response1;
    }

}
