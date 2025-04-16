<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>修改密码页面</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function checkBpwd(){
		if($("#bpwd").val() != $("#rebpwd").val()){
			alert("两次密码不一致！");
			return false;
		}
		document.myform.submit();
	}
</script>
</head>
<body>
<div class="container">
	  	<div class="bg-primary"  style="width:70%; height: 60px;padding-top: 1px;">
	       <h3 align="center">个人信息</h3>
	   </div>
		<br><br>
		<form action="before_register?flag=2" name="myform" method="post"  class="form-horizontal" >
			<div class="form-group has-success">
				<label class="col-sm-2 col-md-2 control-label">邮箱</label>
				<div class="col-sm-4 col-md-4">
					<input type="email" name="bemail" id="bemail" disabled="disabled"
					 value="${buser.bemail}" class="form-control"/>
					 <input type="hidden" name="id" value="${buser.id}"/>
				</div>
			</div>
	
			<div class="form-group has-success">
				  <label class="col-sm-2 col-md-2 control-label">密码</label>
				  <div class="col-sm-4 col-md-4">
		  				<input type="password" class="form-control" name="bpwd" id="bpwd"
					 placeholder="请输入您的新密码" />
				  </div>
			 </div>
	
			<div class="form-group has-success">
				  <label class="col-sm-2 col-md-2 control-label">确认密码</label>
				  <div class="col-sm-4 col-md-4">
		  				<input type="password" class="form-control" name="rebpwd" id="rebpwd"
					 placeholder="请再次输入您的新密码"/>
				  </div>
			 </div>
	
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" onclick="checkBpwd()" class="btn btn-success" >修改</button>
					<button type="reset" class="btn btn-primary" >重置</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>