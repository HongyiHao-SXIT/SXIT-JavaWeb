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
	var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ${months},
            axisTick: {
                alignWithLabel: true
            }
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
            data: ${totalAmount},
            type: 'bar',
            name: '销量（万元）',
            }
        ]
    };
	demo.setOption(option);
</script>
</body>
</html>