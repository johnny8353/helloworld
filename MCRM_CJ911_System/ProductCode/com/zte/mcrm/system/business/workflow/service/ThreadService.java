package com.zte.mcrm.system.business.workflow.service;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.mcrm.framework.business.framework.service.BasicService;
import com.zte.mcrm.system.access.workflow.dao.IThreadDao;
import com.zte.mcrm.system.access.workflow.vo.ThreadVO;
@Repository
public class ThreadService  extends BasicService<ThreadVO> implements IThreadService{
	protected Log log = LogFactory.getLog(getClass());
	@Autowired
	private IThreadDao threadDao ;
	@Override
	public int queryListCount(Object parameter) {
		// TODO Auto-generated method stub
		return threadDao.queryCount(parameter);
	}

	@Override
	public List<ThreadVO> queryList(Object object) {
		// TODO Auto-generated method stub
		return super.queryList(object);
	}

	@Override
	public ThreadVO query(Object parameter) {
		// TODO Auto-generated method stub
		return super.query(parameter);
	}

	@Override
	public int insert(Object parameter) throws Exception {
		// TODO Auto-generated method stub
		return threadDao.insert(parameter);
	}

	@Override
	public int delete(Object parameter) {
		// TODO Auto-generated method stub
		return super.delete(parameter);
	}

	@Override
	public int modify(Object parameter) throws Exception {
		// TODO Auto-generated method stub
		return threadDao.modify(parameter);
	}

	@Override
	public Map<String, ThreadVO> queryMap(Object parameter, String mapKey) {
		// TODO Auto-generated method stub
		return super.queryMap(parameter, mapKey);
	}

	@Override
	public List<ThreadVO> queryPagnation(Object parameter, int start, int limit) {
		// TODO Auto-generated method stub
		return threadDao.queryPagnation(parameter, start, limit);
	}
	
	/**
	 * 
	 * @Description: TODO 修改线程信息 
	 * @param threadId 线程id
	 * @param status 状态
	 * @param completionText 完成信息
	 * @param ActlEndDtFlag 实际结束
	 * @param ActlStartDtFlag 实际开始
	 * @return void  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-3-25
	 */
	public void ModifyThread(String threadId,String status,String completionText,boolean ActlEndDtFlag,boolean ActlStartDtFlag){
		ThreadVO threadVO = new ThreadVO();
		Date date = new Date();
		threadVO.setRowId(threadId);
		threadVO.setLastUpd(date);
		threadVO.setStatus(status);
		threadVO.setCompletionText(completionText);
		if(ActlStartDtFlag){
			threadVO.setActlStartDt(date);
		}
		if(ActlEndDtFlag){
			threadVO.setActlEndDt(date);
		}
		try {
			modify(threadVO);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description: TODO  初始化 普通工作  线程 信息
	 * @param @param className
	 * @param @param desc
	 * @param @param method
	 * @param @return
	 * @param @throws Exception   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-3-25
	 */
	public String InitThread(String className,String desc,String method,String schedStartDt) throws Exception{
		String ip= InetAddress.getLocalHost().getHostAddress();
		String host= InetAddress.getLocalHost().getCanonicalHostName();
		ThreadVO threadVO = new ThreadVO();
		threadVO.setCreated(new Date());
		threadVO.setLastUpd(new Date());
		threadVO.setDescText(desc);
		threadVO.setClassName(className);
		threadVO.setMethod(method);
		threadVO.setRptFlag("N");
		threadVO.setExecSrvrName(host+"_"+ip);
		threadVO.setStatus("排队");
		threadVO.setCreatedBy("JohnnyHuang 黄福强");
		threadVO.setLastUpdBy("JohnnyHuang 黄福强");
		threadVO.setSubmitDate(new Date());
		threadVO.setSchedStartDt(DateUtil.stringToDate(schedStartDt));
		insert(threadVO);
		return threadVO.getRowId();
	}
	
	/**
	 * 
	 * @Description: TODO 初始化 定时工作 线程 信息
	 * @param @param desc
	 * @param @param method
	 * @param @param status
	 * @param @return
	 * @param @throws Exception   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-3-25
	 */
	public String InitRpdPThread(String className,String desc,String status,String method) throws Exception{
		String ip= InetAddress.getLocalHost().getHostAddress();
		String host= InetAddress.getLocalHost().getCanonicalHostName();
		ThreadVO threadVO = new ThreadVO();
		threadVO.setCreated(new Date());
		threadVO.setLastUpd(new Date());
		threadVO.setDescText(desc);
		threadVO.setClassName(className);
		threadVO.setMethod(method);
		threadVO.setRptFlag("Y");
		threadVO.setExecSrvrName(host+"_"+ip);
		threadVO.setStatus(status);
		threadVO.setCreatedBy("JohnnyHuang 黄福强");
		threadVO.setLastUpdBy("JohnnyHuang 黄福强");
		threadVO.setRptUom("秒");
		threadVO.setSubmitDate(new Date());
		insert(threadVO);
		return threadVO.getRowId();
	}
	
	/**
	 * 
	 * @Description: TODO 初始化 定时工作 重复实例  ，传入pid
	 * @param @param taskPid
	 * @param @param schedStartDt
	 * @param @return
	 * @param @throws Exception   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-3-25
	 */
	public String InitRpdSThread(String taskPid,String schedStartDt) throws Exception {
		String ip= InetAddress.getLocalHost().getHostAddress();
		String host= InetAddress.getLocalHost().getCanonicalHostName();
		ThreadVO threadVO = new ThreadVO();
		threadVO.setCreated(new Date());
		threadVO.setLastUpd(new Date());
		threadVO.setClassName("");
		threadVO.setMethod("");
		threadVO.setRptFlag("Y");
		threadVO.setExecSrvrName(host+"_"+ip);
		threadVO.setStatus("活动");
		threadVO.setCreatedBy("JohnnyHuang 黄福强");
		threadVO.setLastUpdBy("JohnnyHuang 黄福强");
		threadVO.setSubmitDate(new Date());
		threadVO.setSchedStartDt(DateUtil.stringToDate(schedStartDt));
		threadVO.setTaskPid(taskPid);
		insert(threadVO);
		return threadVO.getRowId();
	}
	
}
