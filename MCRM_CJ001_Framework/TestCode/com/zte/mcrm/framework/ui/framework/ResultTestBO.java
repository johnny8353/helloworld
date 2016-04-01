/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_ResultTestBO 
 * 文件名称：ResultTestBO.java
 * 系统编号：100000201191
 * 系统名称：MSM市场营销管理
 * 组件编号：MSM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-10-13
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-10-13
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.ui.framework;

/**
 * @author JohnnyHuang 黄福强
 *
 */
public class ResultTestBO
{
	//总测试用例数
   private int totalNum;
   //通过测试用例数
   private int passNum;
   //程序异常测试用例数
   private int errorNum;
   //测试不通过用例数
   private int failureNum;
   //功能测试不通过测试用例数
   private int functionFailureNum;
   //性能测试不通过测试用例数
   private int performanceFailureNum;
   //其它不通过的测试用例
   private int otherCount;
   
   public int getOtherCount()
{
	return otherCount;
}
public void setOtherCount(int otherCount)
{
	this.otherCount = otherCount;
}
//测试通过率
   private String passRate;
   
public String getPassRate()
{
	return passRate;
}
public void setPassRate(String passRate)
{
	this.passRate = passRate;
}
public int getTotalNum()
{
	return totalNum;
}
public void setTotalNum(int totalNum)
{
	this.totalNum = totalNum;
}
public int getPassNum()
{
	return passNum;
}
public void setPassNum(int passNum)
{
	this.passNum = passNum;
}
public int getErrorNum()
{
	return errorNum;
}
public void setErrorNum(int errorNum)
{
	this.errorNum = errorNum;
}
public int getFailureNum()
{
	return failureNum;
}
public void setFailureNum(int failureNum)
{
	this.failureNum = failureNum;
}
public int getFunctionFailureNum()
{
	return functionFailureNum;
}
public void setFunctionFailureNum(int functionFailureNum)
{
	this.functionFailureNum = functionFailureNum;
}
public int getPerformanceFailureNum()
{
	return performanceFailureNum;
}
public void setPerformanceFailureNum(int performanceFailureNum)
{
	this.performanceFailureNum = performanceFailureNum;
}
   
}
