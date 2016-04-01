package com.zte.mcrm.basedata.access.lov.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zte.mcrm.basedata.access.lov.vo.LOV;
import com.zte.mcrm.framework.access.framework.dao.BasicDao;
import com.zte.mcrm.framework.access.framework.dao.BasicDaoImpl;



@Repository
public class LOVDao extends BasicDaoImpl<LOV> implements ILOVDao, BasicDao<LOV>{
	
	@Override
	public String getNamespace() {
		return ILOVDao.class.getCanonicalName();
	}

	@Override
	public List<LOV> queryStaticLOV(List lovtypes) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getLOV",lovtypes);
	}

	@Override
	public List<LOV> queryLOVChildren(LOV lov) {
		return sqlSession.selectList("queryChildren",lov);
	}

	@Override
	public List<LOV> queryStaticLOV(Map<String, String> lovtype) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getLOVByType",lovtype);
	}

	@Override
	public LOV queryLOVByTypeAndName(LOV lov){
		return sqlSession.selectOne("getLOVByTypeAndName",lov);
	}
	
	@Override
	public List<LOV> queryLOVByType(String type){
		LOV example = new LOV();
		example.setType(type);
		return sqlSession.selectList("queryLOVByType",example);
	}

	@Override
	public List<LOV> queryLOVsByTypeAndName(LOV lov) {
		return sqlSession.selectList("getLOVsByTypeAndName",lov);
	}

	
}
