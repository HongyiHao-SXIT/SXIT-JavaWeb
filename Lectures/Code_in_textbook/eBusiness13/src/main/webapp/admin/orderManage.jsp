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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">订单信息</h3>
			</div>
			<div class="panel-body">
				<div class="table table-responsive">
					<table class="table table-bordered table-hover">
						<tbody class="text-center">
							<tr>
								<th>ID</th>
								<th>用户邮箱</th>
								<th>订单金额</th>
								<th>订单状态</th>
								<th>下单日期</th>
							</tr>
							<c:if test="${totalPage != 0 }">
								<c:forEach var="od" items="${allOders }">
									<tr>
										<td>${od.id }</td>
										<td>${od.bemail }</td>
										<td>${od.amount }</td>
										<td>${od.status== 1 ? '已支付':'未支付' }</td>
										<td>${od.orderdate }</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="5" align="right">
										<ul class="pagination">
											<li><a><span>第${currentPage}页</span></a></li>
											<li><a><span>共${totalPage}页</span></a></li>
											<li><c:if test="${currentPage != 1}">
													<a href="admin_orderManager?act=selectOrder&currentPage=${currentPage - 1}">上一页</a>
												</c:if> <c:if test="${currentPage != totalPage}">
													<a href="admin_orderManager?act=selectOrder&currentPage=${currentPage + 1}">下一页</a>
												</c:if></li>
										</ul>
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