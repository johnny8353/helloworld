package com.zte.mcrm.system.common.run.system;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zte.mcrm.framework.ui.framework.AllTest;
import com.zte.mcrm.system.business.workflow.service.IThreadService;
/**
 * 
 * 类 编 号：
 * 类 名 称：TestCaseThread.java
 * 内容摘要：XXX 
 * 完成日期：2016-3-23
 * 编码作者：JohnnyHuang
 */
public class TestCaseThread  extends BaseThread{
	protected Log log = LogFactory.getLog(getClass());
	@Override
	protected void doWakeUp(String tid,String method) {
		log.info("===========TestCaseThread begin===========");
		IThreadService iThreadService = (IThreadService) getBean("threadService");
		//修改重复实例 状态为活动
		iThreadService.ModifyThread(tid,"活动","",false,true);
		try {
			System.out.println("ZTE===========================TestCaseThread");
			if(method.equalsIgnoreCase("SendMailFull")){
				AllTest alltest = new AllTest(false);//flag true发送给所有人，为false发送给项目组
				alltest.testSmartSales();
				AllTest alltest2 = new AllTest(true);//flag true发送给所有人，为false发送给项目组
				alltest2.testSmartSales();
			}else if(method.equalsIgnoreCase("testcase2Hand")){
				AllTest alltest = new AllTest(false);//flag true发送给所有人，为false发送给项目组
				alltest.testSmartSales();
			}else if(method.equalsIgnoreCase("sendMail2All")){
				AllTest alltest = new AllTest(true);//flag true发送给所有人，为false发送给项目组
				alltest.generateReport();
			}else{
				throw new Exception("无法找到方法："+method);
			}
			//修改重复实例 状态为成功
			iThreadService.ModifyThread(tid,"成功","",true,false);
		} catch (Exception e) {
			// TODO: handle exception
			//修改重复实例 状态为错误
			iThreadService.ModifyThread(tid,"错误",e+"_"+e.getMessage(),true,false);
		}
		log.info("===========TestCaseThread end===========");
		
	}
	
	
}
