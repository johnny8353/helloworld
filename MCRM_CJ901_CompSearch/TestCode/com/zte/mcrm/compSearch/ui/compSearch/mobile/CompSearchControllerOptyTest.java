//package com.zte.mcrm.compSearch.ui.compSearch.mobile;
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
//import com.zte.mcrm.compSearch.business.compSearch.service.ICompSearchService;
//import com.zte.mcrm.framework.model.framework.FBO;
//import com.zte.mcrm.framework.model.framework.PageBO;
//import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
//import com.zte.mcrm.framework.ui.framework.AbstractTestBase;
//import com.zte.mcrm.framework.ui.framework.SysTestConst;
//@RunWith(Parameterized. class )
//public class CompSearchControllerOptyTest extends AbstractTestBase {
//	private ICompSearchService compSearchService;
//	private ILogService logService;
//	private String  param;
//	private String  desc;
//	private final static int Bonus = 1;
//	@Parameters
//	public   static  Collection data()
//	{
//		List<String> msList = new ArrayList<String>();
//		List<String> descList = new ArrayList<String>();
//		String opty1 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,02;quickLevel,01;dataId,1-D63BI;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty2 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,02;quickLevel,02;dataId,1-LT06;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty3 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,02;quickLevel,03;dataId,1-LT0S;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty4 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,04;quickLevel,01;dataId,70;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty5 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,04;quickLevel,02;dataId,403;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty6 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,03;quickLevel,01;dataId,1-POMDH;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty7 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,01;quickLevel,01;dataId,1-I6S3;selectCode,;lstupd,2016-11-11 11:11:11;orderby,ObjLevelorMeney","") ;
//		String opty8 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,01;quickLevel,02;dataId,1-IP78;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty9 = getCompSearchMS("6011000000", "speSearchType,03;searchType,02;str,;quickType,01;quickLevel,03;dataId,1-JENM;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		
//		String opty10 = getCompSearchMS("T6011000001", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty11 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty12 = getCompSearchMS("T6011000003", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty13 = getCompSearchMS("T6011000004", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty14 = getCompSearchMS("T6011000002", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty15 = getCompSearchMS("T6011000007", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty16 = getCompSearchMS("T6011000006", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty17 = getCompSearchMS("T6011000005", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty18 = getCompSearchMS("T6011000008", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		
//		String opty19 = getCompSearchMS("T6011000009", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty20 = getCompSearchMS("T6011000010", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty21 = getCompSearchMS("T6011000011", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty22 = getCompSearchMS("T6011000012", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty23 = getCompSearchMS("T6011000013", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty24 = getCompSearchMS("T6011000014", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty25 = getCompSearchMS("T6011000015", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		
//		String opty26 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String opty27 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0301':'5,10';") ;
//		String opty28 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0302':'Draft,Closed,Evaluating';") ;
//		String opty29 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0303':'Range1,Range3';") ;
//		String opty30 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0301':'5,10';'0302':'Draft,Closed,Evaluating';") ;
//		String opty31 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0301':'5,10';'0303':'Range1,Range3';") ;
//		String opty32 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0302':'Draft,Closed,Evaluating';'0303':'Range1,Range3';") ;
//		String opty33 = getCompSearchMS("6011000000", "speSearchType,03;searchType,01;str,福强用例专用商机;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,forcastSignMoney","'0301':'5,10';'0302':'Draft,Closed,Evaluating';'0303':'Range1,Range3';") ;
//		
//		
//		String optyDesc1 = "综合查询-商机-快捷查询-产品-体系结构";
//		String optyDesc2 = "综合查询-商机-快捷查询-产品-产品线";
//		String optyDesc3 = "综合查询-商机-快捷查询-产品-产品大类";
//		String optyDesc4 = "综合查询-商机-快捷查询-行业-行业值";
//		String optyDesc5 = "综合查询-商机-快捷查询-行业-子行业";
//		String optyDesc6 = "综合查询-商机-快捷查询-MTO";
//		String optyDesc7 = "综合查询-商机-快捷查询-营销-事业部";
//		String optyDesc8 = "综合查询-商机-快捷查询-营销-片区";
//		String optyDesc9 = "综合查询-商机-快捷查询-营销-代表处";
//		String optyDesc10 = "综合查询-商机-关键字查询-职位维度";
//		String optyDesc11 = "综合查询-商机-关键字查询-组织维度";
//		String optyDesc12 = "综合查询-商机-关键字查询-MTO维度";
//		String optyDesc13 = "综合查询-商机-关键字查询-行业维度";
//		String optyDesc14 = "综合查询-商机-关键字查询-产品维度";
//		String optyDesc15 = "综合查询-商机-关键字查询-MTO、行业维度";
//		String optyDesc16 = "综合查询-商机-关键字查询-产品、行业维度";
//		String optyDesc17 = "综合查询-商机-关键字查询-产品、MTO维度";
//		String optyDesc18 = "综合查询-商机-关键字查询-MTO、产品、行业维度";
//		String optyDesc19 = "综合查询-商机-关键字查询-服务商机总监、副国代、服务查看只看服务商机";
//		String optyDesc20 = "综合查询-商机-关键字查询-只查看运营商的服务商机";
//		String optyDesc21 = "综合查询-商机-关键字查询-只查看政企网的服务商机";
//		String optyDesc22 = "综合查询-商机-关键字查询-只查看政企网商机";
//		String optyDesc23 = "综合查询-商机-关键字查询-只查看运营商商机";
//		String optyDesc24 = "综合查询-商机-关键字查询-产品维度、只查看运营商的服务商机";
//		String optyDesc25 = "综合查询-商机-关键字查询-行业维度、只查看运营商商机";
//		String optyDesc26 = "综合查询-商机-关键字查询";
//		String optyDesc27 = "综合查询-商机-关键字查询-筛选-商机级别";
//		String optyDesc28 = "综合查询-商机-关键字查询-筛选-商机状态";
//		String optyDesc29 = "综合查询-商机-关键字查询-筛选-商机金额";
//		String optyDesc30 = "综合查询-商机-关键字查询-筛选-商机级别、商机状态";
//		String optyDesc31 = "综合查询-商机-关键字查询-筛选-商机级别、商机金额";
//		String optyDesc32 = "综合查询-商机-关键字查询-筛选-商机状态、商机金额";
//		String optyDesc33 = "综合查询-商机-关键字查询-筛选-商机级别、商机状态、商机金额";
//
//		
//		msList.add(opty1);
//		msList.add(opty2);
//		msList.add(opty3);
//		msList.add(opty4);
//		msList.add(opty5);
//		msList.add(opty6);
//		msList.add(opty7);
//		msList.add(opty8);
//		msList.add(opty9);
//		msList.add(opty10);
//		msList.add(opty11);
//		msList.add(opty12);
//		msList.add(opty13);
//		msList.add(opty14);
//		msList.add(opty15);
//		msList.add(opty16);
//		msList.add(opty17);
//		msList.add(opty18);
//		msList.add(opty19);
//		msList.add(opty20);
//		msList.add(opty21);
//		msList.add(opty22);
//		msList.add(opty23);
//		msList.add(opty24);
//		msList.add(opty25);
//		msList.add(opty26);
//		msList.add(opty27);
//		msList.add(opty28);
//		msList.add(opty29);
//		msList.add(opty30);
//		msList.add(opty31);
//		msList.add(opty32);
//		msList.add(opty33);
//
//		descList.add(optyDesc1);
//		descList.add(optyDesc2);
//		descList.add(optyDesc3);
//		descList.add(optyDesc4);
//		descList.add(optyDesc5);
//		descList.add(optyDesc6);
//		descList.add(optyDesc7);
//		descList.add(optyDesc8);
//		descList.add(optyDesc9);
//		descList.add(optyDesc10);
//		descList.add(optyDesc11);
//		descList.add(optyDesc12);
//		descList.add(optyDesc13);
//		descList.add(optyDesc14);
//		descList.add(optyDesc15);
//		descList.add(optyDesc16);
//		descList.add(optyDesc17);
//		descList.add(optyDesc18);
//		descList.add(optyDesc19);
//		descList.add(optyDesc20);
//		descList.add(optyDesc21);
//		descList.add(optyDesc22);
//		descList.add(optyDesc23);
//		descList.add(optyDesc24);
//		descList.add(optyDesc25);
//		descList.add(optyDesc26);
//		descList.add(optyDesc27);
//		descList.add(optyDesc28);
//		descList.add(optyDesc29);
//		descList.add(optyDesc30);
//		descList.add(optyDesc31);
//		descList.add(optyDesc32);
//		descList.add(optyDesc33);
//
//
//		Object[][] paramObjects = new Object[descList.size()*Bonus][2];
//		for (int i = 0; i < msList.size()*Bonus; i++) {
//			paramObjects[i][0]=msList.get(i%36);
//			paramObjects[i][1]=descList.get(i%36);
//		}
//		return  Arrays.asList( paramObjects );
//	}
//	// 构造函数，对变量进行初始化
//	public  CompSearchControllerOptyTest( String  param,  String  desc)
//	{
//		this.param  =  param;
//		this.desc  =  desc;
//	}
//	@Before
//	public void setUp() throws Exception {
//		compSearchService = (ICompSearchService)ctx.getBean("compSearchService");
//		logService = (ILogService)ctx.getBean("logService");
//	}
//
//	@Test//(timeout=SysTestConst.TIME_SPEC_FUNC)
//	public void testCompSearch() {
//		CompSearchController compSearchController = new CompSearchController();
//		compSearchController.setCompSearchService(compSearchService);
//		compSearchController.setLogService(logService);
//		long time = System.currentTimeMillis();
//		String strJson = compSearchController.doCustom("CompSearch",param);
//		long time2 = System.currentTimeMillis();
//		double ct = (time2-time)/1000.0;
//		assertTrue(desc+"-功能测试-黄福强6011000052"+param+" 输出："+strJson+SysTestConst.TEST_SUFFIX, strJson.indexOf("\"S\":\"true\"")>0);
//		assertTrue(desc+"-性能测试-黄福强6011000052"+param+SysTestConst.TEST_SUFFIX, ct <= SysTestConst.TIME_CS_FUNC);
//	}
//	
//	public static String getCompSearchMS(String U,String KV,String selectCode){
//		SiebelBaseBO baseBO = new SiebelBaseBO();
//		baseBO.setC("CompSearch");
//		baseBO.setL("2052");
//		PageBO page = new PageBO();
//		page.setPSIZE(15);
//		page.setPNO(1);
//		baseBO.setP(page);
//		baseBO.setU(U);
//		String[] array = KV.split(";");
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
//		FBO fbo = new FBO();
//		fbo.setK("selectCode");
//		fbo.setV(selectCode);
//		fbos.add(fbo);
//		baseBO.setF(fbos);
//		String ms = GSONUtil.getGsonStr(baseBO);
//		return ms;
//	}
//}
