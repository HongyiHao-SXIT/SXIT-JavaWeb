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
	客户的IP地址：
	<%
		String IP = request.getRemoteAddr();
		out.println(IP);
	%>  
	<br>客户机的名称  ：
	 <%
		String clientName = request.getRemoteHost();
		out.println(clientName);
	%>  
	<br>服务器的名称：
	 <%
		String serverName = request.getServerName();
		out.println(serverName);
	%>  
	<br>服务器的端口号：
	 <%
		int serverPort = request.getServerPort();
		out.println(serverPort);
	%>  
</body>
</html>