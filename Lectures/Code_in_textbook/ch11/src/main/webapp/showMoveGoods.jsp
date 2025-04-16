<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	该表共有${lownumber }条记录<br>
	现在逆序输出偶数行的记录：<br>
	<table border="1">
		<tr>
			<th>行号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
		</tr>
	<c:forEach items="${allGoods }" var="goods">
		<tr>
			<td>${goods.rowno }</td>
			<td>${goods.id }</td>
			<td>${goods.gname }</td>
			<td>${goods.gprice }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>