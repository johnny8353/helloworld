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
		var msgMethod = $("#msgMethod").val();
		var userId = $("#userId").val();
		var PNO = $("#PNO").val();
		var PSIZE = $("#PSIZE").val();
		var data = "{\"C\":\"getMsgLog\",\"P\":{\"PNO\":\""+PNO+"\",\"PSIZE\":\""+PSIZE+"\"},\"F\":[{\"K\":\"value\",\"V\":\""+msgMethod+"\"},{\"K\":\"userId\",\"V\":\""+userId+"\"}]}";
		$("tr").find("#content").remove();
		$.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "<%=request.getContextPath()%>/MCRM/msglog/services.jssm",
            data: data,
            success: function (data) {  
            for(var i = 0; i < data.D.length; i++)
            {
            	   $("#title").append("<tr id='content'><td>"+(i+1)+"</td><td>"+data.D[i].msgLogId+"</td><td>"+data.D[i].MsgURL+"</td><td>"+
            			data.D[i].msgClass+"</td><td>"+data.D[i].msgMethod+"</td><td>"+
            			data.D[i].msgContent+"</td><td>"+data.D[i].createdBy+"</td><td>"+
            			data.D[i].creationDate+"</td><td>"+data.D[i].lastUpdateDate+"</td><td>"+
            			data.D[i].parentId+"</td></tr>");
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
<span>方法名：</span><input id="msgMethod" type="text">
<span>员工工号：</span><input id="userId" type="text">
<input type="button" value="查询" onclick="onclicks()">
<a href="<%=request.getContextPath()%>/app/getMcrmException.jsp">查询异常信息</a>
<table width="100%" border="1" cellpadding="0" cellspacing="1">
	<tr id="title" bgcolor="ABBDE3">
		<td width="5%">序号</td>
		<td width="5%">MSG_LOG_ID</td>
		<td width="10%">MSG_URL</td>
		<td width="5%">MSG_CALSS</td>
		<td width="10%">MSG_METHOD</td>
		<td width="20%">MSG_CONTENT</td>
		<td width="10%">CREATED_BY</td>
		<td width="10%">CREATION_DATE</td>
		<td width="10%">LAST_UPDATE_DATE</td>
		<td width="10%">PARENT_ID</td>
	</tr>
</table>
<span>当前页：</span><input type="text" id="PNO" value="1" style="width: 20px;"/>
<span>查询条数：</span><input type="text" id="PSIZE" value="20" style="width: 20px;"/>
</div>
</body>
</html>