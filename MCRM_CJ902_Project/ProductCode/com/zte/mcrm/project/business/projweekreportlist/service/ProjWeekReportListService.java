package com.zte.mcrm.project.business.projweekreportlist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.privilege.access.privilege.dao.IPermissionDao;
import com.zte.mcrm.privilege.business.privilege.service.IPrivilegeService;
import com.zte.mcrm.privilege.business.privilege.service.PrivilegeService;
import com.zte.mcrm.project.access.projweekreportlist.dao.ProjWeekReportListDao;
import com.zte.mcrm.project.access.projweekreportlist.vo.ProjWeekReportListVO;
import com.zte.mcrm.project.model.projweekreportlist.ProjWeekReportListBO;

/**   
 * 类 编 号：
 * 类 名 称：ProjWeekReportListService.java
 * 内容摘要：
 * 完成日期：2016-1-21  
 * 编码作者：QunLi
 */
@Service
public class ProjWeekReportListService implements IProjWeekReportListService {
	
	@Autowired
	ProjWeekReportListDao reportListDao ;
	
	@Autowired
	PrivilegeService privilegeService;
	@Override
	public ProjWeekReportListBO getProjWeekReportListBO(ProjWeekReportListBO boBean) {
		String status =SiebelBaseBO.SUCCESS,errorMsg = "",errorCode="";
		int totalCount = 0;
		Map<String, String> fMap = new HashMap<String, String>();
		fMap = boBean.getfMap();
		List<ProjWeekReportListVO> projWeekReportList = null;
		//输入数据校验
		try {
			//验证数据
			ValidateData(fMap,boBean);
			String empNum = boBean.getU();
			String empId = reportListDao.getEmpIdByNum(empNum);  
			//获取权限
			String permission = getPermission(fMap,empNum);
			//获取项目数量
			fMap.put("permission", permission);   
			fMap.put("empId", empId);
			
			totalCount = reportListDao.getProjWeekReportListNum(fMap);
			//获取项目列表
			projWeekReportList = reportListDao.getProjWeekReportList(fMap,boBean.getP().getStartNo(), boBean.getP().getPSIZE());
			
			boBean.setReportVos(projWeekReportList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		boBean.getP().setT(String.valueOf(totalCount));
		boBean.getP().setTP((int) Math.ceil(totalCount*1.0/boBean.getP().getPSIZE()));
		boBean.setErrorCode(errorCode);
		boBean.setErrorMsg(errorMsg);
		boBean.setS(status);
		
		return boBean;
	}
	
	private String getPermission(Map fMap,String empShorNo) {

		fMap.put("infoId", fMap.get("prjId"));
		String flag = privilegeService.getProjMissionRead(fMap, empShorNo);
		System.out.println("flag:"+flag);
		if(flag != null && "1".equals(flag)){
			return "readable";
		}else{
			return "";
		}
	}
	private void ValidateData(Map<String, String> fMap,
			ProjWeekReportListBO boBean) throws Exception{
		int pageSize =  boBean.getP().getPSIZE();
		int currentPage = boBean.getP().getPNO();
		String empShorNo = boBean.getU();
		String prjId = StringUtil.retBlankIfNull(fMap.get("prjId"));
		if("".equals(String.valueOf(currentPage))){
			throw new Exception("当前页必输!(currentPage must be a number!)");
		}else if("".equals(empShorNo)){
			throw new Exception("员工号必输!(empShorNo must input!)");
		}else if("".equals(String.valueOf(pageSize))){
			throw new Exception("页大小必须是数字!(pageSize must be a number!)");
		}else if("".equals(prjId)){
			throw new Exception("项目ID必输!(prjId msut Input!)");
		}
		
	}
}

