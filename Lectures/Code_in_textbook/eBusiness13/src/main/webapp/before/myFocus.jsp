<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>我的收藏</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- 加载header.jsp -->
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">收藏列表</h3>
		</div>
		<div class="panel-body">
			<div class="table table-responsive">
				<table class="table table-bordered table-hover">
					<tbody class="text-center">
						<tr>
							<th>商品编号</th>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>原价</th>
							<th>现价</th>
						</tr>
						<c:forEach var="focus" items="${myFocus}">
						<tr>
							<td>${focus.id}</td>
							<td>
								<a href="before_detail?gno=${focus.id}"> 
								<img src="static/images/${focus.gpicture}"
									style="height: 50px; width: 50px; display: block;">
								</a>
							</td>
							<td>${focus.gname}</td>
							<td>${focus.goprice}</td>
							<td>${focus.grprice}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
</body>
</html>