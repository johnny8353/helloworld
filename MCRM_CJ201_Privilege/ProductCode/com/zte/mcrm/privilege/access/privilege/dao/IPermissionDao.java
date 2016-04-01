package com.zte.mcrm.privilege.access.privilege.dao;

import java.util.List;

import com.zte.mcrm.framework.access.framework.dao.BasicDao;
import com.zte.mcrm.privilege.access.privilege.vo.ProjectVO;

/**   
 * 类 编 号：
 * 类 名 称：IPermissionDao.java
 * 内容摘要：
 * 完成日期：2016-1-25  
 * 编码作者：QunLi
 */
public interface IPermissionDao extends BasicDao<ProjectVO>{
	String getLeaderLevel(String empShorNo);
	List<String> getPositionTypeList(Object parameter);
	int getAuthorization(Object parameter);
	ProjectVO getProjectInfo(Object parameter);
	int getProjTeamInfo(Object parameter) ;  
}

