/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_UserLoginOperLogBO
 * 文件名称：UserLoginOperLogBO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJ201
 * 组件名称：MCRM_CJ201_Privilege
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-22
 * 设计文档：MCRM_CJ201_Privilege 权限管理 组件设计模型.cat
 * 内容摘要：用户日常登陆或操作日志业务对象。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-22
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.privilege.model.privilege;

import com.zte.mcrm.privilege.access.privilege.vo.UserLoginLogVO;
import com.zte.mcrm.privilege.access.privilege.vo.UserOperLogVO;

/**
 * 类 编 号：BL_PU2010101_UserLoginOperLogBO
 * 类 名 称：UserLoginOperLogBO
 * 内容摘要：用户日常登陆或操作日志业务对象
 * 完成日期：2014-10-22
 * 编码作者：JohnnyHuang 黄福强
 */
public class UserLoginOperLogBO
{
	// 登陆日志对象
	private UserLoginLogVO userLoginLogVO = new UserLoginLogVO();
	// 操作日志对象
	private UserOperLogVO userOperLogVO = new UserOperLogVO();
	
	/**
	 * @return the userLoginLogVO
	 */
	public UserLoginLogVO getUserLoginLogVO()
	{
		return userLoginLogVO;
	}
	/**
	 * @param userLoginLogVO the userLoginLogVO to set
	 */
	public void setUserLoginLogVO(UserLoginLogVO userLoginLogVO)
	{
		this.userLoginLogVO = userLoginLogVO;
	}
	/**
	 * @return the userOperLogVO
	 */
	public UserOperLogVO getUserOperLogVO()
	{
		return userOperLogVO;
	}
	/**
	 * @param userOperLogVO the userOperLogVO to set
	 */
	public void setUserOperLogVO(UserOperLogVO userOperLogVO)
	{
		this.userOperLogVO = userOperLogVO;
	}
}
