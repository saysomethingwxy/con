var i=0;
function addLine(obj){
	var font=$(obj);
	var img=$("<a href='javascript:;' class='file'>选择文件 <input type='file' name='"+i+"'> </a>");
	i=i+1;
	font.before(img);
}