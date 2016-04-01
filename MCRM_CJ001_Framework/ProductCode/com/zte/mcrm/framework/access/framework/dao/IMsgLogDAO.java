package com.zte.mcrm.framework.access.framework.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.access.framework.vo.MsgLogVO;
import com.zte.mcrm.framework.model.framework.McrmException;

/**
 * 类 编 号：BL_PU2010101_IMsgLogDAO
 * 类 名 称：IMsgLogDAO
 * 内容摘要：调用接口记录DAO接口 
 * 完成日期：2014-11-14
 */
@Repository
public interface IMsgLogDAO {
	/**
	 * 保存调用接口信息
	 * @param msgLogVO
	 * @return
	 */
	public int saveMsgInfo(MsgLogVO msgLogVO) throws  McrmException;
	/**
	 * 修改最后更新时间
	 * @param msgLogVO
	 * @throws McrmException
	 */
	public void updateLastDate(MsgLogVO msgLogVO) throws  McrmException;
	/**
	 * 查询操作日志
	 * @param msgLogVO
	 * @throws McrmException
	 */
	public List<MsgLogVO> getMsgLogInfo(Map<String,Object> mapdata) throws  McrmException;
}
