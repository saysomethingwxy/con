<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<body background="img/regiester1.jpg">
<c:if test="${user!=null}">
	<input hidden="true" value="${user.userid }" id="userid">
	
	<div class="reg1">
		<form class="form-horizontal" method="post"
			role="form" id="changeform">
			<table class="table table-striped" style="width: 800px;">
				<tr align="center">
					<td><h3>
							<strong>查看个人设置</strong>
						</h3></td>
				</tr>
			</table>
			<div class="form-group">
			<input hidden="true" value="66" id="userid">
				<label class="col-sm-2 control-label"><font color="red"></font>角色:</label>
				<div class="col-sm-8">
					<input class="form-control" id="focusedInput" type="text"
						value="运营" disabled>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-2 control-label"><font color="red"></font>邮箱:</label>
				<div class="col-sm-8">
					<input class="form-control" value="${user.email}" id="focusedInput" type="text" disabled>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-2 control-label"><font color="red"></font>姓名:</label>
				<div class="col-sm-8">
					<input class="form-control" id="name" type="text" value="${user.username }" disabled><font
						color="red" id="name1"></font>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-2 control-label"><font color="red"></font>性别:</label>
				<div class="col-sm-8">
					<input class="form-control" id="focusedInput" type="text" value="男"
						disabled>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-2 control-label"><font color="red"></font>员工号:</label>
				<div class="col-sm-8">
					<input class="form-control" id="focusedInput" value="${user.userid }" type="text" disabled>
				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-8">
					<p align="center">
						<a href="mainshow.jsp"><input type="button" class="btn btn-info" value="返回"></a>
					<p>
				</div>
			</div>
		</form>
	</div>
	</c:if> 
</body>
</html>