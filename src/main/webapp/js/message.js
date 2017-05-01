init();
function init() {
	var userid = $("#userid").val();
	$.ajax({
		type : 'GET',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		url : 'mess/getmess?userid=' + userid,
		success : function(data) {
			if (data != null) {
				showCons(data);
			}
		},
		error : function() {
			console.log("请求失败");

		},
	});
}

function showCons(data) {
	var datas = data.datas;
	var role = $("#role").val();
	var messages = datas[0];
	var cons = datas[1];
	var tbody = $("#mess");
	tbody.html("");
	for (var i = 0; i <= cons.length; i++) {
		var con = cons[i];
		var msg = messages[i];
		var conname = con.conname;
		var conid = con.conid;
		var endtime = con.endDate;
		var state = con.state;
		var username = con.username;
		var message = msg.message;
		var date = msg.date;
		var uid = msg.uid;
		if (state == 0) {
			var tr = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
			tr.children('td').eq(0).html(conname);
			tr.children('td').eq(1).html(endtime);
			tr.children('td').eq(2).html("未执行");
			tr.children('td').eq(3).html(date);
			if (role != '0') {
				tr.children('td').eq(4).html("<input type='text' value='"+message+"'/>");
				tr
						.children('td')
						.eq(5)
						.html(
								"<button lang='"+conid+"' name='"+uid+"' class='btn btn-warning' onclick='newMsg(this)'>确认提醒</button>");
			} else {
				tr.children('td').eq(4).html("<font color='red'>"+message+"</font>");
				tr.children('td').eq(5).html("//");
			}
		}
		tbody.append(tr);
	}
}

function newMsg(obj) {
	var msg = $(obj);
	var userid = $("#userid").val();
	var cid=msg.attr("lang");
	var uid=msg.attr("name");
	var message=msg.parent().prev().children("input").eq('0').val();
	var datas={
		"message":message,	
		"uid":uid,
		"userid":userid,
		"cid":cid,
		"type":"mess"
	};
	$.ajax({
		type : 'POST',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(datas),
		url : 'mess/addmess',
		success : function(data) {
			if (data.code == "0000") {
				alert(data.msg);
				init();
			}
		},
		error : function() {
			console.log("请求失败");

		},
	});
}