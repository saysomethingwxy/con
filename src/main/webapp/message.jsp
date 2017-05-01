<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
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
<script src="js/message.js"></script>
<link href="resources/custom.css" rel="stylesheet">

<body background="img/mainbg.jpg">
	<div class="mess1">
		<table  align="center"
			style="border-collapse: separate; border-spacing: 0px 30px; width: 850px;">
			<thead>
				<tr>
					<td>合同名称</td>
					<td>到期时间</td>
					<td>状态</td>
					<td>提醒时间</td>
					<td>提醒信息</td>
					<td>确认提醒</td>
				</tr>
			</thead>
			<tbody id='mess'>
				<tr align="center" id="button">
					<td colspan="3"><input type="button" class="btn btn-warning"
						value="提醒"></td>
				<tr>
			</tbody>
		</table>
	</div>
</body>
</html>