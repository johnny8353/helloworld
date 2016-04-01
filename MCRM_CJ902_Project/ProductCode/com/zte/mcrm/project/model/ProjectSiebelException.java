package com.zte.mcrm.project.model;

import com.zte.mcrm.framework.model.framework.SiebelException;
import com.zte.mcrm.framework.model.framework.SiebelExceptionComm;

/**   
 * 类 编 号：
 * 类 名 称：ProjWeekReportListSiebelException.java
 * 内容摘要：
 * 完成日期：2016-1-21  
 * 编码作者：QunLi
 */
public class ProjectSiebelException extends SiebelException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6459097143023056123L;
	
	
		//模块组件名称
		private final static String MODULE_NAME="项目";
		//模块组件编号
		private final static String MODULE_CODE="CJ902";
		
		public ProjectSiebelException()
		{
			getMcrmExceptionBO().getMcrmExceptionVO().setModuleName(MODULE_NAME);
		}
		  /**
	     * 
	     * 业务描述：该方法负责统一处理数据同步组件产生的异常 抛出
	     * 作          者：JohnnyHuang 黄福强
	     * 完成日期：2014-10-14
	     * @param errorLayer
	     * @param className
	     * @param exception
	     * @throws McrmException
	     */
	    public static synchronized void throwSiebelException(String sysFlag,String methodName,String errorLayer,String className,Exception exception) throws SiebelException
	    {
	    	SiebelExceptionComm.throwSiebelException(sysFlag,methodName,errorLayer,MODULE_NAME,MODULE_CODE,className,exception);
	    }
	    /**
	     * 单纯生成McrmException错误对象而不抛出以便后续手工处理
	     * @param errorLayer
	     * @param moduleName
	     * @param className
	     * @param exception
	     * @return
	     */
	    public static synchronized SiebelException generateSiebelException(String sysFlag,String methodName,String errorLayer, String className, Exception exception)
	    {
	    	return SiebelExceptionComm.generateSiebelException(sysFlag,methodName,errorLayer, MODULE_NAME,MODULE_CODE, className, exception);
	    }

}

