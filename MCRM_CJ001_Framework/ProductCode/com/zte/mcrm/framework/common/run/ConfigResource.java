/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU0010101_ConfigResource.java 
 * 文件名称：ConfigResource.java 
 * 系统编号：Z0001017
 * 系统名称：市场营销信息管理系统（系统用户）
 * 组件编号：MIMS_CJ001
 * 组件名称：框架组件
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2008-05-12
 * 设计文档：MCRM_CJ001_Framework 基础框架 组件设计模型.cat
 * 内容摘要：资源工具类。以单例模式的方式加载资源文件,以确保较少占用系统资源,提高性能。
 */

package com.zte.mcrm.framework.common.run;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.zte.mcrm.framework.common.util.SysConst;
import com.zte.mcrm.pcframework.common.util.SysPcConst;

/**
 * 读取properties文件
 * 
 * @author JohnnyHuang 黄福强
 * 
 */
public class ConfigResource
{

	// MCRM 的PC端的配置文件
	private static final String EN_SYS_FILE = Thread.currentThread().getContextClassLoader().getResource(SysPcConst.EN_SYS_FILE).getPath();

	// MCRM 的PC端的配置文件
	private static final String ZH_SYS_FILE = Thread.currentThread().getContextClassLoader().getResource(SysPcConst.ZH_SYS_FILE).getPath();

	private static final String PFILE_TOOL = Thread.currentThread().getContextClassLoader().getResource(SysConst.MCRM_POP_PATH).getPath();
	// 对应Mcrm.properties
	private File m_file_tool = null;

	// 对应pcserver_resource_ZH.properties
	private File sys_file_zh = null;
	// 对应pcserver_resource_EN.properties
	private File sys_file_en = null;

	// Mcrm.properties文件的最后修改时间
	private long m_lastModifiedTime_tool = 0;
	// pcserver_resource_ZH.properties文件的最后修改时间
	private long sys_lastModifiedTime_zh = 0;
	// pcserver_resource_EN.properties文件的最后修改时间
	private long sys_lastModifiedTime_en = 0;

	// 对应Mcrm.properties
	private Properties m_props_tool = null;

	private Properties sys_props_zh = null;

	private Properties sys_props_en = null;

	private static ConfigResource m_instance = new ConfigResource();

	/**
	 * 私有构造子,类内部加载资源文件
	 * 
	 */
	private ConfigResource()
	{

		// Mcrm.properties文件
		m_file_tool = new File(PFILE_TOOL);
		m_lastModifiedTime_tool = m_file_tool.lastModified();

		if (m_lastModifiedTime_tool == 0)
		{
			System.err.println(PFILE_TOOL + " file does not exist!");
		}
		m_props_tool = new Properties();

		// pcserver_resource_ZH.properties文件
		sys_file_zh = new File(ZH_SYS_FILE);
		sys_lastModifiedTime_zh = sys_file_zh.lastModified();

		if (sys_lastModifiedTime_zh == 0)
		{
			System.err.println(ZH_SYS_FILE + " file does not exist!");
		}
		sys_props_zh = new Properties();

		// pcserver_resource_EN.properties文件
		sys_file_en = new File(EN_SYS_FILE);
		sys_lastModifiedTime_en = sys_file_en.lastModified();

		if (sys_lastModifiedTime_en == 0)
		{
			System.err.println(EN_SYS_FILE + " file does not exist!");
		}
		sys_props_en = new Properties();

		try
		{
			// 加载MIMS_FTP_PATH.properties文件
			m_props_tool.load(new FileInputStream(PFILE_TOOL));
			// 加载pcserver_resource_ZH.properties文件
			sys_props_zh.load(new FileInputStream(ZH_SYS_FILE));
			// 加载pcserver_resource_EN.properties文件
			sys_props_en.load(new FileInputStream(EN_SYS_FILE));

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 返回该类实例供外界调用
	 * 
	 * @return ConfigResource
	 */
	synchronized public static ConfigResource getInstance()
	{
		return m_instance;
	}

	/**
	 * 取Mcrm.properties文件
	 * 
	 * @return Properties
	 */
	final public Properties getDssConfigTool()
	{
		long newTime = m_file_tool.lastModified();

		if (newTime == 0)
		{
			if (m_lastModifiedTime_tool == 0)
			{
				System.err.println(PFILE_TOOL + " file does not exist!");
			}
			else
			{
				System.err.println(PFILE_TOOL + " file was deleted!!");
			}
			return null;
		}
		else if (newTime > m_lastModifiedTime_tool)
		{
			m_props_tool.clear(); // Get rid of the old properties
			try
			{
				m_props_tool.load(new FileInputStream(PFILE_TOOL));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		m_lastModifiedTime_tool = newTime;
		return m_props_tool;

	}
	
	/**
	 * 取pcserver_resource_ZH.properties文件
	 * 
	 * @return Properties
	 */
	final public Properties getZhSysResourceConfig()
	{
		long newTime = sys_file_zh.lastModified();

		if (newTime == 0)
		{
			if (sys_lastModifiedTime_zh == 0)
			{
				System.err.println(ZH_SYS_FILE + " file does not exist!");
			}
			else
			{
				System.err.println(ZH_SYS_FILE + " file was deleted!!");
			}
			return null;
		}
		else if (newTime > sys_lastModifiedTime_zh)
		{
			sys_props_zh.clear(); // Get rid of the old properties
			try
			{
				sys_props_zh.load(new FileInputStream(ZH_SYS_FILE));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		sys_lastModifiedTime_zh = newTime;
		return sys_props_zh;

	}

	/**
	 * 取pcserver_resource_ZH.properties文件
	 * 
	 * @return Properties
	 */
	final public Properties getEnSysResourceConfig()
	{
		long newTime = sys_file_en.lastModified();

		if (newTime == 0)
		{
			if (sys_lastModifiedTime_en == 0)
			{
				System.err.println(EN_SYS_FILE + " file does not exist!");
			}
			else
			{
				System.err.println(EN_SYS_FILE + " file was deleted!!");
			}
			return null;
		}
		else if (newTime > sys_lastModifiedTime_en)
		{
			sys_props_en.clear(); // Get rid of the old properties
			try
			{
				sys_props_en.load(new FileInputStream(EN_SYS_FILE));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		sys_lastModifiedTime_en = newTime;
		return sys_props_en;
	}
	
	
	
	
	
	
	public static void main(String[] args)
	{
		Properties pop = ConfigResource.getInstance().getDssConfigTool();
		// 获取帐号
		System.out.println("USER_NAME=" + pop.getProperty("h4K4dhHk9i8="));
		// 获取密码
		System.out.println("USER_PWD=" + pop.getProperty("IwEkIpQaBwk="));
	}
}
