<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>food.jsp</title>
</head>
<body>
    <form action="" method="post" name="form">
        This is the seasoning counter. Please select the goods you want to purchase:
        <br/>
        <input type="checkbox" name="food" value="Harmonized Oil">
        Harmonized Oil
        <input type="checkbox" name="food" value="Fortified Salt">
        Fortified Salt
        <input type="checkbox" name="food" value="Multivitamin Vinegar">
        Multivitamin Vinegar
        <input type="checkbox" name="food" value="Green Seasoning">
        Green Seasoning
        <br/>
        <input type="submit" name="submit" value="Shop">
        <p>
            <a href="LoginID.jsp">Welcome to modify the membership card number</a>
            <a href="count.jsp">Welcome to check the shopping cart!</a>
        </p>
        <%
            request.setCharacterEncoding("utf-8");
            String goods[] = request.getParameterValues("food");
            if (goods != null && goods.length != 0) {
                for (int i = 0; i < goods.length; i++) {
                    session.setAttribute(goods[i], goods[i]);
                }
            }
        %>
    </form>
</body>
</html>