package com.zte.mcrm.framework.business.framework.service;

import java.util.List;
import java.util.Map;

public interface IBasicService<T>{

	public static final String BEAN_ID = "basicDao";
	/**查询数量*/
	public int queryListCount( Object parameter);
	/** 查询多个记录*/
	public List<T> queryList(Object object);
	/**单个记录或单个对象*/
	public T query(Object parameter);
	/**查询数量*/
//	public int queryCount( Object parameter);
	/**进行新建操作
	 * @throws Exception */
	public int insert( Object parameter) throws Exception;
	/**进行删除操作*/
	public int delete( Object parameter) throws Exception;
	/**进行修改操作
	 * @throws Exception */
	public int modify( Object parameter) throws Exception;
	/**进行查询操作*/
	public Map<String,T> queryMap( Object parameter, String mapKey);
	/**分页查询操作*/
	public List<T> queryPagnation( Object parameter,int start,int limit);
}
