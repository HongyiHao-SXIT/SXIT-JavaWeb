<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面</title>
</head>
<body>
    <h1>欢迎使用 Servlet 示例</h1>
    <form action="hello" method="get">
        <label for="name">请输入你的名字：</label>
        <input type="text" id="name" name="name">
        <input type="submit" value="提交">
    </form>
</body>
</html>