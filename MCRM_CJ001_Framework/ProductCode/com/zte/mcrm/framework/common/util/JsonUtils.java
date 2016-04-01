package com.zte.mcrm.framework.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONUtils;
/**
 * 类 编 号：
 * 类 名 称：JsonUtils.java
 * 内容摘要：json 工具类
 * 完成日期：2016-3-23
 * 编码作者：JohnnyHuang
 */
public class JsonUtils {
	public static final String JSON_ATTRIBUTE = "json";

	public static Object getDTO(String jsonString, Class clazz) {
		JSONObject jsonObject = null;
		try {
			setDataFormat();
			jsonObject = JSONObject.fromObject(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toBean(jsonObject, clazz);
	}

	public static Object getDTO(String jsonString, Class clazz, Map map) {
		JSONObject jsonObject = null;
		try {
			setDataFormat();
			jsonObject = JSONObject.fromObject(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toBean(jsonObject, clazz, map);
	}

	public static Object[] getDTOArray(String jsonString, Class clazz) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		Object[] obj = new Object[array.size()];
		for (int i = 0; i < array.size(); ++i) {
			JSONObject jsonObject = array.getJSONObject(i);
			obj[i] = JSONObject.toBean(jsonObject, clazz);
		}
		return obj;
	}

	public static Object[] getDTOArray(String jsonString, Class clazz, Map map) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		Object[] obj = new Object[array.size()];
		for (int i = 0; i < array.size(); ++i) {
			JSONObject jsonObject = array.getJSONObject(i);
			obj[i] = JSONObject.toBean(jsonObject, clazz, map);
		}
		return obj;
	}

	public static List getDTOList(String jsonString, Class clazz) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		List list = new ArrayList();
		for (Iterator iter = array.iterator(); iter.hasNext();) {
			JSONObject jsonObject = (JSONObject) iter.next();
			list.add(JSONObject.toBean(jsonObject, clazz));
		}
		return list;
	}

	public static List getDTOList(String jsonString, Class clazz, Map map) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		List list = new ArrayList();
		for (Iterator iter = array.iterator(); iter.hasNext();) {
			JSONObject jsonObject = (JSONObject) iter.next();
			list.add(JSONObject.toBean(jsonObject, clazz, map));
		}
		return list;
	}

	public static Map getMapFromJson(String jsonString) {
		setDataFormat();
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Map map = new HashMap();
		for (Iterator iter = jsonObject.keys(); iter.hasNext();) {
			String key = (String) iter.next();
			map.put(key, jsonObject.get(key));
		}
		return map;
	}

	public static Object[] getObjectArray(String jsonString) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		return jsonArray.toArray();
	}

	public static String getJSONString(Object object) {
		String jsonString = null;

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		if (object != null) {
			if ((object instanceof Collection) || (object instanceof Object[]))
				jsonString = JSONArray.fromObject(object, jsonConfig)
						.toString();
			else {
				jsonString = JSONObject.fromObject(object, jsonConfig)
						.toString();
			}
		}
		return (jsonString == null) ? "{}" : jsonString;
	}

	public static String getJSONString(Object object, String[] excludes)
			throws Exception {
		String jsonString = null;
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.setExcludes(excludes);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		if (object != null) {
			if ((object instanceof Collection) || (object instanceof Object[]))
				jsonString = JSONArray.fromObject(object, jsonConfig)
						.toString();
			else {
				jsonString = JSONObject.fromObject(object, jsonConfig)
						.toString();
			}
		}
		return (jsonString == null) ? "{}" : jsonString;
	}

	private static void setDataFormat() {
		JSONUtils.getMorpherRegistry().registerMorpher(
				new MyDateMorpher(new String[] { "yyyy-MM-dd",
						"yyyy-MM-dd HH:mm:ss" }));//默认使用数组0
	}

	public static void main(String[] arg) throws Exception {
		String s = "{status : 'success'}";
		System.out.println(" object : " + getJSONString(s));
	}
    public static Map<String, String> jsonToMap(String jsonString) 
    { 
    	Map<String, String> result = null;
    	if(jsonString != null)
    	{
    		JSONObject jsonObject = JSONObject.fromObject(jsonString);
            result = new LinkedHashMap<String, String>();
            Iterator<String> iterator = jsonObject.keys(); 
            String key = null; 
            String value = null; 
            while (iterator.hasNext()) 
            { 
                key = iterator.next(); 
                value = jsonObject.getString(key); 
                result.put(key, value); 
            } 
    	}
    	
        return result; 
    } 
}
