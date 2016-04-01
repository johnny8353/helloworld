package com.zte.mcrm.framework.ui.framework.controller;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.util.JSONUtils;

import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zte.itp.ssb.framework.base.BaseJSONService;
import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.framework.common.util.Env;
import com.zte.mcrm.framework.common.util.McrmDesSecretUtil;
import com.zte.mcrm.framework.common.util.StringUtils;
import com.zte.mcrm.framework.common.util.SysConst;
import com.zte.mcrm.framework.model.framework.ExceptionBO;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.framework.model.framework.SiebelException;
/**
 * 类 编 号：
 * 类 名 称：SiebelBaseController
 * 内容摘要：系统基础控制器类，所有业务控制器均需要继承此基础类  
 * 完成日期：2016-1-2
 * 编码作者：JohnnyHuang
 */
@Controller("BaseCtrl")
public class BaseController extends BaseJSONService{
	private int page;//页大小
	private int limit;
	private int start;
	private String sort;//排序字段
	private String dir;//排序方式 DESC ASC
	private String obj;//请求的json串
	private String sMethod;//请求方法
	private String rowId;
	
	/**
	 * 基类的统一入口方法所有客户端的调用方法先进该方法
	 */
	public String doPcCustom(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("UseraName", "johnny");
		log.info("Request：" + request);
		// 返回值
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			// // 公共业务BO,所有的具体业务BO都继承它进行扩展
			// SiebelBaseBO baseBO = (SiebelBaseBO)
			// getJavaFromStrJson(SiebelBaseBO.class,requestJsonObject);
			// baseBO = (baseBO == null) ? new SiebelBaseBO() : baseBO;

			// 方法为空
			if (StringUtils.checkStrIsEmpty(sMethod)) {
				// 没匹配到相应的方法的情况
				// 没匹配到相应的方法的情况
				jsonMap = new HashMap<String, Object>();
				// 状态
				jsonMap.put(SiebelBaseBO.IS_SUCCESS, SiebelBaseBO.FAIL);
				// 错误提示语
				jsonMap.put(SiebelBaseBO.EXCEPTION_MSG, "方法不能为空");
				// 错误码
				jsonMap.put(SiebelBaseBO.EXCEPTION_CODE, "");
				return getGsonStr(jsonMap);
			}
			// //换成真实方法名,方法key首字母大写
			// commandName=ss+commandName;
			// //将方法名拼上版本号
			// if(!StringUtils.checkStrIsEmpty(baseBO.getVer()))
			// {
			// commandName=commandName+baseBO.getVer().trim();
			// }
			// 利用反射处理读取类的方法列表
			Class<?> clss = getClass();
			// 方法列表
			Method[] methods = clss.getDeclaredMethods();
			// 从方法列表中查询是否存在将在调用的方法(注意没有特别考虑重载的情况，业务中不要使用方法重载)
			boolean existMethod = false;
			// 最终确定的调用方法
			Method method = null;
			// 方法参数数组
			Object[] paras = null;

			for (int i = 0; i < methods.length; i++) {
				method = methods[i];
				// 有匹配到的方法
				if (method.getName().equals(sMethod)) {
					Class<?>[] parameterTypes = method.getParameterTypes();
					// 参数附值
					paras = new Object[parameterTypes.length];
					int k = 0;
					for (Class<?> clas : parameterTypes) {
						if (JSONUtils.getInnerComponentType(clas).equals(
								HttpServletRequest.class)) {
							paras[k] = request;
						} else {
							// 如果定义的为控制层自定义的业务BO，那么就再转一次JSON字符串到自定义业务BO对象
							// paras[k] =
							// getJavaFromStrJson(clas,requestJsonObject);
						}
						k++;
					}
					existMethod = true;
					break;
				}
			}
			// 匹配到相应的方法
			if (existMethod) {
				jsonMap = (Map<String, Object>) method.invoke(this, paras);
				if (StringUtils.checkStrIsEmpty(""
						+ jsonMap.get(SiebelBaseBO.IS_SUCCESS))) {
					jsonMap.put(SiebelBaseBO.IS_SUCCESS, SiebelBaseBO.SUCCESS);
				}
			} else {
				// 没匹配到相应的方法的情况
				jsonMap = new HashMap<String, Object>();
				// 状态
				jsonMap.put(SiebelBaseBO.IS_SUCCESS, SiebelBaseBO.FAIL);
				// 错误提示语
				jsonMap.put(SiebelBaseBO.EXCEPTION_MSG, "无法找到方法：" + sMethod);
				// 错误码
				jsonMap.put(SiebelBaseBO.EXCEPTION_CODE, "");
			}
			log.info("Respone：" + getGsonStr(jsonMap));
			return getGsonStr(jsonMap);
		} catch (Exception ex) {
			// 没匹配到相应的方法的情况
			jsonMap = new HashMap<String, Object>();
			// 状态
			jsonMap.put(SiebelBaseBO.IS_SUCCESS, SiebelBaseBO.FAIL);
			// 错误提示语
			jsonMap.put(SiebelBaseBO.EXCEPTION_MSG, ex.getMessage());
			return getGsonStr(jsonMap);// exception(FrameMcrmException.generateMcrmException(SiebelExceptionComm.ERROR_LAYER_CONTROLER,
										// this.getClass().getName(), ex),obj);
		}
	}

	public String FormatException(Exception ex) {
		String formatString = ex.toString();
		if (ex instanceof ClassNotFoundException) {
			formatString = "无法找到对应的类！";
		}
		return formatString;
	}
	
	/**
	* 业务描述： 设置请求参数
	* {SORT=name, START=0, _DC=1456278913733, PAGE=1, DIR=DESC, LIMIT=10}
	* 作    者：Johnny Huang
	* 完成日期：2016-2-24 	上午10:49:43
	* @param @param request
	* @return void
	 */
	@Override
	public void SetParameterNames(HttpServletRequest request){
		try{
			String start = requestParameterMap.get("start".toUpperCase());
			String page = requestParameterMap.get("page".toUpperCase());
			String limit = requestParameterMap.get("limit".toUpperCase());
			String dir = requestParameterMap.get("dir".toUpperCase());
			String sort = requestParameterMap.get("sort".toUpperCase());
			String obj = requestParameterMap.get("obj".toUpperCase());
			String method = requestParameterMap.get("method".toUpperCase());
			if(!StringUtil.retBlankIfNull(start).equals("")){
				setStart(Integer.parseInt(start));
				setPage(Integer.parseInt(page));
				setLimit(Integer.parseInt(limit));
				setDir(dir);
				setSort(sort);
			}
			setObj(obj);
			setMethod(method);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	
    /**
     * 同步控制JSON转换
     * 业务描述：XXX 
     * 作          者：Administrator
     * 完成日期：2014-12-15
     * @param jsonMap
     * @return
     */
    public synchronized String getGsonStr(ExceptionBO ebo)
    {
    	String str = GSONUtil.getGsonStr(ebo);
    	log.info("异常输出参数："+str);   	
    	return str;
    }


	public String exception(SiebelException siebelException,String requestJsonObject) 
    {
    	
    	String errorJson="";
    	String errorMsg = "";
		ExceptionBO ebo=new ExceptionBO();
    	try
    	{
    		SiebelBaseBO paramBO=getSiebelBaseBO(requestJsonObject);
    		//
            siebelException.getMcrmExceptionBO().getMcrmExceptionVO().setCreatedBy(paramBO.getU());
		    siebelException.getMcrmExceptionBO().getMcrmExceptionVO().setLastUpdatedBy(paramBO.getU());
		    //根据errorCode获取提示语
		    String errorCode = siebelException.getMcrmExceptionBO().getMcrmExceptionVO().getErrorCode();
		    String msgTip=getErrMsgTip(errorCode,paramBO.getL());
            if(StringUtils.checkStrIsEmpty(msgTip))
            {
            	msgTip=getErrMsgTip(SysConst.SS_METHOD_ERROR,paramBO.getL());
            }
		    //替换系统名
		    msgTip=msgTip.replace(SysConst.SYS_NAME, siebelException.getMcrmExceptionBO().getMcrmExceptionVO().getAppName());
		    //方法名
		    msgTip=msgTip.replace(SysConst.METHOD_NAME, siebelException.getMcrmExceptionBO().getMcrmExceptionVO().getMethodName());

		    int errorId=siebelException.getMcrmExceptionBO().getMcrmExceptionVO().getExceptionInfoId();
		    //替换异常id
		    msgTip=msgTip.replace(SysConst.EXEC_ID,errorId+"");
		    
		    paramBO=null;
		    ebo.setS(ExceptionBO.FALSE);
			ebo.setErrorCode(ExceptionBO.ERROR_1000);
			ebo.setErrorMsg(msgTip);
			errorJson=getGsonStr(ebo);
    	}
    	catch(Exception ex)
    	{
    		
    		ex.printStackTrace();
    		ebo.setS(ExceptionBO.FALSE);
    		ebo.setErrorCode(ExceptionBO.ERROR_1000);
    		errorMsg = "内部服务器在处理异常时发生额外异常！";
    		if(!StringUtils.checkStrIsEmpty(siebelException.getErrorMsg())){
    			errorMsg = siebelException.getErrorMsg();//对于手动抛出的错误
            }
			ebo.setErrorMsg(errorMsg);
			errorJson=getGsonStr(ebo);
    	} 
    	return errorJson;
    }  
	
    /**
	 * 
	 * 获取异常提示语
	 * 编码作者:JohnnyHuang 黄福强
	 * 完成日期:2016-1-4
	 * @param key
	 * @param lan
	 * @return
	 */
	protected String getErrMsgTip(String key, String lan)
	{
		String errTip = "服务器业务处理发生了异常!(#EXECID#)";
		return errTip;
	}
	/**
	 * 
	 * 业务描述：获取接口服务参数对象
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-11-17
	 * @return
	 */
	private SiebelBaseBO getSiebelBaseBO(String requestJsonObject)
	{
		 Type type = new TypeToken<SiebelBaseBO>() {}.getType();
		 return (SiebelBaseBO) GSONUtil.getJavaFromGsonStr(type,requestJsonObject);
	}
	
	public String doDecryptRequest(String jsonStr){
		String result = "";
		try {
			String key = Env.getInstance().getProperty("SECRET_KEY");
			result = McrmDesSecretUtil.doDecrypt(jsonStr,key);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("解密时发生错误："+e.getMessage());
			throw new SiebelException(e.getMessage(),"无法解析请求字符串，请联系管理员！");
		}
		return result;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
    public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}


	public String getMethod() {
		return sMethod;
	}


	public void setMethod(String method) {
		this.sMethod = method;
	}


	public String getRowId() {
		return rowId;
	}


	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	
}
