/**
 * 版权所有：版权所有(C) 2016，中兴通讯 
 * 文件编号：BL_PU2010101_UnitTestParamsBO 
 * 文件名称：UnitTestParamsBO.java
 * 系统编号：100000201191
 * 系统名称：SmartSales 智慧营销
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2016-2-3
 * 设计文档：<如有rose的设计文件则需要填写设计文件名称>
 * 内容摘要：<描写该文件主要功能职责和后续扩展范围> 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2016-2-3
 * 活  动   号：<填写在EC上的开发活动号和名称或版本号>
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.model.framework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zte.mcrm.framework.access.framework.vo.UnitTestParamsVO;

/**
 * 内容摘要：用于单元测试业务
 * 完成日期：2016-2-3
 * 编码作者：JohnnyHuang 黄福强
 */
public class UnitTestParamsBO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4929967373938275801L;
	
	/**
	 * 总测试用例数
	 */
	private int testTotalNum;
	/**
	 * 通过测试用例数
	 */
	private int testPassNum;
	/**
	 * 测试通过率
	 */
	private String testPassPersent;
	/**
	 * 失败测试用例数
	 */
	private int testFailNum;
	/**
	 * 功能测试失败个数
	 */
	private int testFuncFailNum;
	/**
	 * 性能测试失败个数
	 */
	private int testPerfFailNum;
	/**
	 * 其它测试情况失败个数
	 */
	private int testOtherFailNum;
	
	/**
	 * 代码异常个数
	 */
	private int testErrorNum;
	
	/**
	 * 测试用例结果集合
	 */
	private List<UnitTestParamsVO> resultList=new ArrayList<UnitTestParamsVO>();

	/**
	 * 测试结果综合描述
	 */
	private String testDesc;
	
	
	
	/**
	 * @return the testErrorNum
	 */
	public int getTestErrorNum()
	{
		return testErrorNum;
	}

	/**
	 * @param testErrorNum the testErrorNum to set
	 */
	public void setTestErrorNum(int testErrorNum)
	{
		this.testErrorNum = testErrorNum;
	}

	/**
	 * @return the testPassNum
	 */
	public int getTestPassNum()
	{
		return testPassNum;
	}

	/**
	 * @param testPassNum the testPassNum to set
	 */
	public void setTestPassNum(int testPassNum)
	{
		this.testPassNum = testPassNum;
	}

	/**
	 * @return the testPassPersent
	 */
	public String getTestPassPersent()
	{
		return testPassPersent;
	}

	/**
	 * @param testPassPersent the testPassPersent to set
	 */
	public void setTestPassPersent(String testPassPersent)
	{
		this.testPassPersent = testPassPersent;
	}

	/**
	 * @return the testFailNum
	 */
	public int getTestFailNum()
	{
		return testFailNum;
	}

	/**
	 * @param testFailNum the testFailNum to set
	 */
	public void setTestFailNum(int testFailNum)
	{
		this.testFailNum = testFailNum;
	}

	/**
	 * @return the testFuncFailNum
	 */
	public int getTestFuncFailNum()
	{
		return testFuncFailNum;
	}

	/**
	 * @param testFuncFailNum the testFuncFailNum to set
	 */
	public void setTestFuncFailNum(int testFuncFailNum)
	{
		this.testFuncFailNum = testFuncFailNum;
	}

	/**
	 * @return the testPerfFailNum
	 */
	public int getTestPerfFailNum()
	{
		return testPerfFailNum;
	}

	/**
	 * @param testPerfFailNum the testPerfFailNum to set
	 */
	public void setTestPerfFailNum(int testPerfFailNum)
	{
		this.testPerfFailNum = testPerfFailNum;
	}

	/**
	 * @return the testOtherFailNum
	 */
	public int getTestOtherFailNum()
	{
		return testOtherFailNum;
	}

	/**
	 * @param testOtherFailNum the testOtherFailNum to set
	 */
	public void setTestOtherFailNum(int testOtherFailNum)
	{
		this.testOtherFailNum = testOtherFailNum;
	}


	
	
	
	/**
	 * @return the testDesc
	 */
	public String getTestDesc()
	{
		return testDesc;
	}

	/**
	 * @param testDesc the testDesc to set
	 */
	public void setTestDesc(String testDesc)
	{
		this.testDesc = testDesc;
	}

	/**
	 * @return the testTotalNum
	 */
	public int getTestTotalNum()
	{
		return testTotalNum;
	}

	/**
	 * @param testTotalNum the testTotalNum to set
	 */
	public void setTestTotalNum(int testTotalNum)
	{
		this.testTotalNum = testTotalNum;
	}

	/**
	 * @return the resultList
	 */
	public List<UnitTestParamsVO> getResultList()
	{
		return resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<UnitTestParamsVO> resultList)
	{
		this.resultList = resultList;
	}
	
	

}
