<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>validate.jsp</title>
</head>
<body>
<%
	String str = request.getParameter("pwd");
	if (!"nihao2023".equals(str)) {
		response.sendRedirect("login.jsp");
	} else {
		out.print("2023年是蛮拼的一年！");
	}
%>
</body>
</html>
