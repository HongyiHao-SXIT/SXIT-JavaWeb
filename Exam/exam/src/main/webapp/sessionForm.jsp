<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session 示例</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            line-height: 1.6;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        form {
            margin-top: 20px;
        }
        input[type="text"], input[type="submit"] {
            padding: 8px;
            margin: 5px 0;
        }
        .message {
            margin-top: 15px;
            padding: 10px;
            border-radius: 4px;
        }
        .success {
            background-color: #dff0d8;
            color: #3c763d;
        }
        .error {
            background-color: #f2dede;
            color: #a94442;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Session 测试</h1>
        
        <form action="session" method="post">
            <label for="username">请输入用户名：</label><br>
            <input type="text" id="username" name="username" required><br><br>
            <input type="submit" value="提交到Session">
        </form>
        
        <%-- 显示操作结果 --%>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
                String messageClass = message.contains("成功") ? "success" : "error";
        %>
                <div class="message <%= messageClass %>">
                    <%= message %>
                </div>
        <%
            }
        %>
        
        <%-- 显示当前Session中的用户名 --%>
        <%
            String sessionUsername = (String) session.getAttribute("username");
            if (sessionUsername != null) {
        %>
                <div class="message success">
                    当前Session中的用户名: <strong><%= sessionUsername %></strong>
                </div>
        <%
            }
        %>
    </div>
</body>
</html>