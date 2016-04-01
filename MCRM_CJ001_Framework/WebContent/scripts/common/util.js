/**
* @Name: util.js
* @Description: 工具基础类
* @author huangfuqiang
* @date 2016-3-1 
*/
function getQueryParam(name) {
	var regex = RegExp('[?&]' + name + '=([^&]*)');
	var match = regex.exec(location.search) || regex.exec(path);
	return match && decodeURIComponent(match[1]);
}

function ShowMessage(msg)
{
	Ext.MessageBox.show({
	   title: '提醒',
	   msg: msg,
	   buttons: Ext.MessageBox.OK,
	   //animateTarget: 'grid',
	   //fn: showResult,
	   icon: Ext.MessageBox.ERROR
	});
}

//根据form的id获取form下的组件并拼接
function getIdItem(id){
	var ret = "";
	var comp = Ext.getCmp(id);
	
	if(comp){
		var compitem = comp.items.items[0].items.items;//container
		var idArray = new Array(0);
		for(var j=0;j<compitem.length;j++){
			var compitem2 = compitem[j].items.items;//具体组件
			for(var k=0;k<compitem2.length;k++){
				idArray.push(compitem2[k].id);
			}	
		}

		for(var j=0;j<idArray.length;j++){
			var id = idArray[j];
			var value = extGetValue(id);
			var name = extGetLabel(id);
			ret += "{";
			ret += "'id':'"+id+"',"+"'text':'"+jsonEncode(name) +"',"+"'value':'"+jsonEncode(value.toString())+"'";
			ret +="}";
			if(j!=idArray.length-1){
				ret+=",";
			}
		}
	}
	return ret;
}
	
function extGetValue(id){
	var cmp = Ext.getCmp(id);
	if(cmp){
		var value = jsonEncode(Ext.getCmp(id).getValue());
		return value;
	}else if(Ext.get(id)){
		return jsonEncode(Ext.get(id).getValue());
	}
	return "";
}
function extGetRowValue(id){
	var cmp = Ext.getCmp(id);
	if(cmp){
		var value = jsonEncode(Ext.getCmp(id).getRawValue());
		return value;
	}else if(Ext.get(id)){
		return jsonEncode(Ext.get(id).getRawValue());
	}
	return "";
}

function extGetName(id){
	var cmp = Ext.getCmp(id);
	if(cmp){
		var value = jsonEncode(Ext.getCmp(id).getName());
		return value;
	}else if(Ext.get(id)){
		return jsonEncode(Ext.get(id).getName());
	}
	return "";
}

function extGetLabel(id){
	if(Ext.getCmp(id)){
		var value = Ext.getCmp(id).fieldLabel;
		return value;
	}else if(Ext.get(id)){
		return Ext.get(id).fieldLabel;
	}
	return "";
	
}

//根据显示值获取name
function getStateNamebyValue(states,val){
	for(var j=0;j<states.length;j++){
		var id = states[j];
		var name = states[j].name;
		var value = states[j].value;
		if(val==value){
			return name;
		}
	}
	return "";
}


function jsonDecode(str){
	if(str==""||str==undefined){
		return "";
	}
	return str.toString().replace(/&quot0;/g,"\\").replace(/&quot1;/g,"'").replace(/&quot2;/g,"\"").replace(/&quot3;/g,"%");
}

function jsonEncode(str){
	if(str==""||str==undefined){
		return "";
	}
	return str.toString().replace(/\\/g,"&quot0;").replace(/'/g,"&quot1;").replace(/"/g,"&quot2;").replace(/%/g,"&quot3;");
}


function SyncRequest(url){
	Ext.Ajax.request({
		url: scriptGlobal.appRoot+url,
		params: { 'obj': ''},
		async: false,   //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
		method: 'POST',
		success: function (response, options) {
			var json = eval("("+decodeURIComponent(response.responseText)+")");
			var status = json.S;//true
			var message = json.errorMsg?json.errorMsg:json.M;
			if(status=="true")
			{
			}
			else
			{
				Ext.Msg.alert(messageBoxTitle, requestErrorText + message);
			}
		},
		failure: function (response, options) {
			Ext.Msg.alert(messageBoxTitle, requestErrorText + response.status);
		}
	});
}

/**
 * 文本框下拉框，搜索时拼接record，回车时调用
 * data 数据
 * columns 列定义数组
 * searchValue 搜索框的值
 */
var getSelectedJson = function(data,columns){
	var json = '{';
	for(var i=0;i<columns.length;i++){
		var name = columns[i].dataIndex;
		json+=name+":";
		if(data[name]){
			var date = formatDate(data[name]);//0NaN-NaN-NaN NaN:NaN:NaN
			if(date!="0NaN-NaN-NaN NaN:NaN:NaN")//时间类型
			{
				data[name] = date;
			}
			json+="'"+data[name]+"'";
		}else{
			json+="''";
		}
		if(i!=columns.length-1) json+=",";
	}
	json+='}';
	return json;
};

function formatDate(fieldValue){
	return Ext.util.Format.date(fieldValue, 'Y-m-d H:i:s');//默认格式Ymd
}