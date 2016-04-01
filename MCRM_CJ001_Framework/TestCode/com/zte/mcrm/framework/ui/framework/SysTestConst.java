/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_SysTestConst 
 * 文件名称：SysTestConst.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-7-1
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-7-1
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.ui.framework;

/**
 * 类 编 号：BL_PU2010101_SysTestConst
 * 类 名 称：SysTestConst
 * 内容摘要：单元测试的常量类 
 * 完成日期：2015-7-1
 * 编码作者：JohnnyHuang 黄福强
 */
public class SysTestConst
{
	//普通功能key
	public static final String NORMAL="NORMAL";
	//普通功能1.6秒内
   public static final long TIME_NORMAL_FUNC=1;
   
   //特别指定的功能key
   public static final String SPEC="SPEC";
   //特别指定的功能2秒内
   public static final long TIME_SPEC_FUNC=2;
   
   //数据回写功能key
   public static final String CS="CS";
   //线索、商机、项目、客户等业务对象的新建、保存时间在3秒内
   public static final long TIME_CS_FUNC = 3;
   
   public static final String TEST_SUFFIX = "ZTEEND";
   
   
   //测试通过
   public static final String SUCCESS="Pass";
   //测试不通过
   public static final String FAILURE="Fail";
   //测试程序本身发生异常
   public static final String ERROR="Error";
   //比较条件:结果和所给条件值相等
   public static final String EQUALS="EQUALS";
   //比较条件:结果包含所给条件值
   public static final String CONTAINER="CONTAINER";
   //比较条件：结果为NULL
   public static final String TO_NULL="TO_NULL";
   //比较条件：数字大小比较，大于条件值
   public static final String NUM_GREATER_THAN="NUM_GREATER_THAN";
   //比较条件：数字大小比较，大于等于条件值
   public static final String NUM_GREATER_EQUAL_THAN="NUM_GREATER_EQUAL_THAN";
   //比较条件：数字大小比较，小于条件值
   public static final String NUM_LESS_THAN="NUM_LESS_THAN";
   //比较条件：数字大小比较，小于等于条件值
   public static final String NUM_LESS_EQUAL_THAN="NUM_LESS_EQUAL_THAN";
	//分隔符 
	public static final String SP="-";
   //功能测试不通过
	public static final String FUNC_TEST_NOT_PASS="功能测试不通过!";
	public static final int FUNC_TEST_NOT_PASS_TYPE=1;
	//性能测试不通过
	public static final String PERF_TEST_NOT_PASS="性能测试不通过!";
	public static final int PERF_TEST_NOT_PASS_TYPE=2;
	
	//测试发生异常
	public static final int ERROR_TEST_TYPE=3;
	
	//其它测试不通过
	public static final String OTHER_TEST_NOT_PASS="其它情况!";
	public static final int OTHER_TEST_NOT_PASS_TYPE=9;
	//单元测试通过
	public static final String TEST_PASS="单元测试通过!";
	public static final int TEST_PASS_TYPE=0;
	//测试类型:Webservice实现类
	public static final String WS="WS";
	//测试类型:Controller类
	public static final String CTR="CTR";
	
	//需要替换的参数key
	public static final String RandomNum="#RandomNum#";
	// 测试通过用例数
	public static final String testPassNum ="#testPassNum#";
	// 测试通过率
	public static final String testPassPersent ="#testPassPersent#";
	
	// 总失败数
	public static final String failNum ="#failNum#";
	// 功能总失败数
	public static final String funcFailNum = "#funcFailNum#";
	// 性能总失败数
	public static final String perfFailNum = "#perfFailNum#";
	// 其它总失败数
	public static final String otherFailNum = "#otherFailNum#";
    // 总测试用例数
	public static final String totalNum ="#totalNum#";
    // 测试用明细
	public static final String testDetail ="#testDetail#";
	//测试发生异常
	public static final String errorNum ="#errorNum#";
	//性能参考时间
	public static final String referenceTime="#referenceTime#";
	//负责人
	public static final String codingBy="#codingBy#";
}
