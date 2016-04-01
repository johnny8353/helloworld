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
	var donut = false;
	var chart = Ext.create('Ext.chart.Chart', {
			//xtype: 'chart',//
			//insetPadding: 60,//
			//theme: 'Base:gradients',//
			style: 'background:#fff',
			animate: true,
			store: store1,
			legend: {
				position: 'right'//图例相对于图表的相对位置。比如: "top", "bottom", "left", "right", 或者 "float". 如果设置为"float", 图例根据x和y参数表示的位置来显示。
			},
			series: [{
                type: 'pie',
				animate: true,
                angleField: dataArray[1], //store记录中被用来表示饼图各个角的字段名。 这个字段的值必须是正数。
                lengthField: dataArray[1], //store记录中被用来表示饼图各个扇形长度的字段名。 ...
                field: dataArray[1],
                showInLegend: true,
                donut: donut,
                tips: {
					trackMouse: true,
					width: 140,
					height: 28,
					renderer: function(storeItem, item) {
						//calculate percentage.
						var total = 0;
						store1.each(function(rec) {
							total += rec.get(dataArray[1]);
						});
						this.setTitle(storeItem.get('group1') + ': ' + Math.round(storeItem.get(dataArray[1]) / total * 100) + '%');
                  }
                },
                highlight: {
                  segment: {
                    margin: 20
                  }
                },
                label: {
                    field: 'group1',
                    display: 'rotate',
                    contrast: true,
                    font: '18px Arial'
                }
            }]
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
		}, {
            enableToggle: true,
            pressed: false,
            text: '圆环图',
            toggleHandler: function(btn, pressed) {
                chart.series.first().donut = pressed ? 35 : false;
                chart.refresh();
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