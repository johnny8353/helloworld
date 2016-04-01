package com.zte.mcrm.privilege.access.privilege.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.access.framework.dao.BasicDaoImpl;
import com.zte.mcrm.privilege.access.privilege.vo.ProjectVO;

/**   
 * 类 编 号：
 * 类 名 称：PermissionDao.java
 * 内容摘要：
 * 完成日期：2016-1-25  
 * 编码作者：QunLi
 */
@Repository
public class PermissionDao extends BasicDaoImpl<ProjectVO> implements IPermissionDao{
    
	@Override
	public String getNamespace() {
		return IPermissionDao.class.getCanonicalName();
	}

	@Override
	public String getLeaderLevel(String empShorNo) {
		return sqlSession.selectOne(getNamespace()+".getLeaderLevel", empShorNo);
	}

	@Override
	public List<String> getPositionTypeList(Object parameter) {
		return sqlSession.selectList(getNamespace()+".getPositionTypeList", parameter);
	}

	@Override
	public int getAuthorization(Object parameter) {
		return sqlSession.selectOne(getNamespace()+".getAuthorization", parameter);
	}

	@Override
	public ProjectVO getProjectInfo(Object parameter) {
		return sqlSession.selectOne(getNamespace()+".getProjectInfo", parameter);
	}

	@Override
	public int getProjTeamInfo(Object parameter) {
		return sqlSession.selectOne(getNamespace()+".getProjTeamInfo", parameter); 
	}
}

