<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voting Results</title>
</head>
<body>
    <h1>Voting Results</h1>
    <%
        Integer optionAVotes = (Integer) application.getAttribute("OptionA");
        Integer optionBVotes = (Integer) application.getAttribute("OptionB");
        Integer optionCVotes = (Integer) application.getAttribute("OptionC");

        if (optionAVotes == null) {
            optionAVotes = 0;
        }
        if (optionBVotes == null) {
            optionBVotes = 0;
        }
        if (optionCVotes == null) {
            optionCVotes = 0;
        }
    %>
    <p>Votes for Option A: <%= optionAVotes %></p>
    <p>Votes for Option B: <%= optionBVotes %></p>
    <p>Votes for Option C: <%= optionCVotes %></p>
    <a href="vote.jsp">Back to the voting page</a>
</body>
</html>