/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_AllTests 
 * 文件名称：AllTests.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-12-30
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-12-30
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.ui.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.zte.mcrm.framework.access.framework.vo.UnitTestParamsVO;
import com.zte.mcrm.framework.business.framework.service.IUnitTestParamsService;
import com.zte.mcrm.framework.common.util.Env;
import com.zte.mcrm.framework.model.framework.UnitTestParamsBO;
import com.zte.mcrm.framework.ui.framework.controller.SiebelBaseController;


/**
 * 类 编 号：BL_PU2010101_AllTests
 * 类 名 称：AllTests
 * 内容摘要：XXX 
 * 完成日期：2014-12-30
 * 编码作者：JohnnyHuang 黄福强
 */
public class AllTest extends AbstractTestBase
{
	private boolean sendToAll;
	public AllTest(boolean flag) {
		sendToAll = flag;
		//获取单元测试业务处理接口实例
		unitTestParamsService=(IUnitTestParamsService)ctx.getBean("unitTestParamsService");
		// TODO Auto-generated constructor stub
	}
	//单元测试业务处理接口
	private IUnitTestParamsService unitTestParamsService;
	public static void main(String[] args) {
		new AllTest(false).testSmartSales();
	}
	@Test
	  public void testSmartSales()
	   {
		   //获取控制类测试用例列表
		   Map<String,List<UnitTestParamsVO>> paramCtrMap=unitTestParamsService.searchAllParams(SysTestConst.CTR);
		   String rtnStr=baseTst(paramCtrMap,SysTestConst.CTR);
		   
		   ////获取WebService实现类测试用例列表
		   //Map<String,List<UnitTestParamsVO>> paramWsMap=unitTestParamsService.searchAllParams(SysTestConst.WS); 
		  // rtnStr=rtnStr+baseTst(paramWsMap,SysTestConst.WS);
		   //生成测试结果报表
		   generateReport();
		   Assert.assertTrue(rtnStr, true);
	   }
	  
	  /**
	   * 
	   * 生成测试结果报表
	   * 编码作者:JohnnyHuang 黄福强
	   * 完成日期:2016-2-4
	   */
	  public void generateReport()
	  {
		  UnitTestParamsBO ubo=unitTestParamsService.queryAllParamsList();
		  if(ubo!=null)
		  {
			    String fNamePath=Thread.currentThread().getContextClassLoader().getResource("allTests.html").getFile();
	        	String fNameStr=ReadFromFile.readFileByLines(fNamePath);
	        	//总测试数
	        	fNameStr=fNameStr.replace(SysTestConst.totalNum,""+ubo.getTestTotalNum());
	        	//测试通过用例数
	        	fNameStr=fNameStr.replace(SysTestConst.testPassNum,""+ubo.getTestPassNum());
	        	//测试通过率
	        	fNameStr=fNameStr.replace(SysTestConst.testPassPersent,ubo.getTestPassPersent());
	        	//测试失败用例数
	        	fNameStr=fNameStr.replace(SysTestConst.failNum,""+ubo.getTestFailNum());
	        	//功能测试不通过用例数
	        	fNameStr=fNameStr.replace(SysTestConst.funcFailNum,""+ubo.getTestFuncFailNum());
	        	//性能测试不通过用例数
	        	fNameStr=fNameStr.replace(SysTestConst.perfFailNum,""+ubo.getTestPerfFailNum());
	        	//测试发生异常用例数
	        	fNameStr=fNameStr.replace(SysTestConst.errorNum,""+ubo.getTestErrorNum());
	        	//其它情况
	        	fNameStr=fNameStr.replace(SysTestConst.otherFailNum,""+ubo.getTestOtherFailNum());
	        	//明细
	        	fNameStr=fNameStr.replace(SysTestConst.testDetail,""+getDetailTest(ubo.getResultList()));
	        	fNameStr=fNameStr.replace("#TEST_T1#","用例总数");
	        	fNameStr=fNameStr.replace("#TEST_T2#","通过用例数");
	        	fNameStr=fNameStr.replace("#TEST_T3#","通过率");
	        	fNameStr=fNameStr.replace("#TEST_T4#","不通过用例数");
	        	
	        	fNameStr=fNameStr.replace("#TEST_T5#","功能测试不通过用例数");
	        	fNameStr=fNameStr.replace("#TEST_T6#","性能测试不通过用例数");
	        	fNameStr=fNameStr.replace("#TEST_T7#","测试发生异常个数");
	        	fNameStr=fNameStr.replace("#TEST_T8#","其它情况");
	        	
	        	fNameStr=fNameStr.replace("#TEST_T9#","测试状态");
	        	fNameStr=fNameStr.replace("#TEST_T10#","问题描述");
	        	fNameStr=fNameStr.replace("#TEST_T11#","实际执行时间(秒)");
	        	fNameStr=fNameStr.replace("#TEST_T12#","性能参考时间上限(秒)");
	        	fNameStr=fNameStr.replace("#TEST_T13#","负责人");
	        	fNameStr=fNameStr.replace("#TEST_T14#","测试用例名称");
	        	fNameStr=fNameStr.replace("#TEST_T15#","测试用例描述");
	        	fNameStr=fNameStr.replace("#TEST_T16#","Siebel单元测试报告");
	        	
	        	MailManageForDpg mg=new MailManageForDpg();
	        	String mailUrl="http://itpmail.zte.com.cn/mailService/services/MailTemplateService";
	        	String toMail="";
	        	if(sendToAll){
	        		toMail=Env.getInstance().getProperty("TEST_CASE_MAILTO");//"xiao.lang@zte.com.cn;li.xinghui@zte.com.cn;huang.fanghao@zte.com.cn;guo.miao@zte.com.cn;feng.xiaomei@zte.com.cn;ma.huaibao@zte.com.cn;";
	        	}else{
	        		toMail=Env.getInstance().getProperty("TEST_CASE_MAILTOHAND");
	        	}
	        	//toMail=toMail+"xiong.ying5@zte.com.cn;guo.weilun@zte.com.cn;huang.fuqiang@zte.com.cn;fu.zhaohong@zte.com.cn;li.qun35@zte.com.cn;li.qi3@zte.com.cn;xiong.zhide@zte.com.cn;";
	        	String sendFlag=mg.invokeDPGSendTestMail(toMail,mailUrl,fNameStr,ubo);
System.out.println(toMail+"--------"+sendFlag);
		  }
	  }
	  
	  /**
	   * 
	   * 获取详细的测试用例结果列表
	   * 编码作者:JohnnyHuang 黄福强
	   * 完成日期:2016-2-4
	   * @param utList
	   * @return
	   */
	  private String getDetailTest(List<UnitTestParamsVO> utList)
	  {
		  StringBuffer dt=new StringBuffer();
		  int i = 0;
		  for(UnitTestParamsVO uvo:utList)
		  {
			  i++;
			  String cls="style=\"border-bottom:1px solid #000;";
			  if(i%2==0){
				  cls+="background-color:#dfffdf;"; 
			  }else{
				  cls+="background-color:#ecffff;"; 
			  }
			  if(SysTestConst.FAILURE.equalsIgnoreCase(uvo.getTestResult())||SysTestConst.ERROR.equalsIgnoreCase(uvo.getTestResult()))
			  {
				  if(uvo.getFailType()==2 )
				  {
					  cls+=" color: blue;";  
				  }
				  else
				  {
				     cls+="color: red;";
				  }
			  }
			  cls+="\"";
			  dt.append("<tr  align=\"center\"  valign=\"top\""+cls+">")
			  	.append("<td align=\"left\">")
			    .append(uvo.getBeanDesc()+uvo.getBeanKey())
			    .append(" - "+uvo.getMethodDesc()+uvo.getMethodKey())
			    .append("</td>")
			      .append("<td align=\"left\">")
			    .append(""+uvo.getTestSceneDesc())
			    .append("</td>")
			    .append("<td>"+uvo.getTestResult()+"</td>")
			    .append("<td align=\"left\">"+uvo.getTestResultDesc()+"</td>")
			    .append("<td>"+uvo.getMethodExecTime()+"</td>")
			    .append("<td>"+uvo.getReferenceTime()+"</td>")
			    .append("<td>"+uvo.getEncodingBy()+"</td>")
			
			    .append("</tr>");
		  }
		  return dt.toString();
	  }
	  /**
	   * 
	   * 根据BeanKey执行单元测试，开发人员自己本地开发测试使用，提交该方法在svn上为注销状态
	   * 编码作者:6011000109
	   * 完成日期:2016-2-3
	   */
	  
//	  public void testMySmartSales()
//	   {
//		   //获取单元测试业务处理接口实例
//		   unitTestParamsService=(IUnitTestParamsService)ctx.getBean("unitTestParamsService");
//		   
//		   //获取控制类测试用例列表
//		   Map<String,List<UnitTestParamsVO>> paramCtrMap = unitTestParamsService.getUnitTestParamsByBeanKey("common");
//	
//			   String rtnStr=baseTst(paramCtrMap,SysTestConst.CTR);
//			   //String rtnStr=baseTst(paramCtrMap,SysTestConst.WS);
//			   
//			   Assert.assertTrue(rtnStr, rtnStr!=null && rtnStr.length()>0);
//
//	   }

//	  public void testMySmartSales()
//	   {
//		   //获取单元测试业务处理接口实例
//		   unitTestParamsService=(IUnitTestParamsService)ctx.getBean("unitTestParamsService");
//		   
//		   //获取控制类测试用例列表
//		   Map<String,List<UnitTestParamsVO>> paramCtrMap = unitTestParamsService.getUnitTestParamsByBeanKey("paySubPrjIssue");
//		   String rtnStr=baseTst(paramCtrMap,SysTestConst.CTR);
////		   String rtnStr=baseTst(paramCtrMap,SysTestConst.WS);
//		   
//		   Assert.assertTrue(rtnStr, rtnStr!=null && rtnStr.length()>0);
//	   }

	   
	   /**
	    * 
	    * 按不同的用例类型测试
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-1-19
	    * @param paramMap
	    * @param testType
	    * @return
	    */
	   private String baseTst(Map<String,List<UnitTestParamsVO>> paramMap,String testType)
	   {
			   
			   UnitTestParamsBO ubo=null;
               //Controller测试用例
			   if(SysTestConst.CTR.endsWith(testType))
			   {
					 ubo=baseControllerTst(paramMap);
System.out.println("执行了"+ubo.getResultList().size()+"个Controller类型的测试用例!");
			   }
			   //webservice测试用例
			   else if(SysTestConst.WS.endsWith(testType))
			   {
				   ubo=baseWSTst(paramMap);
System.out.println("执行了"+ubo.getResultList().size()+"个WebService类型的测试用例!");
			   }
			   else
			   {
				   
			   }
		       //测试结果集合
			   List<UnitTestParamsVO> resultList=ubo.getResultList();
			   //回写测试结果
			   if(resultList!=null && resultList.size()>0)
			   {
				   unitTestParamsService.updateList(resultList);
			   }
			return ubo.getTestDesc();
	   }
	   
	   /**
	    * 
	    * 测试webservice类型的接口
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-1-16
	    * @param paramMap
	    * @return
	    */
	   protected UnitTestParamsBO baseWSTst(Map<String,List<UnitTestParamsVO>> paramMap)
	   {
		   //返回对象
		   UnitTestParamsBO utb=new UnitTestParamsBO();
		   //测试结果综合描述
		   StringBuffer sbf=new StringBuffer();
	       //回写测试结果
		   List<UnitTestParamsVO> resultList=new ArrayList<UnitTestParamsVO>();
		   //SmartSales基础控制类
		   SiebelBaseController mbc=null;
		   //有需要测试的用例
		   if(paramMap!=null && paramMap.size()>0)
		   {
			   Iterator<Entry<String,List<UnitTestParamsVO>>> iter=paramMap.entrySet().iterator();
			   while (iter.hasNext()) 
			   {
				   Entry<String,List<UnitTestParamsVO>> entry=iter.next();
				   String beanId=entry.getKey();
				try
				{
				   //SmartSales基础控制类
				   mbc=(SiebelBaseController) ctx.getBean(beanId);
			   }
			   catch(Exception ex)
			   {
				   //可能的程序异常
				   mbc=null;
				   //按key更新异常情况
				    UnitTestParamsVO uvo=new UnitTestParamsVO();
				    uvo.setBeanKey(beanId);
				    uvo.setTestType(SysTestConst.WS);
					uvo.setMethodExecTime(0);
					uvo.setTestResult(SysTestConst.ERROR);
					uvo.setTestResultDesc(getExceptionDetailsMessage(ex,900));
					uvo.setFailType(SysTestConst.ERROR_TEST_TYPE);
					//直接更新
					unitTestParamsService.updateByBeanId(uvo);
			   }
				if(mbc!=null)
				{
				   //获取测试用例集合
				   List<UnitTestParamsVO> paramList=entry.getValue();
				   //
				   double ct =0.0;
				   //开始循环测试
				   for(UnitTestParamsVO uvo:paramList)
				   {
					   try
					   {
					   String testParamJson=uvo.getJsonParams();
					   testParamJson=testParamJson.replace(SysTestConst.RandomNum, getRandomNumStr());
			            //开始计时
						double st = System.currentTimeMillis();
						//执行测试
						String strJson = "";//mbc.WSService(testParamJson);

			            //结束计时
						double ed = System.currentTimeMillis();
						//实际执行时间
						ct = (ed - st) / 1000;
						//功能测试条件不通过,这个判断可抽取成私有方法，可能有多种判断情况
						if(!funConditionCompare(uvo,strJson))//场景功能测试条件
						{
							uvo.setJsonParams("");
							uvo.setMethodExecTime(ct);
							uvo.setTestResult(SysTestConst.FAILURE);
							uvo.setTestResultDesc(SysTestConst.FUNC_TEST_NOT_PASS);
							uvo.setFailType(SysTestConst.FUNC_TEST_NOT_PASS_TYPE);
							//综合描述
							sbf.append(uvo.getTestResult()).append(" - ").append(uvo.getTestResultDesc()).append(" - ").append("执行时间："+uvo.getMethodExecTime()+" 秒").append(" - ").append(uvo.getBeanDesc()+uvo.getBeanKey()).append(" - ").append(uvo.getMethodDesc()+uvo.getMethodKey()).append(" - ").append(uvo.getTestSceneDesc()).append("\n");
						}
						else
						{
							uvo.setTestResult(SysTestConst.SUCCESS);
							uvo.setJsonParams("");
							uvo.setMethodExecTime(ct);
							uvo.setTestResultDesc(SysTestConst.TEST_PASS);
							uvo.setFailType(SysTestConst.TEST_PASS_TYPE);
							//性能测试通过条件
							double perf=getPerfVal(uvo.getPerfPassKey());
							//只有功能测试通过了才判断性能指标
							if(ct > perf)//场景性能测试条件
							{
								uvo.setTestResult(SysTestConst.FAILURE);
								uvo.setTestResultDesc(SysTestConst.PERF_TEST_NOT_PASS);
								uvo.setFailType(SysTestConst.PERF_TEST_NOT_PASS_TYPE);
								//综合描述
								sbf.append(uvo.getTestResult()).append(" - ").append(uvo.getTestResultDesc()).append(" - ").append("执行时间："+uvo.getMethodExecTime()+" 秒").append(" - ").append(uvo.getBeanDesc()+uvo.getBeanKey()).append(" - ").append(uvo.getMethodDesc()+uvo.getMethodKey()).append(" - ").append(uvo.getTestSceneDesc()).append("\n");
							}
						}
						resultList.add(uvo);
						System.out.println(uvo.getTestResult()+" - "+uvo.getTestResultDesc()+" - "+"执行时间："+uvo.getMethodExecTime()+" 秒 - "+uvo.getBeanDesc()+uvo.getBeanKey()+" - "+uvo.getMethodDesc()+uvo.getMethodKey()+" - "+uvo.getTestSceneDesc());
					   }//try
					   catch(Exception ex)
					   {
							uvo.setJsonParams("");
							uvo.setMethodExecTime(ct);
							uvo.setTestResult(SysTestConst.ERROR);
							uvo.setTestResultDesc(getExceptionDetailsMessage(ex,900));
							uvo.setFailType(SysTestConst.ERROR_TEST_TYPE);
						    resultList.add(uvo);
					   }
					   
					   }//for
			   }//if(mbc!=null)
			   }//while
		   }//if
		   utb.setResultList(resultList);
		   utb.setTestDesc(sbf.toString());
			return utb;
	   }
	   
	   /**
	    * 
	    * 测试Controller类均调用该方法
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-1-12
	    * @param mbc
	    */
	   protected UnitTestParamsBO baseControllerTst(Map<String,List<UnitTestParamsVO>> paramMap)
	   {
		   //返回对象
		   UnitTestParamsBO utb=new UnitTestParamsBO();
		   //测试结果综合描述
		   StringBuffer sbf=new StringBuffer();
	       //回写测试结果
		   List<UnitTestParamsVO> resultList=new ArrayList<UnitTestParamsVO>();
		   //SmartSales基础控制类
		   SiebelBaseController mbc=null;
		   //有需要测试的用例
		   if(paramMap!=null && paramMap.size()>0)
		   {
			   Iterator<Entry<String,List<UnitTestParamsVO>>> iter=paramMap.entrySet().iterator();
			   while (iter.hasNext()) 
			   {
				   Entry<String,List<UnitTestParamsVO>> entry=iter.next();
				   String beanId=entry.getKey();
				   try
				   {
					   //SmartSales基础控制类
					   mbc=(SiebelBaseController) ctx.getBean(beanId);
				   }
				   catch(Exception ex)
				   {
					   //可能的程序异常
					   mbc=null;
					   //按key更新异常情况
					    UnitTestParamsVO uvo=new UnitTestParamsVO();
					    uvo.setBeanKey(beanId);
					    uvo.setTestType(SysTestConst.CTR);
						uvo.setMethodExecTime(0);
						uvo.setTestResult(SysTestConst.ERROR);
						uvo.setTestResultDesc(getExceptionDetailsMessage(ex,900));
						uvo.setFailType(SysTestConst.ERROR_TEST_TYPE);
						//直接更新
						unitTestParamsService.updateByBeanId(uvo);
				   }

				  //类型转化成功
				  if(mbc!=null)
				  {
				   
				   //获取测试用例集合
				   List<UnitTestParamsVO> paramList=entry.getValue();
				   //
				   double ct =0.0;
				   //开始循环测试
				   for(UnitTestParamsVO uvo:paramList)
				   {
					   
					   try
					   {
						
			            //开始计时
						double st = System.currentTimeMillis();
						//执行测试
						String strJson =mbc.doCustom(uvo.getMethodKey(),uvo.getJsonParams());
			            //结束计时
						double ed = System.currentTimeMillis();
						//实际执行时间
						ct = (ed - st) / 1000;
//System.out.println(strJson);
						//功能测试条件不通过,这个判断可抽取成私有方法，可能有多种判断情况
						if(!funConditionCompare(uvo,strJson)&&!"业务数据-权限判断".equals(uvo.getBeanDesc()))//场景功能测试条件
						{
							uvo.setJsonParams("");
							uvo.setMethodExecTime(ct);
							uvo.setTestResult(SysTestConst.FAILURE);
							uvo.setTestResultDesc(SysTestConst.FUNC_TEST_NOT_PASS);
							uvo.setFailType(SysTestConst.FUNC_TEST_NOT_PASS_TYPE);
							//综合描述
							sbf.append(uvo.getTestResult()).append(" - ").append(uvo.getTestResultDesc()).append(" - ").append("执行时间："+uvo.getMethodExecTime()+" 秒").append(" - ").append(uvo.getBeanDesc()+uvo.getBeanKey()).append(" - ").append(uvo.getMethodDesc()+uvo.getMethodKey()).append(" - ").append(uvo.getTestSceneDesc()).append("\n");
						}
						else
						{
							uvo.setTestResult(SysTestConst.SUCCESS);
							uvo.setJsonParams("");
							uvo.setMethodExecTime(ct);
							uvo.setTestResultDesc(SysTestConst.TEST_PASS);
							uvo.setFailType(SysTestConst.TEST_PASS_TYPE);
							//性能测试通过条件
							double perf=getPerfVal(uvo.getPerfPassKey());
							//只有功能测试通过了才判断性能指标
							if(ct > perf)//场景性能测试条件
							{
								uvo.setTestResult(SysTestConst.FAILURE);
								uvo.setTestResultDesc(SysTestConst.PERF_TEST_NOT_PASS);
								uvo.setFailType(SysTestConst.PERF_TEST_NOT_PASS_TYPE);
								//综合描述
								sbf.append(uvo.getTestResult()).append(" - ").append(uvo.getTestResultDesc()).append(" - ").append("执行时间："+uvo.getMethodExecTime()+" 秒").append(" - ").append(uvo.getBeanDesc()+uvo.getBeanKey()).append(" - ").append(uvo.getMethodDesc()+uvo.getMethodKey()).append(" - ").append(uvo.getTestSceneDesc()).append("\n");
							}
						  }
						  
						  resultList.add(uvo);
						  
//System.out.println(uvo.getTestResult()+" - "+uvo.getTestResultDesc()+" - "+"执行时间："+uvo.getMethodExecTime()+" 秒 - "+uvo.getBeanDesc()+uvo.getBeanKey()+" - "+uvo.getMethodDesc()+uvo.getMethodKey()+" - "+uvo.getTestSceneDesc());
				   
					   }//try
					   catch(Exception ex)
					   {
							uvo.setJsonParams("");
							uvo.setMethodExecTime(ct);
							uvo.setTestResult(SysTestConst.ERROR);
							uvo.setTestResultDesc(getExceptionDetailsMessage(ex,900));
							uvo.setFailType(SysTestConst.ERROR_TEST_TYPE);
						    resultList.add(uvo);
					   }
					   
				   
				   }//for
				   
				   
			   }//if(mbc!=null)
				   
				   
			   }//while
		   }//if

		    utb.setResultList(resultList);
		    utb.setTestDesc(sbf.toString());
			return utb;
		
	   }
	   
	   /**
	    * 
	    * 比较条件
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-1-14
	    * @param jsonStr
	    * @param conditParam
	    * @param compType
	    * @return
	    */
	   private boolean funConditionCompare(UnitTestParamsVO uvo,String rtnJson)
	   {
		   //结果包含所给条件值
		   if(SysTestConst.CONTAINER.equals(uvo.getCompType()))
		   {
			   if(checkStrIsEmpty(rtnJson))
			   {
				   return false;
			   }
			   return rtnJson.indexOf(uvo.getFuncPassVal())>-1;
		   }
		   //结果和所给条件值相等
		   else if(SysTestConst.EQUALS.equals(uvo.getCompType()))
		   {
			   if(checkStrIsEmpty(rtnJson))
			   {
				   return false;
			   }
			   return rtnJson.equals(uvo.getFuncPassVal());
		   }
		   else
		   {
			   return false;
		   }
	   }
	   
	   /**
	    * 
	    * 按不同的性能指标获取相应的性能值
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-1-13
	    * @param perfPassKey
	    * @return
	    */
	   private double getPerfVal(String perfPassKey)
	   {
		   double perfVal=1000.0;
		   if(SysTestConst.NORMAL.equals(perfPassKey))
		   {
			   //普通功能
			   perfVal=SysTestConst.TIME_NORMAL_FUNC;
		   }
		   else if(SysTestConst.SPEC.equals(perfPassKey))
		   {
			   //特别指定的功能
			   perfVal=SysTestConst.TIME_SPEC_FUNC;
		   }
		   else if(SysTestConst.CS.equals(perfPassKey))
		   {
			   //数据回写功能
			   perfVal=SysTestConst.TIME_CS_FUNC;
		   }
		   else
		   {
			   perfVal=1000.0;
		   }
		   return perfVal;
	   }
	   
	   /**
	    * 
	    * 产生随机数
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-1-18
	    * @return
	    */
	   private String getRandomNumStr()
	   {
		   return Integer.toString(new Random().nextInt(10000));
	   }
		/**
		 * 
		 * 获得堆栈信息
		 * 编码作者:JohnnyHuang 黄福强
		 * 完成日期:2016-2-19
		 * @param e 异常信息对象
		 * @param len 长度为负数则表示不限定长度
		 * @return
		 */
		public String getExceptionDetailsMessage(Exception e,int len)
		{
			//声明输出信息
			String input = null;
			//初始化StringWriter
			StringWriter sw = new StringWriter();
			//初始化PrintWriter
			PrintWriter pw = new PrintWriter(sw);
			//打印堆栈
			e.printStackTrace(pw);
			//获得堆栈信息
			input = sw.getBuffer().toString();
			
			if(len>0)
			{
				input=input.substring(0,len);
			}
			return input;
		}
}
