<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div>
			<h2 align="center">管理员登录</h2>
		</div>
		<form class="form-horizontal" action="admin_adminLoginServlet_login" method="post">
			<div class="form-group">
				<label class="col-sm-4 control-label" for="formGroupInputLarge">用户名</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="aname" id="formGroupInputLarge"
						placeholder="用户名">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="formGroupInputSmall">密码</label>
				<div class="col-sm-6">
					<input class="form-control" type="password" name="apwd"
						id="formGroupInputSmall" placeholder="密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-6">
					<button type="submit" class="btn btn-success">登录</button>
					<button type="reset" class="btn btn-primary">重置</button>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-5  col-sm-10">
					<font size="6" color="red">
						<span>${errorMessage }</span>
					</font>
				</div>
			</div>
		</form>
	</div>
</body>
</html>