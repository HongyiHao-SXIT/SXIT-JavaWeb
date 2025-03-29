<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySQL Connection</title>
</head>
<body>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sxit_databases_learning","root","123456");
Statement sta=con.createStatement();
ResultSet res=sta.executeQuery("select * from login");
while(res.next()){
    String Muser=res.getString("Muser");
    String Mpassword=res.getString("Mpassword");
    out.print("用户名："+Muser+"<br>"+"密"+"&nbsp;&nbsp;&nbsp;"+"码："+Mpassword);
}
con.close();
sta.close();
res.close();
%>
</body>
</html>    