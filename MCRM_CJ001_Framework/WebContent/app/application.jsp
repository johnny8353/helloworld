<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/app/common/config.inc"%>   
		<%@ include file="/app/common/head.inc"%> 
		 <script type="text/javascript" src="<%=path %>/scripts/system/workflow.js?sitever=${siteversion}"   charset="utf-8"></script>
		<title>siebel crm</title>
		<script type="text/javascript">
			Ext.onReady(function() {
				readyFunction();
			});
		</script>
	</head>

	<body>
		<div id ="grid">
		</div>
	</body>
</html>
