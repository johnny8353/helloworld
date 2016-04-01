/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmExceptionBO 
 * 文件名称：McrmExceptionBO.java
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
package com.zte.mcrm.framework.model.framework;

import com.zte.mcrm.framework.access.framework.vo.McrmExceptionVO;

/**
 * 类 编 号：BL_PU2010101_McrmExceptionBO
 * 类 名 称：McrmExceptionBO
 * 内容摘要：XXX 
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmExceptionBO
{

	private McrmExceptionVO mcrmExceptionVO=new McrmExceptionVO();

	/**
	 * @return the mcrmExceptionVO
	 */
	public McrmExceptionVO getMcrmExceptionVO()
	{
		return mcrmExceptionVO;
	}

	/**
	 * @param mcrmExceptionVO the mcrmExceptionVO to set
	 */
	public void setMcrmExceptionVO(McrmExceptionVO mcrmExceptionVO)
	{
		this.mcrmExceptionVO = mcrmExceptionVO;
	}
}
