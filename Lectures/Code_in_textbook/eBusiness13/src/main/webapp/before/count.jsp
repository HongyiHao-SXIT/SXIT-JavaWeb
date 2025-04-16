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
<title>订单确认页面</title>
</head>
<body>
<!-- 加载header.jsp -->
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">购物车列表</h3>
		</div>
		<div class="panel-body">
			<div class="table table-responsive">
				<table class="table table-bordered table-hover">
					<tbody class="text-center">
						<tr>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>单价（元）</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:if test="${cartlist.size() > 0 }">
							<c:forEach var="cart" items="${cartlist }">
							<tr>
								<td>
									<a href="before_detail?gno=${cart.id}"> 
									<img src="static/images/${cart.gpicture}"
										style="height: 50px; width: 50px; display: block;">
									</a>
								</td>
								<td>
									<a href="before_detail?gno=${cart.id}"> ${cart.gname }</a>
								</td>
								<td>${cart.grprice}</td>
								<td>${cart.shoppingnum}</td>
								<td>${cart.smallsum}</td>
							</tr>
							</c:forEach>
							<tr>
								<td colspan="5">
								<font style="color: #a60401; font-size: 13px; font-weight: bold; letter-spacing: 0px;">
									购物金额总计(不含运费) ￥&nbsp;<span>${total}</span>元
								</font>
								</td>
							</tr>
							<tr>
								<td colspan="5">
									<a href="before_cart?act=orderSubmit&amount=${total}" >提交订单</a>
								</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>