function loadmenu(buttonId){
	$.get("/portal/menus",function(result){
		$('#menu').html(result);
		$(buttonId).attr('class','active');
	});
}

function getUserNameFromToken(){
	var token = $.cookie('g_token');
	if(token == null || token==''){
		return '';
	}
	var userInfoBase64 = token.split('\.')[1];
	var base = new Base64();
	//{"username":"123","userid":"1","remark":"myselfremark","iss":"XHYJ","aud":"clubportal","exp":1520619437,"nbf":1520587901}
	//最后的数据解析导致json失败，故字符串操作删除最后两个字段,下面为删除逻辑
	var tokenbodystr=base.decode(userInfoBase64);
	console.log(tokenbodystr);
	var index = tokenbodystr.lastIndexOf(',');
	var partTokenBodyStr = tokenbodystr.substring(0,index);
	index = partTokenBodyStr.lastIndexOf(',');
	partTokenBodyStr = partTokenBodyStr.substring(0,index)+'}';
	console.log(partTokenBodyStr);
	var tokenBodyObj = JSON.parse(partTokenBodyStr);
	return tokenBodyObj.username;
}