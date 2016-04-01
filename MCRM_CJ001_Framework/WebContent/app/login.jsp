<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>login Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="Login Page">

<script type="text/javascript" src="<%=request.getContextPath()%>/Scripts/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Scripts/json2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Scripts/encode.js"></script>
<script type="text/javascript">
$(document).ready(function(){  
	$("#submit").click(function() 
    {     
     var params = $("#paraId").find(":hidden,:text,:password").serializeArray();
     var j = {};   
     for (var item in params) 
     {
    	 if(params[item].name=='passwd')
    	 {
    		 j[params[item].name] =encode(params[item].value); 
    	 }
    	 else
    	 {
    		 j[params[item].name] = params[item].value;
    	 }
    	 
     } 
     //
     $.ajax( {             
      url : '${pageContext.request.contextPath}/loginAction/pcCustom.jssm?actionName=Login',  
      type : 'POST',  
      data : JSON.stringify(j),  
      dataType : 'json',
      headers:{Accept:"application/json","Content-Type":"application/json"}, 
      success:function(res) 
      { 
    	  
    	if(res.code=='0000')
    	{
    		
    	  //登陆成功，转发到其它界面
    	  location =res.url;
    	}
    	else
    	{
    		
    	  //登陆失败
    	  alert(res.code+""+res.msg);
    	}

    	 
      },
      error:function(XMLHttpRequest,textStatus,errorThrown)
      {
    	  alert(errorThrown);
      }
    });      
  });  
});
</script>
</head>
<body>
<div id="paraId" > 
      <input type="hidden" id="lan" name="lan" value="2052"/>
      
  帐号：<input type="text" id="userno" name="userno" value=""/><br/>
  密码：<input type="password" id="passwd" name="passwd" value=""/><br/>
  <input type="button" name="button" id="submit" value="登陆" width="30"/><br/>
  
   <span id="showTip"></label> 
 </div>
</body>
</html>
