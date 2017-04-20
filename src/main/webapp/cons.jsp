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
<script src="js/Contract.js"></script>
<link href="resources/custom.css" rel="stylesheet">

<body name="main" background="img/mainbg.jpg">
	<div class="newcon">
		<font color="red" face="黑体"><h1>新合同录入</h1></font> </span><br> <font
			id="tip" color="red"></font>
	</div>
	<div class="cons2">
		<form action="cons/addcon" enctype="multipart/form-data" method="post"
			id="conform">
			<table
				style="border-collapse: separate; border-spacing: 0px 30px; width: 600px;">
				<tr align="center">
					<td>合同编号：</td>
					<td><input type="text" class="form-control" name="conid"></td>
				</tr>
				<tr align="center">
					<td>合同名称：</td>
					<td><input type="text" class="form-control" name="conname"></td>
				</tr>
				<tr align="center">
					<td>合作公司：</td>
					<td><input type="text" class="form-control" name="company"></td>
				</tr>
				<tr align="center">
					<td>签署时间：</td>
					<td><input type="text" class="form-control" name="starttime"></td>
				</tr>
				<tr align="center">
					<td>到期时间：</td>
					<td><input type="text" class="form-control" name="endtime"></td>
				</tr>
				<tr align="center">
					<td>合同详细：</td>
					<td><a href="javascript:;" class="file">选择文件 <input
							type="file" name="f1">
					</a> <a href="javascript:;" class="file">选择文件 <input type="file"
							name="f2">
					</a>
						<h6 align="right" onclick="addLine(this)">
							<font color="a0a0a0">点击继续添加</font></a></td>
				</tr>
				<tr align="center">
					<td>合同负责人：</td>
					<td><input type="text" class="form-control" name="uname"
						id="person1"></td>
				</tr>
				<tr align="center">
					<td>合同签署人：</td>
					<td><input type="text" class="form-control" name="username"
						id="person2"></td>
				</tr>
				<tr align="center">
					<td>合同状态：</td>
					<td><input type="radio" name="state" checked="checked"
						value="0">未执行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="radio" name="state" value="1">已执行</td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" class="btn btn-info"
						value="确认提交" onclick="checkCons()"></td>
				</tr>
			</table>
		</form>
	</div>

</body>

</html>