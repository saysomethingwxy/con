<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用友电子合同平台</title>
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
<body>
<c:if test="${user!=null}">
	<input hidden="true" value="${user.userid }" id="userid">
	<input hidden="true" value="${user.role }" id="role">
	</c:if>
	<div class="head1" style="background-color: white">
		<div class="head2">
			<img src="img/logo.png">
		</div>
		<div class="head3">
			<a href="mainshow.jsp" target="main"><img src="img/mycons.png"
				width="70%"></a>
		</div>
		<div class="head4">
			<a href="cons.jsp" target="main"><img src="img/cons.png"
				width="60%"></a>
		</div>
		<div class="head5">
			<a href="message.jsp" target="main"><img src="img/message1.png"
				width="52%"></a>
		</div>
		<div class="head6">
			<a href="firends.jsp" target="main"><img src="img/friends1.png"
				width="51%"></a>
		</div>
		<div class="head7">
			<img width="50px" src="img/me.jpg" class="img-circle"><a href="login.jsp" class="a" style="text-decoration: none;"
				target="main">退出登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="change.jsp" target="main" class="a" style="text-decoration: none;">查看设置</a>
		</div>
	</div>
</body>
</html>