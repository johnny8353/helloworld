package com.zte.mcrm.framework.model.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.basedata.access.log.vo.LogVO;

public class SiebelBaseBO {
	///** 是否成功S:true,false */
	public static final String IS_SUCCESS="S";
	public static final String SUCCESS="true";
	public static final String FAIL="false";
	public static final String LOG_PREFIX="ZTE日志：";
	
	//翻页对象
	public static final String PAGE_OBJ="P";
	//记录总数
	public static final String TOTAL_RECORD="TR";
	//员工短工号
	public static final String EMP_SHORT_NO="U";
	//异常编码
	public static final String EXCEPTION_CODE="C";
	//异常描述
	public static final String EXCEPTION_MSG="M";
	//业务数据对象
	public static final String DATA_OBJ="D";

	//简单数据对象
	public static final String SIMPLE_ARRAY="F";
	//语言参数
	public static final String LAN_FLAG="L";
	//语言参数
	public static final String PHONE_NUMBERS="phoneNumbers";

	/** 语言标志L：2052中文1033英文 */
	public static final String LAN_CHINESE = "2052";

	public static final String LAN_ENGLISH = "1033";

	/** 服务方法名C */
	private String C;
	/** Token对象:T */
	private String T;
	/** 语言标志L：2052中文1033英文 */
	private String L;
	/** 分页对象P */
	private PageBO P = new PageBO();
	/** 员工工号U */
	private String U;
    //是否成功标志:true,false
	private String S;
	//错误描述
	private String errorMsg;
	//
	private String errorCode;
	//请求开始
	private String requestBegin;
	//请求结束
	private String requestEnd;
	//请求参数
	private String requestParam;
	//名称
	private String name;
	
	private LogVO logVO = new LogVO();
	
	//简单格式参数输入对象 F，接收客户端参数用
	private List<FBO> F = new ArrayList<FBO>();
	//简单格式参数输入对象 FMap
	private Map<String,String> fMap = new HashMap<String, String>();
    //接收对象
	private Map<String,Object> objMap=new HashMap<String,Object>();
	
	/**
	 * 业务描述：业务返回对象
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-11-18
	 * @return
	 */
	public  Map<String,Object> getOutputMap()
	{
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put(IS_SUCCESS,this.S);
		jsonMap.put(EXCEPTION_MSG, this.errorMsg);
		jsonMap.put(EXCEPTION_CODE, this.errorCode);
		return jsonMap;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 业务描述：业务返回对象
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-11-18
	 * @return
	 */
	public  Map<String,Object> getOutputNoCommandNameMap()
	{
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put(IS_SUCCESS,FAIL);
		jsonMap.put(EXCEPTION_MSG, "服务端没有该服务方法"+StringUtil.retBlankIfNull(C));
		jsonMap.put(EXCEPTION_CODE, "4444");
		return jsonMap;
	}
	
	private void setMapParam() 
	{
		if(null != this.F)
		{
			for(FBO f : this.F)
			{
				if(f.getV() instanceof String)
				{
					fMap.put(f.getK(), f.getV().toString());
			    }
				else
				{
					objMap.put(f.getK(),f.getV());
				}
			}
		}

	}
	
	public Map<String, String> getfMap() 
	{
		if(fMap.size()<1)
		{
			setMapParam();
		}
		fMap.put(LAN_FLAG,getL());
		fMap.put(EMP_SHORT_NO,getU());
		return fMap;
	}
	
	public Map<String, Object> getObjMap()
	{
		if(objMap.size()<1)
		{
			setMapParam();	
		}
		return objMap;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getT() {
		return T;
	}

	public void setT(String t) {
		T = t;
	}

	public String getL() {
		/** 语言标志L：2052中文1033英文 */
		String langIdString = "CHS";
		if(StringUtil.retBlankIfNull(L).equals(LAN_ENGLISH)){
			langIdString = "ENU";
		}
		return langIdString;
	}

	public void setL(String l) {
		L = l;
	}

	public PageBO getP() {
		return P;
	}

	public void setP(PageBO p) {
		P = p;
	}

	public String getU() {
		return U;
	}

	public void setU(String u) {
		U = u;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public List<FBO> getF() {
		return F;
	}

	public void setF(List<FBO> f) {
		F = f;
	}

	public String getRequestBegin() {
		return requestBegin;
	}

	public void setRequestBegin(String requestBegin) {
		this.requestBegin = requestBegin;
	}

	public String getRequestEnd() {
		return requestEnd;
	}

	public void setRequestEnd(String requestEnd) {
		this.requestEnd = requestEnd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}
	@SuppressWarnings("static-access")
	public LogVO getLogVO() {
		this.setErrorMsg(StringUtil.retBlankIfNull(this.getErrorMsg()));
		logVO.setROW_ID(String.valueOf(logVO.getRowId()));
		logVO.setINV_USER(this.getU());
		logVO.setMETHOD(this.getC());
		logVO.setNAME(this.getName());
		logVO.setATT01(this.getRequestBegin());
		logVO.setATT02(this.getRequestEnd());
		logVO.setATT03(StringUtil.retBlankIfNull(this.getS()).equals(this.SUCCESS)?"":this.getErrorMsg().substring(0,this.getErrorMsg().length()>1900?1900:this.getErrorMsg().length()));
		logVO.setATT05(this.getP().getT());
		logVO.setDESCS(StringUtil.unicode2String(StringUtil.retBlankIfNull(this.getRequestParam().substring(0,this.getRequestParam().length()>1900?1900:this.getRequestParam().length()))));
		logVO.setSPEND_TIME(DateUtil.getDiffDate(this.getRequestBegin(), this.getRequestEnd()));
		return logVO;
	}
	
}
