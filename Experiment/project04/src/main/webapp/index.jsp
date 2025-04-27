<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>使用 JavaBean</title>
</head>
<body>
    <jsp:useBean id="student" class="com.example.Student" scope="page" />

    <jsp:setProperty property="id" name="student" value="001" />
    <jsp:setProperty property="name" name="student" value="张三" />
    <jsp:setProperty property="age" name="student" value="20" />
    <jsp:setProperty property="gender" name="student" value="男" />


    <p>学生 ID: <jsp:getProperty property="id" name="student" /></p>
    <p>学生姓名: <jsp:getProperty property="name" name="student" /></p>
    <p>学生年龄: <jsp:getProperty property="age" name="student" /></p>
    <p>学生性别: <jsp:getProperty property="gender" name="student" /></p>
</body>
</html>