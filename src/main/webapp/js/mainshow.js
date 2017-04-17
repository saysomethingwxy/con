init();
function init() {
	var userid = $("#userid").val();
	var username=$("#username").val();
	$.ajax({
				type : 'GET',
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				url : 'cons/consinfo?userid=' + userid,
				success : function(data) {
					if (data != null) {
						var datas = data.datas;
						var cons = datas[0];
						var messages = datas[1];
						var tbody = $("tbody");
						for (var i = 0; i <= cons.length; i++) {
							var con = cons[i];
							var conname = con.conname;
							var conid = con.conid;
							var endtime = con.endtime;
							var state = con.state;
							var message = messages[i];
							var tr = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
							tr.children('td').eq(0).html(conname);
							tr.children('td').eq(1).html(endtime);
							tr.children('td').eq(2).html(username);
							tr.children('td').eq(3).html(conname);
							tr.children('td').eq(4).html(message.message);
							if (state == 0) {
								tr.children('td').eq(5).html("未执行");
							}
							if (state == 1) {
								tr.children('td').eq(5).html("已执行");
							}
							if (state == 0) {
								tr
										.children('td')
										.eq(6)
										.html(
												"<button value="+conid+" onclick='changeConState(this)' class='btn btn-info'>完成</button>");
							}
							tr.children('td').eq(7).html(conid);
							tbody.append(tr);
						}
					}
				},
				error : function() {
					console.log("请求失败");

				},
			});
}
function changeConState(con) {
	var obj=$(con);
	alert(obj.parent());
	var conid = obj.val();
	$.ajax({
		type : 'GET',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		url : 'cons/endcon?conid=' + conid,
		success : function(data) {
			if(data.code.equals('0000')){
				init();
			}
			}
		})
}