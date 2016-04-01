package com.zte.mcrm.framework.ui.framework.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: BaseAction
 * @Description: TODO
 * @author huangfuqiang
 * @date 2013-3-19 下午01:07:27
 * 
 */
@Controller
@ParentPackage(value = "appDefault")
@Namespace("/base")
public class BaseAction extends ActionSupport {
	/**
	 * 
	 */
	protected Log log = LogFactory.getLog(getClass());
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	Map<String, Object> map = new HashMap<String, Object>();


//	@Action(value = "/searchCompInfo", results = { @Result(name = SUCCESS, type = "json", params = {
//			"root", "" }) })
//	public String execute() throws Exception {
//		// TODO Auto-generated method stub
//		return SUCCESS;
//	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
