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
    <a href="food.jsp">这里是调料柜台，欢迎选购</a><br>
    <a href="LoginID.jsp">欢迎修改会员卡号</a>
</body>
</html>