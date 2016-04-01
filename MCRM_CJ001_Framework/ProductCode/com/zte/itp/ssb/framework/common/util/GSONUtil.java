package com.zte.itp.ssb.framework.common.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class GSONUtil {
	public static <T> String getGsonStr(T obj) {
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
		Gson gson = builder.create();
		String jsonString = gson.toJson(obj);
		gson = null;
		builder = null;
		return jsonString;
	}

	public static <T> Object getJavaFromGsonStr(Type type, String gsonStr) {
		Gson gson = new Gson();
		Object javaObject = gson.fromJson(gsonStr, type);
		gson = null;
		type = null;
		return javaObject;
	}

	public static void main(String[] args) {
	}
}