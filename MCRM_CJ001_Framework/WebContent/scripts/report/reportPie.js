/**
* @Name: 
* @Description: 饼图
* @author huangfuqiang
* @date 2016-3-1 
*/
document.write("<script language=javascript src='"+scriptGlobal.appRoot+"/scripts/extjs/extends/chart.js' charset='utf-8'></script>");

var filedArray = ['年月','登陆十次及以上','登陆五次及以上','登陆三次及以上','登陆一次及以上'];
var dataArray= [filedArray[1],filedArray[2],filedArray[3],filedArray[4]];
var groupCount = 1;
var groupArray = [filedArray[0]];

Ext.define('dataModel', {extend : 'Ext.data.Model',fields : filedArray,idProperty : groupArray[0]});
		
var readyFunction =function(){
	var store1 = getStore('dataModel','/serverReport/siebel.jssm?method=getPage');
	var chart = getChart(store1,dataArray,groupArray);
	var backBtn = getBackBtn(),reloadBtn = getReloadBtn(store1,obj),animateBtn = getAnimateBtn(chart);
	var donutBtn = {
		enableToggle: true,
		pressed: false,
		text: '圆环图',
		toggleHandler: function(btn, pressed) {
			chart.series.first().donut = pressed ? 35 : false;
			chart.refresh();
		}
	};
	var pie2Btn = {
		enableToggle: true,
		pressed: false,
		text: '玫瑰图',
		toggleHandler: function(btn, pressed) {
			chart.series.first().angleField = pressed ?dataArray[0]:false;
			chart.series.first().lengthField = pressed ?dataArray[0]:false;
			chart.refresh();
		}
	};
	var changeBtn = {
		enableToggle: true,
		pressed: false,
		text: '图',
		toggleHandler: function(btn, pressed) {
			chart.series.first().donut = pressed ? 35 : false;
			chart.refresh();
		}
	};
	var tbar = [backBtn,reloadBtn , animateBtn,donutBtn,pie2Btn];
	var win = getChartWindow('100%','100%',tbar,chart,'siebel服务器用户登陆报表-按月份统计');
	store1.load({params:{obj:obj}});
};


function getChart(store1,dataArray,groupArray)
{
	var chart = Ext.create('Ext.chart.Chart', {
		xtype: 'chart',//
		insetPadding: 40,//
		theme: 'Base:gradients',//
		style: 'background:#fff',
		animate: true,
		store: store1,
		legend: {
			position: 'right'//图例相对于图表的相对位置。比如: "top", "bottom", "left", "right", 或者 "float". 如果设置为"float", 图例根据x和y参数表示的位置来显示。
		},
		series: [getSeries(store1,groupArray,dataArray[0])]
	});
	return chart;
	
}

function getSeries(store1,groupArray,data)
{
	var series = {
		type: 'pie',
		field: data,
		showInLegend: true,
		animate: true,
		donut: false,
		tips: {
		  trackMouse: true,
		  width: 140,
		  height: 28,
		  renderer: function(storeItem, item) {
			//calculate percentage.
			var total = 0;
			store1.each(function(rec) {
				total += rec.get(data);
			});
			this.setTitle(storeItem.get(groupArray[0]) + ': ' + Math.round(storeItem.get(data) / total * 100) + '%');
		  }
		},
		highlight: {
		  segment: {
			margin: 20
		  }
		},
		label: {
			field: groupArray[0],
			display: 'rotate',
			contrast: true,
			font: '18px Arial'
		}
	};
	return series;
}