/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_SysConst 
 * 文件名称：SysConst.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-13
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-13
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.common.util;

/**
 * 类 编 号：BL_PU2010101_SysConst
 * 类 名 称：SysConst
 * 内容摘要：系统常量Key定义在该常量类 
 * 完成日期：2014-10-13
 * 编码作者：JohnnyHuang 黄福强
 */
/**
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016-1-14
 * 编码作者：Administrator
 */
/**
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016-1-14
 * 编码作者：Administrator
 */
public class SysConst 
{
	//多语言标志
	/** 语言标志L：2052中文1033英文 */
	public static final String LAN_CHINESE = "2052";

	public static final String LAN_ENGLISH = "1033";
	//请求参数为空!
	public static final String ERROR_REQUEST_EMPTY="cj001.request.empty";
	//客户端没有传入方法名
	public static final String ERROR_CNAME_EMPTY="cj001.methodname.empty";
	//服务端无该服务方法
	public static final String ERROR_SERVER_NOCOMMAND = "cj001.not.methodname";
	
	//字符串连接符
	public static final String STR_SPLITOR="#";
	//设置系统Token有效期为30分钟
	public static final double sessionTime=30.00;
	//Siebel上下文路径
	public static final String SIEBEL_CONTEX_PATH="SIEBEL_CONTEX_PATH";
	//Siebel java端上下文路径
	public static final String SIEBEL_JAVA_CONTEX_PATH="SIEBEL_JAVA_CONTEX_PATH";
	//需要启动时加载的系统配置文件
	public static final String MCRM_POP_PATH="Mcrm.properties";
   //登陆Controller
	public static final String LOGOUT="logout";
	//不需要权限效验的路径
	public static final String EXCLUDE_AUTH_URL="aaa";
	//密钥
	public static final String SECRET_KEY="SECRET_KEY";
	//员工工号
	public static final String EMP_SHORT_NO="EMP_SHORT_NO";
	//TOKEN
	public static final String TOKEN="TOKEN";
	//效验开关打开
	public static final String HAVE_FILTER_FLAG="Y";
	//平台提供客户信息路径
	public static final String SYNC_CUSTOMER_URL="SYNC_CUSTOMER_URL";
	//商机WS地址
	public static final String OPTYWS_URL= "http://10.5.7.152/MCRMTest/services/optyWS";//"http://10.41.223.181/MCRM/services/optyWS";
	//线索WS地址
	public static final String CLUEWS_URL= "http://10.5.7.152/MCRMTest/services/clueWS";
	//公共WS地址
	public static final String COMMONWS_URL= "http://10.5.7.152/MCRMTest/services/commonWS";
	//项目WS地址
	public static final String PRJWS_URL= "http://10.5.7.152/MCRMTest/services/projectWS";
	//审批WS地址
	public static final String AUDITWS_URL= "http://10.5.7.152/MCRMTest/services/auditWS";
	//即时通讯WS地址
	public static final String MsgWS_URL=	"http://10.5.7.152/MCRMTest/services/messageWS";
	//客户WS地址
	public static final String CUSTOMER_URL = "http://10.5.7.152/MCRMTest/services/customerWS";
	//项目任务WS地址
	public static final String PRJ_TASK = "http://10.5.7.152/MCRMTest/services/prjtaskWS";	
	
	//公共WS地址
	public static final String WS_COMMONWS_URL= "http://"+Env.getInstance().getProperty("SIEBEL_URL")+"/siebel/services/commonWS";
	public static final String WS_TEST_URL= "http://"+Env.getInstance().getProperty("SIEBEL_URL")+"/siebel/services/ATest";
	
	//CMS合同上下文路径
	public static final String CMS_CONTEX_PATH="CMS_CONTEX_PATH";
	//MSM上下文路径
	public static final String MSM_CONTEX_PATH="MSM_CONTEX_PATH";
	//EPM上下文路径
	public static final String EPM_CONTEX_PATH="EPM_CONTEX_PATH";
	//EPMS上下文路径
	public static final String EPMS_CONTEX_PATH="EPMS_CONTEX_PATH";
	//HOL上下文路径
	public static final String HOL_CONTEX_PATH = "HOL_CONTEX_PATH";
	//HR上下文路径
	public static final String HR_CONTEX_PATH = "HR_CONTEX_PATH";
	//TS上下问路径
	public static final String TS_CONTEX_PATH = "TS_CONTEX_PATH";
	/**UDM上下文路径**/
	public static final String UDM_CONTEX_PATH = "UDM_CONTEX_PATH";
	//返回客户端处理状态标识(true:成功；false:失败)
	public static final String IS_TRUE = "true";
	public static final String IS_FALSE = "false";
	//外部系统返回处理状态标识(S:成功；E:失败；N：无权限)
	public static final String IS_SUCCESS = "S";
	public static final String IS_ERROR = "E";
	public static final String IS_CANCEL = "N";
	public static final String IS_CONFIRME = "C";    
	//初始化16位权限码
	public static final String PERMISSION = "0000000000000000";
	//失效权限码
	public static final String DISABLED = "0";
	//有效权限码
	public static final String VALID = "1";
	
	//======操作按钮========================================================
	   //Upd：更新
	   public static final String Upd = "Upd";
	   //AddProd：添加产品信息
	   public static final String AddProd = "AddProd";
	   //AddTeam：添加团队成员
	   public static final String AddTeam = "AddTeam";
	   //AddMilestone：添加里程碑
	   public static final String AddMilestone = "AddMilestone";
	   //AddReport：填写周报
	   public static final String AddReport = "AddReport";
	   //AwardRead:查看项目奖励信息
	   public static final String AwardRead = "AwardRead";
	   //Back:退回
	   public static final String Back = "Back";
	   //New:新建
	   public static final String New = "New";
	   //Close:关闭
	   public static final String Close = "Close";
	   //Del：删除
	   public static final String Del = "Del";
	   //submit:提交
	   public static final String Submit = "Submit";
	   //Distrib：分配
	   public static final String Distrib = "Distrib";
	   //Claim：认领
	   public static final String Claim = "Claim";
	   //TurnOpt：转商机
	   public static final String TurnOpt = "TurnOpt";
	   //ConferenceCall：电话会议
	   public static final String ConferenceCall = "ConferenceCall";
	   //AddGroup:我要建群
	   public static final String AddGroup = "AddGroup";
	   //TurnObj：转立项
	   public static final String TurnObj = "TurnObj";
	 //添加客户权限
	   public static final String addCust = "addCust";
	   //添加线索权限
	   public static final String addClue = "addClue";
	   //添加商机权限
	   public static final String addOpty = "addOpty";
	   //添加项目权限
	   public static final String addPrj = "addPrj";
	   //查看进展权限
	   public static final String MissionRead = "MissionRead";
	   //新建任务
	   public static final String AddTask = "AddTask";
	   //变更项目状态
	   public static final String ChangePrjSta = "ChangePrjSta";
	   //查看项目四算
	   public static final String FourFigure = "FourFigure";
	   /**项目工时统计**/
	   public static final String WorkTimeRead = "WorkTimeRead";
	/**服务端调用外部接口调用异常*/
	//系统宕机或停机维护中
	public static final String SERVER_ERROR="SERVER_ERROR";//
	//方法调用发生异常
	public static final String METHOD_ERROR="METHOD_ERROR";
	//SmartSales自身方法业务处理异常
	public static final String SS_METHOD_ERROR="SS_METHOD_ERROR";
	//系统名参数key
	public static final String SYS_NAME="#SYS_NAME#";
	//方法名参数key
	public static final String METHOD_NAME="#MNAME#";
	//异常id参数key
	public static final String EXEC_ID="#EXECID#";
	//smartsales服务端异常
	public static final String SMARTSALES="SMARTSALES";
	//siebel服务端异常
	public static final String SIEBEL="SIEBEL"; 
	//siebelJava版本接口异常
	public static final String SIEBEL_JAVA="SIEBEL(Java)";
	//hol服务端端异常	
	public static final String HOL="HOL";

	//msm服务端端异常	
	public static final String MSM="MSM";

	//cms服务端端异常	
	public static final String CMS="CMS";

	//hr服务端异常	
	public static final String HR="HR";

	//epm服务端异常
	public static final String EPM="EPM";

	//TMS服务端异常
	public static final String TMS="TMS";
	
	//EPMS服务端异常
	public static final String EPMS = "EPMS";
	/**UDM服务异常**/
	public static final String UDM = "UDM";

	/**
	 * 正式环境地址
	 */
	public final static String ENVIRONMENT_RUNNING_IP = "http://10.5.7.152:8080";
	/**
	 * 测试环境地址
	 */
	public final static String ENVIRONMENT_TEST_IP = "http://10.5.7.150:80";
	/**
	 * 本地开发环境地址
	 */
	public final static String ENVIRONMENT_DEVELOP_IP = "http://127.0.0.1:8080";
	/**
	 * HTML文件保存仿真环境
	 */
	public final static String FILE_SAVE_URL_RUN = "/data/SmartSales/pc/image/suggest";
	/**
	 * 文件保存本地环境
	 */
	public final static String FILE_SAVE_URL_LOCAL= "c://zte/file/image/suggest";

	/**
	 * 本地环境
	 */
	public final static String LOCALHOST= "localhost";
	/**
	 * 仿真环境
	 */
	public final static String RUNNING = "running";
	/**
	 * 测试环境
	 */
	public final static String TEST = "test";
	/**
	 * 文件夹地址
	 */
	public final static String FILE_NAME = "/mfile";
	/**
	 * 静态页面存储地址
	 */
	public final static String SAVE_HTML_FILE = "/html";
	/**
	 * 图片存储地址
	 */
	public final static String SAVE_IMAGE_FILE = "/image";
	/**
	 * 用户反馈图片文件夹
	 */
	public final static String SUGGEST_URL = "/suggest";
	
	public final static String PC = "/pc";
	
	public final static String FLAG 	     	 = "flag";
	public final static String FLAG_VALUE1 	 = "true";
	public final static String FLAG_VALUE2 	 = "false";
	public final static String MESSAGE 	 	 = "message";
	/*public final static String MESSAGE2 	 	 = "cj001.check.params.message2";
	public final static String MESSAGE3 	 	 = "cj001.check.params.message3";
	*/
	public final static String MESSAGE_VALUE1	 = "cj001.check.params.message.value1";
	public final static String MESSAGE_VALUE2	 = "cj001.check.params.message.value2";
	public final static String MESSAGE_VALUE3	 = "cj001.check.params.message.value3";
	public final static String TIME_FORMATE	 = "cj001.check.params.time.formate";
	public final static String NO_PARAMS  	 = "cj001.check.params.no.params";
	public final static String PARAMS_FLAG     = "cj001.check.params.flag";
	public final static String NUMBER_FORMAT   = "cj001.check.params.number.formate";
	/**关闭旧方法**/
	public final static String OFF = "off";
	/**打开新方法**/
	public final static String ON = "on";

	/**指定日期格式为：yyyy-MM-dd**/
	public final static String DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * 关键字查询
	 */
	public final static String SEARCHTYPE_KEY = "01";
	/**
	 * 快捷查询
	 */
	public final static String SEARCHTYPE_QUICK = "02";
	/**
	 *最近使用 
	 */
	public final static String SEARCHTYPE_OFTEN = "03";
	/**参数校验类型_String*/
	public static final String PARAMS_STRING = "String";
	
	
	

}
