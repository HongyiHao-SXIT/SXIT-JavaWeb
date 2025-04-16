<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"  errorPage="example4_15.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_15_1.jsp</title>
</head>
<body>
<%
	int a[] = {1,2,3,4,5};
	for(int i = 0; i <= 5; i++){
		out.print(a[i]);
	}
%>
</body>
</html>