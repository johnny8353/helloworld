package com.zte.mcrm.framework.ui.framework.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import com.zte.mcrm.basedata.business.employee.service.EmployeeInfoService;

public class StartupListener extends ContextLoaderListener implements
		ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println(" StartupListener 初始化成功！");

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring-application-context.xml" });
		; // 加载spring配置文件
		// 获得bean的实例
		EmployeeInfoService getHtmlComponent = (EmployeeInfoService) applicationContext
				.getBean("employeeInfoService");// GetHtmlComponent是在spring中定义的一个bean，他实现了一些初始化的逻辑和操作数据库的动作，里面可以调用hibernate操作数据库
		System.out.println(getHtmlComponent.toString());
		System.out.println("  StartupListener 初始化结束！");
	}

}
