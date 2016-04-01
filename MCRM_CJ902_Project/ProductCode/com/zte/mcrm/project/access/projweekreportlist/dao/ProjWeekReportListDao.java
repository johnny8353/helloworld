package com.zte.mcrm.project.access.projweekreportlist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.access.framework.dao.BasicDaoImpl;
import com.zte.mcrm.project.access.projweekreportlist.vo.ProjWeekReportListVO;

/**   
 * 类 编 号：
 * 类 名 称：ProjWeekReportListDao.java
 * 内容摘要：
 * 完成日期：2016-1-21  
 * 编码作者：QunLi
 */
@Repository
public class ProjWeekReportListDao extends BasicDaoImpl<ProjWeekReportListVO> implements IProjWeekReportListDao {

	@Override
	public int getProjWeekReportListNum(Map map) {
		return sqlSession.selectOne(getNamespace()+".getProjWeekReportListNum", map);
	}

	@Override
	public List<ProjWeekReportListVO> getProjWeekReportList(Object parameter,int start,int limit) {
		if(start < 0 || limit < 0)	
			return sqlSession.selectList(getNamespace() +".getProjWeekReportList", parameter);
		else 
			return sqlSession.selectList(getNamespace() +".getProjWeekReportList", parameter, new RowBounds(start,limit));
	}

	@Override
	public String getEmpIdByNum(String empNum) {
		return sqlSession.selectOne(getNamespace()+".getEmpIdByNum", empNum);
	}
	
	@Override
	public String getNamespace() {
		return IProjWeekReportListDao.class.getCanonicalName();
	}

	
}

