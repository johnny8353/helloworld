/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_EmployeeInfo 
 * 文件名称：EmployeeInfo.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：ServiceSrc
 * 设计作者：10144901
 * 完成日期：2015年1月24日
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：10144901
 * 修改日期：2015年1月24日
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.basedata.model.employee;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.zte.mcrm.basedata.access.dept.vo.DeptInfoVO;
import com.zte.mcrm.basedata.access.employee.vo.EmployeeInfoVO;
import com.zte.mcrm.pcframework.model.pcframework.BasePcBO;


/**
 * 类 编 号：BL_PU2010101_EmployeeInfo
 * 类 名 称：EmployeeInfo
 * 内容摘要：XXX 
 * 完成日期：2015年1月24日
 * 编码作者：10144901
 */
public class EmployeeInfoBO extends BasePcBO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 136120959525476490L;
	//员工对象
	EmployeeInfoVO employeeInfoVo = new EmployeeInfoVO();
    //员工对应的部门
    private DeptInfoVO deptInfoVO=new DeptInfoVO();
    //登陆用户所拥有的资源权限信息
    private List<BigInteger> userResAuthIds=new ArrayList<BigInteger>();
    
	public List<BigInteger> getUserResAuthIds()
	{
		return userResAuthIds;
	}

	public void setUserResAuthIds(List<BigInteger> userResAuthIds)
	{
		this.userResAuthIds = userResAuthIds;
	}

	public DeptInfoVO getDeptInfoVO()
	{
		return deptInfoVO;
	}

	public void setDeptInfoVO(DeptInfoVO deptInfoVO)
	{
		this.deptInfoVO = deptInfoVO;
	}

	public EmployeeInfoVO getEmployeeInfoVo()
	{
		return employeeInfoVo;
	}

	public void setEmployeeInfoVo(EmployeeInfoVO employeeInfoVo)
	{
		this.employeeInfoVo = employeeInfoVo;
	}
    
	
}
