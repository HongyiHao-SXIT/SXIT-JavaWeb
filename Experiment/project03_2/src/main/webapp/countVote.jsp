<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vote Processing</title>
</head>
<body>
    <%
        String selectedOption = request.getParameter("option");
        if (selectedOption != null) {
            Integer voteCount = (Integer) application.getAttribute(selectedOption);
            if (voteCount == null) {
                voteCount = 0;
            }
            voteCount++;
            application.setAttribute(selectedOption, voteCount);
            out.println("You have successfully voted for " + selectedOption + "!");
        } else {
            out.println("Please select an option to vote!");
        }
    %>
    <br>
    <a href="vote.jsp">Back to the voting page</a>
    <a href="result.jsp">View the voting results</a>
</body>
</html>