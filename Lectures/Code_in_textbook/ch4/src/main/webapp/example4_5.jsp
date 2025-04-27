<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_5.jsp</title>
</head>
<body>
	<h2>该页面每3秒钟刷新1次</h2>
	<p>现在的秒钟时间是：
	<%
		Calendar c = Calendar.getInstance();
		out.print("" + c.get( Calendar.SECOND));
		response.setHeader("refresh","3");
	%>
</body>
</html>