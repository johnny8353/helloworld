<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/app/common/config.inc"%>   
		<%@ include file="/app/common/head.inc"%> 
		 <script type="text/javascript" src="<%=path %>/scripts/system/thread.js?sitever=${siteversion}"   charset="utf-8"></script>
		<script type="text/javascript" src="<%=path %>/scripts/extjs/plugin/options-toolbar.js"></script>
		<title>siebel crm</title>
		<script type="text/javascript">
			//SyncRequest('/workflow/siebel.jssm?method=getPageInfo');
			//var fieldArray = [<%=session.getValue("threadShowField")%>];
			//var labelArray = [<%=session.getValue("threadShowLabel")%>];
			//var flagArray = [<%=session.getValue("threadShowFlag")%>];
			//var threadShowJson = [<%=session.getValue("threadShowJson")%>];
			//var titleName = '<%=session.getValue("threadShowTitle")%>';
			Ext.onReady(function() {
				readyFunction();
			});
		</script>
	</head>

	<body>
		<div id ="gridId">
		</div>
		<div id ="gridId2">
		</div>
	</body>
</html>
