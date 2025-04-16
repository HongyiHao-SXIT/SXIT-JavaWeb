<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<meta charset="UTF-8"> 
<style type="text/css">
	.textSize{
		width: 100pt;
		height: 15pt
	}
</style>
<title>注册画面</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	//输入姓名后，调用该方法，判断用户名是否可用
	function nameIsNull(){
		$.ajax({
			//请求路径
			url : "user/isUse",
			//请求类型
			type : "post",
			//data表示发送的数据
			data : JSON.stringify({uname:$("#uname").val()}),
			//定义发送请求的数据格式为JSON字符串
			contentType : "application/json;charset=utf-8",
			//定义回调响应的数据格式为JSON字符串，该属性可以省略
			//dataType : "json",
			//成功响应的结果
			success : function(data){
				if(data == "no"){
					$("#isExit").html("<font color=red size=5>×</font>");
					alert("用户已存在，请修改！");
				}else{
					$("#isExit").html("<font color=green size=5>√</font>");
					alert("用户可用");
				}
			},
	        error : function() {
	            alert("处理异常！");
	        }
		});
	}
</script>
</head>
<body style="background-image: url('images/bb.jpg');">
	<form action="user/regist" method="post" name="registForm">
		<table>
			<tr>
				<td>姓名：</td>
				<td>
<input class="textSize" type="text" id="uname" name="uname" onblur="nameIsNull()" />
						<span id="isExit"></span>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input class="textSize" type="password" name="upass"/></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input class="textSize" type="password" name="reupass"/></td>
			</tr>
			<tr>
	<td colspan="2" align="center"><input type="submit" value="注册" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
