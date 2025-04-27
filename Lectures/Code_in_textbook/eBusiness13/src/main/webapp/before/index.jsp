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
<title>主页</title>
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
</script>
</head>
<body>
	<!-- 加载header.jsp -->
	<jsp:include page="head.jsp"/>
	<div class="container">
		<div>
			<h4>最新商品</h4>
		</div>
		<div class="row">
			<c:forEach var="lasted" items="${lastedGoods }">
				<div class="col-xs-6 col-md-2">
					<a href="before_detail?gno=${lasted.id }" class="thumbnail"> 
						<img  src="static/images/${lasted.gpicture }" style="height: 170px; width: 100%; display: block;">
					</a>
					<div class="caption" style="text-align: center;">
						<div>
							<span>${lasted.gname }</span>
						</div>
						<div>
							<span style="color: red;">&yen;
								<span>${lasted.grprice }</span>
							</span>
							<span class="text-dark" style="text-decoration: line-through;"> &yen;
								<span>${lasted.goprice }</span>
							</span>
						</div>
						<a href="javascript:focus(${lasted.id })" class="btn btn-primary" style="font-size: 10px;">加入收藏</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
