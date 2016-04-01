<%@ page language="java"  import="java.net.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siebel Web</title>
</head>
<body>
<span id="showDiv"></span><br/>
<h3>Welcome to siebel Server!!!!!!!!!</h3>     
<h1>测试链接</h1>
测试链接1：综合查询-项目 <a href="<%=path%>/compsearch/pcCustom.jssm?OBJ=3%2BqIT719aK8WIfOcXi44kus/mD71GQIWKdSqU1IYIK0CMcadbC%2BR1LB8PejgeTTauuhc7rwo6yszE3odoA8ObQJZqnHjRnQqhU442TEEtH14Ga1vZmwaKgTSRs%2BxUJAwFrVtlQl%2BLBWF6iNhIfWta5fHItbpKmBqIzXLlTGl6xYyS7s8Qa1VNVcdfEyZvJOB3IQlXTc/ra8HnTBOh9N/rCSQr1VdgkbuvNI89gP4lqAqSRNjwDV4Elzev382FZaDLuLjgITPYAASKgSoOOjfhHAMablJhwevz2qK/vu79KDzw28mx9OzvMIRemVfB%2B2yKInpX%2BpKMGQj6XdVnY%2BGAgFd5KUPD%2Bb8%2BoRmZXwwZLUZ87IDqsXmI91cJzKtHN6vP9OT47o5NGtkCvumC87BwehPKtTLiFHDhCRmzkh3WiOt8Dw1TWfuFYow28/jbqJnnrayO7tjK5ZlUv3dsexsUK3OESqsftnWitn3JbrD0Kx62UscTZORzQ==">福强测试</a></br>
测试链接2：综合查询-项目 <a href="<%=path%>/compsearch/pcCustom.jssm?OBJ=3%2BqIT719aK8WIfOcXi44kus/mD71GQIWKdSqU1IYIK3IldPXv/n4NuoI%2BTSg2fP0CUJRdGMEvVePySx9IOZZx8gUQYGn8EK5XmduSg3ZUuyiJQ9nFJ7qT8HbHqPACsl3DzRVMhoI7Gbg/0bDXfnyDP0OsIK7TRNLP7sixJnJ1CvQs6wfZvq18x3ub1g6WF1vPdXMbuFtWj59BgkYddEDCE5njIOI4JzVbGykjdzu42R5ySnfq9sYhw5syzFlGmyN43kx6eIUpirKC30ETFkWckjnNNh/2Tk9sw2cYRJBRT6EjomZgFmOHLXIJTXu4KkOxvVDBzYyZVyjKLB81Qlw6TxknXqQZDhhRYsDMwFDZGrRXl6WMoJek9r5vnlcJM6VfLXglMnWSxqvkD4WZ6pJGvK2KkxWsvCEDlnQame0BEP0qfqErUAm%2Bh669P4iV6sKCXHDNkHmyvRaF557uBe6UoeKCT2qvGXaQ6ZqobpU6gERo7XNh8R/tOGRFkUuc7sl2iEyoYAJlJWtAqABtdsmxmqqS4s087p/isc327LzRdv6T3N2EPxpntp5bCGlBjbt">电信</a></br>
测试链接3: 项目周报 <a href="<%=path%>/projweekreportlist/pcCustom.jssm?OBJ=iEuWk2KtsfNLpUIzKZ%2B1F5YucDAy82O4XcHgvtvmgPuLCqIMCTMcWwwdtbs/Mk0NesUTUo6nd7SFYHrsqbZpvSZLRCVZ18HSgxgT3e4QKSpk8wKMviWuEpUanXZz42bmNbQTHOerVJTKamBhk8IrKz0ureIF27zVl886vK9ffSj6Dgk9mgBqBe9ix6Wa0pBzLqNturZVh0D18j7/QJazOhNJ%2BC7afYcPEFss/fMAyEBSNrcKBB%2BImYk13RYmKoM3cLEgU/PTvdNggOw7%2BbOH5i2DT68bibKU6RHAlms4J6RrFP0Tgzu/bql4CD8fun9ZiyinoCiC/nL3JzTSrS9BrLR7T4XyzTC/E0axwTqTnPO09xvmoWdjBqFgPx8w64HhKzGDqBwW/ncGd2cRrWU0hyn1yxZAZ8o/NDk6qlfFkKnDdshVtszIsWmcMcwJNqjmbK63yCbzvAU0pZ3wd%2BaX3GHKsIDDPWgtR7MDtHXD%2BGSMOquIowEKB/Fch/8WnqaSO1P6%2B15wPpOXlnGEBnvjGCRRcIbc7IV%2B7rlBbl/Oonx%2BrLdLGxehqBL17hVOk6338yP4TyE%2B4mj7y4xxLvbe22As3Arhz5Y4SemNZKxKazFJo3k3PDeK27ecgTqTVBMkHy3lEENIQqrKKooxBaTA5JDq1gIdVCImQmRvBedxpjnwBPmQ%2BWgEJ7A0tMu3i8pT">广东省深圳市龙岗区横岗中心学校校园三网融合智能系统</a></br>
<h1>主机信息:</h1>
   <% String ip= InetAddress.getLocalHost().getHostAddress();
   String ip2= InetAddress.getLocalHost().getCanonicalHostName();
   request.setAttribute("ip",ip+"/"+ip2);
   %>
   IP/主机名：${ip }</br>
 测试用例： <a href="<%=path%>/workflow/siebel.jssm?method=testcase">测试用例</a></br>
   
</body>
</html>