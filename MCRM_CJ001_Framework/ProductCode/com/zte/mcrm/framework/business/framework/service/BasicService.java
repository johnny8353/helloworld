package com.zte.mcrm.framework.business.framework.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BasicService<T> implements IBasicService<T>{
	@Override
	public int queryListCount(Object parameter) {
		return 0;
	}
	@Override
	public List<T> queryList(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	@Override
	public T query(Object parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@Override
//	public int queryCount(Object parameter) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int insert(Object parameter) throws Exception {
		return 0;
	}

	@Override
	public int delete(Object parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Object parameter) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, T> queryMap(Object parameter, String mapKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> queryPagnation(Object parameter, int start, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
