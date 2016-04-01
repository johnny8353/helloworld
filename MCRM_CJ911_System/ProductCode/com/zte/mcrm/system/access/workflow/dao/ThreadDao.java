package com.zte.mcrm.system.access.workflow.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.access.framework.dao.BasicDaoImpl;
import com.zte.mcrm.system.access.workflow.vo.ThreadExampleVO;
import com.zte.mcrm.system.access.workflow.vo.ThreadVO;
@Repository
public class ThreadDao  extends BasicDaoImpl<ThreadVO>  implements IThreadDao{
	
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return IThreadDao.class.getCanonicalName();
	}

	
}
