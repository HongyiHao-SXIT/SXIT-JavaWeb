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
<title>新增商品</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<form class="form-horizontal" action="admin_addGoods?act=add" method="post"  enctype="multipart/form-data">
		<div class="form-group">
			<label class="col-sm-4 control-label">商品名</label>
			<div class="col-sm-4">
				<input type="text" name="gname" 
				class="form-control" 
				placeholder="商品名" />
			</div>
		</div>	
		<div class="form-group">
			<label class="col-sm-4 control-label">商品原价</label>
			<div class="col-sm-4">
				<input type="text" name="goprice" 
				class="form-control" 
				placeholder="商品原价"/>
			</div>
		</div>	
		<div class="form-group">
			<label class="col-sm-4 control-label">商品折扣价</label>
			<div class="col-sm-4">
				<input type="text" name="grprice" 
				class="form-control" 
				placeholder="商品折扣价"/>
			</div>
		</div>	
		<div class="form-group">
			<label class="col-sm-4 control-label">商品库存</label>
			<div class="col-sm-4">
				<input type="text" name="gstore" 
					class="form-control" 
					placeholder="商品库存"/>
			</div>
		</div>	
		<div class="form-group">
			<label class="col-sm-4 control-label">商品图片</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="file" 
				name="gpicture">
			</div>
		</div>	
		<div class="form-group">
			<label class="col-sm-4 control-label">商品类型</label>
			<div class="col-sm-4">
				<select name="typeid" class="form-control">
					<c:forEach var="gtp" items="${goodsType}">
						<option value="${gtp.id}">${gtp.typename}</option>
					</c:forEach>
				</select>
			</div>
		</div>	
		<div class="form-group">
			<label class="col-sm-4 control-label">是否广告</label>
			<div class="col-sm-4">
				<label class="radio-inline">
					<input type="radio" name="isshow" value="1"/> 是
    			</label>
				<label class="radio-inline">
					<input type="radio" name="isshow" value="0"/> 否
				</label>
			</div>
		</div>	
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-6">
				<button type="submit" class="btn btn-success">新增</button>
				<button type="reset" class="btn btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
</html>