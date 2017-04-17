init();
function init() {
	var userid = $("#userid").val();
	$.ajax({
		type : 'GET',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		url : 'cons/consinfo?userid=' + userid,
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
	var username = $("#username").val();
	var datas = data.datas;
	var cons = datas[0];
	var messages = datas[1];
	var tbody = $("tbody");
	for (var i = 0; i <= cons.length; i++) {
		var con = cons[i];
		var conname = con.conname;
		var conid = con.conid;
		var endtime = con.endDate;
		var state = con.state;
		var message = messages[i];
		var tr = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
		tr.children('td').eq(0).html(conname);
		tr.children('td').eq(1).html(endtime);
		tr.children('td').eq(2).html(username);
		tr.children('td').eq(3).html("查看");
		//添加新合同同时插入提醒信息
		tr.children('td').eq(4).html(message.message);
		if (state == 0) {
			tr.children('td').eq(5).html("未执行");
			tr
					.children('td')
					.eq(6)
					.html(
							"<button value="
									+ conid
									+ " onclick='changeConState(this)' class='btn btn-info'>完成</button>");
		}
		if (state == 1) {
			tr.attr("bgcolor","#e0e0e0");
			tr.children('td').eq(5).html("已执行");
			tr.children('td').eq(6).html("\\");
		}
		tbody.append(tr);
	}
}
function changeConState(con) {
	var obj = $(con);
	var conid = obj.val();
	$.ajax({
		type : 'GET',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		url : 'cons/endcon?conid=' + conid,
		success : function(data) {
			if (data.code == '0000') {
				obj.parent().parent().attr("bgcolor","#e0e0e0");
				obj.parent().html("\\");
			}
		}
	})
}