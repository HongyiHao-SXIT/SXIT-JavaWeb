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
<title>我的订单</title>
</head>
<body>
	<!-- 加载header.jsp -->
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">订单列表</h3>
		</div>
		<div class="panel-body">
			<div class="table table-responsive">
				<table class="table table-bordered table-hover">
					<tbody class="text-center">
						<tr>
							<th>订单编号</th>
							<th>订单金额</th>
							<th>订单状态</th>
							<th>下单时间</th>
							<th>查看详情</th>
						</tr>
						<c:forEach var="order" items="${myOrder}">
						<tr>
							<td>${order.id}</td>
							<td>${order.amount}</td>
							<td>
								<c:if test="${order.status == 0}">
									<span>
										未支付 &nbsp; <a href="before_cart?act=pay&oid=${order.id}" >去支付</a>
									</span>
								</c:if>
								<c:if test="${order.status == 1}">
									<span>
										已支付
									</span>
								</c:if>
							</td>
							<td>${order.orderdate}</td>
							<td>
								<a href="before_indexMy?id=${order.id}&&act=orderDetail">查看详情</a>
							</td>
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