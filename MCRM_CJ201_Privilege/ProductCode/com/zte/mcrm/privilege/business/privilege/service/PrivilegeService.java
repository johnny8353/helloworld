package com.zte.mcrm.privilege.business.privilege.service;

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
import com.zte.mcrm.privilege.access.privilege.dao.PermissionDao;
import com.zte.mcrm.privilege.access.privilege.vo.ProjectVO;
import com.zte.mcrm.privilege.model.privilege.PrivilegeBO;

/**
 * 类 编 号： 类 名 称：PrivilegeService.java 内容摘要： 完成日期：2016-1-25 编码作者：QunLi
 */
@Service
public class PrivilegeService implements IPrivilegeService {
	protected Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Override 
	public String getPrivilegeControlInfo(PrivilegeBO boBean) {
		//初始化对象
		String status = SiebelBaseBO.SUCCESS, errorMsg = "", errorCode = "";
		Map<String, String> fMap = new HashMap<String, String>();
		fMap = boBean.getfMap();

		String infoType = fMap.get("infoType");// 信息类型
		String privilegeStr = null;
		try {
			validateDate(fMap, boBean);
			if ("02".equals(infoType)) {
				
			} else if ("03".equals(infoType)) {

			} else if ("04".equals(infoType)) {

			} else if ("0401".equals(infoType)) {
					
			} else if ("0402".equals(infoType)) {

			} else if ("0300".equals(infoType)) {

			} else if ("0301".equals(infoType)) {

			} else if ("0302".equals(infoType)) {

			} else if ("0303".equals(infoType)) {

			} else if ("0304".equals(infoType)) {
				
			} else if ("040100".equals(infoType)) {

			} else if ("040101".equals(infoType)) {

			} else if ("040102".equals(infoType)) {

			} else if ("040103".equals(infoType)) {

			} else if ("040200".equals(infoType)) {

			} else if ("040201".equals(infoType)) {

			} else if ("040202".equals(infoType)) {

			} else if ("040203".equals(infoType)) {

			} else{
				privilegeStr="0000000000000000";
				throw new Exception("没有infoType为"+infoType+"的权限控制");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return privilegeStr;
	}
	
	/**
	 * 获取任务书阅读权限
	 * @return
	 */
	public String getProjMissionRead(Map<String, String> fMap,String empShorNo){
		String infoId = fMap.get("infoId");// 信息Id
		String flag = "0";
		
		try {
			//必输校验
			if ("".equals(StringUtil.retBlankIfNull(empShorNo)))
				throw new Exception("员工号必输！(empShorNo must input！)");
			if ("".equals(StringUtil.retBlankIfNull(infoId)))
				throw new Exception("信息Id必输！(infoId must input！)");
			
			flag = getMissionReadable_Authorization(empShorNo, "Project");
			if (!"1".equals(flag)) {
				flag = getMissionReadable_Team(infoId, empShorNo, "Proj");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private String getMissionReadable_Team(String infoId, String empShorNo,String infoType) throws Exception {
		String flag = "0";
		if("Proj".equals(infoType)){
			//立项
			ProjectVO projectVo = permissionDao.getProjectInfo(infoId);
			String parentId = "";
			if(projectVo != null){
				parentId = projectVo.getParentId();
				Map<String, String> map = new HashMap<String, String>();
				map.put("projId", infoId);
				map.put("empShorNo", empShorNo);
				
				int count = permissionDao.getProjTeamInfo(map);
				if(count > 0){
					flag = "1";
				}
				//如果有项目群,且在项目中无权限,则还要判断是否是项目群团队成员
				if(parentId != null){
					if(!"1".equals(flag) && !"".equals(parentId)){
						count = permissionDao.getProjTeamInfo(map);
						if(count >0){
							flag = "1";
						}
					}
				}
			}else{
				throw new Exception("查找不到Id为"+infoId+"的项目");
			}
		}else if("ProjApp".equals(infoType)){
			//项目
		}else if("Opty".equals(infoType)){
			//商机
		}
		return flag;
	}
	
	/**
	 * 判断是否是领导
	 * @param empShorNo
	 * @return
	 */
	private String getLeaderLevel(String empShorNo) {
		String flag = permissionDao.getLeaderLevel(empShorNo);
		if(flag != null){ 
			return "1";
		}else{
			return "0";
		}
	}

	/**
	 * 获取外围授权人员权限
	 * @param empShorNo
	 * @param string
	 * @return
	 * @throws Exception 
	 */
	private String getMissionReadable_Authorization(String empShorNo, String string) throws Exception {
		
		//判断是否是领导
		String flag = getLeaderLevel(empShorNo);
		//如果不是领导,判断是否赋权
		if(!"1".equals(flag)){
			//根据工号获取职位类型类表
			List<String> positionTypeList = permissionDao.getPositionTypeList(empShorNo);
			Map<String, String> map = null;
			if(positionTypeList != null){
				
				for (String  positionType : positionTypeList) {
					map = new HashMap<String, String>();
					map.put("positionType", positionType);
					map.put("infoType", "Project");
					int count =  permissionDao.getAuthorization(map);
					if(count > 0){//只要找到一条记录就可以返回
						flag = "1";
						break;
					}
				}
			}
		}
		return flag;
	}
	
	/**
	 * 校验必输
	 * @param fMap
	 * @param boBean
	 * @throws Exception
	 */
	private void validateDate(Map<String, String> fMap, PrivilegeBO boBean)
			throws Exception {
		String buttonStr = fMap.get("buttonStr");// 按钮key字符串
		String infoId = fMap.get("infoId");// 信息Id
		String empShorNo = boBean.getU();

		if ("".equals(StringUtil.retBlankIfNull(empShorNo)))
			throw new Exception("员工号必输！(empShorNo must input！)");
		if ("".equals(StringUtil.retBlankIfNull(buttonStr)))
			throw new Exception("按钮key字符串必输！(buttonStr must input！)");
		if ("".equals(StringUtil.retBlankIfNull(infoId)))
			throw new Exception("信息Id必输！(infoId must input！)");
	}
}
