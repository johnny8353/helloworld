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
//public class CompSearchControllerTest extends AbstractTestBase {
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
//		String ms1 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,02;quickLevel,01;dataId,1-D63BI;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms2 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,02;quickLevel,02;dataId,1-LT06;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms3 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,02;quickLevel,03;dataId,1-LT0S;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms4 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,04;quickLevel,01;dataId,70;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms5 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,04;quickLevel,02;dataId,403;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms6 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,03;quickLevel,01;dataId,1-POMDH;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms7 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,01;quickLevel,01;dataId,1-I6S3;selectCode,;lstupd,2016-11-11 11:11:11;orderby,ObjLevelorMeney","") ;
//		String ms8 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,01;quickLevel,02;dataId,1-IP78;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms9 = getCompSearchMS("6011000000", "speSearchType,04;searchType,02;str,;quickType,01;quickLevel,03;dataId,1-JENM;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms10 = getCompSearchMS("T6011000001", "speSearchType,04;searchType,01;str,福强用例 项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms11 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms12 = getCompSearchMS("T6011000003", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms13 = getCompSearchMS("T6011000004", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms14 = getCompSearchMS("T6011000002", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms15 = getCompSearchMS("T6011000007", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms16 = getCompSearchMS("T6011000006", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms17 = getCompSearchMS("T6011000005", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms18 = getCompSearchMS("T6011000008", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms19 = getCompSearchMS("T6011000001", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms20 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms21 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms22 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';") ;
//		String ms23 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0402':'Project App Doing,PROCESS,Project App Discontinue';") ;
//		String ms24 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0403':'Range1,Range3';") ;
//		String ms25 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';'0402':'Project App Doing,PROCESS,Project App Discontinue';") ;
//		String ms26 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';'0403':'Range1,Range3';") ;
//		String ms27 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0402':'Project App Doing,PROCESS,Project App Discontinue';'0403':'Range1,Range3';") ;
//		String ms28 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用项目;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';'0402':'Project App Doing,PROCESS,Project App Discontinue';'0403':'Range1,Range3';") ;
//		String ms29 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String ms30 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';") ;
//		String ms31 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0402':'Project App Doing,PROCESS';") ;
//		String ms32 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0403':'Range1,Range3';") ;
//		String ms33 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';'0402':'Project App Doing,PROCESS';") ;
//		String ms34 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';'0403':'Range1,Range3';") ;
//		String ms35 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0402':'Project App Doing,PROCESS,Project App Discontinue';'0403':'Range1,Range3';") ;
//		String ms36 = getCompSearchMS("6011000000", "speSearchType,04;searchType,01;str,福强用例专用立项;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0401':'5,10';'0402':'Project App Doing,PROCESS';'0403':'Range1,Range3';") ;
//		String ms100 = getCompSearchMS("6011000047", "speSearchType,04;searchType,01;str,电信;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		
//		
//		String desc1="综合查询-项目-快捷查询-产品-体系结构";
//		String desc2="综合查询-项目-快捷查询-产品-产品线";
//		String desc3="综合查询-项目-快捷查询-产品-产品大类";
//		String desc4="综合查询-项目-快捷查询-行业-行业值";
//		String desc5="综合查询-项目-快捷查询-行业-子行业";
//		String desc6="综合查询-项目-快捷查询-MTO";
//		String desc7="综合查询-项目-快捷查询-营销-事业部";
//		String desc8="综合查询-项目-快捷查询-营销-片区";
//		String desc9="综合查询-项目-快捷查询-营销-代表处";
//		String desc10="综合查询-项目-关键字查询-职位维度";
//		String desc11="综合查询-项目-关键字查询-组织维度";
//		String desc12="综合查询-项目-关键字查询-MTO维度";
//		String desc13="综合查询-项目-关键字查询-行业维度";
//		String desc14="综合查询-项目-关键字查询-产品维度";
//		String desc15="综合查询-项目-关键字查询-MTO、行业维度";
//		String desc16="综合查询-项目-关键字查询-产品、行业维度";
//		String desc17="综合查询-项目-关键字查询-产品、MTO维度";
//		String desc18="综合查询-项目-关键字查询-MTO、产品、行业维度";
//		String desc19="综合查询-立项-关键字查询-职位维度";
//		String desc20="综合查询-立项-关键字查询-组织维度";
//		String desc21="综合查询-项目-关键字查询";
//		String desc22="综合查询-项目-关键字查询-筛选-项目级别";
//		String desc23="综合查询-项目-关键字查询-筛选-项目状态";
//		String desc24="综合查询-项目-关键字查询-筛选-项目金额";
//		String desc25="综合查询-项目-关键字查询-筛选-项目级别、项目状态";
//		String desc26="综合查询-项目-关键字查询-筛选-项目级别、项目金额";
//		String desc27="综合查询-项目-关键字查询-筛选-项目状态、项目金额";
//		String desc28="综合查询-项目-关键字查询-筛选-项目级别、项目状态、项目金额";
//		String desc29="综合查询-立项-关键字查询";
//		String desc30="综合查询-立项-关键字查询-筛选-项目级别";
//		String desc31="综合查询-立项-关键字查询-筛选-项目状态";
//		String desc32="综合查询-立项-关键字查询-筛选-项目金额";
//		String desc33="综合查询-立项-关键字查询-筛选-项目级别、项目状态";
//		String desc34="综合查询-立项-关键字查询-筛选-项目级别、项目金额";
//		String desc35="综合查询-立项-关键字查询-筛选-项目状态、项目金额";
//		String desc36="综合查询-立项-关键字查询-筛选-项目级别、项目状态、项目金额";
//		msList.add(ms1);
//		msList.add(ms2);
//		msList.add(ms3);
//		msList.add(ms4);
//		msList.add(ms5);
//		msList.add(ms6);
//		msList.add(ms7);
//		msList.add(ms8);
//		msList.add(ms9);
//		msList.add(ms10);
//		msList.add(ms11);
//		msList.add(ms12);
//		msList.add(ms13);
//		msList.add(ms14);
//		msList.add(ms15);
//		msList.add(ms16);
//		msList.add(ms17);
//		msList.add(ms18);
//		msList.add(ms19);
//		msList.add(ms20);
//		msList.add(ms21);
//		msList.add(ms22);
//		msList.add(ms23);
//		msList.add(ms24);
//		msList.add(ms25);
//		msList.add(ms26);
//		msList.add(ms27);
//		msList.add(ms28);
//		msList.add(ms29);
//		msList.add(ms30);
//		msList.add(ms31);
//		msList.add(ms32);
//		msList.add(ms33);
//		msList.add(ms34);
//		msList.add(ms35);
//		msList.add(ms36);
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
//		descList.add(desc12);
//		descList.add(desc13);
//		descList.add(desc14);
//		descList.add(desc15);
//		descList.add(desc16);
//		descList.add(desc17);
//		descList.add(desc18);
//		descList.add(desc19);
//		descList.add(desc20);
//		descList.add(desc21);
//		descList.add(desc22);
//		descList.add(desc23);
//		descList.add(desc24);
//		descList.add(desc25);
//		descList.add(desc26);
//		descList.add(desc27);
//		descList.add(desc28);
//		descList.add(desc29);
//		descList.add(desc30);
//		descList.add(desc31);
//		descList.add(desc32);
//		descList.add(desc33);
//		descList.add(desc34);
//		descList.add(desc35);
//		descList.add(desc36);
//
//		Object[][] paramObjects = new Object[descList.size()*Bonus][2];
//		for (int i = 0; i < msList.size()*Bonus; i++) {
//			paramObjects[i][0]=msList.get(i%36);
//			paramObjects[i][1]=descList.get(i%36);
//		}
//		return  Arrays.asList( paramObjects );
//	}
//	// 构造函数，对变量进行初始化
//	public  CompSearchControllerTest( String  param,  String  desc)
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
