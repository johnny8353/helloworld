/**
 * 版权所有：版权所有(C) 2016，中兴通讯 
 * 文件编号：BL_PU2010101_UnitTestParamsService 
 * 文件名称：UnitTestParamsService.java
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
package com.zte.mcrm.framework.business.framework.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zte.mcrm.framework.access.framework.dao.IUnitTestParamsDAO;
import com.zte.mcrm.framework.access.framework.vo.UnitTestParamsVO;
import com.zte.mcrm.framework.common.util.StringUtils;
import com.zte.mcrm.framework.model.framework.UnitTestParamsBO;

/**
 * 内容摘要：单元测试业务处理类
 * 完成日期：2016-1-13
 * 编码作者：JohnnyHuang 黄福强
 */
@Service("unitTestParamsService")
public class UnitTestParamsService implements IUnitTestParamsService
{
	@Autowired
	private IUnitTestParamsDAO unitTestParamsDAO;

	/**
	 * 
	 * 获取所有需要测试的测试场景记录
	 * 编码作者:JohnnyHuang 黄福强
	 * 完成日期:2016-1-13
	 * @return
	 */
	@Override
	public Map<String,List<UnitTestParamsVO>> searchAllParams(String testType)
	{
		Map<String,List<UnitTestParamsVO>> paramMap=new HashMap<String,List<UnitTestParamsVO>>();
		try
		{
			// TODO Auto-generated method stub
			List<UnitTestParamsVO> paramList = unitTestParamsDAO.searchAllParams(testType);
			//先获取到map key
			if(paramList!=null && paramList.size()>0)
			{
				Map<String,String> tmpMap=new HashMap<String,String>();
				for(UnitTestParamsVO uvo:paramList)
				{
					tmpMap.put(uvo.getBeanKey(), uvo.getBeanKey());
				}
				 //按BeanKey接口循环,将list转换为map
				 Iterator<Entry<String,String>> iter = tmpMap.entrySet().iterator();
				 while (iter.hasNext()) 
				 {
					 String key =iter.next().getKey(); 
					 //
					 List<UnitTestParamsVO> voList=new ArrayList<UnitTestParamsVO>();
					 for(UnitTestParamsVO uvo:paramList)
					 {
						if(key.equals(uvo.getBeanKey()))
						{
							voList.add(uvo);
						}
					 }
					 paramMap.put(key, voList);
				 }
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return paramMap;
	}
	
	/**
	 * 
	 * 获取所有测试用例，为报表展示使用
	 * 编码作者:JohnnyHuang 黄福强
	 * 完成日期:2016-2-4
	 * @return
	 */
	public UnitTestParamsBO queryAllParamsList()
	{
		UnitTestParamsBO ubo=new UnitTestParamsBO();

		try
		{
			 
		     List<UnitTestParamsVO> utList =unitTestParamsDAO.searchAllParams(null);
		     if(utList!=null && utList.size()>0)
			{
				// 总失败数
				int failNum = 0;
				// 功能总失败数
				int funcFailNum = 0;
				// 性能总失败数
				int perfFailNum = 0;
				//测试发生异常数
				int errorNum=0;
				// 其它总失败数
				int otherFailNum = 0;
                // 总测试用例数
				int totalNum = utList.size();
				ubo.setTestTotalNum(totalNum);
				
				// 记录明细
				ubo.setResultList(utList);
				for (UnitTestParamsVO uvo : utList)
				{
					//普通功能1秒
					if("NORMAL".equalsIgnoreCase(uvo.getPerfPassKey()))
					{
						uvo.setReferenceTime(1);
					}
					//特别指定功能2秒
					else if("SPEC".equalsIgnoreCase(uvo.getPerfPassKey()))
					{
						uvo.setReferenceTime(2);
					}
					//数据回写功能3秒
					else if("CS".equalsIgnoreCase(uvo.getPerfPassKey()))
					{
						uvo.setReferenceTime(3);	
					}
					else
					{
						uvo.setReferenceTime(1);
					}
					if ("Fail".equalsIgnoreCase(uvo.getTestResult())||"Error".equalsIgnoreCase(uvo.getTestResult()))
					{
						failNum = failNum + 1;
						if (1 == uvo.getFailType())
						{
							funcFailNum = funcFailNum + 1;
						}
						else if (2 == uvo.getFailType())
						{
							perfFailNum = perfFailNum + 1;
						}
						else if (3 == uvo.getFailType())
						{
							errorNum = errorNum + 1;
						}
						else
						{
							otherFailNum = otherFailNum + 1;
						}

					}
				}
				// 通过数
				ubo.setTestPassNum(totalNum - failNum);
				// 失败数
				ubo.setTestFailNum(failNum);
				// 测试通过率
				ubo.setTestPassPersent(StringUtils.formatMoney((totalNum - failNum) * 100.0 / totalNum));
				// 功能总失败数
				ubo.setTestFuncFailNum(funcFailNum);
				// 性能总失败数
				ubo.setTestPerfFailNum(perfFailNum);
				//测试发生异常数量
				ubo.setTestErrorNum(errorNum);
				// 其它总失败数
				ubo.setTestOtherFailNum(otherFailNum);
			}
		     
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ubo;
	}

    public static String formatMoney(double money) throws Exception
    {
    	DecimalFormat formatter = new DecimalFormat();
        //
        formatter.applyPattern("0.00");
        return formatter.format(money);
    }
	
	   /**
	    * 
	    * 测试结果回写
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-1-13
	    * @param list
	    * @return
	    */
	   public int updateList(List<UnitTestParamsVO> list)
	   {
		   int rtn=0;
		   try
		   {
			   rtn=unitTestParamsDAO.updateList(list);
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   return rtn;
	   }
	   
	   /**
	    * 
	    * 按beanId和testType更新记录
	    * 编码作者:JohnnyHuang 黄福强
	    * 完成日期:2016-2-19
	    * @param uvo
	    * @return
	    */
	   public int updateByBeanId(UnitTestParamsVO uvo)
	   {
		   int rtn=0;
		   try
		   {
			   rtn=unitTestParamsDAO.updateByBeanId(uvo);
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   return rtn; 
	   }
	
	/**
	 * @return the unitTestParamsDAO
	 */
	public IUnitTestParamsDAO getUnitTestParamsDAO()
	{
		return unitTestParamsDAO;
	}

	/**
	 * @param unitTestParamsDAO the unitTestParamsDAO to set
	 */
	public void setUnitTestParamsDAO(IUnitTestParamsDAO unitTestParamsDAO)
	{
		this.unitTestParamsDAO = unitTestParamsDAO;
	}

	@Override
	public Map<String, List<UnitTestParamsVO>> getUnitTestParamsByBeanKey(
			String beanKey)
	{
		Map<String,List<UnitTestParamsVO>> paramMap=new HashMap<String,List<UnitTestParamsVO>>();
		try
		{
			// TODO Auto-generated method stub
			List<UnitTestParamsVO> paramList = unitTestParamsDAO.getUnitTestParamsByBeanKey(beanKey);
			//先获取到map key
			if(paramList!=null && paramList.size()>0)
			{
				Map<String,String> tmpMap=new HashMap<String,String>();
				for(UnitTestParamsVO uvo:paramList)
				{
					tmpMap.put(uvo.getBeanKey(), uvo.getBeanKey());
				}
				 //按BeanKey接口循环,将list转换为map
				 Iterator<Entry<String,String>> iter = tmpMap.entrySet().iterator();
				 while (iter.hasNext()) 
				 {
					 String key =iter.next().getKey(); 
					 //
					 List<UnitTestParamsVO> voList=new ArrayList<UnitTestParamsVO>();
					 for(UnitTestParamsVO uvo:paramList)
					 {
						if(key.equals(uvo.getBeanKey()))
						{
							voList.add(uvo);
						}
					 }
					 paramMap.put(key, voList);
				 }
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return paramMap;
	}
	
	
}
