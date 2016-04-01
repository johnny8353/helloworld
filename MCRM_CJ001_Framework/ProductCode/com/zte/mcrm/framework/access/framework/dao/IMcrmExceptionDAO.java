package com.zte.mcrm.framework.access.framework.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.access.framework.vo.McrmExceptionVO;
import com.zte.mcrm.framework.model.framework.McrmException;
/**
 * 类 编 号：BL_PU2010101_IMcrmBaseDAO
 * 类 名 称：IMcrmBaseDAO
 * 内容摘要：异常处理DAO操作类接口 
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
@Repository
public interface IMcrmExceptionDAO 
{
	/**
	 * 业务描述：保存异常信息 
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-10-14
	 * @param mcrmExceptionVO
	 * @return
	 */
	 public boolean saveExceptionInfo(McrmExceptionVO mcrmExceptionVO) throws  McrmException;
	 
	 /**
	  * 
	  * 业务描述：获取一条异常信息
	  * 作          者：JohnnyHuang 黄福强
	  * 完成日期：2014-10-22
	  * @param exId
	  * @return
	  * @throws Exception
	  */
	 public McrmExceptionVO getExceptinInfo(int exId) throws  McrmException;
	 
	 /**
	  * 
	  * 业务描述：根据条件查询异常信息
	  * 作          者：6418000155
	  * 完成日期：2015-1-19
	  * @param mapData
	  * @return
	  * @throws McrmException
	  */
	 public List<McrmExceptionVO> getExceptionInfoList(Map<String,Object> mapData) throws McrmException;
}
