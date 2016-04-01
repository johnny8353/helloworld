/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_ApplicationStartup 
 * 文件名称：ApplicationStartup.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-20
 * 设计文档：XXX
 * 内容摘要：提前加载配置文件。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-20
 * 活  动   号：提前加载配置文件 
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.ui.framework.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
/**
 * 类 编 号：
 * 类 名 称：ApplicationStartup
 * 内容摘要：提前加载配置文件  
 * 完成日期：2016-1-12
 * 编码作者：JohnnyHuang
 */
@Service
public class ApplicationStartup implements BeanPostProcessor
{

	protected Log log = LogFactory.getLog(getClass());

	@Override
	public Object postProcessAfterInitialization(Object beanObj, String beanName) throws BeansException
	{
		log.info("实例化对象"+":"+beanObj.toString());
		try
		{

//				// 数据字典
//				SysDataConfig sd = new SysDataConfig();
//				log.info("开始初始数据...");
//				// 初始化配置文件
//				sd.initProperties(ConfigResource.getInstance().getDssConfigTool());
//                //信息类型
//
//				log.info("初始数据结束!");


		}
		catch (Exception ex)
		{
			log.error("初始数据有异常!");
			ex.printStackTrace();
		}
		return beanObj;
	}
	

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)throws BeansException
	{
		// TODO Auto-generated method stub
		return arg0;
	}

}
