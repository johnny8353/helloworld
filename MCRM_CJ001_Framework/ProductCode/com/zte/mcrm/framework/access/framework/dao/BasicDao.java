package com.zte.mcrm.framework.access.framework.dao;

import java.util.List;
import java.util.Map;

public interface BasicDao<T> {

		public static final String BEAN_ID = "basicDao";
		/**
		 * 通过myBatis查询多个记录
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @return
		 */
//		public int queryListCount( Object parameter);
		/**
		 * 通过myBatis查询多个记录
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public List<T> queryList( Object parameter);
		/**
		 * 通过myBatis查询单个记录或单个对象
		 * @param statementId Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public T query( Object parameter);
		/**
		 * 通过myBatis查询数量
		 * @param statementId Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public int queryCount( Object parameter);

		/**
		 * 通过myBatis进行新建操作
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public int insert( Object parameter);

		/**
		 * 通过myBatis进行删除操作
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public int delete( Object parameter);
		
		/**
		 * 通过myBatis进行删除全部操作
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public int deleteAll( Object parameter);

		/**
		 * 通过myBatis进行修改操作
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public int modify( Object parameter);
		
		/**
		 * 通过myBatis进行查询操作
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @return
		 */
		public Map<String,T> queryMap( Object parameter, String mapKey);
		
		/**
		 * 通过myBatis进行分页查询操作
		 * @param statementId MyBatis Sql Id
		 * @param parameter 参数
		 * @param start 起始位置
		 * @param limit 查询条数
		 * @return
		 */
		public List<T> queryPagnation( Object parameter,int start,int limit);

}
