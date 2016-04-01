/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_PrivMcrmException 
 * 文件名称：PrivMcrmException.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-14
 * 设计文档：XXX
 * 内容摘要：权限管理组件的异常处理类，负责统一处理权限管理组件产生的异常。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-14
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.privilege.model;

import com.zte.mcrm.framework.model.framework.McrmException;
import com.zte.mcrm.framework.model.framework.McrmExceptionComm;

/**
 * 类 编 号：BL_PU2010101_PrivMcrmException
 * 类 名 称：PrivMcrmException
 * 内容摘要：权限管理组件的异常处理类，负责统一处理权限管理组件产生的异常 
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
public class PrivMcrmException extends McrmException
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2342765451769635660L;
	//模块组件名称
	private final static String CJ201_NAME="权限管理";
	//模块组件编号
	private final static String CJ201_CODE="CJ201";
	
    public PrivMcrmException()
    {
    	getMcrmExceptionBO().getMcrmExceptionVO().setModuleName(CJ201_NAME);
    }
    
    /**
     * 
     * 业务描述：该方法负责统一处理权限管理组件产生的异常 抛出
     * 作          者：JohnnyHuang 黄福强
     * 完成日期：2014-10-14
     * @param errorLayer
     * @param className
     * @param exception
     * @throws McrmException
     */
    public static synchronized void throwPrivMcrmException(String errorLayer,
    		String className,
    		Exception exception) throws McrmException
    {
    	McrmExceptionComm.throwMcrmException(errorLayer,CJ201_NAME,CJ201_CODE,className,exception);
    }
    /**
     * 单纯生成McrmException错误对象而不抛出以便后续手工处理
     * @param errorLayer
     * @param moduleName
     * @param className
     * @param exception
     * @return
     */
    public static synchronized McrmException generateMcrmException(String errorLayer, String className, Exception exception)
    {
    	return McrmExceptionComm.generateMcrmException(errorLayer, CJ201_NAME,CJ201_CODE, className, exception);
    }
}
