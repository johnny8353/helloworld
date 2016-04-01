package com.zte.mcrm.framework.access.framework.dao;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BasicDaoImpl<T> implements BasicDao<T> {

	private static Logger logger = Logger.getLogger(BasicDaoImpl.class);
	@Resource
	protected SqlSession sqlSession ;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public SqlSession getSqlSession() {

		return this.sqlSession;
	}
//	@Override
//	public int queryListCount( Object parameter){
//		return sqlSession.selectOne(getNamespace() +".queryListCount",parameter);
//
//	}
	@Override
	public int insert( Object parameter) {
		return sqlSession.insert(getNamespace() + ".insert", parameter);
	}

	@Override
	public int delete( Object parameter) {
		return sqlSession.delete(getNamespace() +".delete", parameter);
	}
	
	@Override
	public int deleteAll( Object parameter) {
		return sqlSession.delete(getNamespace() +".deleteAll", parameter);
	}
	

	@Override
	public int modify( Object parameter) {
		return sqlSession.update(getNamespace() +".modify", parameter);
	}

	@Override
	public T query( Object parameter) {
		return sqlSession.selectOne(getNamespace() +".query", parameter);
	}

	@Override
	public List<T> queryList(Object parameter) {
		return sqlSession.selectList(getNamespace() +".queryList", parameter);
		
	}
	
	@Override
	public Map<String,T> queryMap( Object parameter, String mapKey) {
		return sqlSession.selectMap(getNamespace() +".queryMap",parameter,mapKey);
	}
	
	@Override
	public List<T> queryPagnation(Object value,int start,int limit) {
		if(start < 0 || limit < 0)	return sqlSession.selectList(getNamespace() +".queryPagnation", value);
		else return sqlSession.selectList(getNamespace() +".queryPagnation", value, new RowBounds(start,limit));
	}

	@Override
	public int queryCount( Object parameter) {
		return sqlSession.selectOne(getNamespace() +".queryCount",parameter);
	}
	
	public List<T> queryPagnationByExample(Object example,int start,int limit) {
		if(start < 0 || limit < 0)	return sqlSession.selectList(getNamespace() +".queryPagnationByExample", example);
		else return sqlSession.selectList(getNamespace() +".queryPagnationByExample", example, new RowBounds(start,limit));
	}
	
	public List<T> queryCountByExample(Object example) {
		return sqlSession.selectOne(getNamespace() +".queryCountByExample",example);
	}
	
	public abstract String getNamespace();
}
