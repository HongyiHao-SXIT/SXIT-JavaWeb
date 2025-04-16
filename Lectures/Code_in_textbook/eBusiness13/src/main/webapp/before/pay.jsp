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
<title>订单支付页面</title>
</head>
<body>
<!-- 加载header.jsp -->
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">订单提交成功</h3>
		</div>
		<div class="panel-body">
			<div>
	您的订单编号为<font color="red" size="5"> <span id="oid">${oid}</span></font>	。<br><br>
				<a href="before_cart?act=pay&oid=${oid}">去支付</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>