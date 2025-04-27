<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>注册页面</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/jquery-3.6.0.min.js"></script>
<script src="static/js/common.js"></script>
<script type="text/javascript">
	function checkEmail(bemail){
		if(checkNull(bemail, "请输入邮箱！")){
			$.ajax({//提交检查用户名是否可用请求
				//请求路径
				url : "before_register",
				//请求类型
				type : "post",
				//data表示发送的数据
				data : "bemail=" + bemail + "&&flag=1",
				//成功响应的结果
				success : function(obj){
					$("#isExit").html(obj);
				},
		        error : function() {
		            alert("处理异常！");
		        }
			});
		}
	}
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
	       <h3 align="center">用户注册</h3>
	   </div>
		<br><br>
		<form action="before_register?flag=0" name="myform" method="post"  class="form-horizontal" >
			<div class="form-group has-success">
				<label class="col-sm-2 col-md-2 control-label">邮箱</label>
				<div class="col-sm-4 col-md-4">
					<table style="width:100%">
						<tr>
							<td><input type="email" name="bemail" id="bemail" class="form-control"
					 placeholder="请输入您的邮箱"  onblur="checkEmail(this.value)"/></td>
					 		<td>
					 			<span id="isExit"></span>
					 		</td>
						</tr>
					</table>
				</div>
			</div>
	
			<div class="form-group has-success">
				  <label class="col-sm-2 col-md-2 control-label">密码</label>
				  <div class="col-sm-4 col-md-4">
		  				<input type="password" class="form-control" name="bpwd" id="bpwd"
					 placeholder="请输入您的密码" />
				  </div>
			 </div>
	
			<div class="form-group has-success">
				  <label class="col-sm-2 col-md-2 control-label">确认密码</label>
				  <div class="col-sm-4 col-md-4">
		  				<input type="password" class="form-control" name="rebpwd" id="rebpwd"
					 placeholder="请输入您的密码"/>
				  </div>
			 </div>
	
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" onclick="checkBpwd()" class="btn btn-success" >注册</button>
					<button type="reset" class="btn btn-primary" >重置</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>