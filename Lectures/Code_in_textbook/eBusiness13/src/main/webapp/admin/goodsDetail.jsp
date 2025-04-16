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
	  <table class="table">
	  	 <tr>
	  	 	<th>ID</th>
	  	 	<td>${goods.id }</td>
	  	 </tr>
	  	 <tr>
	  	 	<th>商品名称</th>
	  	 	<td>${goods.gname }</td>
	  	 </tr>
	  	 <tr>
	  	 	<th>商品原价</th>
	  	 	<td>${goods.goprice }</td>
	  	 </tr>
	  	 <tr>
	  	 	<th>商品折扣价</th>
	  	 	<td>${goods.grprice }</td>
	  	 </tr>
	  	 <tr>
	  	 	<th>商品库存</th>
	  	 	<td>${goods.gstore }</td>
	  	 </tr>
	  	 <tr>
	  	 	<th>商品图片</th>
	  	 	<td>
	  	 		<img height="100" width="100" src="static/images/${goods.gpicture }">
	  	 	</td>
	  	 </tr>
	  	 <tr>
	  	 	<th>商品类型</th>
	  	 	<td>
	  	 		${goods.typename }
	  	 	</td>
	  	 </tr>
	  	 <tr>
	  	 	<th>是否广告</th>
	  	 	<td>
	  	 		<c:if test="${goods.isshow == 1}">
	  	 			是
	  	 		</c:if>
	  	 		<c:if test="${goods.isshow == 0}">
	  	 			否
	  	 		</c:if>
	  	 	</td>
	  	 </tr>
	  </table>
	</div>
</body>
</html>