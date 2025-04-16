<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int n = 0;
	Integer count = (Integer)application.getAttribute("count");
	if(count != null){
		n = count;	
	}
	n++;
	application.setAttribute("count", n);
	out.print("您是第" + n + "个访问该网站的客户！");
%>
</body>
</html>