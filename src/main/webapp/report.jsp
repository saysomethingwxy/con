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
<script src="js/report.js"></script>
<link href="resources/custom.css" rel="stylesheet">

<body name="main" background="img/mainbg.jpg">
<div class="rep">
<table>
<tr align="center"><td><img src="img/repo.png" width="60%"/></td></tr>
</table><br><br>
<table>
<tr align="left" id="tr1"><td><img src="img/re1.png" width="50%"/> </td><td></td></tr>
</table><br><br>
<table style="width: 500px">
				<tr id="tyear">
					<td><h4>
							<span class="glyphicon glyphicon-search"></span>查看报表年份:
						</h4></td>
					<td><select id="s" style="width: 100px; height: 30px"
						onchange="getYear()">
					</select></td>
				</tr>
			</table><br><br>
			按月份 完成量：
			<table class="table table-striped">
			<tr id="mon1"><td>月份</td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr id="qty1"><td>合同量</td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			</tr>
			</table>
			<div id="c1" style="width: 600px; height: 400px"></div>
			按月份未完成量：
			<table class="table table-striped">
			<tr id="mon2"><td>月份</td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr id="qty2"><td>合同量</td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			</tr>
			</table>
			<div id="c2" style="width: 600px; height: 400px"></div>
</div>

</body>
</html>