<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<!-- Graph CSS -->
<link href="resources/css/lines.css" rel='stylesheet' type='text/css' />
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link href="resources/css/div.css" rel="stylesheet">
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<script src="js/echarts.js"></script>
<script src="js/cons.js"></script>
<link href="resources/custom.css" rel="stylesheet">

<body background="img/mainbg.jpg">
	<iframe name="content_frame" marginwidth=0 marginheight=0 width=100%
		height=80 src="head.html" frameborder=0 scrolling="no"> </iframe>

	<div class="mess1">
		<form action="mainshow.html" method="post">
			<table align="center"
				style="border-collapse: separate; border-spacing: 0px 30px; width: 600px;">
				<thead>
					<tr align="center">
						<td>合同名称</td>
						<td>选择需要提醒好友</td>
						<td>备注信息</td>
					</tr>
				</thead>
				<tbody>
					<tr align="center">
						<td>《合同1》</td>
						<td>。。。</td>
						<td>。。。</td>
					</tr>
					<tr align="center">
						<td colspan="3"><input type="button" class="btn btn-warning"
							value="提醒"></td>
					<tr>
				</tbody>
			</table>
		</form>
	</div>
	<div class="mess2">
		<table align="center"
			style="border-collapse: separate; border-spacing: 0px 30px; width: 600px;">
			<thead>
				<tr align="center">
					<td>合同名称</td>
					<td>被提醒好友</td>
					<td>备注信息</td>
					<td>时间</td>
				</tr>
			</thead>
			<tbody>
				<tr align="center">
					<td>《合同1》</td>
					<td>研发经理</td>
					<td>执行</td>
					<td>2016-08-09</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>