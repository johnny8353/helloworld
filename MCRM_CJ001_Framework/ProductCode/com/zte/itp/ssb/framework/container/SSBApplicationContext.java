package com.zte.itp.ssb.framework.container;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SSBApplicationContext implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	@SuppressWarnings("static-access")
	public  void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-application-context.xml");
		return applicationContext;
	}

	public static <T> Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	public static <T> Object getBean(Class<T> clz) throws BeansException {
		Object result = applicationContext.getBean(clz);
		return result;
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.isSingleton(name);
	}

	public static Class<?> getType(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getType(name);
	}

	public static String[] getAliases(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getAliases(name);
	}
}