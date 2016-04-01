/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmBaseBO 
 * 文件名称：McrmBaseBO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-11-17
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-11-17
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.model.framework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 类 编 号：BL_PU2010101_McrmBaseBO
 * 类 名 称：McrmBaseBO
 * 内容摘要：公共参数定义，所有其它业务BO继承此公共BO 
 * 完成日期：2014-11-17
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmBaseBO implements Serializable
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1009751821479442790L;
	///** 是否成功S:true,false */
	public static final String IS_SUCCESS="S";
	public static final String SUCCESS="true";
	public static final String FALSE="false";
	//翻页对象
	public static final String PAGE_OBJ="P";
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
	public String C;
	/** Token对象:T */
	public String T;
	/** 语言标志L：2052中文1033英文 */
	public String L;
	/** 分页对象P */
	public PageBO P = new PageBO();
	/** 员工工号U */
	public String U;
    //是否成功标志:true,false
	public String S;
	//错误描述
	public String errorMsg;
	//
	public String errorCode;
	
	//简单格式参数输入对象 F，接收客户端参数用
	private List<FBO> F = new ArrayList<FBO>();
	//简单格式参数输入对象 FMap
	private Map<String,String> fMap = new HashMap<String, String>();
    //接收对象
	private Map<String,Object> objMap=new HashMap<String,Object>();
	//是否自动取消关注
	private String cancel;
	/**
	 * @return the objMap
	 */
	public Map<String, Object> getObjMap()
	{
		if(objMap.size()<1)
		{
			setMapParam();	
		}
		
		return objMap;
	}

	/**
	 * @param objMap the objMap to set
	 */
	public void setObjMap(Map<String, Object> objMap)
	{
		this.objMap = objMap;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	public String getS()
	{
		return S;
	}

	public void setS(String s)
	{
		S = s;
	}

	public String getErrorMsg()
	{
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the c
	 */
	public String getC()
	{
		return C;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setC(String c)
	{
		C = c;
	}

	/**
	 * @return the l
	 */
	public String getL()
	{
		return L;
	}

	/**
	 * @param l
	 *            the l to set
	 */
	public void setL(String l)
	{
		L = l;
	}

	/**
	 * @return the p
	 */
	public PageBO getP()
	{
		return P;
	}

	/**
	 * @param p
	 *            the p to set
	 */
	public void setP(PageBO p)
	{
		P = p;
	}

	/**
	 * @return the u
	 */
	public String getU()
	{
		return U;
	}

	/**
	 * @param u
	 *            the u to set
	 */
	public void setU(String u)
	{
		U = u;
	}
 
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
	
	/**
	 * 业务描述：业务返回对象
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-11-18
	 * @return
	 */
	public  Map<String,Object> getOutputNoCommandNameMap()
	{
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put(IS_SUCCESS,FALSE);
		jsonMap.put(EXCEPTION_MSG, "服务端没有该服务方法："+C);
		jsonMap.put(EXCEPTION_CODE, "4444");
		return jsonMap;
	}
	
	public List<FBO> getfList() {
		return F;
	}

	public void setfList(List<FBO> F) {
		this.F = F;
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
		return fMap;
	}
	
	
	
	
	

	public void setfMap(Map<String, String> fMap) {
		this.fMap = fMap;
	}

	public String getT() {
		return T;
	}

	public void setT(String t) {
		T = t;
	}

	/**
	 * @return the cancel
	 */
	public String getCancel()
	{
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(String cancel)
	{
		this.cancel = cancel;
	}

//	/**
//	 * @return the d
//	 */
//	public DBO getD()
//	{
//		return D;
//	}
//
//	/**
//	 * @param d the d to set
//	 */
//	public void setD(DBO d)
//	{
//		D = d;
//	}
}
