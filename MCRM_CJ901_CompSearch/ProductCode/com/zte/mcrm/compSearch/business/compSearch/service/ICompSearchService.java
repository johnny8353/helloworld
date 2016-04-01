package com.zte.mcrm.compSearch.business.compSearch.service;

import com.zte.mcrm.compSearch.access.compSearch.vo.CompSearchVO;
import com.zte.mcrm.compSearch.model.compSearch.CompSearchBO;
import com.zte.mcrm.framework.business.framework.service.IBasicService;
/**
 * 类 编 号：
 * 类 名 称：
 * 内容摘要：综合查询业务服务接口 
 * 完成日期：2015-12-30
 * 编码作者：JohnnyHuang
 */
public interface ICompSearchService extends IBasicService<CompSearchVO>{
	/**
	* 业务描述：综合查询业务服务方法 
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:39:32
	* @param @param boBean
	* @param @return
	* @return CompSearchBO
	 */
	public CompSearchBO CompSearch(CompSearchBO boBean);
	/**
	* 业务描述：判断员工是否有权限访问记录
	* 作    者：Johnny Huang
	* 完成日期：2016-1-11 	下午03:39:32
	* @param @param boBean
	* @param @return
	* @return CompSearchBO
	 */
	CompSearchBO judgeSingleDataVisibility(CompSearchBO boBean);
}
