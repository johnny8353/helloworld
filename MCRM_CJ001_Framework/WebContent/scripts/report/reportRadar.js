/**
* @Name: 
* @Description: 雷达图
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
	var chart = getChart(store1,dataArray,groupArray,false);
	var backBtn = getBackBtn(),reloadBtn = getReloadBtn(store1,obj),animateBtn = getAnimateBtn(chart);
	var toggleBtn = {
		enableToggle: true,
		pressed: false,
		text: '阴影效果 ',
		toggleHandler: function(btn, pressed) {
			win.close();
			toggleBtn.pressed = pressed;
			chart = pressed ? getChart(store1,dataArray,groupArray,true):getChart(store1,dataArray,groupArray,false);
			tbar = [backBtn,reloadBtn , animateBtn,toggleBtn];
			win = getChartWindow(1000,600,tbar,chart,'siebel服务器用户登陆报表-按月份统计');
		}
	};
	var tbar = [backBtn,reloadBtn , animateBtn,toggleBtn];
	var win = getChartWindow(1000,600,tbar,chart,'siebel服务器用户登陆报表-按月份统计');
	store1.load({params:{obj:obj}});
};



function getChart(store1,dataArray,groupArray,fillFlag)
{
	var chart = Ext.create('Ext.chart.Chart', {
		style: 'background:#fff',
		animate: true,
		store: store1,
		theme: 'Category2',//要使用的主题名称.主题定义的颜色和其他显示的轴上的刻度标记，文本，标题文本，线的颜色，标记颜色和风格等。 主题的值可以为'Base', 'Green'，'Sky', 'Red', 'Purple', 'Blue', 'Yellow'和六个类别主题从'Category1' 到 'Category6'。 默认值是'Base'.
		insetPadding: 20,
		legend: {
			position: 'right'//图例说明相对于图表的相对位置。比如: "top", "bottom", "left", "right", 或者 "float". 如果设置为"float", 图例根据x和y参数表示的位置来显示。
		},
		axes: [{
			type: 'Radial',
			position: 'radial',
			minimum: 100,
			maximum: 5000,
			label: {
				display: true
			}
		}],
		series: [
		   getSeries(groupArray,dataArray[0],fillFlag),
		   getSeries(groupArray,dataArray[1],fillFlag),
		   getSeries(groupArray,dataArray[2],fillFlag),
		   getSeries(groupArray,dataArray[3],fillFlag)
		]
		
	});
	return chart;
}



function getSeries(groupArray,data,fillFlag)
{
	var style = {
			'stroke-width': 2,
			opacity: 0.4,
			fill: 'none'//'none'
		};
	if(fillFlag)
	{
		style = {
			opacity: 0.4
		};
	}
	// Series. 序列是负责数据仓库中中的数据点的视觉呈现
	var series = {
		type: 'radar',
		xField: groupArray[0],
		yField: data,
		showInLegend: true,
		showMarkers: true,
		markerConfig: {
			//type: 'circle',//cross circle不指定多个列随机分配圈X
			radius: 5,
			size: 5
		},
		tips: {
			trackMouse: true,
			width: 150,
			height: 28,
			renderer: function(storeItem, item) {
				this.setTitle(storeItem.get(groupArray[0]) + ': ' + storeItem.get(data)+ ' 次 ') ;
			}
		},
		highlight: {
			size: 7,
			radius: 7
		},
		style: style
	};
	return series;
}