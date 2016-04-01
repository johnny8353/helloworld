/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_DispatchServlet 
 * 文件名称：DispatchServlet.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-1-10
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-1-10
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.itp.ssb.framework.ui.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zte.itp.ssb.framework.base.IJsonService;
import com.zte.itp.ssb.framework.common.util.HttpRequestUtil;
import com.zte.itp.ssb.framework.container.SSBApplicationContext;

/**
 * 类 编 号：BL_PU2010101_DispatchServlet 类 名 称：DispatchServlet 内容摘要：XXX
 * 完成日期：2015-1-10 编码作者：JohnnyHuang 黄福强
 */
public class DispatchServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6361612722834035099L;
	private Log log = LogFactory.getLog(DispatchServlet.class);
	private static final String contentType = "text/html;charset=UTF-8";
	private static final String noCache = "No-cache";
	private static final String nocache = "no-cache";

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String responseJsonString = dispatchRequest(request);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0L);
		PrintWriter out = response.getWriter();
		out.print(responseJsonString);
	}

	private String dispatchRequest(HttpServletRequest request) {
		long time = System.currentTimeMillis();
		String currentUrl = request.getRequestURL().toString();
		this.log.info("jssb已接收请求,其URL为: " + currentUrl);
//		log.warn("dispatchRequest请求调用总用时00："+(System.currentTimeMillis()-time)+"ms");
		String context = request.getContextPath();
		String jsonServiceClassName = HttpRequestUtil
				.getJsonServiceNameFromUrl(currentUrl, context);
		this.log.info("分发的JSON服务名称为: " + jsonServiceClassName);
//		log.warn("dispatchRequest请求调用总用时0："+(System.currentTimeMillis()-time)+"ms");
		IJsonService jsonService = (IJsonService) SSBApplicationContext.getBean(jsonServiceClassName);
//		log.warn("dispatchRequest请求调用总用时1："+(System.currentTimeMillis()-time)+"ms");
		this.log.info("-------begin Initialize request Conetxt------");
		jsonService.init(request);
//		log.warn("dispatchRequest请求调用总用时2："+(System.currentTimeMillis()-time)+"ms");
		this.log.info("-------end Initialize request Conetxt!-------");
		// return jsonService.service();
		String responseString = jsonService.service(request);
		long time2 = System.currentTimeMillis();
		log.warn("dispatchRequest请求调用总用时3："+(time2-time)+"ms");
		return responseString;
	}
}
