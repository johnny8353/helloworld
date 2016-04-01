/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_PagePcBO
 * 文件名称：PagePcBO.java
 * 系统编号：100000201191
 * 系统名称：SmartSales 智慧营销
 * 组件编号：MCRM_CJ002
 * 组件名称：MCRM_CJ002_PcFramework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-11-2
 * 设计文档：XXX
 * 内容摘要：PC端专用翻页对象。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-11-2
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.pcframework.model.pcframework;

public class PagePcBO
{
	//起始行号
   private long startNum=0L;
   //每页记录数
   private int pageSize=10;
   //总页数
   private long totalPage=0;
   
public long getStartNum()
{
	return startNum;
}
public void setStartNum(long startNum)
{
	this.startNum = startNum;
}
public int getPageSize()
{
	return pageSize;
}
public void setPageSize(int pageSize)
{
	this.pageSize = pageSize;
}
public long getTotalPage()
{
	return totalPage;
}
public void setTotalPage(long totalPage)
{
	this.totalPage = totalPage;
}
   
}
