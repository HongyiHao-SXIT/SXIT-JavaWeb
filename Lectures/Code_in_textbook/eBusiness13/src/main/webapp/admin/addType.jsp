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
	<form class="form-horizontal" action="admin_Type?act=add" method="post">
		<div class="form-group">
			<label class="col-sm-4 control-label" for="formGroupInputLarge">用户名</label>
			<div class="col-sm-4">
				<input class="form-control" type="text" name="typename" id="formGroupInputLarge"
					placeholder="类型名">
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