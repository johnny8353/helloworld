/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_IMcrmExceptionInfoService 
 * 文件名称：IMcrmExceptionInfoService.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-14
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-14
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.business.framework.service;

import java.util.List;
import java.util.Map;

import com.zte.mcrm.framework.access.framework.vo.McrmExceptionVO;
import com.zte.mcrm.framework.model.framework.McrmException;
import com.zte.mcrm.framework.model.framework.McrmExceptionBO;

/**
 * 类 编 号：BL_PU2010101_IMcrmExceptionInfoService
 * 类 名 称：IMcrmExceptionInfoService
 * 内容摘要：XXX 
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
public interface IMcrmExceptionInfoService
{
	/**
	 * 业务描述：保存异常信息 
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-10-14
	 * @param mcrmExceptionBO
	 * @return
	 */
	public boolean saveExceptionInfo(McrmExceptionBO mcrmExceptionBO);
	
	 /**
	  * 
	  * 业务描述：获取一条异常信息
	  * 作          者：JohnnyHuang 黄福强
	  * 完成日期：2014-10-22
	  * @param exId
	  * @return
	  * @throws Exception
	  */
	 public McrmExceptionBO getExceptinInfo(int exId) throws McrmException;
	 
	 /**
	  * 
	  * 业务描述：根据条件查询异常信息
	  * 作          者：6418000155
	  * 完成日期：2015-1-19
	  * @param mapData
	  * @return
	  * @throws McrmException
	  */
	 public List<McrmExceptionVO> getExceptionInfoList(Map<String,Object> mapData) throws McrmException;
}
