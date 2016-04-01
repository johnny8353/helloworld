package com.zte.mcrm.framework.ui.framework.controller;

import java.lang.reflect.Type;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

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
@Controller("siebelBaseCtrl")
public class SiebelBaseController extends BaseJSONService{
	private int page;//页大小
	private int limit;
	private int start;
	private String sort;//排序字段
	private String dir;//排序方式 DESC ASC
	private String obj;//请求的json串
	private String method;//请求方法
	private String rowId;
	
	public String FormatException(Exception ex){
		String formatString = ex.toString();
		if(ex instanceof ClassNotFoundException){
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
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getRowId() {
		return rowId;
	}


	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	
}
