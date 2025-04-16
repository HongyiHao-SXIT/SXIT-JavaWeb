<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<form class="form-horizontal" action="admin_Type?act=update" method="post">
		<div class="form-group">
			<label class="col-sm-4 control-label" for="formGroupInputLarge1">类型ID</label>
			<div class="col-sm-4">
				<input class="form-control"
				 type="text" readonly
				 value="${goodsType.id }"
				 name="id" 
				 id="formGroupInputLarge1">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label" for="formGroupInputLarge2">用户名</label>
			<div class="col-sm-4">
				<input class="form-control" 
				type="text" 
				value="${goodsType.typename }"
				name="typename" 
				id="formGroupInputLarge2"
					placeholder="类型名">
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