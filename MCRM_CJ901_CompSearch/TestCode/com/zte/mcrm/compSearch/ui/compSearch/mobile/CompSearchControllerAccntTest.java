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
//public class CompSearchControllerAccntTest extends AbstractTestBase {
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
//		String account1 = getCompSearchMS("6011000000", "speSearchType,01;searchType,02;str,;quickType,03;quickLevel,01;dataId,1-POMDH;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String account2 = getCompSearchMS("6011000000", "speSearchType,01;searchType,02;str,;quickType,01;quickLevel,01;dataId,1-I6S3;selectCode,;lstupd,2016-11-11 11:11:11;orderby,CreateDate","") ;
//		String account3 = getCompSearchMS("6011000000", "speSearchType,01;searchType,02;str,;quickType,01;quickLevel,02;dataId,1-IP78;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String account4 = getCompSearchMS("6011000000", "speSearchType,01;searchType,02;str,;quickType,01;quickLevel,03;dataId,1-JENM;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		
//		String account5 = getCompSearchMS("T6011000001", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String account6 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String account7 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","") ;
//		String account8 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0101':'10002,10003,10005';") ;
//		String account9 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0102':'Y';") ;
//		String account10 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0103':'AA001,AA003';") ;
//		String account11 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0101':'10002,10003,10005';'0102':'Y';") ;
//		String account12 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0101':'10002,10003,10005';'0103':'AA001,AA003';") ;
//		String account13 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,","'0102':'Y';'0103':'AA001,AA003';") ;
//		String account14 = getCompSearchMS("6011000000", "speSearchType,01;searchType,01;str,福强用例专用客户;quickType,;quickLevel,;dataId,;selectCode,;lstupd,2016-11-11 11:11:11;orderby,CreateDate","'0101':'10002,10003,10005';'0102':'Y';'0103':'AA001,AA003';") ;
//		
//		String accntDesc1 = "综合查询-客户-快捷查询-MTO";
//		String accntDesc2 = "综合查询-客户-快捷查询-营销-事业部";
//		String accntDesc3 = "综合查询-客户-快捷查询-营销-片区";
//		String accntDesc4 = "综合查询-客户-快捷查询-营销-代表处";
//		String accntDesc5 = "综合查询-客户-关键字查询-职位维度";
//		String accntDesc6 = "综合查询-客户-关键字查询-组织维度";
//		String accntDesc7 = "综合查询-客户-关键字查询";
//		String accntDesc8 = "综合查询-客户-关键字筛选-客户类型";
//		String accntDesc9 = "综合查询-客户-关键字筛选-客户范围";
//		String accntDesc10 = "综合查询-客户-关键字筛选-运营商级别";
//		String accntDesc11 = "综合查询-客户-关键字筛选-客户类型-客户范围";
//		String accntDesc12 = "综合查询-客户-关键字筛选-客户类型-运营商级别";
//		String accntDesc13 = "综合查询-客户-关键字筛选-客户范围-运营商级别";
//		String accntDesc14 = "综合查询-客户-关键字筛选-客户类型-客户范围-运营商级别";
//
//		msList.add(account1);
//		msList.add(account2);
//		msList.add(account3);
//		msList.add(account4);
//		msList.add(account5);
//		msList.add(account6);
//		msList.add(account7);
//		msList.add(account8);
//		msList.add(account9);
//		msList.add(account10);
//		msList.add(account11);
//		msList.add(account12);
//		msList.add(account13);
//		msList.add(account14);
//		descList.add(accntDesc1);
//		descList.add(accntDesc2);
//		descList.add(accntDesc3);
//		descList.add(accntDesc4);
//		descList.add(accntDesc5);
//		descList.add(accntDesc6);
//		descList.add(accntDesc7);
//		descList.add(accntDesc8);
//		descList.add(accntDesc9);
//		descList.add(accntDesc10);
//		descList.add(accntDesc11);
//		descList.add(accntDesc12);
//		descList.add(accntDesc13);
//		descList.add(accntDesc14);
//
//		Object[][] paramObjects = new Object[descList.size()*Bonus][2];
//		for (int i = 0; i < msList.size()*Bonus; i++) {
//			paramObjects[i][0]=msList.get(i%36);
//			paramObjects[i][1]=descList.get(i%36);
//		}
//		return  Arrays.asList( paramObjects );
//	}
//	// 构造函数，对变量进行初始化
//	public  CompSearchControllerAccntTest( String  param,  String  desc)
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
