/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU0020101_PcDataConfig
 * 文件名称：PcDataConfig.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-10-26
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-10-26
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.pcframework.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JohnnyHuang 黄福强
 *
 */
public class PcDataConfig
{
	private static final String ALL_RESOURCE="ALL_RESOURCE";

	//不需要效验session的功能访问
	private static  Map<String,Object> allResource=new HashMap<String,Object>();

	 //初始化资源
	public static void initMenuRes(List list)
	{
		//所有资源
		allResource.put(ALL_RESOURCE, list);
	}
	/**
	 * 获取系统全部可用资源
	 * @return
	 */
	public static Object getAllResource()
	{
		return allResource.get(ALL_RESOURCE);
	}

	 
}
