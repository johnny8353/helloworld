/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_MailManageForDpg 
 * 文件名称：MailManageForDpg.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-1-6
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-1-6
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.ui.framework;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.lang.StringEscapeUtils;

import com.zte.mcrm.framework.model.framework.UnitTestParamsBO;

/**
 * 类 编 号：BL_PU2010101_MailManageForDpg 类 名 称：MailManageForDpg 内容摘要：XXX
 * 完成日期：2015-1-6 编码作者：JohnnyHuang 黄福强
 */
public class MailManageForDpg {
	// 修改记录: 02 开始
	// 修改日期: 2010-05-13
	// 修 改 人: 罗泽辉
	// 活 动 号: 612001566769
	// 修改内容: 优化。实现按国际分别发送中英文版邮件
	
	/**
     * 邮件发送客户端程序，调用DPG邮件服务端发送邮件
     * @param object 邮件业务对象
     * @return 发送成功返回0000;发送失败返回0001
     */
    public synchronized String invokeDPGSendTestMail(String toMail,String mailUrl,String bodyDetail,UnitTestParamsBO ubo) 
    {
    	String sendFlag = "0001";
		try 
		{
			// 这里使用org.apache.axis.client包中的service和call
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(mailUrl);

			// 设置需要调用的方法名称
			call.setOperationName("sendMail");
			// 构建一个前面例子中提到的xml文件作为调用邮件服务的参数
			String mailBody = patchMailXml(toMail,bodyDetail,ubo);
            //发送成功返回:0000 ,发送失败：0001
			sendFlag = (String)call.invoke(new Object[] {mailBody });
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//程序报异常
			sendFlag="0001";
		}

		return sendFlag;
	}
	
	/**
	 * 邮件发送客户端程序，调用DPG邮件服务端发送邮件
	 * 
	 * @param object
	 *            邮件业务对象
	 * @return 发送成功返回0000;发送失败返回0001
	 */
	public synchronized String invokeDPGSendMails(String toMail, String webUrl,String rootPath,
			String mailUrl) {
		String sendFlag = "0001";
		try {
			// 这里使用org.apache.axis.client包中的service和call
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(mailUrl);

			// 设置需要调用的方法名称
			call.setOperationName("sendMail");
			// 构建一个前面例子中提到的xml文件作为调用邮件服务的参数
			String mailBody = patchUpMailsXml(toMail, rootPath, webUrl);
			// 发送成功返回:0000 ,发送失败：0001
			sendFlag = (String) call.invoke(new Object[] { mailBody });
		} catch (Exception e) {
			// 程序报异常
			e.printStackTrace();
			sendFlag = "0001";
		}

		return sendFlag;
	}

	public ResultTestBO getFailuresNum(String rootUrl) {

		String fileName = rootUrl + "/test/reports/overview-summary.html";
		String fileNameStr = ReadFromFile.readFileByLines(fileName);
//		String reqUrl = webUrl + "/overview-summary.html";
//		String fileNameStr = HTTPClient.HttpPost(reqUrl,"");
		// 获取总数：
		String aStr = fileNameStr.substring(fileNameStr
				.indexOf("all-tests.html\">"), fileNameStr
				.indexOf("</a></td><td><a title=\"Display all failures"));
		aStr = aStr.substring(aStr.indexOf(">") + 1);
		aStr = (aStr == null || aStr.equals("")) ? "0" : aStr;
		// 获取失败数
		String fStr = fileNameStr.substring(fileNameStr
				.indexOf("href=\"alltests-fails.html\">"), fileNameStr
				.indexOf("</a></td><td><a title=\"Display all errors\""));
		fStr = fStr.substring(fStr.indexOf(">") + 1);
		fStr = (fStr == null || fStr.equals("")) ? "0" : fStr;
		// 如果存在有测试未通过的用例则再分是功能还是性能不通过
		int funCount = 0;
		int perfCount = 0;
		int otherCount = 0;
		if (Integer.parseInt(fStr) > 0) {
			String fName = rootUrl + "/test/reports/alltests-fails.html";
//			String fName = webUrl + "/alltests-fails.html";
			String fNameStr = ReadFromFile.readFileByLines(fName);
//			String fNameStr = HTTPClient.HttpPost(fName,"");
			fNameStr = GetStrDelSpeCode(fNameStr, SysTestConst.TEST_SUFFIX);
			funCount = calculateString(fNameStr,StringEscapeUtils.escapeHtml("功能测试") ) ;
			perfCount = calculateString(fNameStr, StringEscapeUtils.escapeHtml("性能测试"));
			otherCount = Integer.parseInt(fStr) - funCount - perfCount;

		}
		// 获取程序异常数
		String errRateStr = fileNameStr.substring(
				fileNameStr.indexOf("href=\"alltests-errors.html\">"),
				fileNameStr.indexOf("%</td>") + 1);
		String errStr = errRateStr.substring(errRateStr.indexOf(">") + 1,
				errRateStr.indexOf("<"));
		errStr = (errStr == null || errStr.equals("")) ? "0" : errStr;

		// 获取测试通过率
		String passRate = errRateStr
				.substring(errRateStr.lastIndexOf("<td>") + 4);
		passRate = (passRate == null || passRate.equals("")) ? "0.00%"
				: passRate;

		// 返回结果
		ResultTestBO rstBO = new ResultTestBO();
		// 总测试用例
		rstBO.setTotalNum(Integer.parseInt(aStr));
		// 不通过的测试用例
		rstBO.setFailureNum(Integer.parseInt(fStr) + Integer.parseInt(errStr));
		// 功能测试不通过的测试用例
		rstBO.setFunctionFailureNum(funCount);
		// 性能测试不通过的测试用例
		rstBO.setPerformanceFailureNum(perfCount);
		// 其它不通过的测试用例
		rstBO.setOtherCount(otherCount);
		// 程序运行异常的测试用例
		rstBO.setErrorNum(Integer.parseInt(errStr));
		// 通过的测试用例
		rstBO.setPassNum(rstBO.getTotalNum() - rstBO.getFailureNum());
		// 测试通过率
		rstBO.setPassRate(passRate);

		return rstBO;
	}
	
	/**
     * 
     * 新测试方式的邮件
     * 编码作者:JohnnyHuang 黄福强
     * 完成日期:2016-2-4
     * @param toMail
     * @param bodyDetail
     * @param failNum
     * @return
     */
    private String patchMailXml(String toMail,String bodyDetail,UnitTestParamsBO ubo)
    {
        String toCcMail="";
        String toBccMail="";
        
        String titles="总共执行了"+ubo.getTestTotalNum()+"个测试用例";
        int failNum=ubo.getTestFailNum();
        if(failNum>0)
        {
        	titles=titles+",有"+failNum+"个测试用例测试不通过";
        }
        else
        {
        	titles=titles+",所有测试用例均测试通过";
        }
        String subject="【Siebel单元测试结果】"+"("+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))+")"+"："+titles+",请查阅!";
        String mailFrom="siebelcrm@zte.com.cn";
        

        
        
    	// 需要传输给DPG邮件服务的邮件xml字串
    	StringBuffer buffStr = new StringBuffer();
    	buffStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	buffStr.append("<mail-config>");
    	buffStr.append("<head><systemType>siebel</systemType></head>");
    	buffStr.append("<mails>");
    	buffStr.append("<mail>");
    	buffStr.append("<mailtoIsOne>true</mailtoIsOne>");
    	buffStr.append("<importance>0</importance><priority>0</priority>");
        
        buffStr.append("<title><![CDATA["+subject+"]]></title>");

    	buffStr.append("<mailfrom><![CDATA["+mailFrom+"]]></mailfrom>");
    	
    	//直接发送
    	buffStr.append("<mailto>"+toMail.trim()+"</mailto>");
    	//抄送
    	buffStr.append("<mailcc>"+toCcMail.trim()+"</mailcc>");
        //密送
        buffStr.append("<mailbcc>"+toBccMail.trim()+"</mailbcc>");
        
        //只发中文邮件
        buffStr.append("<mailBody id=\"zh_CN\">");
        buffStr.append("<WarmCall>温馨提醒：本邮件为系统自动发送，请不要回复本邮件。</WarmCall>");
        buffStr.append("<MailSysName>siebel单元测试结果 通知</MailSysName>");
        buffStr.append("<ClickLook></ClickLook>");
        buffStr.append("<LinkAdd></LinkAdd>");
        buffStr.append("<MainText><![CDATA["+bodyDetail+"]]></MainText>");
        buffStr.append("</mailBody>");

    	//结束标签
    	buffStr.append("</mail>");
    	buffStr.append("</mails>");
    	buffStr.append("</mail-config>");
    	
    	return buffStr.toString();
    }

	/**
	 * 邮件拼接邮件内容体
	 * 
	 * @param object
	 *            邮件业务对象
	 * @return 返回Xml格式的字串
	 */
	public String patchUpMailsXml(String toMail, String rootUrl, String webUrl) {
		// 邮件基本业务类
		// MailBaseBO bo = (MailBaseBO)object;
		// 获取测试未通过数量
		ResultTestBO rstBO = getFailuresNum(rootUrl);
		String subTitle = "测试全部通过!";
		String titles = "测试全部通过!";
		if (rstBO.getFailureNum() > 0) {
			StringBuffer sf = new StringBuffer();
			sf.append("测试通过" + rstBO.getPassNum() + "个测试用例,");
			sf.append("有" + rstBO.getFailureNum() + "个测试用例未通过!");
			sf.append("其中功能测试未通过用例" + rstBO.getFunctionFailureNum() + "个,");
			sf.append("性能测试未通过用例" + rstBO.getPerformanceFailureNum() + "个,");
			sf.append("测试发生程序异常的用例" + rstBO.getErrorNum() + "个,");
			sf.append("其它未通过测试的用例" + rstBO.getOtherCount() + "个,");
			subTitle = sf.toString();
			titles = "有" + rstBO.getFailureNum() + "个测试用例未通过!";
		}
		subTitle = subTitle + "测试通过率为" + rstBO.getPassRate();
		String toCcMail = "";
		String toBccMail = "";
		String subject = "【Siebel单元测试结果】"
				+ "("
				+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date())) + ")" + "：总共"
				+ rstBO.getTotalNum() + "个测试用例," + titles + ",请查阅!";
		String mailFrom = "siebelcrm@zte.com.cn";

		// 需要传输给DPG邮件服务的邮件xml字串
		StringBuffer buffStr = new StringBuffer();
		buffStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		buffStr.append("<mail-config>");
		buffStr.append("<head><systemType>Siebel Web</systemType></head>");
		buffStr.append("<mails>");
		buffStr.append("<mail>");
		buffStr.append("<mailtoIsOne>false</mailtoIsOne>");
		buffStr.append("<importance>0</importance><priority>0</priority>");

		// 需要发送的邮件语言版本，ZH发中文，EN发英文，其他的发双语言
		String langType = "ZH";

		// 发中文标题
		if (langType.equals("ZH")) {
			buffStr.append("<title><![CDATA[" + subject + "]]></title>");
		} else
		// 默认是发英文标题
		{
			buffStr.append("<title><![CDATA[" + subject + "]]></title>");
		}
		buffStr.append("<mailfrom><![CDATA[" + mailFrom + "]]></mailfrom>");

		// 直接发送
		buffStr.append("<mailto>" + toMail.trim() + "</mailto>");
		// 抄送
		buffStr.append("<mailcc>" + toCcMail.trim() + "</mailcc>");
		// 密送
		buffStr.append("<mailbcc>" + toBccMail.trim() + "</mailbcc>");

		// 只发中文邮件
		if (langType.equals("ZH")) {
			buffStr.append(patchMailsXmlForCN(subTitle,rootUrl, webUrl));
		} else
		// 只发英文邮件
		{
			buffStr.append(patchMailsXmlForEN());
		}
		// 结束标签
		buffStr.append("</mail>");
		buffStr.append("</mails>");
		buffStr.append("</mail-config>");

		return buffStr.toString();
	}

	/**
	 * 拼装中文的邮件内容
	 * 
	 * @param bo
	 *            邮件业务对象
	 * @return
	 */
	private String patchMailsXmlForCN(String subTitle,String rootUrl, String webUrl) {
		StringBuffer mailContext = new StringBuffer();
		mailContext.append("<mailBody id=\"zh_CN\">");
		mailContext.append("<WarmCall>温馨提醒：本邮件为系统自动发送，请不要回复本邮件。</WarmCall>");
		mailContext.append("<MailSysName>Siebel单元测试结果 通知</MailSysName>");

		mailContext.append("<ClickLook>点击查看</ClickLook>");
		mailContext.append("<LinkAdd><![CDATA[" + webUrl
				+ "/index.html]]></LinkAdd>");

		mailContext.append("<MainText><![CDATA[" + subTitle +"</br>"+ getMailBody(rootUrl, webUrl)
				+ "]]></MainText>");
		mailContext.append("</mailBody>");

		return mailContext.toString();
	}

	private String getMailBody(String rootUrl, String webUrl) {

		String fileName = rootUrl + "/test/reports/all-tests.html";// "/build/test/reports/overview-summary.html";
//		String reqUrl =  webUrl + "/all-tests.html";// "/build/test/reports/overview-summary.html";
		String rtn = ReadFromFile.readFileByLines(fileName);
//		String rtn = HTTPClient.HttpPost(reqUrl,"");
		//截取掉中间无用信息
        rtn = GetStrDelSpeCode(rtn, SysTestConst.TEST_SUFFIX);
		rtn = rtn.replace("stylesheet.css\">", webUrl + "/stylesheet.css\">"+
				"<style> body {font:normal 68% verdana,arial,helvetica;color:#000000;}table tr td, table tr th {font-size: 68%;}table.details tr th{font-weight: bold;text-align:left;background:#a6caf0;}table.details tr td{background:#eeeee0;}p {line-height:1.5em;margin-top:0.5em; margin-bottom:1.0em;}h1 {margin: 0px 0px 5px; font: 165% verdana,arial,helvetica}h2 {margin-top: 1em; margin-bottom: 0.5em; font: bold 125% verdana,arial,helvetica}h3 {margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica}h4 {margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica}h5 {margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica}h6 {margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica}.Error {font-weight:bold; color:red;}.Failure {font-weight:bold; color:purple;}.Properties {text-align:right;}</style>");
		rtn = rtn
				.replace(
						"onload=\"open('allclasses-frame.html','classListFrame')\"",
						"");
//		rtn = rtn.replace("<th>Status</th>", "<th width=\"8%\">Status</th>");
//		rtn = rtn.replace("<th width=\"80%\">Type</th>",
//				"<th width=\"60%\">Type</th>");
		rtn = rtn.replace("all-tests.html", webUrl + "/all-tests.html");
		rtn = rtn.replace("alltests-fails.html", webUrl
				+ "/alltests-fails.html");
		rtn = rtn.replace("alltests-errors.html", webUrl
				+ "/alltests-errors.html");
		rtn = rtn.replace("href=\"com", "href=\"" + webUrl + "/com");

		// System.out.println(rtn);
		return rtn;
	}

	/**
	 * 拼装英文的邮件内容
	 * 
	 * @param bo
	 *            邮件业务对象
	 * @return
	 */
	private String patchMailsXmlForEN() {
		StringBuffer mailContext = new StringBuffer();
		mailContext
				.append("<mailBody id=\"en_US\">")
				.append("<WarmCall>Prompt: Please do not reply to this mail automatically sent by system.</WarmCall>")
				.append("<MailSysName>ECC-MICI Marketing Information Competitive ＆ Intelligence Notification</MailSysName>");

		mailContext.append("<ClickLook></ClickLook>");
		mailContext.append("<LinkAdd></LinkAdd>");

		mailContext.append("<MainText><![CDATA[]]></MainText>");
		mailContext.append("</mailBody>");

		return mailContext.toString();
	}
	/**
    *
    * 业务描述：傳入一个字符串，截取掉中间一部分，该部分用一个特殊符号包含。返回截取后的字符串
    * 作    者：Johnny Huang
    * 完成日期：2015-12-28
    * @param 
    * @return
    * @throws 
    */
    public static String GetStrDelSpeCode(String str,String SpeCode){
    	String returnSql = "";
    	 Pattern regex =Pattern.compile(SpeCode);
         String[] strs=regex.split(str);
         if(strs.length>=3){
        	 for (int i = 0; i < strs.length; i++) {
				if(i%2==0){
					returnSql += strs[i];
				}
			}
         }else{
        	 returnSql = str ;
         }
         return returnSql;
    }
	/**
	 * 计算toStr在str出现的次数
	 * 
	 * @param str
	 * @param toFindStr
	 * @return
	 */
	private int calculateString(String str, String toStr) {
		int count = 0;
		int index = 0;
		while (index != -1) {
			index = str.indexOf(toStr);
			if (index < 0) {
				break;
			}
			str = str.substring(index + toStr.length());
			count++;
		}
		return count;
	}

	// 修改记录: 02 结束
	public static void main(String[] args) {
		// String rootUrl="E:/MCRM/ServerCode";
		// //
		// ResultTestBO rstBO= new MailManageForDpg().getFailuresNum(rootUrl);

		// args=new String[4];
//		String toMail = "test@zte.com.cn,6011000052@zte.com.cn";
//		String webUrl = "http://10.5.6.97:8088/reports";
//		String rootPath = "D:/java/build-test";
//		String mailUrl = "http://itpmail.zte.com.cn/mailService/services/MailTemplateService";
//		String toMail = "test@zte.com.cn,6011000052@zte.com.cn";
//		String webUrl = "http://10.5.6.97:8088/reports";
//		String rootPath = "D:/java/build-test";
//		String mailUrl = "http://itpmail.zte.com.cn/mailService/services/MailTemplateService";
		 String toMail=args[0];//"xiao.lang@zte.com.cn,li.xinghui@zte.com.cn";
		 String webUrl=args[1];//"http://10.41.223.181/reports";
		 String rootPath =args[2];// "E:/MCRM/ServerCode";
		 String mailUrl =args[3];//"http://itpmail.zte.com.cn/mailService/services/MailTemplateService";
//		 System.out.println(rootPath);

		// (String toMail,String webUrl,String rootPath,String mailUrl)
		String bb = new MailManageForDpg().invokeDPGSendMails(toMail, webUrl,rootPath,
				 mailUrl);

		System.out.println(bb);

	}

}
