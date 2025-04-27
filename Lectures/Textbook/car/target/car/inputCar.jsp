<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inputCar.jsp</title>
</head>
<body>
    <form action="showCar.jsp" method="post">
        Please enter the car brand:
        <input type="text" name="tradeMark"/>
        <br>
        Please enter your vehicle's license plate number:
        <input type="text" name="number"/>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>    