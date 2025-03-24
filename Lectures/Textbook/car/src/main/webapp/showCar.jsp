<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>showCars.jsp</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="smallCar" class="com.bean.Car" scope="page" />

    <jsp:setProperty property = "*" name = "smallCar"/>

    The car brand is: <jsp:getProperty property = "tradeMark" name = "smallCar"/>
    <br>
    vehicle's license plate number:<jsp:getProperty property = " number" name = "smallCar"/>

</body>
</html>