/**
* @Name: 
* @Description: 表格基础类
* @author huangfuqiang
* @date 2016-3-1 
*/

Ext.require('Ext.chart.*');
Ext.require(['Ext.Window','Ext.window.*', 'Ext.fx.target.Sprite', 'Ext.layout.container.Fit']);

//变量定义
var bd = Ext.getBody();
var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';//必输*

//报表类型LOV数据
var typeLOVDatas = [
	{"name":"Line","value":"折线图"},
	{"name":"Column","value":"柱形图"},
	{"name":"Area","value":"面积图"},
	{"name":"Pie","value":"饼图"},
	{"name":"Grid","value":"数据列表图"},
	{"name":"Radar","value":"雷达图"}
];
//报表时间粒度LOV数据
var modeLOVDatas = [
	{"name":"Hour","value":"按时"},
	{"name":"Day","value":"按天"},
	{"name":"Week","value":"按周"},
	{"name":"Month","value":"按月"},
	{"name":"Quarter","value":"按季"},
	{"name":"Year","value":"按年"}
];

function getChartWindow(width,height,tbar,chart,title)
{
	var win = Ext.create('Ext.window.Window', {
		width: getGWidth(),
		height: getGHeight(),
//		bodyStyle :'overflow-x:hidden;overflow-y:scroll', //隐藏水平滚动条,显示用overflow-x:visible
		minHeight: 400,
		minWidth: 800,
		hidden: false,
		shadow: false,
		maximizable: true,
//		maximized :true,
		closable :false,
		title: title,
		autoShow: true,
		layout: 'fit',
		tbar: tbar,
		items: chart
	});
	return win;
}

function getStore(dataModel,url,gridDivId){
	// create the Data Store
	var store = Ext.create('Ext.data.Store', {
		pageSize : 5000,
		model : dataModel,
//		remoteSort : true,
		proxy : {
			type : 'ajax',
			url : scriptGlobal.appRoot+url,
			reader : {
				type: 'json',
				root : 'D',
				totalProperty : 'P.T'
			},
			// sends single sort as multi parameter
			simpleSortMode : true
		},
		sorters : [ {
			property : '',
			direction : ''
		} ]
	});
	store.on("load",function(records, operation, success){
		if(store.getCount()>0)
		{
			var grid1 = Ext.getCmp(gridDivId);
//			grid1.getSelectionModel().select(0);
			if(!editRowArray[gridDivId]) {editRowArray[gridDivId]=0;}//第一次load，赋值为0
			grid1.getSelectionModel().select(editRowArray[gridDivId]);//load的时候选中load前选中的行
		}
		if(!success)
		{
			ShowMessageSysError();
		}
	});
	return store;
}



function getBackBtn()
{
	var backBtn = {
		text: '返回',
		handler: function() {
			Ext.MessageBox.confirm(messageBoxTitle, '您确定要返回上一个界面吗?', function(choice){
				if(choice=="yes"){//yes no
					history.go(-1);
				}
			});
		}
	};
	return backBtn;
}

function getReloadBtn(store1,obj)
{
	var reloadBtn = {
		text: '重新加载',
		handler: function() {
			var myMask = new Ext.LoadMask(Ext.getBody(),{msg:msg});
			myMask.show();
			store1.load({params:{obj:obj}});
			myMask.hide();
		}
	};
	return reloadBtn;
}


function getAnimateBtn(chart)
{
	var animateBtn = {
		enableToggle: true,
		pressed: true,
		text: '开启动画',
		toggleHandler: function(btn, pressed) {
			chart.animate = pressed ? { easing: 'ease', duration: 500 } : false;
		}
	};
	return animateBtn;
}


	
	