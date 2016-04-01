package com.zte.mcrm.framework.ui.framework.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.zte.itp.ssb.framework.common.util.GSONUtil;

/**
 * 类 编 号：基础框架业务实现类 
 * 类 名 称：SiebelBaseWSController
 * 内容摘要：XXX 
 * 完成日期：2016-1-6
 * 编码作者：JohnnyHuang
 */

public class SiebelBaseWSController extends SiebelBaseController
{
    public synchronized String getGsonStr(Map<String, Object> jsonMap)
    {
    	String str = GSONUtil.getGsonStr(jsonMap);    	
    	return str;
    }
}