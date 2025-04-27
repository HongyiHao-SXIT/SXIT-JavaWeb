<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>商品详情</title>
<script type="text/javascript">
	function focus(gid){
		$.ajax({
			//请求路径
			url : "before_focus",
			//请求类型
			type : "post",
			//data表示发送的数据
			data : "gno=" + gid,
			//成功响应的结果
			success : function(obj){
				alert(obj);
			},
	        error : function() {
	            alert("处理异常！");
	        }
		});
	}
	function putCart(){
		if(!(/(^[1-9]\d*$)/.test($("#buyNumber").val()))){
			alert("购买量请输入正整数!");
			$("#buyNumber").focus();
			return;
		}
		if(parseInt($("#buyNumber").val()) > parseInt($("#gstore").text())){
			alert("购买量超出库存!");
			$("#buyNumber").focus();
			return;
		}
		//获取路径
		var pathName=window.document.location.pathname;
		//截取，得到项目名称
		var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		window.location.href = projectName + "/before_cart?act=put&goodstable_id=" +  $("#gid").val() + "&shoppingnum=" + $("#buyNumber").val();
	}
</script>
</head>
<body>
	<!-- 加载header.jsp -->
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-3">
				<img src="static/images/${goods.gpicture }"
					style="height: 220px; width: 280px; display: block;">
			</div>
			<div class="col-xs-6 col-md-3">
				<p>商品名：<span>${goods.gname }</span></p>
				<p>
					商品折扣价：<span style="color: red;">&yen;
						<span>${goods.grprice }</span>
					</span>
				</p>
				<p>
					商品原价：
					<span class="text-dark" style="text-decoration: line-through;"> &yen;
						<span>${goods.goprice }</span>
					</span>
				</p>
				<p>
					商品类型：<span>${goods.typename }</span>
				</p>
				<p>
					库存：<span id="gstore">${goods.gstore }</span>
				</p>
				<p>
					<input type="text" size="12" class="form-control" placeholder="请输入购买量" id="buyNumber" name="buyNumber"/>
					<input type="hidden" name="gid" id="gid" value="${goods.id}"/>
				</p>
				<p>
					<a href="javascript:focus(${goods.id})" class="btn btn-primary"
						style="font-size: 10px;">加入收藏</a>
					<a href="javascript:putCart()" class="btn btn-success"
						style="font-size: 10px;">加入购物车</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>