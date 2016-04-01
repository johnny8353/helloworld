package com.zte.mcrm.basedata.access.employee.dao;

import org.springframework.stereotype.Repository;

import com.zte.mcrm.basedata.access.employee.vo.EmployeeInfoVO;
import com.zte.mcrm.basedata.model.employee.EmployeeInfoBO;
import com.zte.mcrm.framework.model.framework.McrmException;

/**
 * 业务描述：操作动态信息
 * 完成日期：2014-11-17
 * @author 10144901
 *
 */
@Repository
public interface IEmployeeInfoDAO 
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
