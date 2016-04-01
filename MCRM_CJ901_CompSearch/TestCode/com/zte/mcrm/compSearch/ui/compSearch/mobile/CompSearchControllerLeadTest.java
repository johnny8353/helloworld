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
//public class CompSearchControllerLeadTest extends AbstractTestBase {
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
//		String lead1 = getCompSearchMS("6011000000", "speSearchType,02;searchType,02;str,;quickType,04;quickLevel,01;dataId,70;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String lead2 = getCompSearchMS("6011000000", "speSearchType,02;searchType,02;str,;quickType,04;quickLevel,02;dataId,403;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String lead3 = getCompSearchMS("6011000000", "speSearchType,02;searchType,02;str,;quickType,03;quickLevel,01;dataId,1-POMDH;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String lead4 = getCompSearchMS("6011000000", "speSearchType,02;searchType,02;str,;quickType,01;quickLevel,01;dataId,1-I6S3;selectCode,;lstupd,2016-11-11 11:11:11;orderby,ObjLevelorMeney","") ;
//		String lead5 = getCompSearchMS("6011000000", "speSearchType,02;searchType,02;str,;quickType,01;quickLevel,02;dataId,1-IP78;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String lead6 = getCompSearchMS("6011000000", "speSearchType,02;searchType,02;str,;quickType,01;quickLevel,03;dataId,1-JENM;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		
//		String lead7 = getCompSearchMS("T6011000001", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String lead8 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		
//		String lead9 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String lead10 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0201':'System,System Service';") ;
//		String lead11 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0202':'Draft,Closed,Refused';") ;
//		String lead12 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0203':'Range1,Range3';") ;
//		String lead13 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0201':'System,System Service';'0202':'Draft,Closed,Refused';") ;
//		String lead14 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0201':'System,System Service';'0203':'Range1,Range3';") ;
//		String lead15 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0202':'Draft,Closed,Refused';'0203':'Range1,Range3';") ;
//		String lead16 = getCompSearchMS("6011000000", "speSearchType,02;searchType,01;str,福强用例专用线索;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,forcastSignMoney","'0201':'System,System Service';'0202':'Draft,Closed,Refused';'0203':'Range1,Range3';") ;
//		
//		
//		String leadDesc1 = "综合查询-线索-快捷查询-行业-行业值";
//		String leadDesc2 = "综合查询-线索-快捷查询-行业-子行业";
//		String leadDesc3 = "综合查询-线索-快捷查询-MTO";
//		String leadDesc4 = "综合查询-线索-快捷查询-营销-事业部";
//		String leadDesc5 = "综合查询-线索-快捷查询-营销-片区";
//		String leadDesc6 = "综合查询-线索-快捷查询-营销-代表处";
//		String leadDesc7 = "综合查询-线索-关键字查询-职位维度";
//		String leadDesc8 = "综合查询-线索-关键字查询-组织维度";
//		String leadDesc9 = "综合查询-线索-关键字查询";
//		String leadDesc10 = "综合查询-线索-关键字筛选-业务范围";
//		String leadDesc11 = "综合查询-线索-关键字筛选-线索状态";
//		String leadDesc12 = "综合查询-线索-关键字筛选-线索金额";
//		String leadDesc13 = "综合查询-线索-关键字筛选-业务范围-线索状态";
//		String leadDesc14 = "综合查询-线索-关键字筛选-业务范围-线索金额";
//		String leadDesc15 = "综合查询-线索-关键字筛选-线索状态-线索金额";
//		String leadDesc16 = "综合查询-线索-关键字筛选-业务范围-线索状态-线索金额";
//
//		
//		msList.add(lead1);
//		msList.add(lead2);
//		msList.add(lead3);
//		msList.add(lead4);
//		msList.add(lead5);
//		msList.add(lead6);
//		msList.add(lead7);
//		msList.add(lead8);
//		msList.add(lead9);
//		msList.add(lead10);
//		msList.add(lead11);
//		msList.add(lead12);
//		msList.add(lead13);
//		msList.add(lead14);
//		msList.add(lead15);
//		msList.add(lead16);
//		
//		descList.add(leadDesc1);
//		descList.add(leadDesc2);
//		descList.add(leadDesc3);
//		descList.add(leadDesc4);
//		descList.add(leadDesc5);
//		descList.add(leadDesc6);
//		descList.add(leadDesc7);
//		descList.add(leadDesc8);
//		descList.add(leadDesc9);
//		descList.add(leadDesc10);
//		descList.add(leadDesc11);
//		descList.add(leadDesc12);
//		descList.add(leadDesc13);
//		descList.add(leadDesc14);
//		descList.add(leadDesc15);
//		descList.add(leadDesc16);
//
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
//	public  CompSearchControllerLeadTest( String  param,  String  desc)
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
