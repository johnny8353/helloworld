/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：DA_PU2010101_UserOperLogVO 
 * 文件名称：UserOperLogVO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJ201
 * 组件名称：MCRM_CJ201_Privilege
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-27
 * 设计文档：MCRM_CJ201_Privilege 权限管理 组件设计模型.cat
 * 内容摘要：用户操作日志VO。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-27
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.privilege.access.privilege.vo;

/**
 * 类 编 号：DA_PU2010101_UserOperLogVO
 * 类 名 称：UserOperLogVO
 * 内容摘要：用户操作日志VO 
 * 完成日期：2014-10-27
 * 编码作者：JohnnyHuang 黄福强
 */
public class UserOperLogVO
{
//	   OPER_ID             BIGINT(15) not null auto_increment,
	private int operId;
//	   EMP_NO               VARCHAR(50),
	private String empNo;
//	   MODEL_NAME           VARCHAR(50),
	private String modelName;
//	   BUSINESS_NAME        VARCHAR(50),
	private String businessName;
//     OPER_TYPE            VARCHAR(10),
	private String operType;
//	   DATA_ID              VARCHAR(20),
	private String dataId;
//	   OPER_DATE            TIMESTAMP,
	private String operDate;
//	   ENABLE_FLAG          VARCHAR(1) default 'Y',
	private String enableFlag;
	
/**
	 * @return the operId
	 */
	public int getOperId()
	{
		return operId;
	}
	/**
	 * @param operId the operId to set
	 */
	public void setOperId(int operId)
	{
		this.operId = operId;
	}
	/**
	 * @return the empNo
	 */
	public String getEmpNo()
	{
		return empNo;
	}
	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo)
	{
		this.empNo = empNo;
	}
	/**
	 * @return the modelName
	 */
	public String getModelName()
	{
		return modelName;
	}
	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName)
	{
		this.modelName = modelName;
	}
	/**
	 * @return the businessName
	 */
	public String getBusinessName()
	{
		return businessName;
	}
	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName)
	{
		this.businessName = businessName;
	}
	/**
	 * @return the operType
	 */
	public String getOperType()
	{
		return operType;
	}
	/**
	 * @param operType the operType to set
	 */
	public void setOperType(String operType)
	{
		this.operType = operType;
	}
	/**
	 * @return the dataId
	 */
	public String getDataId()
	{
		return dataId;
	}
	/**
	 * @param dataId the dataId to set
	 */
	public void setDataId(String dataId)
	{
		this.dataId = dataId;
	}
	/**
	 * @return the operDate
	 */
	public String getOperDate()
	{
		return operDate;
	}
	/**
	 * @param operDate the operDate to set
	 */
	public void setOperDate(String operDate)
	{
		this.operDate = operDate;
	}
	/**
	 * @return the enableFlag
	 */
	public String getEnableFlag()
	{
		return enableFlag;
	}
	/**
	 * @param enableFlag the enableFlag to set
	 */
	public void setEnableFlag(String enableFlag)
	{
		this.enableFlag = enableFlag;
	}

}
