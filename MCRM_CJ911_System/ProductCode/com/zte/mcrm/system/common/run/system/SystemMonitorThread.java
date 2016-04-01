package com.zte.mcrm.system.common.run.system;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.siebel.data.SiebelDataBean;
import com.siebel.data.SiebelException;
import com.zte.itp.ssb.framework.common.util.DateUtil;
import com.zte.mcrm.framework.common.util.Env;
import com.zte.mcrm.framework.common.util.SysDataDictionary;
import com.zte.mcrm.framework.ui.framework.ReadFromFile;
import com.zte.mcrm.system.business.siebel.webservice.AccountQueryPageMSO_Output;
import com.zte.mcrm.system.business.siebel.webservice.AccountWSLocator;
import com.zte.mcrm.system.business.workflow.service.IThreadService;
import com.zte.mcrm.system.common.util.ZMailUtil;

/**
 * 类 编 号：
 * 类 名 称：SystemMonitorThread.java
 * 内容摘要：监控 系统 是否可用 
 * 完成日期：2016-3-25
 * 编码作者：JohnnyHuang 黄福强
 */
public class SystemMonitorThread   extends BaseThread{
//	private static SiebelDataBean siebelDataBean = new SiebelDataBean();
	protected Log log = LogFactory.getLog(getClass());
	@Override
	protected void doWakeUp(String tid, String method) {
		log.info("===========SystemMonitorThread begin===========");
		IThreadService iThreadService = (IThreadService) getBean("threadService");
		//修改重复实例 状态为活动
		iThreadService.ModifyThread(tid,"活动","",false,true);
		try {
			if(method.equalsIgnoreCase("MonitorSiebel")){
				MonitorSiebel();
			}
			//修改重复实例 状态为成功
			iThreadService.ModifyThread(tid,"成功","",true,false);
		} catch (Exception e) {
			// TODO: handle exception
			//修改重复实例 状态为错误
			iThreadService.ModifyThread(tid,"错误",e+"_"+e.getMessage(),true,false);
		
		}
		log.info("===========SystemMonitorThread end===========");
	}
	public void MonitorSiebel(){
		try {
			String testUrl = Env.getInstance().getProperty("SIEBEL_WS_URL");
			String testDesc = Env.getInstance().getProperty("SIEBEL_WS_DESC");
			String[] urlArr = testUrl.split(";");
			String[] descArr = testDesc.split(";");
			String fNamePath=Thread.currentThread().getContextClassLoader().getResource("sytemMonitor.html").getFile();
        	String fNameStr=ReadFromFile.readFileByLines(fNamePath);
        	fNameStr=fNameStr.replace("#TEST_T16#","Siebel系统服务器监控结果");
        	fNameStr=fNameStr.replace("#TEST_T10#","环境信息");
        	fNameStr=fNameStr.replace("#TEST_T11#","IP地址");
        	fNameStr=fNameStr.replace("#TEST_T12#","监控结果");
        	boolean flag = false;//发送邮件标志
        	StringBuffer sDetail = new StringBuffer();
			for (int i = 0; i < urlArr.length; i++) {
				String cls="style=\"border-bottom:1px solid #000;";
				if(i%2==0){
					cls+="background-color:#dfffdf;"; 
				}else{
					cls+="background-color:#ecffff;"; 
				}
				String sUrl = urlArr[i];
				String sDesc = descArr[i];
				String sMessage = new SystemMonitorThread().MonitorSiebelWeb(sUrl);
				if(!sMessage.equals("")){
					cls+="color: red;";
					flag = true;
				}else{
					cls+=" color: blue;";
					sMessage="Normal";
				}
				cls+="\"";
				sDetail.append("<tr  align=\"center\"  valign=\"top\""+cls+">")
			  	.append("<td align=\"left\">")
			    .append(""+sDesc)
			    .append("</td>")
			      .append("<td align=\"left\">")
			    .append(""+sUrl)
			    .append("</td>")
			    .append("<td>"+sMessage+"</td>")
			    .append("</tr>");
			}
			fNameStr=fNameStr.replace("#testDetail#",""+sDetail.toString());
			String toMail = "";
			if(flag){//发给项目组
				toMail = Env.getInstance().getProperty("SYSTEM_MONITOR_MAILTO");
			}else{//发给Johnny
				toMail = Env.getInstance().getProperty("SYSTEM_MONITOR_MAILTOHAND");
			}
			String title = "【Siebel服务器监控结果】"+DateUtil.getNowDateTime()+" 服务器告警，请尽快查看原因！";
			String bodyDetail = fNameStr;
			if(!toMail.equals("")){
				ZMailUtil.invokeDPGSendTestMail(toMail,title,bodyDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	public String MonitorSiebelWeb(String wsUrl) throws Exception{
		
		String sMessage = "";
		try {
			AccountQueryPageMSO_Output output = new AccountQueryPageMSO_Output();
			AccountWSLocator accountWS = new AccountWSLocator();
			accountWS.setAccountWSPortEndpointAddress("http://"+wsUrl+":7780/eai_anon_chs/start.swe?SWEExtSource=AnonWebService&SweExtCmd=Execute");
			accountWS.getAccountWSPort().accountQueryPageMSO(null);
		} catch (Exception e) {
			String error = e.getMessage();
			//服务器启动状态
			
			//服务器停止状态
			if(error.indexOf(SysDataDictionary.MSG_SERVER_500)>-1){
				sMessage = "ERROR:"+"siebel服务器无法访问！";
			}
		}
		return sMessage;
	}

	
	public static void main(String[] args) throws SiebelException {
		try {
			Boolean loginFlag = false;
			//测试
//			loginFlag = siebelDataBean.login("siebel://10.5.6.97:2321/SBA_82/htimObjMgr_chs","SADMIN", "SADMIN", "chs");
			//仿真移动
//			loginFlag = siebelDataBean.login("siebel://10.5.7.161:2321/SBA_82/htimObjMgr_chs","SADMIN", "SADMIN", "chs");
			//仿真灰度
//			loginFlag = siebelDataBean.login("siebel://10.3.64.180:2321/SBA_82/htimObjMgr_chs","SADMIN", "SADMIN", "chs");
			//仿真环境
//			loginFlag = siebelDataBean.login("siebel://10.5.6.196:2321/SBA_82/htimObjMgr_chs","SADMIN", "SADMIN", "chs");
			//生产App1 94
//			loginFlag = siebelDataBean.login("siebel://10.30.13.94:2321/SBA_81/htimObjMgr_chs","SADMIN", "sadmin_803873", "chs");
			//生产App2 95
//			loginFlag = siebelDataBean.login("siebel://10.30.13.95:2321/SBA_81/htimObjMgr_chs","SADMIN", "sadmin_803873", "chs");
			//生产App3 123
//			loginFlag = siebelDataBean.login("siebel://10.30.15.123:2321/SBA_82/htimObjMgr_chs","SADMIN", "sadmin_803873", "chs");
			if (loginFlag) {
				System.out.println("login Success");
			} else {
				System.out.println("login Failed");
			}
//			System.out.println("Logoff");
//			siebelDataBean.logoff();
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
		}
	}
}
