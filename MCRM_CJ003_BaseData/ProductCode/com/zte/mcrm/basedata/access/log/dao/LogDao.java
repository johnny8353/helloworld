package com.zte.mcrm.basedata.access.log.dao;

import org.springframework.stereotype.Repository;

import com.zte.mcrm.basedata.access.log.vo.LogVO;
import com.zte.mcrm.framework.access.framework.dao.BasicDaoImpl;
@Repository
public class LogDao  extends BasicDaoImpl<LogVO>  implements ILogDao{

	@Override
	public String getNamespace() {
		return ILogDao.class.getCanonicalName();
	}

}
