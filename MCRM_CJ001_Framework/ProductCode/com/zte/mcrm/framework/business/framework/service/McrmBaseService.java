/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmBaseService 
 * 文件名称：McrmBaseService.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-27
 * 设计文档：MCRM_CJ001_Framework 基础框架 组件设计模型.cat
 * 内容摘要：基础框架业务实现类。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-27
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.business.framework.service;


import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.zte.itp.ssb.framework.common.util.GSONUtil;
import com.zte.mcrm.framework.model.framework.ExceptionBO;
import com.zte.mcrm.framework.model.framework.McrmException;

/**
 * 类 编 号：BL_PU2010101_McrmBaseService
 * 类 名 称：McrmBaseService
 * 内容摘要：基础框架业务实现类 
 * 完成日期：2014-10-27
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmBaseService implements IMcrmBaseService
{
	public String saveException(McrmException mcrmException,String jsonStr)
	{
		String errorJson="";
		ExceptionBO ebo=new ExceptionBO();
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
		IMcrmExceptionInfoService mcrmExceptionInfoService = (IMcrmExceptionInfoService) wac.getBean("mcrmExceptionInfoService");
    	try
    	{   ebo.setS(ExceptionBO.FALSE);
			ebo.setErrorCode(ExceptionBO.ERROR_1000);
			ebo.setErrorMsg(ExceptionBO.ERROR_MSG+"1231221");
			errorJson=GSONUtil.getGsonStr(ebo);
    	}
    	catch(Exception ex)
    	{ 
    		ex.printStackTrace();
    		ebo.setS(ExceptionBO.FALSE);
    		ebo.setErrorCode(ExceptionBO.ERROR_1000);
			ebo.setErrorMsg("内部服务器在处理异常时发生额外异常！");
			errorJson=GSONUtil.getGsonStr(ebo);
    	} 
    	return errorJson;
	}
}
