/**
 * 
 */
 
Ext.require('Ext.chart.*');
Ext.require(['Ext.Window','Ext.window.*', 'Ext.fx.target.Sprite', 'Ext.layout.container.Fit', 'Ext.window.MessageBox']);
var filedArray = ['group1','登陆十次及以上','登陆五次及以上','登陆三次及以上','登陆一次及以上'];
var dataArray= [filedArray[1],filedArray[2],filedArray[3],filedArray[4]];
var groupCount = 1;
var groupArray = [filedArray[0]];

Ext.define('dataModel', {extend : 'Ext.data.Model',fields : filedArray,idProperty : groupArray[0]});
		
var readyFunction =function(){
	var store1 = getStore();
	var seriesConfig = function(field) {
        return {
            type: 'radar',
            xField: groupArray[0],
            yField: field,
            showInLegend: true,
            showMarkers: true,
            markerConfig: {
                radius: 5,
                size: 5
            },
            tips: {
                trackMouse: true,
                width: 200,
                height: 28,
                renderer: function(storeItem, item) {
                    this.setTitle(storeItem.get(groupArray[0]) + ': ' + storeItem.get(field));
                }
            },
            style: {
                'stroke-width': 2,
				opacity: 0.4,
                fill: false//'none'
            }
        }
    };
	var chart = Ext.create('Ext.chart.Chart', {
			style: 'background:#fff',
			animate: true,
			store: store1,
			theme: 'Category2',
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
               seriesConfig(dataArray[0])
            ]
			
		});

	var win = Ext.create('Ext.window.Window', {
		width: 1000,
		height: 600,
		minHeight: 600,
		minWidth: 800,
		hidden: false,
		shadow: false,
		maximizable: true,
		title: 'siebel服务器用户登陆报表-按月份统计',
		autoShow: true,
		layout: 'fit',
		tbar: [{
			text: '返回',
			handler: function() {
				Ext.MessageBox.confirm(messageBoxTitle, '您确定要返回上一个界面吗?', function(choice){
					history.go(-1);
				});
			}
		}, {
			text: '重新加载',
			handler: function() {
				// Add a short delay to prevent fast sequential clicks
				Ext.window.loadTask.delay(100, function() {
					store1.load();
				});
			}
		}, {
			enableToggle: true,
			pressed: true,
			text: '开启动画',
			toggleHandler: function(btn, pressed) {
				chart.animate = pressed ? { easing: 'ease', duration: 500 } : false;
			}
		}],
		items: chart
	});
	store1.load();
};


function getStore(){
	// create the Data Store
	var store = Ext.create('Ext.data.Store', {
		pageSize : 10,
		model : 'dataModel',
		remoteSort : true,
		proxy : {
			type : 'ajax',
			url : scriptGlobal.appRoot+'/serverReport/siebel.jssm?method=getPage',
			reader : {
				type: 'json',
				root : 'D',
				totalProperty : ''
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
		if(!success)
		{
			ShowMessageSysError();
		}
	});
	return store;
}