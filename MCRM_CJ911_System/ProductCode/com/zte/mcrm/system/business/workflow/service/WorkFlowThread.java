package com.zte.mcrm.system.business.workflow.service;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.ui.framework.AllTest;
import com.zte.mcrm.system.access.workflow.vo.ThreadVO;
public class WorkFlowThread extends Thread{
	protected Log log = LogFactory.getLog(getClass());
	private IThreadService iThreadService;
	
	private String threadId;
	private boolean flag;
	private String type;
	
	 public WorkFlowThread() {
		super();
	}

	public WorkFlowThread(String type,String threadId,boolean flag,IThreadService iThreadService) {
		this.type = type; 
		this.threadId = threadId;
		 this.iThreadService = iThreadService;
		 this.flag = flag;
		// TODO Auto-generated constructor stub
	}

	synchronized public void run(){
		try {
			if(type.equalsIgnoreCase("testcase2Hand"))
			{
				ModifyThread(threadId,"活动","",false,true);
				AllTest alltest = new AllTest(flag);//flag true发送给所有人，为false发送给项目组
				alltest.testSmartSales();
			}else if(type.equalsIgnoreCase("sendMail2All"))
			{
				ModifyThread(threadId,"活动","",false,true);
				AllTest alltest = new AllTest(flag);//flag true发送给所有人，为false发送给项目组
				alltest.generateReport();
			}
//			for(int i=0;i<1000000;i++)
//			{
//				System.out.println(i);
//				if(i==999999){
//					throw new Exception("dd");
//				}
//				 
//			}
			ModifyThread(threadId,"成功","",true,false);
			
		} catch (Exception e) {
			e.printStackTrace();
			ModifyThread(threadId,"错误",e+e.getMessage(),true,false);
		}
    }
	
	/**
	 * 
	 * @param threadId 线程id
	 * @param status 状态
	 * @param completionText 完成信息
	 * @param ActlEndDtFlag 实际结束
	 * @param ActlStartDtFlag 实际开始
	 */
	private void ModifyThread(String threadId,String status,String completionText,boolean ActlEndDtFlag,boolean ActlStartDtFlag){
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
			iThreadService.modify(threadVO);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
