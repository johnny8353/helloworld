<%@ page contentType="text/html; charset=utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String siteVersion = "1.1";//SystemSetting.getSettingValue("application.siteVersion");
	//用户信息
%>


<script type="text/javascript">
	//appRoot:"/siebel"		hostUrl	:"http://localhost:8088/siebel/"
	var scriptGlobal ={
		appRoot: "<%=path%>",
		hostUrl: "<%=basePath%>",
		theme:'',
		siteversion: "<%=siteVersion%>"
	};
	var path = '<%=path%>';
	//set theme
	var css_style = 'ext-all-gray-debug';//ext-all-neptune	ext-all-access	ext-all-debug	ext-sandbox	ext-all-gray
	var theme = 'xtheme-green';
	//var mvg_icon = scriptGlobal.appRoot + "/scripts/extjs/resources/images/icons/mvg_icon.gif";
	
</script>

<!-- scriptGlobal.appRoot -->