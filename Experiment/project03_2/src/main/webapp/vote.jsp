<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voting Page</title>
</head>
<body>
    <h1>Please select the option you support to vote.</h1>
    <form action="countVote.jsp" method="post">
        <input type="radio" name="option" value="OptionA"> Option A<br>
        <input type="radio" name="option" value="OptionB"> Option B<br>
        <input type="radio" name="option" value="OptionC"> Option C<br>
        <input type="submit" value="Vote">
    </form>
</body>
</html>