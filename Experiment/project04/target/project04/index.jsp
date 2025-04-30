<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生信息</title>
</head>
<body>
    <jsp:useBean id="student" class="com.example.Student" scope="request">
        <jsp:setProperty name="student" property="id" value="001" />
        <jsp:setProperty name="student" property="name" value="张三" />
        <jsp:setProperty name="student" property="age" value="20" />
    </jsp:useBean>

    <h2>学生信息</h2>
    <p>学号: <jsp:getProperty name="student" property="id" /></p>
    <p>姓名: <jsp:getProperty name="student" property="name" /></p>
    <p>年龄: <jsp:getProperty name="student" property="age" /></p>
</body>
</html>