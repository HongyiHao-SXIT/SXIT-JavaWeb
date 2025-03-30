<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>shop.jsp</title>
</head>
<body>
    <%
    String no = request.getParameter("no");
    if(no == null){
        no = "";
    } else{
        session.setAttribute("no", no);
    }
    %>
    <a href="food.jsp">This is the seasoning counter. Welcome to make your purchase.</a><br>
    <a href="LoginID.jsp">Welcome to modify the membership card number.</a>
</body>
</html>