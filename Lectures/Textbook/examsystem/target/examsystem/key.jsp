<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>key.jsp</title>
</head>
<body>
    <%
    String id = (String) session.getAttribute("id");

    int sum = 0;

    String first = (String)session.getAttribute("one");
    if("D".equals(first)){
        sum += 2;
    }
    String second = (String)session.getAttribute("two");
    if("True".equals(second)){
        sum += 2;
    }
    %>
    您的成绩公布如下:
    <table border = "1">
        <tr>
            <th width = "50%">
                考号
            </th>
            <th width = "50%">
                成绩
            </th>
        </tr>
        <tr>
            <td><%= id %></td>
            <td align="right"><%= sum %></td>
        </tr>
    </table>
</body>
</html>