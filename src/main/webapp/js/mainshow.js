init();
function init(){
	var userid=$("#userid").val();
	alert(userid);
	var datas={
			"userid":userid
	};
	$.ajax({  
    	type:'POST',  
    	dataType:"json",
		contentType: "application/json;charset=UTF-8",
      	data: JSON.stringify(datas),
  		url:'cons/consinfo',
 		success:function(data) {
 			alert(datas.msg);
     	},
	});  
}