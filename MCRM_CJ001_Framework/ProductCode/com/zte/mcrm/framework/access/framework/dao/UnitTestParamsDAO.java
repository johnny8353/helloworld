package com.zte.mcrm.framework.access.framework.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.access.framework.vo.UnitTestParamsVO;
@Repository
public class UnitTestParamsDAO  extends BasicDaoImpl<UnitTestParamsVO>  implements IUnitTestParamsDAO{
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return IUnitTestParamsDAO.class.getCanonicalName();
	}

	@Override
	public List<UnitTestParamsVO> searchAllParams(String testType) {
		// TODO Auto-generated method stub
		 return sqlSession.selectList(getNamespace() +".searchAllParams", testType);
	}

	@Override
	public int updateList(List<UnitTestParamsVO> list) {
		// TODO Auto-generated method stub
		return sqlSession.update(getNamespace() +".updateList",list);
	}

	@Override
	public int updateByBeanId(UnitTestParamsVO uvo) {
		// TODO Auto-generated method stub
		return sqlSession.update(getNamespace() +".updateByBeanId",uvo);
	}

	@Override
	public List<UnitTestParamsVO> getUnitTestParamsByBeanKey(String beanKey) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(getNamespace() +".getUnitTestParamsByBeanKey", beanKey);
	}
}
