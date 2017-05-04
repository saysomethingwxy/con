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
<body background="img/forget.jpg">
	<div style="background-image: url('img/forbg.jpg');" class="for1">
		<div class="log2">
			<div class="input-group">
				邮&nbsp;箱：<input id="mail" class="form-control" type="text" onblur="changinp()">
			</div>
		</div>
		<div class="log3">
			<div class="input-group">
				验证码:<input id="code" class="form-control" type="text" onblur="changinp()">
			</div>
			<br>

			<div>
				<a href="forget2.html" class="btn btn-info">下一步</a> <a
					href="login.html" class="btn btn-info">取消</a>
			</div>
		</div>

	</div>
</body>
</html>