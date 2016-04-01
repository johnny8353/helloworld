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
//
///**
// * 类 编 号：
// * 类 名 称：CompSearchControllerJudgeDataTest
// * 内容摘要：XXX 
// * 完成日期：2016-1-27
// * 编码作者：JohnnyHuang
// */
//@RunWith(Parameterized. class )
//public class CompSearchControllerJudgeDataTest  extends AbstractTestBase {
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
//		String ms1 = getCompSearchMS("10168319","speSearchType,04;infoId,1-188JJY") ;
//		String ms2 = getCompSearchMS("10168319","speSearchType,04;infoId,1-15WMER") ;
//		String ms3 = getCompSearchMS("10055889","speSearchType,04;infoId,1-TZAOD") ;
//		String ms4 = getCompSearchMS("10055889","speSearchType,04;infoId,1-1316C0") ;
//		String ms5 = getCompSearchMS("10168319","speSearchType,04;infoId,1-15UJYR") ;
//		String ms6 = getCompSearchMS("10174569","speSearchType,04;infoId,1-16GZ5W") ;
//		String ms7 = getCompSearchMS("10039159","speSearchType,04;infoId,1-188JNS") ;
//		String ms8 = getCompSearchMS("10039159","speSearchType,04;infoId,1-13XNN3") ;
//		String ms9 = getCompSearchMS("10039159","speSearchType,04;infoId,1-15WMER") ;
//		String ms10 = getCompSearchMS("10039159","speSearchType,04;infoId,1-16GZ5W") ;
//		String ms11 = getCompSearchMS("10174569","speSearchType,04;infoId,1-13XNN3") ;
//		String ms12 = getCompSearchMS("10174569","speSearchType,04;infoId,1-15UJYR") ;
//		String ms13 = getCompSearchMS("10174569","speSearchType,04;infoId,1-188JNS") ;
//		String ms14 = getCompSearchMS("10130400","speSearchType,04;infoId,1-Q781T") ;
//		String ms15 = getCompSearchMS("10130400","speSearchType,04;infoId,1-15UBB3") ;
//		String ms16 = getCompSearchMS("10130400","speSearchType,04;infoId,1-15QMIP") ;
//		String ms17 = getCompSearchMS("10130400","speSearchType,04;infoId,1-1330JZ") ;
//		String ms18 = getCompSearchMS("10165804","speSearchType,04;infoId,1-18P1EA") ;
//		String ms19 = getCompSearchMS("10165804","speSearchType,04;infoId,1-15NRQ9") ;
//		String ms20 = getCompSearchMS("10165804","speSearchType,04;infoId,1-15LMVE") ;
//		String ms21 = getCompSearchMS("10165804","speSearchType,04;infoId,1-1330JZ") ;
//		String ms22 = getCompSearchMS("10165804","speSearchType,04;infoId,1-188JNS") ;
//		String ms23 = getCompSearchMS("10165974","speSearchType,04;infoId,1-18MH1H") ;
//		String ms24 = getCompSearchMS("10165974","speSearchType,04;infoId,1-188JNS") ;
//		String ms25 = getCompSearchMS("00004649","speSearchType,04;infoId,1-18MH1H") ;
//		String ms26 = getCompSearchMS("00004649","speSearchType,04;infoId,1-139T6X") ;
//		String ms27 = getCompSearchMS("00004649","speSearchType,04;infoId,1-188JNS") ;
//		String ms28 = getCompSearchMS("00001267","speSearchType,04;infoId,1-MFAUH") ;
//		String ms29 = getCompSearchMS("00001267","speSearchType,04;infoId,1-MCV5W") ;
//		String ms30 = getCompSearchMS("10026869","speSearchType,04;infoId,1-UMPSL") ;
//		String ms31 = getCompSearchMS("10026869","speSearchType,04;infoId,1-Y11PP") ;
//		String ms32 = getCompSearchMS("10026869","speSearchType,04;infoId,1-188JNS") ;
//		String ms33 = getCompSearchMS("10018690","speSearchType,04;infoId,1-14258N") ;
//		String ms34 = getCompSearchMS("10018690","speSearchType,04;infoId,1-131WHR") ;
//		String ms35 = getCompSearchMS("10018690","speSearchType,04;infoId,1-188JNS") ;
//		String ms36 = getCompSearchMS("00020069","speSearchType,04;infoId,1-188JNS") ;
//		String ms37 = getCompSearchMS("00020069","speSearchType,04;infoId,1-15UBWH") ;
//		String ms38 = getCompSearchMS("00020069","speSearchType,04;infoId,1-18MH1H") ;
//		String ms39 = getCompSearchMS("00155611","speSearchType,04;infoId,1-13JV07") ;
//		String ms40 = getCompSearchMS("00155611","speSearchType,04;infoId,1-12L8M7") ;
//		String ms41 = getCompSearchMS("00155611","speSearchType,04;infoId,1-188JNS") ;
//		String ms42 = getCompSearchMS("10007515","speSearchType,04;infoId,1-17BE7J") ;
//		String ms43 = getCompSearchMS("10007515","speSearchType,04;infoId,1-148O99") ;
//		String ms44 = getCompSearchMS("10007515","speSearchType,04;infoId,1-UD9BU") ;
//		String ms45 = getCompSearchMS("10007515","speSearchType,04;infoId,1-188JNS") ;
//		String ms46 = getCompSearchMS("10172332","speSearchType,04;infoId,1-110M7P") ;
//		String ms47 = getCompSearchMS("10172332","speSearchType,04;infoId,1-S951U") ;
//		String ms48 = getCompSearchMS("10172332","speSearchType,04;infoId,1-188JNS") ;
//		String ms49 = getCompSearchMS("10184097","speSearchType,04;infoId,1-RO6I8") ;
//		String ms50 = getCompSearchMS("10184097","speSearchType,04;infoId,1-15L5YR") ;
//		String ms51 = getCompSearchMS("10171551","speSearchType,04;infoId,1-188JNS") ;
//		String ms52 = getCompSearchMS("10171551","speSearchType,04;infoId,1-YJIMO") ;
//		String ms53 = getCompSearchMS("10171551","speSearchType,04;infoId,1-1413LL") ;
//		String ms54 = getCompSearchMS("10184097","speSearchType,04;infoId,1-188JNS") ;
//		String ms55 = getCompSearchMS("10055889","speSearchType,04;infoId,1-188JNS") ;
//
//		
//		String desc1 = "业务数据-权限判断-项目-无权限1";
//		String desc2 = "业务数据-权限判断-项目-无权限2";
//		String desc3 = "业务数据-权限判断-项目-组织1";
//		String desc4 = "业务数据-权限判断-项目-组织2";
//		String desc5 = "业务数据-权限判断-项目-组织3";
//		String desc6 = "业务数据-权限判断-项目-组织4";
//		String desc7 = "业务数据-权限判断-项目-组织5";
//		String desc8 = "业务数据-权限判断-项目-MTO1";
//		String desc9 = "业务数据-权限判断-项目-MTO2";
//		String desc10 = "业务数据-权限判断-项目-MTO3";
//		String desc11 = "业务数据-权限判断-项目-产品1";
//		String desc12 = "业务数据-权限判断-项目-产品2";
//		String desc13 = "业务数据-权限判断-项目-产品3";
//		String desc14 = "业务数据-权限判断-项目-行业1";
//		String desc15 = "业务数据-权限判断-项目-行业2";
//		String desc16 = "业务数据-权限判断-项目-行业3";
//		String desc17 = "业务数据-权限判断-项目-组织+MTO1";
//		String desc18 = "业务数据-权限判断-项目-组织+MTO2";
//		String desc19 = "业务数据-权限判断-项目-组织+MTO3";
//		String desc20 = "业务数据-权限判断-项目-组织+产品1";
//		String desc21 = "业务数据-权限判断-项目-组织+产品2";
//		String desc22 = "业务数据-权限判断-项目-组织+产品3";
//		String desc23 = "业务数据-权限判断-项目-组织+产品4";
//		String desc24 = "业务数据-权限判断-项目-组织+行业1";
//		String desc25 = "业务数据-权限判断-项目-组织+行业2";
//		String desc26 = "业务数据-权限判断-项目-组织+行业3";
//		String desc27 = "业务数据-权限判断-项目-MTO+产品1";
//		String desc28 = "业务数据-权限判断-项目-MTO+产品2";
//		String desc29 = "业务数据-权限判断-项目-MTO+产品3";
//		String desc30 = "业务数据-权限判断-项目-MTO+行业1";
//		String desc31 = "业务数据-权限判断-项目-MTO+行业2";
//		String desc32 = "业务数据-权限判断-项目-MTO+行业3";
//		String desc33 = "业务数据-权限判断-项目-产品+行业1";
//		String desc34 = "业务数据-权限判断-项目-产品+行业2";
//		String desc35 = "业务数据-权限判断-项目-产品+行业3";
//		String desc36 = "业务数据-权限判断-项目-组织+MTO+产品1";
//		String desc37 = "业务数据-权限判断-项目-组织+MTO+产品2";
//		String desc38 = "业务数据-权限判断-项目-组织+MTO+产品3";
//		String desc39 = "业务数据-权限判断-项目-组织+产品+行业1";
//		String desc40 = "业务数据-权限判断-项目-组织+产品+行业2";
//		String desc41 = "业务数据-权限判断-项目-组织+产品+行业3";
//		String desc42 = "业务数据-权限判断-项目-组织+产品+行业4";
//		String desc43 = "业务数据-权限判断-项目-组织+MTO+行业1";
//		String desc44 = "业务数据-权限判断-项目-组织+MTO+行业2";
//		String desc45 = "业务数据-权限判断-项目-组织+MTO+行业3";
//		String desc46 = "业务数据-权限判断-项目-组织+MTO+行业4";
//		String desc47 = "业务数据-权限判断-项目-MTO+产品+行业1";
//		String desc48 = "业务数据-权限判断-项目-MTO+产品+行业2";
//		String desc49 = "业务数据-权限判断-项目-MTO+产品+行业3";
//		String desc50 = "业务数据-权限判断-项目-MTO+产品+行业4";
//		String desc51 = "业务数据-权限判断-项目-组织+MTO+产品+行业1";
//		String desc52 = "业务数据-权限判断-项目-组织+MTO+产品+行业2";
//		String desc53 = "业务数据-权限判断-项目-组织+MTO+产品+行业3";
//		String desc54 = "业务数据-权限判断-项目-组织+MTO+产品+行业4";
//		String desc55 = "业务数据-权限判断-项目-组织+MTO+产品+行业5";
//
//		
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
//		msList.add(ms37);
//		msList.add(ms38);
//		msList.add(ms39);
//		msList.add(ms40);
//		msList.add(ms41);
//		msList.add(ms42);
//		msList.add(ms43);
//		msList.add(ms44);
//		msList.add(ms45);
//		msList.add(ms46);
//		msList.add(ms47);
//		msList.add(ms48);
//		msList.add(ms49);
//		msList.add(ms50);
//		msList.add(ms51);
//		msList.add(ms52);
//		msList.add(ms53);
//		msList.add(ms54);
//		msList.add(ms55);
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
//		descList.add(desc37);
//		descList.add(desc38);
//		descList.add(desc39);
//		descList.add(desc40);
//		descList.add(desc41);
//		descList.add(desc42);
//		descList.add(desc43);
//		descList.add(desc44);
//		descList.add(desc45);
//		descList.add(desc46);
//		descList.add(desc47);
//		descList.add(desc48);
//		descList.add(desc49);
//		descList.add(desc50);
//		descList.add(desc51);
//		descList.add(desc52);
//		descList.add(desc53);
//		descList.add(desc54);
//		descList.add(desc55);
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
//	public  CompSearchControllerJudgeDataTest( String  param,  String  desc)
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
//		String strJson = compSearchController.doCustom("JudgeSingleDataVisibility",param);
//		long time2 = System.currentTimeMillis();
//		double ct = (time2-time)/1000.0;
//		assertTrue(desc+"-功能测试-黄福强6011000052"+param+" 输出："+strJson+SysTestConst.TEST_SUFFIX, strJson.indexOf("\"S\":\"true\"")>0||strJson.indexOf("You have no permission to operate this Record")>0);
//		assertTrue(desc+"-性能测试-黄福强6011000052"+param+SysTestConst.TEST_SUFFIX, ct <= SysTestConst.TIME_NORMAL_FUNC);
//	}
//	
//	public static String getCompSearchMS(String U,String KV){
//		SiebelBaseBO baseBO = new SiebelBaseBO();
//		baseBO.setC("JudgeSingleDataVisibility");
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
//		baseBO.setF(fbos);
//		String ms = GSONUtil.getGsonStr(baseBO);
//		return ms;
//	}
//
//}
