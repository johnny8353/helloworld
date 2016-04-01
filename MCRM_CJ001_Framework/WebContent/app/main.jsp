<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<style type="text/css">
	
	</style>
		<%@ include file="/app/common/config.inc"%>   
		<%@ include file="/app/common/head.inc"%> 
		 <script type="text/javascript" src="<%=path %>/scripts/main.js?sitever=${siteversion}"   charset="utf-8"></script>
		 <script type="text/javascript" src="<%=path %>/scripts/extjs/plugin/TabCloseMenu.js"></script>
		 <script type="text/javascript" src="<%=path %>/scripts/extjs/plugin/options-toolbar.js"></script>
	
		<title>siebel crm</title>
		<script type="text/javascript">
			Ext.onReady(function() {
				readyFunction();
			});
		</script>
	</head>

	<body>
		<div id="west" class="x-hide-display">
	   </div>
	   <div id="center" class="x-hide-display">
	   </div>	
	</body>
</html>
