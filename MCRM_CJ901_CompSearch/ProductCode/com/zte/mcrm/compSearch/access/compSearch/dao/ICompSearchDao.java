package com.zte.mcrm.compSearch.access.compSearch.dao;


import java.util.List;
import java.util.Map;

import com.zte.mcrm.compSearch.access.compSearch.vo.CompSearchVO;
import com.zte.mcrm.framework.access.framework.dao.BasicDao;

//@Repository
public interface ICompSearchDao extends BasicDao<CompSearchVO>{
	/**
	* 业务描述：获取用户有权限的组织
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:34:17
	* @param @param parameter
	* @param @return
	* @return Map<String,Map<String,String>>
	 */
	public Map<String,Map<String, String>> queryAvailableOrg( Object parameter);
	/**
	* 业务描述：综合查询-获取项目数据分页查询
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:34:49
	* @param @param parameter
	* @param @param start
	* @param @param limit
	* @param @return
	* @return List<CompSearchVO>
	 */
	public List<CompSearchVO> queryProjPagnation( Object parameter,int start,int limit);
	
	/**
	* 业务描述：综合查询-获取项目数据分页查询2
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:34:49
	* @param @param parameter
	* @param @param start
	* @param @param limit
	* @param @return
	* @return List<CompSearchVO>
	 */
	public List<CompSearchVO> queryProjPagnation2( Object parameter,int start,int limit);
	/**
	* 业务描述：综合查询-获取项目数据总数
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:36:45
	* @param @param parameter
	* @param @return
	* @return int
	 */
	public int queryProjCount( Object parameter);
	/**
	* 业务描述：综合查询-获取商机数据分页查询
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:34:49
	* @param @param parameter
	* @param @param start
	* @param @param limit
	* @param @return
	* @return List<CompSearchVO>
	 */
	public List<CompSearchVO> queryOptyPagnation( Object parameter,int start,int limit);
	/**
	* 业务描述：综合查询-获取商机数据总数
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:36:45
	* @param @param parameter
	* @param @return
	* @return int
	 */
	public int queryOptyCount( Object parameter);
	/**
	* 业务描述：综合查询-获取线索数据分页查询
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:34:49
	* @param @param parameter
	* @param @param start
	* @param @param limit
	* @param @return
	* @return List<CompSearchVO>
	 */
	public List<CompSearchVO> queryLeadPagnation( Object parameter,int start,int limit);
	/**
	* 业务描述：综合查询-获取线索数据总数
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:36:45
	* @param @param parameter
	* @param @return
	* @return int
	 */
	public int queryLeadCount( Object parameter);
	/**
	* 业务描述：综合查询-获取客户数据分页查询
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:34:49
	* @param @param parameter
	* @param @param start
	* @param @param limit
	* @param @return
	* @return List<CompSearchVO>
	 */
	public List<CompSearchVO> queryAccntPagnation( Object parameter,int start,int limit);
	/**
	* 业务描述：综合查询-获取客户数据总数
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:36:45
	* @param @param parameter
	* @param @return
	* @return int
	 */
	public int queryAccntCount( Object parameter);
	
	/**
	 * 
	* 业务描述：判断员工是否有权限访问记录
	* 作    者：Johnny Huang
	* 完成日期：2016-1-25 	下午03:51:53
	* @param @param parameter
	* @param @return
	* @return int
	 */
	public int judgeSingleDataVisibility( Object parameter);
	
}
