package com.zte.itp.ssb.framework.base;

import java.lang.reflect.Type;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.zte.itp.ssb.framework.common.Constants;
import com.zte.itp.ssb.framework.common.ResultData;
import com.zte.itp.ssb.framework.common.exception.JSONServiceException;
import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.itp.ssb.framework.common.util.HttpRequestUtil;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.framework.common.util.Env;
import com.zte.mcrm.framework.common.util.McrmDesSecretUtil;
import com.zte.mcrm.framework.model.framework.PostBaseJson;
/**
 * 
 * 类 编 号：
 * 类 名 称：BaseJSONService
 * 内容摘要：XXX 
 * 完成日期：2016-1-11
 * 编码作者：JohnnyHuang
 */
@Service
public abstract class BaseJSONService implements IJsonService {
	protected HttpServletRequest request;
	protected Log log = LogFactory.getLog(getClass());
	private String requestJsonObject;
	protected Map<String, String> requestParameterMap;
	protected Map<String, Object> requestAttrMap;

	protected String getRequestJsonObject() {
		return this.requestJsonObject;
	}

	@Override
	public void init(HttpServletRequest request) throws JSONServiceException {
		// this.requestJsonObject = HttpRequestUtil.getJsonFromRequest(request);
		// this.log.info("页面传递到后台的JSON信息: " + this.requestJsonObject);
		parseRequestParameter(request);
		parseRequestAttribute(request);
		// this.request = request;
	}

	protected void parseRequestParameter(HttpServletRequest request) {
		this.requestParameterMap = new HashMap();
		try {
			Enumeration paramNames = request.getParameterNames();
			if (null != paramNames) {
				this.log.info("---begin parsing request parameter---");
				while (paramNames.hasMoreElements()) {
					String paramName = (String) paramNames.nextElement();
					String paramValues = request.getParameter(paramName);
					this.requestParameterMap.put(paramName.toUpperCase(),
							paramValues);
				}
				this.log.info("---finish parsing request parameter---");
			} else {
				this.log.info("It's occured warn in parsing parameter from request.");
			}
		} catch (Exception e) {
			this.log.error("request请求中解析参数param发生异常,异常信息:" + e);
		}
	}

	protected void parseRequestAttribute(HttpServletRequest request) {
		this.requestAttrMap = new HashMap();
		try {
			Enumeration paramNames = request.getAttributeNames();
			if (null != paramNames) {
				this.log.info("---begin parsing request attribute---");
				while (paramNames.hasMoreElements()) {
					String attrName = (String) paramNames.nextElement();
					Object attrValue = request.getAttribute(attrName);
					this.requestAttrMap.put(attrName.toUpperCase(), attrValue);
				}
				this.log.info("---end parsing request attribute---");
			} else {
				this.log.info("It's occured warn in parsing attribute from request.");
			}
		} catch (Exception e) {
			this.log.error("request请求中解析属性attr发生异常,异常信息:" + e);
		}
		parseSessionAttribute(request);
	}

	private void parseSessionAttribute(HttpServletRequest request) {
		try {
			HttpSession httpSession = request.getSession();
			if (null != httpSession) {
				Enumeration paramNames = httpSession.getAttributeNames();
				if (null != paramNames) {
					this.log.info("---begin parsing httpSession attribute---");
					while (paramNames.hasMoreElements()) {
						String attrName = (String) paramNames.nextElement();
						Object attrValue = request.getAttribute(attrName);
						if (!isContainKey(this.requestAttrMap, attrName)) {
							this.requestAttrMap.put(attrName.toUpperCase(),
									attrValue);
						}
					}
					this.log.info("---end parsing httpSession attribute---");
				}
			} else {
				this.log.info("It's occured warn in parsing attribute from session.");
			}
		} catch (Exception e) {
			this.log.error("会话中解析请求属性attr发生异常,异常信息:" + e);
		}
	}

	protected String getMethodName(HttpServletRequest request)
			throws JSONServiceException {
		String currentUrl = request.getRequestURL().toString();
		String context = request.getContextPath();
		String methodName = "";
		try {
			methodName = HttpRequestUtil.getMethodNameFromUrl(currentUrl,
					context);
		} catch (Exception e) {
			this.log.error("It's occured error in getting methodName from request,Cause:"
					+ e);
		}
		return methodName;
	}

	@Override
	public String service() throws JSONServiceException {
		String commandName = StringUtil
				.toUpperCase(getParameter("CommandName"));

		if (("".equals(commandName)) || ("null".equals(commandName))) {
			commandName = StringUtil.toUpperCase(getMethodName(this.request));
		}
		// post方式
		if (requestJsonObject.indexOf(PostBaseJson.COMMAND_NAME) > -1) {
			Type type = new TypeToken<PostBaseJson>() {
			}.getType();
			try {
				PostBaseJson o = (PostBaseJson) GSONUtil.getJavaFromGsonStr(
						type, getRequestJsonObject());
				commandName = o.getC();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.log.info("commandName(请求命令): " + commandName);

		if (Constants.ADD.equals(commandName)) {
			return doAdd();
		}
		if ((Constants.EDIT.equals(commandName))
				|| (Constants.UPDATE.equals(commandName))) {
			return doEdit();
		}
		if (Constants.DELETE.equals(commandName)) {
			return doDelete();
		}
		if (Constants.QUERY.equals(commandName)) {
			return doQuery();
		}
		if ((Constants.INITIALIZE.equals(commandName))
				|| ("GETCONTROLDATA".equals(commandName))) {
			return doInitializeData();
		}
		if (Constants.INIT.equals(commandName)) {
			return doInitializeData();
		}
		if (Constants.PAGING.equals(commandName)) {
			return doPageQuery();
		}
		if (Constants.GETENTITY.equals(commandName)) {
			return doQueryEntityForEidt();
		}
		// Modify by JohnnyHuang 黄福强 2014-11-26
		// 自定义
		String str = checkRequestUrl(commandName);
		if (str != null) {
			return str;
		}

		return doCustom(commandName);
	}
	
	/**
	* 业务描述： 设置请求参数
	* 作    者：Johnny Huang
	* 完成日期：2016-2-24 	上午10:49:43
	* @param @param request
	* @return void
	 */
	public void SetParameterNames(HttpServletRequest request){}
	
	@Override
	public String service(HttpServletRequest request)
			throws JSONServiceException {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String commandName = getMethodName(request);
		if ("siebel".equals(commandName)) {
			//设置请求参数
			SetParameterNames(request);
			return doPcCustom(request);
		}
		
		String requestJsonObject = HttpRequestUtil.getJsonFromRequest(request);
		if ("pcCustom".equals(commandName)||"siebelCustom".equals(commandName)) {
			requestJsonObject = HttpRequestUtil.getJsonFromRequestURL(request);
		}
		
		if (!"siebelCustom".equals(commandName)&&!requestJsonObject.equals("")) {//siebel请求跳过加密
			String key = Env.getInstance().getProperty("SECRET_KEY");
			try {
				requestJsonObject = McrmDesSecretUtil.doDecrypt(requestJsonObject,key);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("解密时发生错误："+e.getMessage()+";requestJsonObject:"+requestJsonObject);
				jsonMap.put("S", "false");
				jsonMap.put("M", "无法解析请求字符串，请联系管理员！");
				return getGsonStr(jsonMap);
			}
		}
		// 判断如果是Post提交方式
		if (requestJsonObject.indexOf(PostBaseJson.COMMAND_NAME) > -1) {
			Type type = new TypeToken<PostBaseJson>() {
			}.getType();
			try {
				PostBaseJson o = (PostBaseJson) GSONUtil.getJavaFromGsonStr(
						type, requestJsonObject);
				commandName = o.getC();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.log.info("commandName(请求命令): " + commandName);
		}

		// 执行PC的业务功能
		
		// if ("LOGOUT".equals(commandName))
		// {
		// return doLogOut(request,requestJsonObject);
		// }
		// if (Constants.ADD.equals(commandName))
		// {
		// return doAdd(request,requestJsonObject);
		// }
		// if ((Constants.EDIT.equals(commandName)) ||
		// (Constants.UPDATE.equals(commandName)))
		// {
		// return doEdit(request,requestJsonObject);
		// }
		// if (Constants.DELETE.equals(commandName))
		// {
		// return doDelete(request,requestJsonObject);
		// }
		// if (Constants.QUERY.equals(commandName))
		// {
		// return doQuery(request,requestJsonObject);
		// }
		// if ((Constants.INITIALIZE.equals(commandName)) ||
		// ("GETCONTROLDATA".equals(commandName)))
		// {
		// return doInitializeData(request,requestJsonObject);
		// }
		// if (Constants.INIT.equals(commandName))
		// {
		// return doInitializeData(request,requestJsonObject);
		// }
		// if (Constants.PAGING.equals(commandName))
		// {
		// return doPageQuery(request,requestJsonObject);
		// }
		// if (Constants.GETENTITY.equals(commandName))
		// {
		// return doQueryEntityForEidt(request,requestJsonObject);
		// }
		// if ("EXPORT".equals(commandName))
		// {
		// return doExport(request,requestJsonObject);
		// }

		// Modify by JohnnyHuang 黄福强 2014-11-26
		// 自定义
		String str = checkRequestUrl(commandName, request, requestJsonObject);
		if (str != null) {
			return str;
		}

		return doCustom(commandName, requestJsonObject);
	}

	// 执行PC端的功能 json
	public String doPcCustom(HttpServletRequest request,
			String requestJsonObject) {
		return null;
	}

	// 执行PC端的功能 非json
	public String doPcCustom(HttpServletRequest request) {
		return null;
	}
	
	// 登陆
	public String doLogin(HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	// 注销
	public String doLogOut(HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	// 导出
	public String doExport(HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	// 效验请求路径
	public String checkRequestUrl(String commandName) {
		return null;
	}

	public String checkRequestUrl(String commandName,
			HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	public String getDomainGsonStr(String gsonStr) {
		String result = gsonStr;
		if (null != this.request) {
			String callBack = getParameter("CallBack");
			if (StringUtil.isNullAndBlank(callBack)) {
				result = (callBack + "(" + gsonStr + ")").toString();
			}
		}
		return result;
	}

	public String getDomainGsonStr(ResultData resultData) {
		String gsonStr = GSONUtil.getGsonStr(resultData);
		String result = gsonStr;
		if (null != this.request) {
			String callBack = getParameter("CallBack");
			if (StringUtil.isNullAndBlank(callBack)) {
				result = (callBack + "(" + gsonStr + ")").toString();
			}
		}
		return result;
	}

	public String getCustomGsonStr(String datasource) {
		StringBuffer buf = new StringBuffer();
		buf.append("{\"Succeed\":true,\"ErrMsg\":\"\",\"Data\":");
		buf.append(datasource);
		buf.append("}");
		String result = buf.toString();
		if (null != this.request) {
			String callBack = getParameter("CallBack");
			if (StringUtil.isNullAndBlank(callBack)) {
				result = (callBack + "(" + buf.toString() + ")").toString();
			}
		}

		System.out.println(result);
		return result;
	}

	public String doInitializeData() {
		return null;
	}

	public String doInitializeData(HttpServletRequest request,
			String requestJsonObject) {
		return null;
	}

	public String doQueryEntityForEidt() {
		return null;
	}

	public String doQueryEntityForEidt(HttpServletRequest request,
			String requestJsonObject) {
		return null;
	}

	public String doCustom(String commandName) throws JSONServiceException {
		return null;
	}

	public String doCustom(String commandName, String requestJsonObject)
			throws JSONServiceException {
		return null;
	}

	public String doAdd() {
		return null;
	}

	public String doAdd(HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	public String doEdit() {
		return null;
	}

	public String doEdit(HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	public String doDelete() {
		return null;
	}

	public String doDelete(HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	public String doQuery() {
		return null;
	}

	public String doQuery(HttpServletRequest request, String requestJsonObject) {
		return null;
	}

	public String doPageQuery() {
		return null;
	}

	public String doPageQuery(HttpServletRequest request,
			String requestJsonObject) {
		return null;
	}

	protected String getParameter(String parameterName) {
		String parameterVal = null;
		if (null == parameterName) {
			this.log.error("parameterName(参数名称)为null.");
			return null;
		}
		this.log.info("It's accepting parameterName:" + parameterName);
		String key = parameterName.toUpperCase();
		try {
			if (isContainKey(this.requestParameterMap, key)) {
				parameterVal = this.requestParameterMap.get(key);
			}
			if (null == parameterVal) {
				parameterVal = this.request.getParameter(parameterName);
			}
		} catch (Exception e) {
			this.log.error("It's occured error in getting parameter("
					+ parameterName + "),Cause:" + e);
		}
		return parameterVal;
	}

	protected Object getAttribute(String attrName) {
		Object attrVal = null;
		if (null == attrName) {
			this.log.error("attrName is null!");
			return attrVal;
		}
		this.log.info("It's accepting attrName:" + attrName);
		String key = attrName.toUpperCase();
		try {
			if (isContainKey(this.requestAttrMap, key)) {
				attrVal = this.requestAttrMap.get(key);
			}
			if (null == attrVal) {
				attrVal = this.request.getAttribute(attrName);
			}
		} catch (Exception e) {
			this.log.error("It's occured error in getting attribute("
					+ attrName + "),Cause:" + e);
		}
		return attrVal;
	}

	private boolean isContainKey(Map<?, ?> ht, String key) {
		boolean flag = false;
		if ((null != key) && (null != ht) && (ht.containsKey(key))) {
			flag = true;
		}
		return flag;
	}
	
	/**
	* 业务描述：map 转为 字符串
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:41:59
	* @param @param jsonMap
	* @param @return
	* @return String
	 */
    public synchronized String getGsonStr(Map<String, Object> jsonMap)
    {
    	String str = GSONUtil.getGsonStr(jsonMap);    	
    	log.info("输出参数："+str);
    	return str;
    }
}