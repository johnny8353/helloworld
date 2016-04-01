<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/Scripts/jquery.js"></script>
<script type="text/javascript">
	function onclicks(){
		var infoId = $("#infoId").val();
		var className = $("#className").val();
		var userId = $("#userId").val();
		var PNO = $("#PNO").val();
		var PSIZE = $("#PSIZE").val();
		var data = "{\"C\":\"getExceptionInfoList\",\"P\":{\"PNO\":\""+PNO+"\",\"PSIZE\":\""+PSIZE+"\"},\"F\":[{\"K\":\"id\",\"V\":\""+infoId+"\"},{\"K\":\"value\",\"V\":\""+className+"\"},{\"K\":\"userId\",\"V\":\""+userId+"\"}]}";
		$("tr").find("#content").remove();
		$.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "<%=request.getContextPath()%>/MCRM/exception/services.jssm",
            data: data,
            success: function (data) {  
            for(var i = 0; i < data.D.length; i++)
            {
            	   $("#title").append("<tr id='content'><td>"+(i+1)+"</td><td>"+data.D[i].exceptionInfoId+"</td><td>"+data.D[i].appName+"</td><td>"+
            			data.D[i].errorLayer+"</td><td>"+data.D[i].moduleName+"</td><td>"+
            			data.D[i].className+"</td><td>"+data.D[i].methodName+"</td><td>"+
            			data.D[i].errorCode+"</td><td>"+data.D[i].exceptionMessage+"</td><td>"+
            			data.D[i].createdBy+"</td><td>"+data.D[i].createdDate+"</td></tr>");
             }
            if(''!= data.M && null != data.M)
            {
            	alert(data.M);
            }
           }
        });

	}
	
</script>
</head>
<body>
<div style="width: 100%;">
<span>ID：</span><input id="infoId" type="text">
<span>类名：</span><input id="className" type="text">
<span>员工工号：</span><input id="userId" type="text">
<input type="button" value="查询" onclick="onclicks()">
<a href="<%=request.getContextPath()%>/app/getMsgInfo.jsp">查询操作记录信息</a>
<table width="100%" border="1" cellpadding="0" cellspacing="1">
	<tr id="title" bgcolor="ABBDE3">
		<td width="5%">序号</td>
		<td width="5%">EXCEPTION_INFO_ID</td>
		<td width="5%">APP_NAME</td>
		<td width="5%">ERROR_LAYER</td>
		<td width="5%">MODULE_NAME</td>
		<td width="20%">CLASS_NAME</td>
		<td width="5%">METHOD_NAME</td>
		<td width="5%">ERROR_CODE</td>
		<td width="30%">EXCEPTION_MESSAGE</td>
		<td width="5%">CREATED_BY</td>
		<td width="10%">CREATION_DATE</td>
	</tr>
</table>
<span>当前页：</span><input type="text" id="PNO" value="1" style="width: 20px;"/>
<span>查询条数：</span><input type="text" id="PSIZE" value="5" style="width: 20px;"/>
</div>
</body>
</html>