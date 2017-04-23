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
	var datas = data.datas;
	var cons = datas[0];
	var messages = datas[1];
	var tbody = $("#tbody");
	tbody.html("");
	for (var i = 0; i <= cons.length; i++) {
		var con = cons[i];
		var conname = con.conname;
		var conid = con.conid;
		var endtime = con.endDate;
		var state = con.state;
		var username=con.username;
		var message = messages[i];
		var tr = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
		tr.children('td').eq(0).html(conname);
		tr.children('td').eq(1).html(endtime);
		tr.children('td').eq(2).html(username);
		tr.children('td').eq(3).html("<a value='"+conid+"' onclick='imgShow(this)'>查看</a>");
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

function getConByWord(){
	var word=$("#keyword").val();
	var userid = $("#userid").val();
	$.ajax({
		type : 'GET',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		url : 'cons/getcons?word=' + word+"&userid="+userid,
		success : function(data) {
			if (data.code == '0000') {
				showCons(data);
			}
		}
	})
}

function imgShow(obj){
	var conid=$(obj).attr("value");
	$.ajax({
		type : 'GET',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		url : 'cons/getimg?conid=' + conid,
		success : function(data) {
			if (data.code == '0000') {
				var imgs=data.datas;
				var tr=$("<tr><td id='page'></td></tr><tr><td id='img'></td></tr>");
				var tb=$("#tbody");
				$("thead").remove();
				tb.html("");
				tb.append(tr);
				$("#img").append("<img src='cons/"+imgs[1]+"'/>");
				for(var i=1;i<imgs.length;i++){
					var a=$("<a value='"+imgs[i]+"' onclick='show(this)'>"+i+"  </a>");
					$("#page").append(a);
				}
				var a=$("<a href='mainshow.jsp' onclick='show()'>    返回  </a>");
				$("#page").append(a);
			}
		}
	})
}
function show(obj){
	var img=$(obj).attr("value");
	$("#img").html("<img src='cons/"+img+"'/>");
}