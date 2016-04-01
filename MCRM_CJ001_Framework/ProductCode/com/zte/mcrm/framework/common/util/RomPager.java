/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_TestPagerModel 
 * 文件名称：TestPagerModel.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-8-6
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-8-6
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zte.mcrm.framework.model.framework.PageModel;
/**
 * 类 编 号：BL_PU2010101_TestPagerModel
 * 类 名 称：TestPagerModel
 * 内容摘要：XXX 
 * 完成日期：2015-8-6
 * 编码作者：JohnnyHuang 黄福强
 */
public class RomPager
{
	public static void main(String args[])
	{ 
		//初始化数据
		Map<String,Object> eMap=new HashMap<String,Object>();
		for(int i=0;i<300000;i++)
		{
			eMap.put(i+"test", i+"test");
		}
		
		long stT=System.currentTimeMillis();
		
		RomPager tpd=new RomPager();
        String str="10060";
        //查数据
        List<Object> rt=tpd.findMapByKey(eMap,str);
        //分页
        List rstList=tpd.testPageMode(rt,15,3);
        
        long edT=System.currentTimeMillis();
        
        System.out.println("毫秒:"+(edT-stT));
        
        if(rstList!=null)
        {
        	for(Object a:rstList)
        	{
        		System.out.println(a.toString());
        	}
        }
        
    } 
	
	//分页
	public List testPageMode(List<Object> list,int pageSize,int stNum)
	{
	        PageModel pm = new PageModel(list, pageSize); 
	        
	        List sublist = pm.getObjects(stNum); 
	        
	        return sublist;
	}
	
	//查找符合条件的数据集合
	public List<Object> findMapByKey(Map<String,Object> eMap,String str)
	{
		//返回集合
		 List<Object> rtList=new ArrayList<Object>();
         
		 //
		 Iterator iter = eMap.entrySet().iterator();
		 while (iter.hasNext()) 
		 {
			 Map.Entry e = (Map.Entry) iter.next(); 
		     if(null != e.getKey() && e.getKey().toString().toUpperCase().indexOf(str.toUpperCase())>-1)
		     {
		    	 rtList.add(e.getValue());
		     }
		     e=null;
		 }
		 return rtList;
	}

}
