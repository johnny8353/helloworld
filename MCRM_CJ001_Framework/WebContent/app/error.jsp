<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.zte.mcrm.pcframework.common.util.SysPcConst"%>
<%
String msgKey=request.getParameter("msgKey");
String lan=request.getParameter("lan");
String msgTip=SysPcConst.getMsgTip(msgKey, lan);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="Error Page">


<script type="text/javascript" src="<%=request.getContextPath()%>/Scripts/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 

});

</script>
</head>
<body>
    <H2><%=msgTip%></H2> 
    <a href="javascript:document.getElementById('showTip').style.display = 'block';void(0);">
               详细信息
    </a> 
    <div id="showTip" style="color: red; display: none;"><%=msgTip%></div>
    

</body>
</html>
