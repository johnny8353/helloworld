package com.zte.mcrm.basedata.access.lov.dao;

import java.util.List;
import java.util.Map;

import com.zte.mcrm.basedata.access.lov.vo.LOV;
import com.zte.mcrm.framework.access.framework.dao.BasicDao;
/**
 * 
 * 类 编 号：
 * 类 名 称：LOVDao
 * 内容摘要：值列表 数据库层服务接口 
 * 完成日期：2016-1-11
 * 编码作者：JohnnyHuang
 */
public interface ILOVDao extends BasicDao<LOV>{
	public List<LOV> queryStaticLOV(List lovtypes);
	public List<LOV> queryStaticLOV(Map<String, String> lovtype);
	/**
	* 业务描述：根据父ID获取子值列表数据
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午04:07:02
	* @param @param lov
	* @param @return
	* @return List<LOV>
	 */
	public List<LOV> queryLOVChildren(LOV lov);
	public LOV queryLOVByTypeAndName(LOV lov);
	/**
	* 业务描述：获取 Type下的值列表数据
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午04:06:06
	* @param @param type
	* @param @return
	* @return List<LOV>
	 */
	public List<LOV> queryLOVByType(String type);
	/**
	* 业务描述：获取 Type下Name in ( Names)  的值列表数据
	* names下包含多个值列表: '','',''
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午04:02:06
	* @param @param lov
	* @param @return
	* @return List<LOV>
	 */
	public List<LOV> queryLOVsByTypeAndName(LOV lov);
}
