package com.zte.mcrm.basedata.business.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zte.mcrm.basedata.access.log.dao.ILogDao;
import com.zte.mcrm.basedata.access.log.vo.LogVO;
import com.zte.mcrm.compSearch.access.compSearch.dao.ICompSearchDao;
import com.zte.mcrm.framework.business.framework.service.BasicService;

/**
 * 类 编 号：
 * 类 名 称：LogService
 * 内容摘要：日志服务 实现类 
 * 完成日期：2015-12-29
 * 编码作者：JohnnyHuang
 */
@Service
public class LogService  extends BasicService<LogVO> implements ILogService {
	@Autowired
	private ILogDao logDao;
	@Override
	public int insert(Object parameter){
		return logDao.insert(parameter);
	}

	@Override
	public int modify(Object parameter) {
		return logDao.modify(parameter);
	}

	
}
