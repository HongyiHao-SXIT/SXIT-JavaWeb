<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<script src="static/js/common.js"></script>
<script src="static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function refreshCode(){
		document.getElementById("mycode").src = "before_validateCode?t=" + Math.random();
	}
	//登录表单验证
	function checkForm(){
		if(!checkNull($("#bemail").val(), "请输入邮箱！")){
			$("#bemail").focus();
			return false;
		}		
		if(!checkNull($("#bpwd").val(), "请输入密码！")){
			$("#bpwd").focus();
			return false;
		}
		if(!checkNull($("#code").val(), "请输入验证码！")){
			$("#code").focus();
			return false;
		}
		document.myform.submit();
		return true;
	}
</script>
<body>
	<div class="container">
		<div class="bg-primary"  style="width:70%; height: 60px;padding-top: 1px;">
	       <h3 align="center">用户登录</h3>
	   </div>
		<br><br>
		<form action="before_userLogin" name="myform" method="post"  class="form-horizontal" role="form" >
			<div class="form-group has-success">
				<label class="col-sm-2 col-md-2 control-label">邮箱</label>
				<div class="col-sm-4 col-md-4">
					<input type="email" class="form-control" name="bemail" id="bemail" value="${bemail }"
					 placeholder="请输入您的邮箱"/>
				</div>
			</div>
		
			<div class="form-group has-success">
				  <label class="col-sm-2 col-md-2 control-label">密码</label>
				  <div class="col-sm-4 col-md-4">
		  				<input type="password" class="form-control" name="bpwd" id="bpwd"
					 placeholder="请输入您的密码"/>
				  </div>
			 </div>
			 
			 <div class="form-group has-success">
				  <label class="col-sm-2 col-md-2 control-label">验证码</label>
				  <div class="col-sm-4 col-md-5">
				  		<table style="width: 100%">
				  			<tr>
				  				<td><input type="text" class="form-control" name="code" id="code"
					 placeholder="请输入验证码"/></td>
					 			<td>
					 				<img src="before_validateCode" id="mycode">
					 			</td>
					 			<td>
					 				<a href="javascript:refreshCode()">看不清换一张</a>
					 			</td>
				  			</tr>
				  		</table>
				  </div>
			 </div>
			 
			 
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" onclick="checkForm()" class="btn btn-success" >登录</button>
					<button type="reset" class="btn btn-primary" >重置</button>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<font size="6" color="red">
						<span>${errorMessage }</span>
					</font>
				</div>
			</div>
		</form>
	</div>
</body>
</html>