<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Triangle Calculator - Input</title>
    <link rel="stylesheet" href="css/main_style.css">
</head>
<body>
    <h2>Please enter the three sides of the triangle</h2>
    <form action="showTriangle.jsp" method="post">
        <label for="sideA">Side A length:</label>
        <input type="number" id="sideA" name="sideA" step="0.01" min="0.01" required>
        
        <label for="sideB">Side B length:</label>
        <input type="number" id="sideB" name="sideB" step="0.01" min="0.01" required>
        
        <label for="sideC">Side C length:</label>
        <input type="number" id="sideC" name="sideC" step="0.01" min="0.01" required>
        
        <button type="submit">Calculate</button>
    </form>
</body>
</html>