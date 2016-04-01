package com.zte.mcrm.compSearch.access.compSearch.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.zte.mcrm.compSearch.access.compSearch.vo.CompSearchVO;
import com.zte.mcrm.framework.access.framework.dao.BasicDaoImpl;

@Repository
public class CompSerachDao extends BasicDaoImpl<CompSearchVO>  implements ICompSearchDao{

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return ICompSearchDao.class.getCanonicalName();
	}
	@Override
	public Map<String, Map<String, String>> queryAvailableOrg(Object parameter) {
		return sqlSession.selectMap(getNamespace() + ".queryAvailableOrg", parameter,"ROW_ID");
	}

	@Override
	public List<CompSearchVO> queryProjPagnation(Object parameter,int start,int limit) {
		if(start < 0 || limit < 0)	return sqlSession.selectList(getNamespace() +".queryProjPagnation", parameter);
		else return sqlSession.selectList(getNamespace() +".queryProjPagnation", parameter, new RowBounds(start,limit));
	}
	
	@Override
	public List<CompSearchVO> queryProjPagnation2(Object parameter,int start,int limit) {
		Map<String, String> fMap = (Map<String, String>) parameter;
		fMap.put("start", String.valueOf(start));
		fMap.put("end", String.valueOf(limit+start));
		return sqlSession.selectList(getNamespace() +".queryProjPagnation2", fMap);
	}

	@Override
	public int queryProjCount(Object parameter) {
		return sqlSession.selectOne(getNamespace() +".queryProjCount",parameter);
	}
	@Override
	public List<CompSearchVO> queryOptyPagnation(Object parameter, int start,
			int limit) {
		if(start < 0 || limit < 0)	return sqlSession.selectList(getNamespace() +".queryOptyPagnation", parameter);
		else return sqlSession.selectList(getNamespace() +".queryOptyPagnation", parameter, new RowBounds(start,limit));
	}
	@Override
	public int queryOptyCount(Object parameter) {
		return sqlSession.selectOne(getNamespace() +".queryOptyCount",parameter);
	}
	@Override
	public List<CompSearchVO> queryLeadPagnation(Object parameter, int start,
			int limit) {
		if(start < 0 || limit < 0)	return sqlSession.selectList(getNamespace() +".queryLeadPagnation", parameter);
		else return sqlSession.selectList(getNamespace() +".queryLeadPagnation", parameter, new RowBounds(start,limit));
	}
	@Override
	public int queryLeadCount(Object parameter) {
		return sqlSession.selectOne(getNamespace() +".queryLeadCount",parameter);
	}
	@Override
	public List<CompSearchVO> queryAccntPagnation(Object parameter, int start,
			int limit) {
		if(start < 0 || limit < 0)	return sqlSession.selectList(getNamespace() +".queryAccntPagnation", parameter);
		else return sqlSession.selectList(getNamespace() +".queryAccntPagnation", parameter, new RowBounds(start,limit));
	}
	@Override
	public int queryAccntCount(Object parameter) {
		return sqlSession.selectOne(getNamespace() +".queryAccntCount",parameter);
	}
	@Override
	public int judgeSingleDataVisibility(Object parameter) {
		return sqlSession.selectOne(getNamespace() +".judgeSingleDataVisibility",parameter);
	}
	
}
