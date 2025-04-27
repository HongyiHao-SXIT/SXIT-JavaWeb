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
<title>查询商品</title>
<script type="text/javascript">
    function confirmDelete(id){
        if (window.confirm ("你确定真的要删除吗？")){
           	var url = location.pathname.substring(0, location.pathname.lastIndexOf("/")); 
           	//绝对路径
           	window.location.href = url + "/admin_GoodsServlet?id="+ id + "&act=deleteAgoods";			
        }
    }
</script>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">商品列表</h3>
			</div>
			<div class="panel-body">
				<div class="table table-responsive">
					<table class="table table-bordered table-hover">
						<tbody class="text-center">
							<tr>
								<th>商品ID</th>
								<th>商品名称</th>
								<th>商品类型</th>
								<th>修改</th>
								<th>删除</th>
								<th>详情</th>
							</tr>
							<c:if test="${totalPage != 0 }">
								<c:forEach var="goods" items="${allGoods }">
									<tr>
										<td>${goods.id }</td>
										<td>${goods.gname }</td>
										<td>${goods.typename }</td>
										<td><a href="admin_GoodsServlet?id=${goods.id }&act=updateAgoods">修改</a></td>
										<td><a href="javascript:confirmDelete(${goods.id })">删除</a>
										</td>
										<td><a href="admin_GoodsServlet?id=${goods.id }&act=detail">详情</a></td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="6" align="right">
										<ul class="pagination">
											<li><a><span>第${currentPage}页</span></a></li>
											<li><a><span>共${totalPage}页</span></a></li>
											<li><c:if test="${currentPage != 1}">
													<a href="admin_selectGoodsServlet?currentPage=${currentPage - 1}">上一页</a>
												</c:if> <c:if test="${currentPage != totalPage}">
													<a href="admin_selectGoodsServlet?currentPage=${currentPage + 1}">下一页</a>
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