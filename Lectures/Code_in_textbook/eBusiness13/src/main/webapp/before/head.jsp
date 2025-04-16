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
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/jquery-3.6.0.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<style type="text/css">
     .carousel{
         height: 200px;
         background-color: #000;
      }
      .carousel .item{
         height: 200px;
         background-color: #000;
      }
      .carousel img{
         width: 100%;
      }
</style>
</head>
<body>
	<div class="container-fruid">
		<div class="navbar navbar-default navbar-fixed-top" role="navigation"
			style="padding-left: 30px;">
			<div class="navbar-header">
				<span class="navbar-brand">欢迎光临eBusiness</span>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="before/register.jsp">注册</a></li>
				<li>
					<c:if test="${buser == null}">
						<a href="before/login.jsp" >
							<span >
								登录
							</span>
						</a>
					</c:if>
					<c:if test="${buser != null}">
							<a>
								<span>欢迎${buser.bemail}</span>
							</a>
					</c:if>
				</li>
				<li><a href="admin/login.jsp">后台</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right" style="padding-right: 30px;">
				<li><a href="before/userInfo.jsp">个人信息</a></li>
				<li><a href="before_cart?act=select">我的购物车</a></li>
				<li><a href="before_indexMy?act=myFocus">我的收藏</a></li>
				<li><a href="before_indexMy?act=myOrder">我的订单</a></li>
				<li class="dropdown"><a href="##" data-toggle="dropdown"
					class="dropdown-toggle">关于我们<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="##">联系我们</a></li>
						<li><a href="##">投诉建议</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- ************************************************** -->
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel" style="margin-top: 20px;">
			<!-- Indicators 小圆圈-->
			<ol class="carousel-indicators">
				<c:forEach var="advise" varStatus="status" items="${adviseGoods }">
					<c:if test="${status.index == 0 }">
						<li data-target="#carousel-example-generic" 
						data-slide-to="${status.count }" class="active"></li>
					</c:if>
					<c:if test="${status.index != 0 }">
						<li data-target="#carousel-example-generic" 
						data-slide-to="${status.count }"></li>
					</c:if>
				</c:forEach>
			</ol>
			<!-- 滚动广告图片 -->
			<div class="carousel-inner" role="listbox">
				<c:forEach var="advise" varStatus="status" items="${adviseGoods }">
					<c:if test="${status.index == 0 }">
						<div class="item active">
							<a href="before_detail?gno=${advise.id }">
								<img src="static/images/${advise.gpicture }" alt="${status.count }">
							</a>
							<div class="carousel-caption"><span>${advise.gname }</span></div>
						</div>
					</c:if>
					<c:if test="${status.index != 0 }">
						<div class="item">
							<a href="before_detail?gno=${advise.id }">
								<img src="static/images/${advise.gpicture }" alt="${status.count }">
							</a>
							<div class="carousel-caption"><span>${advise.gname }</span></div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- *************************************** -->
		<div class="navbar navbar-default " role="navigation">
			<ul class="nav navbar-nav" style="padding-left: 50px;">
				<li><a href="">首页</a></li>
				<c:forEach var="type" items="${allTypes}">
					<li><a href="before_first?typeid=${type.id }"><span>${type.typename}</span></a></li>
				</c:forEach>
			</ul>
			<form action="before_search" class="navbar-form navbar-right"
				style="padding-right: 50px;">
				<div class="form-group">
					<input type="text" class="form-control" name="mykey" placeholder="请输入关键词" />
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
		</div>
	</div>
</body>
</html>
