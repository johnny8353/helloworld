/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmExceptionInfoService 
 * 文件名称：McrmExceptionInfoService.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-14
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-14
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.business.framework.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zte.mcrm.framework.access.framework.dao.IMcrmExceptionDAO;
import com.zte.mcrm.framework.access.framework.vo.McrmExceptionVO;
import com.zte.mcrm.framework.model.framework.FrameMcrmException;
import com.zte.mcrm.framework.model.framework.McrmException;
import com.zte.mcrm.framework.model.framework.McrmExceptionBO;
import com.zte.mcrm.framework.model.framework.McrmExceptionComm;

/**
 * 类 编 号：BL_PU2010101_McrmExceptionInfoService
 * 类 名 称：McrmExceptionInfoService
 * 内容摘要：XXX 
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
@Service
public class McrmExceptionInfoService implements IMcrmExceptionInfoService
{
//    @Autowired
	private IMcrmExceptionDAO mcrmExceptionDAO;
    
    /**
	 * 业务描述：保存异常信息 
	 * 作          者：JohnnyHuang 黄福强
	 * 完成日期：2014-10-14
	 * @param mcrmExceptionBO
	 * @return
	 */
	@Override
	public boolean saveExceptionInfo(McrmExceptionBO mcrmExceptionBO)
	{
		boolean bln=false;
		try
		{
			String errMsg=mcrmExceptionBO.getMcrmExceptionVO().getExceptionMessage();
			if (errMsg!= null && errMsg.length()>3800) 
			{
				mcrmExceptionBO.getMcrmExceptionVO().setExceptionMessage(errMsg.substring(0, 3800));
				errMsg=null;
			}
			bln= mcrmExceptionDAO.saveExceptionInfo(mcrmExceptionBO.getMcrmExceptionVO());
		}
		catch(Exception ex)
		{
			bln=false;
			ex.printStackTrace();
		}
		return bln;
	}
	
	 /**
	  * 
	  * 业务描述：获取一条异常信息
	  * 作          者：JohnnyHuang 黄福强
	  * 完成日期：2014-10-22
	  * @param exId
	  * @return
	  * @throws Exception
	  */
	 @Override
	public McrmExceptionBO getExceptinInfo(int exId) throws  McrmException
	 {
		 McrmExceptionBO mbo =new McrmExceptionBO();
			try
			{
				mbo.setMcrmExceptionVO(mcrmExceptionDAO.getExceptinInfo(exId));
			}
			catch(Exception ex)
			{
				FrameMcrmException.throwFrameMcrmException(McrmExceptionComm.ERROR_LAYER_SERVICE, this.getClass().getName(), ex);
			}
		 return mbo;
	 }

	 /**
	  * 根据条件查询异常信息
	  */
	@Override
	public List<McrmExceptionVO> getExceptionInfoList(
			Map<String, Object> mapData) throws McrmException
	{
		List<McrmExceptionVO> list = new ArrayList<McrmExceptionVO>();
		try{
			list = mcrmExceptionDAO.getExceptionInfoList(mapData);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
