<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF - 8">
    <title>answer.jsp</title>
</head>
<body>
<form action="example4_9_3.jsp" method="post">
    <% 
    //考号
    String id = request.getParameter("id");
    session.setAttribute("id", id);
    String first = request.getParameter("one");
    session.setAttribute("one", first);
    String second = request.getParameter("two");
    session.setAttribute("two", second); 
    %>
    您的考号： <%= id %><br/>
    一，单项选择题（）
    <br/>
    1. <%= first %>
    二、判断题（）
    <br/>
    1. <%= second %><br/>
    <input type="submit" value="确认完毕"/>
    <a href = "page1.jsp">重新答题</a>
</form>
</body>
</html>