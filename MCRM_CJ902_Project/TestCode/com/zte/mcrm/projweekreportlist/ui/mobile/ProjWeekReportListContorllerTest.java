//package com.zte.mcrm.projweekreportlist.ui.mobile;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//
//import com.zte.itp.ssb.framework.common.util.GSONUtil;
//import com.zte.mcrm.basedata.business.log.service.ILogService;
//import com.zte.mcrm.framework.common.util.McrmDesSecretUtil;
//import com.zte.mcrm.framework.model.framework.FBO;
//import com.zte.mcrm.framework.model.framework.PageBO;
//import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
//import com.zte.mcrm.framework.ui.framework.AbstractTestBase;
//import com.zte.mcrm.framework.ui.framework.SysTestConst;
//import com.zte.mcrm.project.business.projweekreportlist.service.IProjWeekReportListService;
//import com.zte.mcrm.project.ui.mobile.projweekreportlist.ProjWeekReportListContorller;
//
///**   
// * 类 编 号：
// * 类 名 称：ProjWeekReportListContorllerTest.java
// * 内容摘要：
// * 完成日期：2016-1-22  
// * 编码作者：QunLi
// */
//@RunWith(Parameterized. class )
//public class ProjWeekReportListContorllerTest extends AbstractTestBase{
//	private IProjWeekReportListService projWeekReportListService;
//	private ILogService logService;
//	private String  param;
//	private String  desc;
//	private final static int Bonus = 1;
//	
//	@Parameters
//	public static  Collection data(){
//		List<String> msList = new ArrayList<String>();
//		List<String> descList = new ArrayList<String>();
//		
//		String report1 = getCompSearchMS("10060009", "prjId,1-16GZ1Z;lstUpd,") ;//第一次,不计入总测试
//		
//		String report2 = getCompSearchMS("60110000567", "prjId,1-16GZ1Z;lstUpd,") ;//周报查看人员  - 2条
//		String report3 = getCompSearchMS("10010346", "prjId,1-16GZ1Z;lstUpd,") ;//团队成员
//		String report4 = getCompSearchMS("10000680", "prjId,1-16GZ1Z;lstUpd,") ;//领导
//		String report5 = getCompSearchMS("10060009", "prjId,1-16GZ1Z;lstUpd,") ;//外围授权人员
//		String report6 = getCompSearchMS("6011000056", "prjId,1-16GZ1Z;lstUpd,") ;//其他无权限人员-路人甲
//		 
//		String report7 = getCompSearchMS("60110000567", "prjId,1-16GZ1Z;lstUpd,2016-2-2 00:00:00") ;//周报查看人员  - 2条
//		String report8 = getCompSearchMS("10010346", "prjId,1-16GZ1Z;lstUpd,2016-2-2 00:00:00") ;//团队成员
//		String report9 = getCompSearchMS("10000680", "prjId,1-16GZ1Z;lstUpd,2016-2-2 00:00:00") ;//领导
//		String report10 = getCompSearchMS("10060009", "prjId,1-16GZ1Z;lstUpd,2016-2-2 00:00:00") ;//外围授权人员
//		String report11 = getCompSearchMS("6011000056", "prjId,1-16GZ1Z;lstUpd,2016-2-2 00:00:00") ;//其他无权限人员-路人甲
//		
//		
//		msList.add(report1);
//		msList.add(report2);
//		msList.add(report3);
//		msList.add(report4);
//		msList.add(report5);
//		msList.add(report6);
//		
//		msList.add(report7);
//		msList.add(report8);
//		msList.add(report9);
//		msList.add(report10);
//		msList.add(report11);
//		
//		
//		String desc1 = "周报列表查询-周报查看人员";
//		
//		String desc2 = "周报列表查询-周报查看人员-无最后更新时间";
//		String desc3 = "周报列表查询-团队成员-无最后更新时间";
//		String desc4 = "周报列表查询-领导-无最后更新时间";
//		String desc5 = "周报列表查询-外围授权人员-无最后更新时间";
//		String desc6 = "周报列表查询-其他无权限人员-路人甲-无最后更新时间";
//		
//		String desc7 = "周报列表查询-周报查看人员-有最后更新时间";
//		String desc8 = "周报列表查询-团队成员-有最后更新时间";
//		String desc9 = "周报列表查询-领导-有最后更新时间";
//		String desc10 = "周报列表查询-外围授权人员-有最后更新时间";
//		String desc11 = "周报列表查询-其他无权限人员-路人甲-有最后更新时间";
//		
//		descList.add(desc1);
//		descList.add(desc2);
//		descList.add(desc3);
//		descList.add(desc4);
//		descList.add(desc5);
//		descList.add(desc6);
//		descList.add(desc7);
//		descList.add(desc8);
//		descList.add(desc9);
//		descList.add(desc10);
//		descList.add(desc11);
//		
//		Object[][] paramObjects = new Object[descList.size()*Bonus][2];
//		for (int i = 0; i < msList.size()*Bonus; i++) {
//			paramObjects[i][0]=msList.get(i%11);
//			paramObjects[i][1]=descList.get(i%11);
//		}
//		return  Arrays.asList(paramObjects);
//	}
//	// 构造函数，对变量进行初始化
//	public  ProjWeekReportListContorllerTest( String  param,  String  desc)
//	{
//		this.param  =  param;
//		this.desc  =  desc;
//	}
//	@Before
//	public void setUp() throws Exception {
//		projWeekReportListService = (IProjWeekReportListService) ctx.getBean("projWeekReportListService");
//		logService = (ILogService)ctx.getBean("logService");
//	}
//	
//	@Test
//	public void testProjWeekReportList(){
//		ProjWeekReportListContorller controller = new ProjWeekReportListContorller();
//		controller.setReportService(projWeekReportListService);
//		controller.setLogService(logService);
//		long time = System.currentTimeMillis();
//		String strJson = null;
//		for (int i = 0; i < 100; i++) {
//			strJson = controller.doCustom("projWeekReportList",param);	
//		}
//		
//		long time2 = System.currentTimeMillis();
//		double ct = (time2-time)/1000.0;
//		
//		assertTrue(desc+"功能测试-李群6011000056"+param+" 输出："+strJson+SysTestConst.TEST_SUFFIX, strJson.indexOf("\"S\":\"true\"")>0);
//		assertTrue(desc+"-性能测试-李群6011000056"+param+SysTestConst.TEST_SUFFIX, ct <= SysTestConst.TIME_CS_FUNC);
//	}
//	
//	public static String getCompSearchMS(String U,String KV){
//		SiebelBaseBO baseBO = new SiebelBaseBO();
//		baseBO.setC("GetProjectReportList");
//		baseBO.setL("2052");
//		PageBO page = new PageBO();
//		page.setPSIZE(15);
//		page.setPNO(1);
//		baseBO.setP(page);
//		baseBO.setU(U);
//		
//		String[] array = KV.split(";");
//		
//		List<FBO> fbos = new ArrayList<FBO>();
//		for (int i = 0; i < array.length; i++) {
//			String[] mykv = array[i].split(",");
//			FBO fbo = new FBO();
//			fbo.setK(mykv[0]);
//			if(mykv.length>1)
//			{
//				fbo.setV(mykv[1]);
//			}else{
//				fbo.setV("");
//			}
//			fbos.add(fbo);
//		}
//		
//		FBO fbo = new FBO();
//		fbos.add(fbo);
//		baseBO.setF(fbos);
//		String ms = GSONUtil.getGsonStr(baseBO);
//		return ms;
//	}
//	
//	
//}
//
