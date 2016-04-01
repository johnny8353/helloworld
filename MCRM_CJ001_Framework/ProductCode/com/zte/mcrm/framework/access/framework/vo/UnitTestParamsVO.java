/**
 * 版权所有：版权所有(C) 2016，中兴通讯 
 * 文件编号：BL_PU2010101_UnitTestParamsVO 
 * 文件名称：UnitTestParamsVO.java
 * 系统编号：100000201191
 * 系统名称：SmartSales 智慧营销
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2016-1-13
 * 设计文档：<如有rose的设计文件则需要填写设计文件名称>
 * 内容摘要：<描写该文件主要功能职责和后续扩展范围> 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2016-1-13
 * 活  动   号：<填写在EC上的开发活动号和名称或版本号>
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.access.framework.vo;

import java.io.Serializable;

/**
 * 内容摘要：测试参数值对象
 * 完成日期：2016-1-13
 * 编码作者：JohnnyHuang 黄福强
 */
public class UnitTestParamsVO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1340711766024204275L;

	//额外属性
	private double referenceTime;
	///对应数据库表字段
    private String id;
	//业务类的bean id,一般是Controller类的bean id
	private String beanKey;
	//类的中文说明，尽量简洁
	private String beanDesc;
	//方法key,即请求参数中的C的值
	private String methodKey;
	//方法中文描述
	private String methodDesc;
	//测试场景，一个接口方法有多种场景需要测试
	private String testSceneDesc;
	//测试场景对应的测试参数，按json的格式
	private String jsonParams;
	//该场景功能测试通过的条件值
	private String funcPassVal;
	//条件比较方式
	private String compType;
	//该场景性能测试通过的key,目前分三种：NORMAL：普通操作 ,SPEC:特别指定的操作,CS:数据回写操作
	private String perfPassKey;
	//被测试的方法的实际执行时间，跟性能指标对比判断该方法性能是否通过
	private double methodExecTime;
	//最后测试结果,：Success:测试通过(功能测试和性能测试都通过);Failure:功能测试和性能测试其中一种没通过.
	private String testResult;
	//结果详情描述
	private String testResultDesc;
	//编码负责人：如 李兴辉10144901
	private String encodingBy;
	//记录是否有效：Y:有效；N:无效
	private String enableFlag;
	//测试记录创建人：员工电脑号
	private String createdBy;
	//测试记录创建时间：格式如：2016-01-21 12:12:12
	private String createdDate;
	//最后修改人：员工电脑号
	private String lastUpdatedBy;
	//最后修改时间：格式如：2016-01-21 12:12:12
	private String lastUpdatedDate;
	//备注说明 
	private Double memo;
	//测试失败类型:失败类型:1:功能测试不通过,2:性能测试不通过,9:其它测试不通过,0：初始状态,没意义
	private int failType;
	//测试接口类型：CTR  WS
	private String testType;
	
	
	/**
	 * @return the referenceTime
	 */
	public double getReferenceTime()
	{
		return referenceTime;
	}

	/**
	 * @param referenceTime the referenceTime to set
	 */
	public void setReferenceTime(double referenceTime)
	{
		this.referenceTime = referenceTime;
	}

	/**
	 * @return the testType
	 */
	public String getTestType()
	{
		return testType;
	}

	/**
	 * @param testType the testType to set
	 */
	public void setTestType(String testType)
	{
		this.testType = testType;
	}

	/**
	 * @return the failType
	 */
	public int getFailType()
	{
		return failType;
	}

	/**
	 * @param failType the failType to set
	 */
	public void setFailType(int failType)
	{
		this.failType = failType;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the beanKey
	 */
	public String getBeanKey()
	{
		return beanKey;
	}

	/**
	 * @param beanKey the beanKey to set
	 */
	public void setBeanKey(String beanKey)
	{
		this.beanKey = beanKey;
	}

	/**
	 * @return the beanDesc
	 */
	public String getBeanDesc()
	{
		return beanDesc;
	}

	/**
	 * @param beanDesc the beanDesc to set
	 */
	public void setBeanDesc(String beanDesc)
	{
		this.beanDesc = beanDesc;
	}

	/**
	 * @return the methodKey
	 */
	public String getMethodKey()
	{
		return methodKey;
	}

	/**
	 * @param methodKey the methodKey to set
	 */
	public void setMethodKey(String methodKey)
	{
		this.methodKey = methodKey;
	}

	/**
	 * @return the methodDesc
	 */
	public String getMethodDesc()
	{
		return methodDesc;
	}

	/**
	 * @param methodDesc the methodDesc to set
	 */
	public void setMethodDesc(String methodDesc)
	{
		this.methodDesc = methodDesc;
	}

	/**
	 * @return the testSceneDesc
	 */
	public String getTestSceneDesc()
	{
		return testSceneDesc;
	}

	/**
	 * @param testSceneDesc the testSceneDesc to set
	 */
	public void setTestSceneDesc(String testSceneDesc)
	{
		this.testSceneDesc = testSceneDesc;
	}

	/**
	 * @return the jsonParams
	 */
	public String getJsonParams()
	{
		return jsonParams;
	}

	/**
	 * @param jsonParams the jsonParams to set
	 */
	public void setJsonParams(String jsonParams)
	{
		this.jsonParams = jsonParams;
	}

	/**
	 * @return the funcPassVal
	 */
	public String getFuncPassVal()
	{
		return funcPassVal;
	}

	/**
	 * @param funcPassVal the funcPassVal to set
	 */
	public void setFuncPassVal(String funcPassVal)
	{
		this.funcPassVal = funcPassVal;
	}

	/**
	 * @return the perfPassKey
	 */
	public String getPerfPassKey()
	{
		return perfPassKey;
	}

	/**
	 * @param perfPassKey the perfPassKey to set
	 */
	public void setPerfPassKey(String perfPassKey)
	{
		this.perfPassKey = perfPassKey;
	}

	/**
	 * @return the methodExecTime
	 */
	public double getMethodExecTime()
	{
		return methodExecTime;
	}

	/**
	 * @param methodExecTime the methodExecTime to set
	 */
	public void setMethodExecTime(double methodExecTime)
	{
		this.methodExecTime = methodExecTime;
	}

	/**
	 * @return the testResult
	 */
	public String getTestResult()
	{
		return testResult;
	}

	/**
	 * @param testResult the testResult to set
	 */
	public void setTestResult(String testResult)
	{
		this.testResult = testResult;
	}
	
	/**
	 * @return the testResultDesc
	 */
	public String getTestResultDesc()
	{
		return testResultDesc;
	}

	/**
	 * @param testResultDesc the testResultDesc to set
	 */
	public void setTestResultDesc(String testResultDesc)
	{
		this.testResultDesc = testResultDesc;
	}

	/**
	 * @return the encodingBy
	 */
	public String getEncodingBy()
	{
		return encodingBy;
	}

	/**
	 * @param encodingBy the encodingBy to set
	 */
	public void setEncodingBy(String encodingBy)
	{
		this.encodingBy = encodingBy;
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

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate()
	{
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy)
	{
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * @return the lastUpdatedDate
	 */
	public String getLastUpdatedDate()
	{
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(String lastUpdatedDate)
	{
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public Double getMemo() {
		return memo;
	}

	public void setMemo(Double memo) {
		this.memo = memo;
	}

	/**
	 * @return the compType
	 */
	public String getCompType()
	{
		return compType;
	}

	/**
	 * @param compType the compType to set
	 */
	public void setCompType(String compType)
	{
		this.compType = compType;
	}

}
