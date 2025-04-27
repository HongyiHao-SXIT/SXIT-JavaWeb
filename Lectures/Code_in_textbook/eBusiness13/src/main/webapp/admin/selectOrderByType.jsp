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
<script src="static/js/echarts.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">近1年的订单统计</h3>
		</div>
		<div class="panel-body">
			<div id="demo" style="width: '80%'; height: 400px;"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var demo= echarts.init(document.getElementById('demo'));
	var typenames = ${typenames};
	var totalAmount = ${totalAmount};
	var dataList = [];
	for(var i = 0; i < typenames.length; i++){
		dataList[i] = {value: totalAmount[i], name: typenames[i]};
	}
	var option = {
	        title: {
	            text: '按商品分类统计订单',
	            subtext: '单位万元',
	            left: 'center'
	        },
	        tooltip: {
	            trigger: 'item'
	        },
	        legend: {
	            orient: 'vertical',
	            left: 'left'
	        },
	        series: [
	            {
	            name: '订单量',
	            type: 'pie',
	            radius: '50%',
	            data: dataList,
	            emphasis: {
	                itemStyle: {
	                shadowBlur: 10,
	                shadowOffsetX: 0,
	                shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	            }
	        ]
	    };
	demo.setOption(option);
</script>
</body>
</html>