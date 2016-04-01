/**
 * 
* @Name: common.js
* @Description:  系统公共基础类
* @author huangfuqiang
* @date 2016-2-27 
*
 */
Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.toolbar.Paging',
    'Ext.ModelManager',
    'Ext.tip.QuickTipManager'
]);
Ext.Loader.setConfig({
    enabled: true
});

//定义变量
var displayMsg = '显示第 {0} 条到 {1} 条记录，一共 {2} 条';//分页拦显示信息
var emptyMsg = "对不起，没有记录可以显示";//没有数据提示信息
var msg = '正在请求数据，请稍侯……';//加载数据时提示信息
var messageBoxTitle = "提示信息";
var systemErrorText = '服务器发生错误，请联系管理员！';
var requestErrorText = 'ZTE-102-REQ：';
var timeoutErrorText = '请求超时或网络故障！';

var editRowArray = new Array();//存储编辑行
//定义键值对state Model
Ext.define('State', {
	extend: 'Ext.data.Model',
	fields: [
		{type: 'string', name: 'name'},
		{type: 'string', name: 'value'}
	]
});

var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
	clicksToMoveEditor: 1,
	autoCancel: false
});
var cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
	clicksToEdit: 1
});

//弹出系统出错框
function ShowMessageSysError()
{
	Ext.MessageBox.show({
	   title: messageBoxTitle,
	   msg: systemErrorText,
	   buttons: Ext.MessageBox.OK,
	   //animateTarget: 'grid',
	   //fn: showResult,
	   icon: Ext.MessageBox.ERROR
	});
}
	
function getGrid(tbar,store,columns,gridRendDivId,gridTitle,width,height)
{
	var grid = Ext.create('Ext.grid.Panel', {
		id:gridRendDivId,
		width: width,
		height:height,
		title: gridTitle,
		store: store,
		//disableSelection: true,
		loadMask: true,
		autoScroll:true,
		autoExpandColumn : 'desc',
		columnLines: true,
		viewConfig: {
			enableTextSelection: true,
			stripeRows: true
		},
		selModel: {
            selType: 'rowmodel'
        },
		// grid columns
		columns:columns,
		// paging bar on the bottom
		bbar: getBbar(store),
		renderTo: gridRendDivId,
//		plugins: [rowEditing],
        tbar:tbar
	});
	
	return grid;
}

function getBbar(store){
	var bbar = Ext.create('Ext.PagingToolbar', {
		store: store,
		displayInfo: true,
		displayMsg: displayMsg,
		emptyMsg: emptyMsg
	});
	var refreshBtn = bbar.items.items[10];  //隐藏掉Ext自带刷新图标
	if(refreshBtn != undefined)
		refreshBtn.hide();
	return bbar;
};

function getGHeight(){
	var height = 400;
	var eastDiv = parent.document.getElementById("east-panel");
	if(eastDiv!=null){
		height = eastDiv.offsetHeight-46;
	}
	return height;
}

function getGWidth(){
	var width = 800;
	var eastDiv = parent.document.getElementById("east-panel");
	if(eastDiv!=null){
		width = eastDiv.offsetWidth-25;
	}
	return width;
}

function getLocalCombo(label,store,name,defaultName){
	var combo = {
		xtype:'combo',
		fieldLabel: label,
		displayField: 'value',
		valueField: 'name',
		value:defaultName,
		forceSelection: true,  //必须从下拉框中选择一个值
		store: store,
		queryMode: 'local',
		margin:5,
		allowBlank: false,
		name: name+'Name',
		id:name+'Id',
		columnWidth: 0.5
	};
	return combo;
}

function getLocalStore(data){
	var store =  Ext.create('Ext.data.Store', {
		autoDestroy: true,
		model: 'State',
		data: data
	});
	return store;
}