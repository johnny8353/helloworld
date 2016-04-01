/**
* @Name: 
* @Description: 数据列表
* @author huangfuqiang
* @date 2016-3-1 
*/
document.write("<script language=javascript src='"+scriptGlobal.appRoot+"/scripts/extjs/extends/chart.js' charset='utf-8'></script>");

var filedArray = ['年月','登陆十次及以上','登陆五次及以上','登陆三次及以上','登陆一次及以上'];
var dataArray= [filedArray[1],filedArray[2],filedArray[3],filedArray[4]];
var groupCount = 1;
var groupArray = [filedArray[0]];

//var dataModel = Ext.create('Ext.data.Model', {fields : filedArray,idProperty : groupArray[0]});
Ext.define('dataModel', {extend : 'Ext.data.Model',fields : filedArray,idProperty : groupArray[0]});
var readyFunction =function(){
	var store1 = getStore('dataModel','/serverReport/siebel.jssm?method=getPage');
	var backBtn = getBackBtn(),reloadBtn = getReloadBtn(store1,obj);
	var tbar = [backBtn,reloadBtn];
	var columns = new Array();
	columns.push({
			text: filedArray[0],
			flex: 1,//占用全部的剩余宽度
			dataIndex: filedArray[0]
		});
	for(var i = 1;i<filedArray.length;i++)
	{
		columns.push({
			text: filedArray[i],
			width:150,
			//editor: {xtype: 'textfield'},//不设置会只读
			dataIndex: filedArray[i]
		});
	};
	var grid = getGrid(false,store1,columns,"",false,800,400);
	var win = getChartWindow(1000,600,tbar,grid,'siebel服务器用户登陆报表-按月份统计');
	store1.load({params:{obj:obj}});
};
