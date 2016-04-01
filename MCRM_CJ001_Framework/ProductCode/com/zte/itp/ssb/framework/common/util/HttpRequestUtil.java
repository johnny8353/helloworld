package com.zte.itp.ssb.framework.common.util;

import java.io.BufferedInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zte.mcrm.framework.common.interceptor.RequestInterceptor;

public abstract class HttpRequestUtil {
	private static Log log = LogFactory.getLog(RequestInterceptor.class);

	public static String getJsonFromRequestURL(HttpServletRequest request) {
		String jsonString = "";
		try {
			Map map = new HashMap();
			Enumeration paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();

				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() != 0) {
						map.put(paramName, paramValue);
					}
				}
			}
			JSONObject json = JSONObject.fromObject(map);
			jsonString = json.getString("OBJ");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("It's occured error in reading json's from request url,Cause:"
					+ e);
		}
		
		return jsonString;
	}

	// public static String parseRequestAttribute(HttpServletRequest request) {
	// String jsonString = "";
	// Map map = new HashMap();
	// try {
	// Enumeration paramNames = request.getAttributeNames();
	// if (null != paramNames) {
	// log.info("---begin parsing request attribute---");
	// while (paramNames.hasMoreElements()) {
	// String attrName = (String) paramNames.nextElement();
	// Object attrValue = request.getAttribute(attrName);
	// map.put(attrName.toUpperCase(), attrValue);
	// }
	// log.info("---end parsing request attribute---");
	// } else {
	// log.info("It's occured warn in parsing attribute from request.");
	// }
	// } catch (Exception e) {
	// log.error("request请求中解析属性attr发生异常,异常信息:" + e);
	// }
	// JSONArray json = JSONArray.fromObject(map);
	// jsonString = json.toString();
	// return jsonString;
	// }
	//
	// public static String getXmlFromRequest(HttpServletRequest request) {
	// String xmlString = "";
	// Map map = new HashMap();
	// Enumeration paramNames = request.getParameterNames();
	// while (paramNames.hasMoreElements()) {
	// String paramName = (String) paramNames.nextElement();
	//
	// String[] paramValues = request.getParameterValues(paramName);
	// if (paramValues.length == 1) {
	// String paramValue = paramValues[0];
	// if (paramValue.length() != 0) {
	// map.put(paramName, paramValue);
	// }
	// }
	// }
	// JSONObject json = JSONObject.fromObject(map);
	// XMLSerializer xmlSerializer = new XMLSerializer();
	// xmlString = xmlSerializer.write(json, "UTF-8");
	// return xmlString;
	// //
	// // Set<Map.Entry<String, String>> set = map.entrySet();
	// // System.out.println("------------------------------");
	// // for (Map.Entry entry : set) {
	// // System.out.println(entry.getKey() + ":" + entry.getValue());
	// // }
	// // System.out.println("------------------------------");
	// }
	public static String getJsonFromRequest(HttpServletRequest request) {
		StringBuffer buf = new StringBuffer();
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(request.getInputStream());

			byte[] contents = new byte[1024];
			int byteRead = 0;
			while ((byteRead = bis.read(contents)) != -1) {
				buf.append(new String(contents, 0, byteRead, "UTF-8"));
			}

		} catch (Exception e) {
			log.error("It's occured error in reading json's inputStream from request,Cause:"
					+ e);
		} finally {
			try {
				if (null != bis) {
					bis.close();
					bis = null;
				}

			} catch (Exception e) {
				log.error("It's occured error in closing stream from request,Cause:"
						+ e);
			}
		}
		return buf.toString();
	}

	public static String getJsonServiceNameFromUrl(String requestUrl,
			String context) {
		String resURL = requestUrl.substring(requestUrl.indexOf(context)
				+ context.length() + 1);
		resURL = resURL.substring(0, resURL.indexOf(".jssm"));
		String[] s = resURL.split("/");
		int len = s.length;
		String jsonServiceClassName = s[(len - 2)];
		return jsonServiceClassName;
	}

	public static String getExportServiceNameFromUrl(String requestUrl,
			String context) {
		String resURL = requestUrl.substring(requestUrl.indexOf(context)
				+ context.length() + 1);
		resURL = resURL.substring(0, resURL.indexOf(".pssm"));
		String[] s = resURL.split("/");
		int len = s.length;
		String jsonServiceClassName = s[(len - 2)];
		return jsonServiceClassName;
	}

	public static String getMethodNameFromUrl(String requestUrl, String context) {
		String methodName = "";
		String resURL = requestUrl.substring(requestUrl.indexOf(context)
				+ context.length() + 1);
		resURL = resURL.substring(0, resURL.indexOf(".jssm"));
		String[] s = resURL.split("/");
		int len = s.length;
		methodName = s[(len - 1)];
		return methodName;
	}
}
