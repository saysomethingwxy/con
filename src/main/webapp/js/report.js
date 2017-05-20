var date = new Date();
var curYear = date.getFullYear();
var month=null;
var months=null;
var con=null;
var cons=null;
init();
function init() {
	// 初始化
	month=new Array();
	months=new Array();
	con=new Array();
	cons=new Array();
	$.get("cons/getrep?year=" + curYear, function(data) {
		var obj=jQuery.parseJSON(data).datas;
		var count=obj[0];
		$("#tr1").children('td').eq(1).html("<font color='red' size='12'>"+count+"</font>");
		var conqty=obj[1];
		var conqtys=obj[2];
		for(var i=0;i<conqty.length;i++){
			$("#mon1").children('td').eq(i+1).html(conqty[i].month);
			$("#qty1").children('td').eq(i+1).html(conqty[i].qty);
			$("#mon2").children('td').eq(i+1).html(conqtys[i].month);
			$("#qty2").children('td').eq(i+1).html(conqtys[i].qty);
			month[i]=conqty[i].month;
			months[i]=conqtys[i].month;
			con[i]=conqty[i].qty;
			cons[i]=conqtys[i].qty;
		}
		showDivClient();
		showDivCntInv();
		})
	}
function getYear() {
	var item = $("#tyear").children('td').eq(1).children('select');
	curYear = item.get(0).value;
	init();
}

function showDivClient() {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('c1'));

	// 指定图表的配置项和数据
	var option = {
		color : [ '#3398DB' ],
		title : {},
		tooltip : {},
		legend : {
			data : [ '月完成合同量' ]
		},
		xAxis : {
			data : month
		},
		yAxis : {},
		series : [ {
			name : '月完成合同量',
			type : 'bar',
			data : con
		} ]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}
function showDivCntInv() {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('c2'));

	// 指定图表的配置项和数据
	var option = {
		color : [ '#3398DB' ],
		title : {},
		tooltip : {},
		legend : {
			data : [ '月未完成合同量' ]
		},
		xAxis : {
			data : months
		},
		yAxis : {},
		series : [ {
			name : '月未完成合同量',
			type : 'bar',
			data : cons
		} ]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}
$(function() {
	$(window).ready(
			function() {
				var startYear = 2016;
				var endYear = curYear;
				var optionGrp;
				for (var i = startYear; i <= endYear+3; i++) {
					if (i == curYear) {
						var option = "<option value=" + i + " selected='true'>"
								+ i + "</option>";
					} else {
						var option = "<option value=" + i + ">" + i
								+ "</option>";
					}
					optionGrp += option;
				}
				$("#s").html(optionGrp);
			});
})
