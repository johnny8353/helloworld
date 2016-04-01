package com.zte.mcrm.compSearch.business.compSearch.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.basedata.access.log.dao.ILogDao;
import com.zte.mcrm.basedata.access.log.vo.LogVO;
import com.zte.mcrm.basedata.access.lov.dao.ILOVDao;
import com.zte.mcrm.basedata.access.lov.vo.LOV;
import com.zte.mcrm.compSearch.access.compSearch.dao.ICompSearchDao;
import com.zte.mcrm.compSearch.access.compSearch.vo.CompSearchVO;
import com.zte.mcrm.compSearch.model.compSearch.CompSearchBO;
import com.zte.mcrm.framework.business.framework.service.BasicService;
import com.zte.mcrm.framework.model.framework.FBO;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;

/**
 * 类 编 号： 类 名 称：CompSearchService 内容摘要：综合查询业务服务类 完成日期：2015-12-30
 * 编码作者：JohnnyHuang
 */
@Service
public class CompSearchService extends BasicService<CompSearchVO> implements
		ICompSearchService {
	protected Log log = LogFactory.getLog(getClass());
	@Autowired
	private ICompSearchDao compSearchDao;
	@Autowired
	private ILOVDao lovDao;

	@Override
	public CompSearchBO judgeSingleDataVisibility(CompSearchBO boBean) {
		int totalCount = 0;
		String status = SiebelBaseBO.SUCCESS, errorMsg = "", errorCode = "";
		Map<String, String> fMap = new HashMap<String, String>();
		Map<String, Map<String, String>> availableOrgMaps = new HashMap<String, Map<String, String>>();
		try {
			fMap = boBean.getfMap();
			availableOrgMaps = compSearchDao.queryAvailableOrg(boBean);
			queryAvailableOrg(availableOrgMaps, fMap);
			totalCount = compSearchDao.judgeSingleDataVisibility(fMap);
			boBean.getP().setT(String.valueOf(totalCount));
			if(totalCount!=1){
				throw new Exception("你没有权限操作该记录! You have no permission to operate this Record!");
			}
		} catch (Exception e) {
			status = SiebelBaseBO.FAIL;
			errorMsg = e.getMessage();
			e.printStackTrace();
		} finally {
			boBean.setErrorCode(errorCode);
			boBean.setErrorMsg(errorMsg);
			boBean.setS(status);
		}
		return boBean;
	}

	@Override
	public CompSearchBO CompSearch(CompSearchBO boBean) {
		String status = SiebelBaseBO.SUCCESS, errorMsg = "", errorCode = "";
		int totalCount = 0;
		Map<String, String> fMap = new HashMap<String, String>();
		Map<String, Map<String, String>> availableOrgMaps = new HashMap<String, Map<String, String>>();

		try {
			fMap = boBean.getfMap();
			// 输入数据校验
			ValidateData(fMap, boBean);
			availableOrgMaps = compSearchDao.queryAvailableOrg(boBean);
			fMap.put(
					"orderBy",
					GetOrderbyStr(fMap.get("speSearchType"),
							fMap.get("orderby")));
			fMap.put("selectCode",
					GetSelectCodeSql(fMap.get("selectCode"), boBean.getL()));
			queryAvailableOrg(availableOrgMaps, fMap);
			// 处理str关键字
			String searchType = fMap.get("searchType");
			if (searchType.equals("01")) {
				String str = fMap.get("str");
				str = StringUtil.decodeSpecialCharsWhenLikeUseBackslash(str);// 查询关键字
				str = str.toUpperCase().replace(' ', '%');
				fMap.put("str", str);
			}
			// 处理项目
			if (fMap.get(FBO.SPESEARCHTYPE_STRING).equals(
					CompSearchBO.PROJCODE_STRING)) {
				totalCount = compSearchDao.queryProjCount(fMap);
				if(totalCount>1000){//数量较大时采用in方式
					boBean.setSearchVOs(compSearchDao.queryProjPagnation2(fMap,
						boBean.getP().getStartNo(), boBean.getP().getPSIZE()));
				}else{
					boBean.setSearchVOs(compSearchDao.queryProjPagnation(fMap,
							boBean.getP().getStartNo(), boBean.getP().getPSIZE()));
				}
				
			}
			// 处理商机
			else if (fMap.get(FBO.SPESEARCHTYPE_STRING).equals(
					CompSearchBO.OPTYCODE_STRING)) {
				totalCount = compSearchDao.queryOptyCount(fMap);
				boBean.setSearchVOs(compSearchDao.queryOptyPagnation(fMap,
						boBean.getP().getStartNo(), boBean.getP().getPSIZE()));
			}
			// 处理线索
			else if (fMap.get(FBO.SPESEARCHTYPE_STRING).equals(
					CompSearchBO.LEADCODE_STRING)) {
				totalCount = compSearchDao.queryLeadCount(fMap);
				boBean.setSearchVOs(compSearchDao.queryLeadPagnation(fMap,
						boBean.getP().getStartNo(), boBean.getP().getPSIZE()));
			}
			// 处理客户
			else if (fMap.get(FBO.SPESEARCHTYPE_STRING).equals(
					CompSearchBO.ACCOUNTCODE_STRING)) {
				totalCount = compSearchDao.queryAccntCount(fMap);
				boBean.setSearchVOs(compSearchDao.queryAccntPagnation(fMap,
						boBean.getP().getStartNo(), boBean.getP().getPSIZE()));
			}

		} catch (Exception e) {
			status = SiebelBaseBO.FAIL;
			errorMsg = e.getMessage();
			e.printStackTrace();
		} finally {
			boBean.getP().setT(String.valueOf(totalCount));
			boBean.getP().setTP(
					(int) Math.ceil(totalCount * 1.0 / boBean.getP().getPSIZE()));
			boBean.setErrorCode(errorCode);
			boBean.setErrorMsg(errorMsg);
			boBean.setS(status);
			log.info(SiebelBaseBO.LOG_PREFIX + "结果总数：" + totalCount);
			log.info(SiebelBaseBO.LOG_PREFIX + "结果状态：" + status);
			log.info(SiebelBaseBO.LOG_PREFIX + "结果信息：" + errorMsg);
		}
		return boBean;
	}

	public void ValidateData(Map<String, String> fMap, CompSearchBO boBean)
			throws Exception {
		String speSearchType = StringUtil.retBlankIfNull(fMap
				.get("speSearchType"));
		String empShorNo = StringUtil.retBlankIfNull(boBean.getU());
		String searchType = StringUtil.retBlankIfNull(fMap.get("searchType"));
		String quickType = StringUtil.retBlankIfNull(fMap.get("quickType"));
		String dataId = StringUtil.retBlankIfNull(fMap.get("dataId"));
		String quickLevel = StringUtil.retBlankIfNull(fMap.get("quickLevel"));
		String str = StringUtil.retBlankIfNull(fMap.get("str"));
		int pageSize = boBean.getP().getPSIZE();
		int currentPage = boBean.getP().getPNO();
		if (String.valueOf(pageSize).equals("")) {
			throw new Exception("页大小pageSize不能为空！");
		}
		if (String.valueOf(currentPage).equals("")) {
			throw new Exception("当前页currentPage不能为空！");
		}
		if (empShorNo.equals("")) {
			throw new Exception("员工empShorNo不能为空！");
		}
		if (!(speSearchType.equals("01") || speSearchType.equals("02")
				|| speSearchType.equals("03") || speSearchType.equals("04"))) {
			throw new Exception("查询对象类型speSearchType值不符合,值为(01/02/03/04)！");
		}
		if (searchType.equals("01")) {
			if (str.equals("")) {
				throw new Exception("关键字查询：关键字str不能为空！");
			}
		} else if (searchType.equals("02")) {
			if (quickType.equals("")) {
				throw new Exception("快捷查询：类型quickType不能为空！");
			}
			if (dataId.equals("")) {
				throw new Exception("快捷查询：关键字dataId不能为空！");
			}
			if (quickLevel.equals("")) {
				throw new Exception("快捷查询：层级quickLevel不能为空！");
			}
		} else {
			throw new Exception("查询类型searchType值不符合,值为(01/02)！");
		}
	}

	public void queryAvailableOrg(
			Map<String, Map<String, String>> availableOrgMaps,
			Map<String, String> fMap) {
		String orgVisibleOrgStr = "";// 用户组织维度可见性
		String mtoVisibleOrgStr = "";// mto维度可见性
		String prodVisibleOrgStr = "";// 产品维度可见性
		String tradeVisibleOrgStr = "";// 行业维度可见性
		String accTypeVisibleOrgStr = "";// 客户类型维度
		String accTypeVisibleSQLStr = "";// 客户类型维度sql
		String speSearchType = fMap.get(FBO.SPESEARCHTYPE_STRING);
		for (Map.Entry<String, Map<String, String>> entry : availableOrgMaps
				.entrySet()) {
			Map<String, String> map1 = entry.getValue();
			String bu_id = "", type = "";
			for (Entry<String, String> entry2 : map1.entrySet()) {
				if (entry2.getKey().equalsIgnoreCase("bu_id")) {
					bu_id = entry2.getValue();
				}
				if (speSearchType
						.equalsIgnoreCase(CompSearchBO.PROJCODE_STRING)) {
					if (entry2.getKey().equalsIgnoreCase("proj_sect")) {
						type = entry2.getValue();
					}
				} else if (speSearchType
						.equalsIgnoreCase(CompSearchBO.OPTYCODE_STRING)) {
					if (entry2.getKey().equalsIgnoreCase("OPPTY_SECT")) {
						type = entry2.getValue();
					}
				} else if (speSearchType
						.equalsIgnoreCase(CompSearchBO.LEADCODE_STRING)) {
					if (entry2.getKey().equalsIgnoreCase("LEAD_SECT")) {
						type = entry2.getValue();
					}
				} else if (speSearchType
						.equalsIgnoreCase(CompSearchBO.ACCOUNTCODE_STRING)) {
					if (entry2.getKey().equalsIgnoreCase("ACCNT_SECT")) {
						type = entry2.getValue();
					}
				}
			}
			if (type.toUpperCase().indexOf("SUBORG") > -1) {
				orgVisibleOrgStr += "'" + bu_id + "',";
			}
			if (type.toUpperCase().indexOf("MTO") > -1) {
				mtoVisibleOrgStr += "'" + bu_id + "',";
			}
			if (type.toUpperCase().indexOf("PROD") > -1) {
				prodVisibleOrgStr += "'" + bu_id + "',";
			}
			if (type.toUpperCase().indexOf("TRADE") > -1) {
				tradeVisibleOrgStr += "'" + bu_id + "',";
			}

			// 客户类型和业务范围
			if (type.toUpperCase().indexOf("OPERATOR") > -1) {
				accTypeVisibleSQLStr += " or  ( exists (select 1 from siebel.s_party_rpt_rel p52 where p52.sub_party_id = t.DEPT_ID and p52.party_id = '"
						+ bu_id + "')";
				accTypeVisibleSQLStr += " and t.accType = 'Operator')";
			}
			if (type.toUpperCase().indexOf("GOVERNMENT") > -1) {
				accTypeVisibleSQLStr += " or  ( exists (select 1 from siebel.s_party_rpt_rel p52 where p52.sub_party_id = t.DEPT_ID and p52.party_id = '"
						+ bu_id + "')";
				accTypeVisibleSQLStr += " and t.accType = 'Government')";
			}
			if (type.toUpperCase().indexOf("SERVICE") > -1) {
				accTypeVisibleSQLStr += " or  ( exists (select 1 from siebel.s_party_rpt_rel p52 where p52.sub_party_id = t.DEPT_ID and p52.party_id = '"
						+ bu_id + "')";
				accTypeVisibleSQLStr += " and  (";
				accTypeVisibleSQLStr += " t.businessType = 'System Service' or t.businessType = 'System Enginee Service' or t.businessType = 'Service' ";
				accTypeVisibleSQLStr += "))";
			}
			if (type.toUpperCase().indexOf("GOVERSER") > -1) {
				accTypeVisibleSQLStr += " or  ( exists (select 1 from siebel.s_party_rpt_rel p52 where p52.sub_party_id = t.DEPT_ID and p52.party_id = '"
						+ bu_id + "')";
				accTypeVisibleSQLStr += " and  (";
				accTypeVisibleSQLStr += " (t.businessType = 'System Service' or t.businessType = 'System Enginee Service' or t.businessType = 'Service') and t.accType = 'Government'";
				accTypeVisibleSQLStr += "))";
			}
			if (type.toUpperCase().indexOf("OPERSER") > -1) {
				accTypeVisibleSQLStr += " or  ( exists (select 1 from siebel.s_party_rpt_rel p52 where p52.sub_party_id = t.DEPT_ID and p52.party_id = '"
						+ bu_id + "')";
				accTypeVisibleSQLStr += " and  (";
				accTypeVisibleSQLStr += " (t.businessType = 'System Service' or t.businessType = 'System Enginee Service' or t.businessType = 'Service') and t.accType = 'Operator' ";
				accTypeVisibleSQLStr += "))";
			}

		}
		fMap.put(CompSearchBO.ORGVISIBLEORGSTR_STRING,
				StringUtil.delLastComma(orgVisibleOrgStr));
		fMap.put(CompSearchBO.MTOVISIBLEORGSTR_STRING,
				StringUtil.delLastComma(mtoVisibleOrgStr));
		fMap.put(CompSearchBO.PRODVISIBLEORGSTR_STRING,
				StringUtil.delLastComma(prodVisibleOrgStr));
		fMap.put(CompSearchBO.TRADEVISIBLEORGSTR_STRING,
				StringUtil.delLastComma(tradeVisibleOrgStr));
		fMap.put(CompSearchBO.ACCTYPEVISIBLESQLSTR_STRING, accTypeVisibleSQLStr);
	}

	public String GetOrderbyStr(String speSearchType, String orderBy)
			throws Exception {

		String orderbyStr = "";
		// 预计签单金额：forcastSignMoney级别或线索总金额：ObjLevelorMeney状态：ObjectStatus创建时间：CreateDate
		if (speSearchType.equals("01")) {
			// 4.创建时间：CreateDate 5.客户名称：ObjName 6.客户类型：ObjType
			orderBy = StringUtil.retBlankIfNull(orderBy).equals("") ? "ObjName"
					: StringUtil.retBlankIfNull(orderBy);
			if (orderBy.equals("CreateDate")) {
				orderbyStr = " order by CreateDate desc ";
			} else if (orderBy.equals("ObjName")) {
				orderbyStr = " order by nlssort(infoname,'NLS_SORT=SCHINESE_PINYIN_M') asc ";
			} else if (orderBy.equals("ObjType")) {
				orderbyStr = " order by ObjLevelorMeney asc ";
			} else {
				orderbyStr = " order by nlssort(infoname,'NLS_SORT=SCHINESE_PINYIN_M') asc ";//默认名称排序
				//throw new Exception("排序orderby值不符合,值为(ObjectStatus/CreateDate/ObjName/ObjType)！");
			}
		} else if (speSearchType.equals("02") || speSearchType.equals("03")
				|| speSearchType.equals("04")) {
			orderBy = StringUtil.retBlankIfNull(orderBy).equals("") ? "forcastSignMoney"
					: StringUtil.retBlankIfNull(orderBy);
			if (orderBy.equals("forcastSignMoney")) {
				orderbyStr = " order by ObjectStatusFlag asc,forcastSignMoney desc ";
			} else if (orderBy.equals("ObjLevelorMeney")) {
				orderbyStr = " order by ObjectStatusFlag asc,ObjLevelorMeney desc ";
			} else if (orderBy.equals("ObjectStatus")) {
				orderbyStr = " order by ObjectStatusOrder desc ";
			} else if (orderBy.equals("CreateDate")) {
				orderbyStr = "  order by ObjectStatusFlag asc,CreateDate desc ";
			} else {
				throw new Exception(
						"排序orderby值不符合,值为(forcastSignMoney/ObjLevelorMeney/ObjectStatus/CreateDate)！");
			}
		}
		return orderbyStr;
	}

	public String GetSelectCodeSql(String selectCode, String langId)
			throws Exception {
		// 綜合查詢后篩選,,
		// 1．项目：
		// 项目级别：0401项目状态：0402项目金额：0403
		// 2.商机：
		// 商机级别：0301商机状态：0302商机金额：0303
		// 3.线索：
		// 业务范围：0201线索状态：0202预计我司金额：0203
		// 4.客户：
		// 客户类型：0101客户范围：0102运营商级别：0103
		String commonSql = "";
		if (!StringUtil.retBlankIfNull(selectCode).equals("")) {
			// 查询后筛选
			String[] typeArrays = selectCode.split(";");
			for (int i = 0; i < typeArrays.length; i++) {
				String[] typeArray = typeArrays[i].split(":");
				if (typeArray.length == 2) {
					String typeName = typeArray[0];
					String typeValue = getInStr(typeArray[1]);
// System.out.println(typeValue);
					if (StringUtil.retBlankIfNull(typeValue).equals("")) {
						throw new Exception("selectCode格式错误");
					}
					if (typeName.equals("'0401'") || typeName.equals("'0301'")
							|| typeName.equals("'0201'")
							|| typeName.equals("'0101'")) {
						commonSql += " and t.MSEARCCH1  in (" + typeValue + ")";
					} else if (typeName.equals("'0302'")
							|| typeName.equals("'0202'")
							|| typeName.equals("'0102'")) {
						commonSql += " and t.MSEARCCH2 in (" + typeValue + ")";
					} else if (typeName.equals("'0402'")) {
						LOV lov = new LOV();
						lov.setName(typeValue);
						lov.setType("ZTE_MCRM_PROJAPP_STATUS");
						lov.setLangId(langId);
						List<LOV> lovs = lovDao.queryLOVsByTypeAndName(lov);
						String type2 = "'";
						for (LOV lov2 : lovs) {
							type2 += lov2.getDescText() + ",";
						}
						type2 += "'";
						commonSql += " and OBJECTSTATUS in (" + getInStr(type2)
								+ ")";
					} else if (typeName.equals("'0103'")) {
						commonSql += " and t.MSEARCCH3 in (" + typeValue + ")";
					} else if (typeName.equals("'0403'")
							|| typeName.equals("'0303'")
							|| typeName.equals("'0203'")) {
						commonSql += " AND (1=2";
						String[] Array03 = typeValue.split(",");
						for (int j = 0; j < Array03.length; j++) {
							if (Array03[j].equals("'Range1'")) {
								commonSql += " OR (t.forcastSignMoney >=0 and t.forcastSignMoney<   100)";
							} else if (Array03[j].equals("'Range2'")) {
								commonSql += " OR (t.forcastSignMoney >=100 and t.forcastSignMoney<   500)";
							} else if (Array03[j].equals("'Range3'")) {
								commonSql += " OR (t.forcastSignMoney >=500 and t.forcastSignMoney<   1000)";
							} else if (Array03[j].equals("'Range4'")) {
								commonSql += " OR (t.forcastSignMoney >=1000 and t.forcastSignMoney<   5000)";
							} else if (Array03[j].equals("'Range5'")) {
								commonSql += " OR (t.forcastSignMoney >=5000)";
							} else {
								throw new Exception("selectCode不能使用"
										+ Array03[j]);
							}
						}
						commonSql += ")";
					} else {
						throw new Exception("selectCode不能使用" + typeName);
					}
				} else if (typeArray[i] == "") {
				} else {
					throw new Exception("selectCode格式错误");
				}
			}
		}
		return commonSql;
	}

	public String getInStr(String str) {
		String inStr = "";
		str = str.replace("'", "");
		String[] tempArray = str.split(",");
		for (int i = 0; i < tempArray.length; i++) {
			inStr += "'" + tempArray[i] + "'";
			if (i != tempArray.length - 1) {
				inStr += ",";
			}
		}
		return inStr;
	}

}
