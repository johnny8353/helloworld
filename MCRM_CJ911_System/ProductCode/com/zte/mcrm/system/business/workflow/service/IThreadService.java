package com.zte.mcrm.system.business.workflow.service;

import java.net.InetAddress;
import java.util.Date;

import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.mcrm.framework.business.framework.service.IBasicService;
import com.zte.mcrm.system.access.workflow.vo.ThreadVO;

public interface IThreadService  extends IBasicService<ThreadVO>{
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
	public void ModifyThread(String threadId,String status,String completionText,boolean ActlEndDtFlag,boolean ActlStartDtFlag);
	
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
	public String InitThread(String className,String desc,String method,String schedStartDt) throws Exception;
	
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
	public String InitRpdPThread(String className,String desc,String status,String method) throws Exception;
	
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
	public String InitRpdSThread(String taskPid,String schedStartDt) throws Exception;
}
