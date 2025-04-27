<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>redirectForward.jsp</title>
</head>
<body>
    <form action="redirectForwardServlet" method="post">
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type="text" name="user"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="pwd"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</body>
</html>