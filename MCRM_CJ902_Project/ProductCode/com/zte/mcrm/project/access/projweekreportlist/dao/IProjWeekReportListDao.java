package com.zte.mcrm.project.access.projweekreportlist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.zte.mcrm.framework.access.framework.dao.BasicDao;
import com.zte.mcrm.project.access.projweekreportlist.vo.ProjWeekReportListVO;

/**   
 * 类 编 号：
 * 类 名 称：IProjWeekReportListDao.java
 * 内容摘要：
 * 完成日期：2016-1-21  
 * 编码作者：QunLi
 */
public interface IProjWeekReportListDao extends BasicDao<ProjWeekReportListVO> {
	/**
	 * 获取周报数量
	 * @param paramter
	 * @return
	 */
	int getProjWeekReportListNum(Map paramter);
	/**
	 * 获取周报列表
	 * @param paramter
	 * @param start
	 * @param limit
	 * @return
	 */
	List<ProjWeekReportListVO> getProjWeekReportList(Object paramter,int start,int limit);
	/**
	 * 根据员工工号获取员工Id
	 * @param empNum
	 * @return
	 */
	String getEmpIdByNum(String empNum);
}

