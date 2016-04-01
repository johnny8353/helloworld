/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmBaseController
 * 文件名称：McrmBaseController.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-15
 * 设计文档：XXX
 * 内容摘要：系统基础控制器类，所有业务控制器均需要继承此基础类。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-15
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.ui.framework.controller;



import java.util.Map;

import org.springframework.stereotype.Controller;

import com.zte.itp.ssb.framework.base.BaseJSONService;
import com.zte.itp.ssb.framework.common.util.GSONUtil;


/**
 * 
 * 类 编 号：
 * 类 名 称：McrmBaseController
 * 内容摘要：系统基础控制器类，所有业务控制器均需要继承此基础类 
 * 完成日期：2016-1-4
 * 编码作者：JohnnyHuang
 */
@Controller("mcrmBaseCtrl")
public class McrmBaseController extends BaseJSONService
{
	/**
	* 业务描述：map 转为 字符串
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:41:59
	* @param @param jsonMap
	* @param @return
	* @return String
	 */
    public synchronized String getGsonStr(Map<String, Object> jsonMap)
    {
    	String str = GSONUtil.getGsonStr(jsonMap);    	
    	log.info("输出参数："+str);
    	return str;
    }
    
}
