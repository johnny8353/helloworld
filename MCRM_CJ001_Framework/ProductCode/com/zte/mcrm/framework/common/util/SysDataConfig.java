/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_SysDataConfig 
 * 文件名称：SysDataConfig.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-11-18
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-11-18
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * 类 编 号：BL_PU2010101_SysDataConfig
 * 类 名 称：SysDataConfig
 * 内容摘要：定义系统常量 
 * 完成日期：2014-11-18
 * 编码作者：JohnnyHuang 黄福强
 */
public class SysDataConfig
{
	//效验开关
	public static final String FILTER_FLAG="FILTER_FLAG";
	//加密key
	public static final String SECRET_KEY="SECRET_KEY";
	//siebel地址
	public static final String SIEBEL_URL="SIEBEL_URL";

   //其它属性
   private static Map<String,String> otherPropMap=new HashMap<String,String>();
   
   //初始化
   public void initProperties(Properties pops)
   {
	   otherPropMap.put(FILTER_FLAG, pops.getProperty(FILTER_FLAG));
	   otherPropMap.put(SECRET_KEY, pops.getProperty(SECRET_KEY));
	   otherPropMap.put(SIEBEL_URL, pops.getProperty(SIEBEL_URL));
   }
   /**
    * 
    * 业务描述：获取系统配置文件其它属性 
    * 作          者：JohnnyHuang 黄福强
    * 完成日期：2015-1-22
    * @return
    */
   public static Map<String, String> getOtherPropMap()
   {
	   return otherPropMap;
   }
   
}
