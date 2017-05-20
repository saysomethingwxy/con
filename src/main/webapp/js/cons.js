function iFrameHeight() {
	var ifm = document.getElementById("iframepage");
	var subWeb = document.frames ? document.frames["iframepage"].document
			: ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
		ifm.width = subWeb.body.scrollWidth;
	}
}
function changinp(obj) {
	var input = $(obj);
	input.attr('placeholder', '');
	$("#mail1").text("");

}
function changeinput(obj) {
	var input = $(obj);
	input.attr('placeholder', '搜索合同关键字');
}
function changefinput(obj) {
	var input = $(obj);
	input.attr('placeholder', '搜索用户姓名');
}
function changehinput(obj) {
	var input = $(obj);
	input.attr('placeholder', '邮箱');
}
function changepsss(obj) {
	var input = $(obj);
	input.attr('placeholder', '密码');
}
/**
 * 检验注册表单
 * 
 * @returns {Boolean}
 */
function register() {
	var flag = 1;
	var mail = $("#mail").val();
	if (mail != "" && mail != null) {
		if (mail.match(/[\w-]+@{1}[\w-]+\.{1}\w{2,4}(\.{0,1}\w{2}){0,1}/ig) != mail) {
			$("#mail1").text("邮箱格式不正确！");
			flag = 0;
		}
	} else {
		$("#mail1").text("邮箱不能为空！");
		flag = 0;
	}
	var name = $("#name").val();
	if (name == "" || name == null) {
		$("#name1").text("姓名不能为空！");
		flag = 0;
	}
	var password = $("#password").val();
	if (password != "" && password != null) {
		if (password.length < 6) {
			$("#psd").attr("color", "red");
			$("#psd").text("密码长度不少于6位字符！");
			flag = 0;
		}
	} else {
		$("#psd").attr("color", "red");
		$("#psd").text("密码不能为空！");
		flag = 0;
	}
	var password = $("#password").val();
	if (password != "" && password != null) {
		if (password.length < 6) {
			$("#psd").arrt("color", "red");
			$("#psd").text("密码长度不少于6位字符！");
			flag = 0;
		}
	} else {
		$("#psd").attr("color", "red");
		$("#psd").text("密码不能为空！");
		flag = 0;
	}
	var password1 = $("#password1").val();
	if (password1 != password) {
		$("#psd1").text("重复密码有误！");
		flag = 0;
	}
	var id = $("#id").val();
	if (id == "" || id == null) {
		$("#id1").text("员工号不能为空！");
		flag = 0;
	}
	// var yzm = $("#yzm");
	// check(yzm);
	var code = $("#code").val();
	if (flag == 0) {
		return false;
	}
	var sex = $("input[name='sex'][checked]").val();
	var role = $("input[name='role'][checked]").val();
	var datas = {
		"userid" : id,
		"username" : name,
		"sex" : sex,
		"password" : password,
		"email" : mail,
		"role" : role,
		"code":code
	}
	if (flag == 1) {
		$.ajax({
			type : 'POST',
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(datas),
			url : 'user/regester',
			success : function(data) {
				if (data.code == "1001") {
					$("#mail1").text(data.msg);
				}
				if (data.code == "0000") {
					alert(data.msg);
					window.location.href = "/yonyoucon/login.jsp";
				}
				if (data.code == "9999") {
					$("#mail1").text(data.msg);
				}
			},
			error : function() {
				console.log("请求失败");

			},
		});
	}
}
function clean() {
	$("#mail1").text("");
	$("#name1").text("");
	$("#psd").text("");
	$("#psd1").text("");
	$("#id1").text("");
	$("#yzm").text("");
}
/**
 * 验证码校验
 * 
 * @param obj
 */
function check(obj) {
	var yzm = $(obj).val();
	if (yzm != "" && yzm != null) {
		$.get("url", function(data) {
			var data = "aaaa";
			var yzm = $(obj).val();
			if (yzm != data) {
				$("#yzm").text("验证码错误！");
			}
		});
	} else {
		$("#yzm").text("验证码不能为空！");
	}
}
function cleancheck(obj) {
	$(obj).val("");
	$("#yzm").text("");
}
/**
 * 登录校验
 * 
 * @returns {Boolean}
 */
function checkLog() {
	var flag = 1;
	var mail = $("#mail").val();
	if (mail == "" || mail == null) {
		flag = 0;
	}
	var password = $("#password").val();
	if (password == "" || password == null) {
		flag = 0;
	}
	if (flag == 0) {
		$("#mail1").text("邮箱和密码不能为空！");
	}
	var datas = {
		"userid" : mail,
		"password" : password
	}
	if (flag == 1) {
		$.ajax({
			type : 'POST',
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(datas),
			url : 'user/login',
			success : function(data) {
				if (data.code == "1001") {
					$("#mail1").text(data.msg);
				}
				if (data.code == "0000") {
					window.location.href = "/yonyoucon/mainshow.jsp";
				}
				if (data.code == "9999") {
					$("#mail1").text(data.msg);
				}
			},
			error : function() {
				console.log("请求失败");

			},
		});
	}
}
/**
 * 合同校验
 */
function checkCons() {
	var flag = 1;
	var id = $("#conid").val();
	var name = $("#conname").val();
	var com = $("#concom").val();
	var time = $("#time").val();
	var endtime = $("endtime").val();
	var con = $("#cons").val();
	var pson1 = $("#person1").val();
	var pson2 = $("#person2").val();
	var tip = $("#tip");
	if (id == 0 || name == "" || com == "" || time == "" || time == ""
			|| endtime == "" || con == "" || pson1 == "" || pson2 == "") {
		flag = 0;
	}
	if (flag == 0) {
		tip.text("本页全部为必填项！");
		return false;
	}
	if (flag == 1) {
		alert(111);
		window.location.href = "/yonyoucon/mainshow.jsp";
		document.getElementById('form').submit();
	}
}
/**
 * 校验修改设置
 */
function checkChange() {
	var flag = 0;
	var userid = $("#userid").val();
	var name = $("#name").val();
	var name1 = $("#name1");
	if (name == null || name == "") {
		name1.text("姓名不能为空！");
	} else {
		flag = 1;
	}
	var datas = {
		"userid" : userid,
		"username" : name
	}
	if (flag == 1) {
		$.ajax({
			type : 'POST',
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(datas),
			url : 'user/change',
			success : function(data) {
				if (data.code == "1001") {
					name1.text(data.msg);
				}
				if (data.code == "0000") {
					window.location.href = "/yonyoucon/mainshow.jsp";
				}
				if (data.code == "9999") {
					name1.text(data.msg);
				}
			},
			error : function() {
				console.log("请求失败");

			},
		});
	}
}

function getCode(){
	var mail = $("#mail").val();
	$.ajax({
		type : 'GET',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		url : 'user/getcode?email='+mail,
		success : function(data) {
			if (data.code == "0000") {
				alert(data.msg);
			}
			if (data.code == "9999") {
				alert(data.msg);
			}
		},
		error : function() {
			console.log("请求失败");
		},
	});
}
