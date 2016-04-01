/**
 * 版权所有：版权所有(C) 2008，中兴通讯 
 * 文件编号：BL_PU0010101_ConfigResource.java 
 * 文件名称：ConfigResource.java 
 * 系统编号：Z0001017
 * 系统名称：市场营销信息管理系统（系统用户）
 * 组件编号：MSM_CJ001
 * 组件名称：框架组件
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2008-05-12
 * 设计文档：MSM_CJ001_Framework 基础框架 组件设计模型.cat
 * 内容摘要：资源工具类。以单例模式的方式加载资源文件,以确保较少占用系统资源,提高性能。
 */

package com.zte.mcrm.framework.ui.framework;

import java.io.FileInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 读取资源类文件
 * @author JohnnyHuang 黄福强
 *
 */
public class ConfigResource
{

	private static final String testAppXml = "spring-application-context.xml";

	protected ApplicationContext sctx = null;

	private static ConfigResource m_instance = new ConfigResource();

	/**
	 * 私有构造子,类内部加载资源文件
	 *
	 */
	private ConfigResource()
	{
		try
		{
			getConfig();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 返回该类实例供外界调用
	 * @return ConfigResource
	 */
	synchronized public static ConfigResource getInstance()
	{
		return m_instance;
	}

	
	/**
	 * 文件加载
	 * @return Properties
	 */
	final public void getConfig()
	{
		try
		{
			sctx = new ClassPathXmlApplicationContext("classpath:" + testAppXml);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
