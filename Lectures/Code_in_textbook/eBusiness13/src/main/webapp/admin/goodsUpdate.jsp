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
<title>修改商品</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<form class="form-horizontal" action="admin_addGoods?act=update" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label class="col-sm-4 control-label">商品ID</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="text" 
				name="id" 
				readonly="readonly"
				value="${goods.id }"
				>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">商品名</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="text" 
				name="gname"  value="${goods.gname }"
				placeholder="商品名">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">商品原价</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="text" 
				name="goprice" value="${goods.goprice }" 
				placeholder="商品原价">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">商品折扣价</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="text" 
				name="grprice"  value="${goods.grprice }"
				placeholder="商品折扣价">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">商品库存</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="text" 
				name="gstore" value="${goods.gstore }"
				placeholder="商品库存">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">商品图片</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="file" 
				name="gpicture"><br>
				<input type="hidden" name="oldgpicture" value="${goods.gpicture }">
				<img height="50" width="50" alt="商品无图片"
				 src="static/images/${goods.gpicture }">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">商品类型</label>
			<div class="col-sm-4">
				<select name="typeid" class="form-control">
					<c:forEach var="type" items="${goodsType }">
						<c:if test="${type.id == goods.goodstype_id }">
							<option value="${type.id }" selected="selected">${type.typename }</option>
						</c:if>
						<c:if test="${type.id != goods.goodstype_id }">
							<option value="${type.id }">${type.typename }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">是否广告</label>
			<div class="col-sm-4">
				<c:if test="${goods.isshow == 1 }">
					<label class="radio-inline">
	 						<input  type="radio" name="isshow" checked="checked" value = "1"> 是
	    			</label>
					<label class="radio-inline">
						<input  type="radio" name="isshow"  value = "0"> 否
					</label>
				</c:if>
				<c:if test="${goods.isshow == 0 }">
					<label class="radio-inline">
	 						<input  type="radio" name="isshow"  value = "1"> 是
	    			</label>
					<label class="radio-inline">
						<input  type="radio" name="isshow" checked="checked"  value = "0"> 否
					</label>
				</c:if>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-6">
				<button type="submit" class="btn btn-success">修改</button>
				<button type="reset" class="btn btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
</html>