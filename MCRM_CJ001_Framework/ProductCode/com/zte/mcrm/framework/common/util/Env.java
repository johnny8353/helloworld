package com.zte.mcrm.framework.common.util;

import java.util.Properties;
import java.io.*;

@SuppressWarnings("serial")
public class Env extends Properties {
	private static Env instance;

	public static Env getInstance() {
		if (instance != null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}

	public static void setInstance(Env instance) {
		Env.instance = instance;
	}

	// synchronized保证在同一时间内只能别一个人调用！（同步方法的意思）
	private static synchronized void makeInstance() {
		if (instance == null) {
			instance = new Env();
		}
	}

	private Env() {
		InputStream in = Env.class.getClassLoader().getResourceAsStream("siebel.properties");
		try {
			load(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("错误：没有读取属性文件，" + "请确认siebel.properties文件是否存在！");
			e1.printStackTrace();
		}
//		InputStream is = getClass().getResourceAsStream("../../../datasource.properties");//读取数据库配置文件
	}
	public static void main(String[] args) {
		System.out.println(Env.getInstance().getProperty("SIEBEL_URL"));
	}
}