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
	<div class="friend1">
		<table style="border-collapse: separate; border-spacing: 15px 30px; width: 300px;">
			<tr align="center">
				<th colspan="3">好友请求</th>
			</tr>
			<tr align="center">
				<td><img width="80px" src="img/tx2.jpg" class="img-circle"></td>
				<td>姓名xxx</td>
				<td><a class="btn btn-success">同意</a></td>
			</tr>
		</table>
	</div>
	<div class="friend2">
		<table style="border-collapse: separate; border-spacing: 0px 30px; width: 500px;">
			<tr align="center">
				<td colspan="3"><input type="text" name="search"
					onfocus="changinp(this)" onblur="changefinput(this)"
					class="form-control" placeholder="搜索用户姓名" style="width: 350px;"></td>
				<td><button class="btn btn-success">
						<span class="glyphicon glyphicon-search"></span>
					</button></td>
			</tr>
			<tr align="center">
				<td><img width="80px" src="img/tx2.jpg" class="img-circle"></td>
				<td>姓名xxx</td>
				<td>部门xxx</td>
				<td><a class="btn btn-info">添加</a></td>
			</tr>
		</table>
	</div>
	<div class="friend3">
		<table style="border-collapse: separate; border-spacing: 15px 30px; width: 200px;">
			<tr align="center">
				<th colspan="2">我的好友</th>
			</tr>
			<tr align="center">
				<td><img width="80px" src="img/tx2.jpg" class="img-circle"></td>
				<td>姓名xxx</td>
			</tr>
		</table>
		</td>
	</div>
</body>
</html>