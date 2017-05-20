<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body background="img/bg1.jpg">
	<div style="background-image: url('img/bg5.png');" class="login">
		<form class="form-horizontal" role="form" action="" method="post" id="logform">
			<div class="log1">
				
			</div>
			<div class="log2">
				<div class="input-group">
					<span class="glyphicon glyphicon-envelope"></span><input id="mail"
						type="text" class="form-control" name="mail" placeholder="邮箱"
						onfocus="changinp(this)" onblur="changehinput(this)">
				</div>
			</div>
			<div class="log3"
				<div class="input-group">
					<span class="glyphicon glyphicon-lock"></span> <input
						style="width: 210px;" id="password" type="password"
						class="form-control" name="password" placeholder="密码"
						onfocus="changinp(this)" onblur="changepsss(this)"><font id="mail1" color="red"></font>
				</div>
			</div>
			<div class="log4">
				<a href="register.jsp" style="text-decoration: none;">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="forget1.html" style="text-decoration: none;">忘记密码？</a>
			</div>
			<div class="log5">
				<input type="button" onclick="checkLog()" class="btn btn-success"
					value="L  O  G  I  N">
					<!--  <input type="submit" onclick="checkLog()" class="btn btn-success"
					value="L  O  G  I  N">-->
			</div>
		</form>
	</div>
</html>