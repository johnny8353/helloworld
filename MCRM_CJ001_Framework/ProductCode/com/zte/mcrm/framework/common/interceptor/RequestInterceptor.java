package com.zte.mcrm.framework.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zte.itp.ssb.framework.common.util.HttpRequestUtil;

public class RequestInterceptor extends MethodFilterInterceptor {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(RequestInterceptor.class);
	@Override
	protected String doIntercept(ActionInvocation invoker) throws Exception {
		// TODO Auto-generated method stub
		this.log.info("请求拦截开始...");
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentUrl = request.getRequestURL().toString();
		this.log.info("jssb已接收请求,其URL为: " + currentUrl);
		String context = request.getContextPath();
		this.log.info("jssb已接收请求,其ContextPath为: " + context);
		String requestJsonObject = HttpRequestUtil.getJsonFromRequest(request);
		this.log.info("jssb已接收请求,其requestJsonObject为: " + requestJsonObject);
		String jsonServiceClassName = HttpRequestUtil.getJsonServiceNameFromUrl(currentUrl, context);
		this.log.info("分发的JSON服务名称为: " + jsonServiceClassName);
//		String requestXmlObject = HttpRequestUtil.getXmlFromRequest(request);
//		this.log.info("jssb已接收请求,其requestXmlObject为: " + requestXmlObject);
		
//		String jsonServiceClassName = HttpRequestUtil
//				.getJsonServiceNameFromUrl(currentUrl, context);
//		this.log.info("分发的JSON服务名称为: " + jsonServiceClassName);
//		String parseRequestAttribute = HttpRequestUtil.parseRequestAttribute(request);
//		this.log.info("jssb已接收请求,其parseRequestAttribute为: " + parseRequestAttribute);
		String result = invoker.invoke();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0L);
		
		System.out.println("请求拦截结束...");
		return result;
	}
	



}
