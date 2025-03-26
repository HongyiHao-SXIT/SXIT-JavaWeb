<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="triangle" class="com.example.triangle.Triangle" scope="page"/>
<jsp:setProperty name="triangle" property="*"/>

<html>
<head>
    <title>Triangle Calculation Results</title>
    <link rel="stylesheet" href="css/main_style_2.css">
</head>
<body>
    <h2>Triangle Calculation Results</h2>
    
    <div class="result">
        <p><strong>Entered sides:</strong></p>
        <p>Side A: <jsp:getProperty name="triangle" property="sideA"/></p>
        <p>Side B: <jsp:getProperty name="triangle" property="sideB"/></p>
        <p>Side C: <jsp:getProperty name="triangle" property="sideC"/></p>
        
        <% if (triangle.isValid()) { %>
            <p><strong>Perimeter:</strong> <%= String.format("%.2f", triangle.getPerimeter()) %></p>
            <p><strong>Area:</strong> <%= String.format("%.2f", triangle.getArea()) %></p>
        <% } else { %>
            <p class="error">Error: The entered sides cannot form a valid triangle!</p>
            <p class="error">Please ensure the sum of any two sides is greater than the third side.</p>
        <% } %>
    </div>
    
    <a href="inputTriangle.jsp" class="back-btn">Back to Input</a>
</body>
</html>