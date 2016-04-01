package com.zte.mcrm.system.ui.workflow.web;


import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.zte.itp.ssb.framework.common.util.StringUtil;
import com.zte.mcrm.framework.common.util.JsonUtils;
import com.zte.mcrm.framework.common.util.SysDataDictionary;
import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.framework.ui.framework.controller.BaseController;
import com.zte.mcrm.system.access.workflow.vo.ThreadExampleVO;
import com.zte.mcrm.system.access.workflow.vo.ThreadVO;
import com.zte.mcrm.system.business.workflow.service.IThreadService;
import com.zte.mcrm.system.common.run.system.BaseThread;
import com.zte.mcrm.system.common.run.system.StartupServlet;
import com.zte.mcrm.system.model.workflow.ThreadBO;

/**
 * 类 编 号：SCRM_Controller_001
 * 类 名 称：WorkFlowController
 * 内容摘要：综合查询 控制层 
 * 完成日期：2016-12-27 
 * 编码作者：JohnnyHuang
 */
@Controller("workflow")
public class WorkFlowController  extends BaseController{
	protected Log log = LogFactory.getLog(getClass());
	public static Map<String, Object> threadLists;
	@Autowired
	private IThreadService iThreadService;
	
	public WorkFlowController() {
	}

//	public String doPcCustom1(HttpServletRequest request) {
//		
//		log.info(SiebelBaseBO.LOG_PREFIX + "请求参数" + request);
//		log.info(SiebelBaseBO.LOG_PREFIX + "请求时间" + DateUtil.getNowDateTime());
//		if(threadLists==null){
//			threadLists = new HashMap<String, Object>();
//		}
//		String message = "";
//		WorkFlowBO boBean1 = new WorkFlowBO();
//		ThreadBO boBean = new ThreadBO();
//		Map<String, Object> jsonMap = new HashMap<String, Object>();
//		try {
//			if(StringUtil.retBlankIfNull(getMethod()).equalsIgnoreCase("getPage")){
//				Vector<SchedulerObjectVO> results = new Vector<SchedulerObjectVO>();
//				for (int i = getStart(); i < getStart()+getLimit()&&i<StartupServlet.getSchedulers().size(); i++) {
////					results.add(WorkFlowBO.getSchedulers(StartupServlet.getSchedulers()).get(i));
//				}
//				// 获取返回对象Map
//				boBean.getP().setT(String.valueOf(StartupServlet.getSchedulers().size()));
//				jsonMap.put(SiebelBaseBO.DATA_OBJ, results);
//				jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
//			}else if ("getPageInfo".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				HttpSession session = request.getSession();
//				//相关操作后
////				session.setAttribute("threadShowField", boBean.getShowField());
////				session.setAttribute("threadShowLabel", boBean.getShowLabel());
////				session.setAttribute("threadShowFlag", boBean.getShowFlag());
////				session.setAttribute("threadShowJson", boBean.getShowJson());
//				session.setAttribute("threadShowTitle", "线程管理界面");
//				jsonMap.put(SiebelBaseBO.IS_SUCCESS, "true");
//			}else if ("getThreadPage".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				ThreadExampleVO parameter = new ThreadExampleVO();
//				parameter.setOrderByClause("created desc");
//				parameter.or().andClassNameIsNotNull();
//				List<ThreadVO> results = iThreadService.queryPagnation(parameter, getStart(), getLimit());
//				int totalCount = iThreadService.queryListCount(parameter);
//				boBean.setThreadVOs(results);
//				boBean.getP().setT(String.valueOf(totalCount));
//				jsonMap.put(SiebelBaseBO.DATA_OBJ, results);
//				jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
//			}else if ("getThreadRpdPage".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				ThreadVO vo = new ThreadVO();
//				System.out.println(getObj());
//				if(!StringUtil.checkStrIsEmpty(getObj())){
//					vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
//				}
//				ThreadExampleVO parameter = new ThreadExampleVO();
//				parameter.or().andTaskPidEqualTo(vo.getRowId());
//				parameter.setOrderByClause("created desc");
//				List<ThreadVO> results = iThreadService.queryPagnation(parameter, getStart(), getLimit());
//				int totalCount = iThreadService.queryListCount(parameter);
//				boBean.setThreadVOs(results);
//				boBean.getP().setT(String.valueOf(totalCount));
//				
//				jsonMap.put(SiebelBaseBO.DATA_OBJ, results);
//				jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
//			}else if ("testcase2Hand".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				String className = "com.zte.mcrm.system.common.run.system.TestCaseThread";
//				String id = iThreadService.InitThread(className, "测试用例结果邮件发送2Hand","testcase2Hand", "");
//				setRowId(id);
//				Class threadClass = Class.forName(className);
//				BaseThread bst = (BaseThread) threadClass.newInstance();
//				bst.setSchedule(id, "testcase2Hand");
//				bst.start();
//				boBean.setS(SiebelBaseBO.SUCCESS);
//				boBean.setErrorMsg("提交测试用例成功！");
//				jsonMap = boBean.getOutputMap();
//			}
//			else if ("sendMail2All".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				String className = "com.zte.mcrm.system.common.run.system.TestCaseThread";
//				String id = iThreadService.InitThread(className, "测试用例结果邮件发送2All","sendMail2All", "");
//				setRowId(id);
//				Class threadClass = Class.forName(className);
//				BaseThread bst = (BaseThread) threadClass.newInstance();
//				bst.setSchedule(id, "sendMail2All");
//				bst.start();
//				boBean.setS(SiebelBaseBO.SUCCESS);
//				boBean.setErrorMsg("提交测试用例成功！");
//				jsonMap = boBean.getOutputMap();
//			}else if ("stopThread".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				ThreadVO vo = new ThreadVO();
//				vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
//				setRowId(vo.getRowId());
//				StartupServlet.getSchdulerObject(vo.getRowId()).getThread().notifyStop();
//				iThreadService.ModifyThread(vo.getRowId(), SysDataDictionary.THREAD_STATUS_CANCEL, "手动取消", false, true);
//				boBean.setS(SiebelBaseBO.SUCCESS);
//				boBean.setErrorMsg("成功！");
//				jsonMap = boBean.getOutputMap();
//			}else if ("suspendThread".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				ThreadVO vo = new ThreadVO();
//				vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
//				if(!vo.getStatus().equalsIgnoreCase(SysDataDictionary.THREAD_STATUS_ACTIVE)){
//					boBean.setS(SiebelBaseBO.FAIL);
//					boBean.setErrorMsg("只有状态为"+SysDataDictionary.THREAD_STATUS_ACTIVE+"才能执行该操作");
//					jsonMap = boBean.getOutputMap();
//					return getGsonStr(jsonMap);
//				}
//				setRowId(vo.getRowId());
//				StartupServlet.getSchdulerObject(vo.getRowId()).getThread().suspendSchedule();
//				iThreadService.ModifyThread(vo.getRowId(), SysDataDictionary.THREAD_STATUS_PENDING, "手动挂起", false, false);
//				boBean.setS(SiebelBaseBO.SUCCESS);
//				boBean.setErrorMsg("成功！");
//				jsonMap = boBean.getOutputMap();
//			}else if ("resumeThread".equalsIgnoreCase(StringUtil.retBlankIfNull(getMethod()))) {
//				ThreadVO vo = new ThreadVO();
//				vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
//				if(!vo.getStatus().equalsIgnoreCase(SysDataDictionary.THREAD_STATUS_PENDING)){
//					boBean.setS(SiebelBaseBO.FAIL);
//					boBean.setErrorMsg("只有状态为"+SysDataDictionary.THREAD_STATUS_PENDING+"才能执行该操作");
//					jsonMap = boBean.getOutputMap();
//					return getGsonStr(jsonMap);
//				}
//				
//				setRowId(vo.getRowId());
//				StartupServlet.getSchdulerObject(vo.getRowId()).getThread().resumeSchedule();
//				iThreadService.ModifyThread(vo.getRowId(), SysDataDictionary.THREAD_STATUS_ACTIVE, "手动恢复", false, false);
//				boBean.setS(SiebelBaseBO.SUCCESS);
//				boBean.setErrorMsg("成功！");
//				jsonMap = boBean.getOutputMap();
//			}else{
//				jsonMap = boBean.getOutputNoCommandNameMap();
//			}
//			message = getGsonStr(jsonMap);
//		} catch (Exception ex) {//ClassNotFoundException
//			boBean.setErrorCode( SiebelBaseBO.FAIL);
//			boBean.setErrorMsg(ex.getMessage());
//			ex.printStackTrace();
//			iThreadService.ModifyThread(getRowId(), SysDataDictionary.THREAD_STATUS_ERROR, FormatException(ex), false, true);
//			return exception(CompSearchSiebelException.generateSiebelException("","",SiebelExceptionComm.ERROR_LAYER_CONTROLER, this.getClass().getName(), ex),GSONUtil.getGsonStr(boBean));
//		}finally{
//			//记录日志信息到数据库
//		}
//		return message;
//	}
	
	
	
	public Map<String, Object> resumeThread() throws Exception{
		// 返回值
		ThreadBO boBean = new ThreadBO();
		Map<String, Object> jsonMap = boBean.getOutputMap();
		ThreadVO vo = new ThreadVO();
		vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
		if(!vo.getStatus().equalsIgnoreCase(SysDataDictionary.THREAD_STATUS_PENDING)){
			boBean.setS(SiebelBaseBO.FAIL);
			boBean.setErrorMsg("只有状态为"+SysDataDictionary.THREAD_STATUS_PENDING+"才能执行该操作");
			jsonMap = boBean.getOutputMap();
			return jsonMap;
		}
		
		setRowId(vo.getRowId());
		StartupServlet.getSchdulerObject(vo.getRowId()).getThread().resumeSchedule();
		iThreadService.ModifyThread(vo.getRowId(), SysDataDictionary.THREAD_STATUS_ACTIVE, "手动恢复", false, false);
		return jsonMap;
	}
	public Map<String, Object> suspendThread() throws Exception{
		// 返回值
		ThreadBO boBean = new ThreadBO();
		Map<String, Object> jsonMap = boBean.getOutputMap();
		ThreadVO vo = new ThreadVO();
		vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
		if(!vo.getStatus().equalsIgnoreCase(SysDataDictionary.THREAD_STATUS_ACTIVE)){
			boBean.setS(SiebelBaseBO.FAIL);
			boBean.setErrorMsg("只有状态为"+SysDataDictionary.THREAD_STATUS_ACTIVE+"才能执行该操作");
			jsonMap = boBean.getOutputMap();
			return jsonMap;
		}
		setRowId(vo.getRowId());
		StartupServlet.getSchdulerObject(vo.getRowId()).getThread().suspendSchedule();
		iThreadService.ModifyThread(vo.getRowId(), SysDataDictionary.THREAD_STATUS_PENDING, "手动挂起", false, false);
		return jsonMap;
	}
	
	public Map<String, Object> stopThread() throws Exception{
		// 返回值
		ThreadBO boBean = new ThreadBO();
		Map<String, Object> jsonMap = boBean.getOutputMap();
		ThreadVO vo = new ThreadVO();
		vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
		setRowId(vo.getRowId());
		StartupServlet.getSchdulerObject(vo.getRowId()).getThread().notifyStop();
		iThreadService.ModifyThread(vo.getRowId(), SysDataDictionary.THREAD_STATUS_CANCEL, "手动取消", false, true);
		return jsonMap;
	}
	public Map<String, Object> sendMail2All() throws Exception{
		// 返回值
		ThreadBO boBean = new ThreadBO();
		Map<String, Object> jsonMap = boBean.getOutputMap();
		String className = "com.zte.mcrm.system.common.run.system.TestCaseThread";
		String id = iThreadService.InitThread(className, "测试用例结果邮件发送2All","sendMail2All", "");
		setRowId(id);
		Class threadClass = Class.forName(className);
		BaseThread bst = (BaseThread) threadClass.newInstance();
		bst.setSchedule(id, "sendMail2All");
		bst.start();
		return jsonMap;
	}
	
	public Map<String, Object> testcase2Hand() throws Exception{
		// 返回值
		ThreadBO boBean = new ThreadBO();
		Map<String, Object> jsonMap = boBean.getOutputMap();
		String className = "com.zte.mcrm.system.common.run.system.TestCaseThread";
		String id = iThreadService.InitThread(className, "测试用例结果邮件发送2Hand","testcase2Hand", "");
		setRowId(id);
		Class threadClass = Class.forName(className);
		BaseThread bst = (BaseThread) threadClass.newInstance();
		bst.setSchedule(id, "testcase2Hand");
		bst.start();
		return jsonMap;
	}
	
	public Map<String, Object> getThreadRpdPage(){
		// 返回值
		ThreadBO boBean = new ThreadBO();
		Map<String, Object> jsonMap = boBean.getOutputMap();
		ThreadVO vo = new ThreadVO();
//System.out.println(getObj());
		if(!StringUtil.checkStrIsEmpty(getObj())){
			vo = (ThreadVO) JsonUtils.getDTO(getObj(), ThreadVO.class);
		}
		ThreadExampleVO parameter = new ThreadExampleVO();
		parameter.or().andTaskPidEqualTo(vo.getRowId());
		parameter.setOrderByClause("created desc");
		List<ThreadVO> results = iThreadService.queryPagnation(parameter, getStart(), getLimit());
		int totalCount = iThreadService.queryListCount(parameter);
		boBean.setThreadVOs(results);
		boBean.getP().setT(String.valueOf(totalCount));
		
		jsonMap.put(SiebelBaseBO.DATA_OBJ, results);
		jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
		return jsonMap;
	}
	
	public Map<String, Object> getThreadPage(){
		// 返回值
		ThreadBO boBean = new ThreadBO();
		Map<String, Object> jsonMap = boBean.getOutputMap();
		ThreadExampleVO parameter = new ThreadExampleVO();
		parameter.setOrderByClause("created desc");
		if(!getSort().equals("")){
			parameter.setOrderByClause(boBean.getColumnNameByField(getSort())+" "+getDir());
		}
		parameter.or().andClassNameIsNotNull();
		List<ThreadVO> results = iThreadService.queryPagnation(parameter, getStart(), getLimit());
		int totalCount = iThreadService.queryListCount(parameter);
		boBean.setThreadVOs(results);
		boBean.getP().setT(String.valueOf(totalCount));
		jsonMap.put(SiebelBaseBO.DATA_OBJ, results);
		jsonMap.put(SiebelBaseBO.PAGE_OBJ, boBean.getP());
		return jsonMap;
	}
	
	
}
