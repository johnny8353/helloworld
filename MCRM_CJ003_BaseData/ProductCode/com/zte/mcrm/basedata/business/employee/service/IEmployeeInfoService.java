/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_IEmployeeInfoService 
 * 文件名称：IEmployeeInfoService.java
 * 系统编号：100000201191
 * 系统名称：MSM市场营销管理
 * 组件编号：MSM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-10-21
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-10-21
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.basedata.business.employee.service;

import com.zte.mcrm.basedata.access.employee.vo.EmployeeInfoVO;
import com.zte.mcrm.basedata.model.employee.EmployeeInfoBO;
import com.zte.mcrm.framework.model.framework.McrmException;

/**
 * @author JohnnyHuang 黄福强
 *
 */
public interface IEmployeeInfoService
{
	/**
	 * 
	 * 业务描述：保存人员信息
	 * 作          者：10144901
	 * 完成日期：2015-01-26
	 * @param EmployeeInfoVO
	 * @return
	 * @throws McrmException
	 */
	public void saveEmployeeInfo(EmployeeInfoVO employeeInfoVo) throws McrmException;
	
	/**
	 * 
	 * 业务描述：更新人员信息
	 * 作    者：10144901
	 * 完成日期：2015-01-26
	 * @param EmployeeInfoVO
	 * @return
	 * @throws McrmException
	 */
	public boolean updateEmployeeInfo(EmployeeInfoVO employeeInfoVo) throws McrmException;
	
	/**
	 * 获取一条员工信息
	 * @param employeeInfoVo
	 * @return
	 * @throws McrmException
	 */
	public EmployeeInfoBO getEmployeeInfo(EmployeeInfoVO employeeInfoVo) throws McrmException;
}
