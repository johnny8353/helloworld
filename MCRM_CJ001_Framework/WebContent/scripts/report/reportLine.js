/**
* @Name: 
* @Description: 折线图
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
	var tbar = [backBtn,reloadBtn , animateBtn];
	var win = getChartWindow(800,400,tbar,chart,'siebel服务器用户登陆报表-按月份统计');
	store1.load({params:{obj:obj}});
};

function getChart(store1,dataArray,groupArray)
{
	var chart = Ext.create('Ext.chart.Chart', {
		style: 'background:#fff',
		animate: true,
		store: store1,
		theme: 'Base',//要使用的主题名称.主题定义的颜色和其他显示的轴上的刻度标记，文本，标题文本，线的颜色，标记颜色和风格等。 主题的值可以为'Base', 'Green'，'Sky', 'Red', 'Purple', 'Blue', 'Yellow'和六个类别主题从'Category1' 到 'Category6'。 默认值是'Base'.
		legend: {
			position: 'bottom'//图例说明相对于图表的相对位置。比如: "top", "bottom", "left", "right", 或者 "float". 如果设置为"float", 图例根据x和y参数表示的位置来显示。
		},
		//Axes是定义显示图表数据点边界的线. 例子中使用了最常用的配置之一的轴配置-水平的“x”轴，和垂直的“y”轴:
		axes: [{
			type: 'Numeric',
			position: 'left',
			fields: dataArray,
			title: '登陆次数',
			minorTickSteps: 1,
			grid: {
				odd: {
					opacity: 1,
					fill: '#ddd',
					stroke: '#bbb',
					'stroke-width': 1
				}
			},
			minimum: 0,
			adjustMinimumByMajorUnit: 0
		}, {
			type: 'Category',
			position: 'bottom',
			fields: groupArray,
			title: '年月',
			grid: true
		}],
		series: [
			getSeries(groupArray,dataArray[0]),
			getSeries(groupArray,dataArray[1]),
			getSeries(groupArray,dataArray[2]),
			getSeries(groupArray,dataArray[3])
		]
	});
	return chart;
}



function getSeries(groupArray,data)
{
	// Series. 序列是负责数据仓库中中的数据点的视觉呈现
	var series = {
		type: 'line',//折线图
		axis: 'left',//坐标轴上的点可以绑定的数值. 可以使用的值有'left', 'bottom', 'top' 和 'right'。你必须给坐标轴明确指定使用曲线中的一个值， 否则将使用一个相对适用的值。
		xField: groupArray[0],
		yField: data,
		//fill: true,//在曲线以下的部分将使用eefill和 opacity 配置属性进行填充
		tips: {
			trackMouse: true,
			width: 150,
			height: 28,
			renderer: function(storeItem, item) {
				//item.series.yField 获取当前点击的列标签
				this.setTitle(storeItem.get(groupArray[0]) + ': ' + storeItem.get(item.series.yField)+ ' 次 ') ;
			}
		},
		markerConfig: {
			//type: 'circle',//cross circle不指定多个列随机分配圈X
			size: 4,
			radius: 4,
			'stroke-width': 0
		},//
		highlight: {
			size: 7,
			radius: 7
		}
	};
	return series;
}