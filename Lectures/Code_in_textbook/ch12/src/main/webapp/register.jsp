<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
		$.ajax({//提交检查用户名是否可用请求
				//请求路径
				url : "IsUseServlet",
				//请求类型
				type : "post",
				//data表示发送的数据
				data : {
					uname : $("#uname").val()
				},
				//成功响应的结果
				success : function(obj){
					if(obj == "no"){
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
	<form action="RegistServlet" method="post" name="registForm">
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
				<td><input class="textSize" type="password" maxlength="20" name="upass"/></td>
			</tr>
			
			<tr>
				<td>确认密码：</td>
				<td><input class="textSize" type="password" maxlength="20" name="reupass"/></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="button" value="注册" onclick="allIsNull()"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
