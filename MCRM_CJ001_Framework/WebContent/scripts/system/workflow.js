
var readyFunction =function(){
	
	Ext.define('ForumThread', {
			extend : 'Ext.data.Model',
			fields : [ 'thread','name','desc','type','period','offset','suspend' ],
			idProperty : 'desc'
		});
	var store = getStore();
	var handleAction = function(action){
    };
	    var colorMenu = Ext.create('Ext.menu.ColorPicker', {
        handler: function(cm, color){
            Ext.example.msg('Color Selected', '<span style="color:#' + color + ';">You choose {0}.</span>', color);
        }
    });
	var tbar = Ext.create('Ext.toolbar.Toolbar', {
            layout: {
                overflowHandler: 'Menu'
            },
            items: [{
                xtype:'splitbutton',
                text: 'Menu Button',
                iconCls: 'add16',
                handler: Ext.Function.pass(handleAction, 'Menu Button'),
                menu: [{text: 'Menu Item 1', handler: Ext.Function.pass(handleAction, 'Menu Item 1')}]
            },'-',{
                xtype:'splitbutton',
                text: 'Cut',
                iconCls: 'add16',
                handler: Ext.Function.pass(handleAction, 'Cut'),
                menu: [{text: 'Cut menu', handler: Ext.Function.pass(handleAction, 'Cut menu')}]
            },{
                text: 'Copy',
                iconCls: 'add16',
                handler: Ext.Function.pass(handleAction, 'Copy')
            },{
                text: 'Paste',
                iconCls: 'add16',
                menu: [{text: 'Paste menu', handler: Ext.Function.pass(handleAction, 'Paste menu')}]
            },'-',{
                text: 'Format',
                iconCls: 'add16',
                handler: Ext.Function.pass(handleAction, 'Format')
            },'->', {
                fieldLabel: 'Action',
                labelWidth: 70,
                width: 180,
                xtype: 'datefield',
                labelSeparator: '',
                enableKeyEvents: true,
                listeners: {
                    expand: function(){
                        fromPicker = true;
                    },
                    collapse: function(){
                        fromPicker = false;  
                    },
                    change: function(d, newVal, oldVal) {
                        if (fromPicker || !d.isVisible()) {
                            showDate(d, newVal);
                        }
                    },
                    keypress: {
                        buffer: 500,
                        fn: function(field){
                            var value = field.getValue();
                            if (value !== null && field.isValid()) {
                                showDate(field, value);
                            }
                        }
                    }
                }
            }, {
                text: 'Sell',
                iconCls: 'money-down',
                enableToggle: true,
                toggleHandler: function(button, pressed) {
                    Ext.example.msg('<b>Action</b>', 'Right ToggleButton ' + (pressed ? 'Buy' : 'Sell'));
                    button.setText(pressed ? 'Buy' : 'Sell')
                    button.setIconCls(pressed ? 'money-up' : 'money-down')
                }
            }, {
                text: 'Choose a Color',
                menu: colorMenu // <-- submenu by reference
            }]
        });
	
	var columns = [{
			id: 'desc',
			text: "说明",
			width:100,
			editable:true,
			editor: {
                xtype: 'textfield'
            },
			dataIndex: 'desc'
		},{
			text: "名称",
			width:100,
			editable:true,
			editor: {
                xtype: 'textfield'
            },
			dataIndex: 'name'
		},{
			text: "类型",
			width:100,
			editable:true,
			editor: {
                xtype: 'textfield'
            },
			dataIndex: 'type'
		},{
			text: "线程类",
			width:150,
			editable:true,
			editor: {
                xtype: 'textfield'
            },
			dataIndex: 'thread'
		}];
	var grid = getGrid(tbar,store,columns,"grid","定时任务",800,400);

	// trigger the data store load
	//store.loadPage(1);
	store.load();
	//var tbar = getTBar(productCM,productStore,store_query);
	//var productGrid = getGrid('grid','产品列表',productCM,productStore,true,tbar,"%",0);
	//InitEventFuncNoCurd({grid:productGrid,cm:productCM,store:productStore,store_query:store_query,MId:''});	
	//productStore.load({params:{start:0, limit:pagesize,condition:retStoreQuery(store_query)}});
	
	//hierarchyControl({p:{grid:productGrid}});

};


function getStore(){
	// create the Data Store
	var store = Ext.create('Ext.data.Store', {
		pageSize : 10,
		model : 'ForumThread',
		remoteSort : true,
		proxy : {
			type : 'ajax',
			url : scriptGlobal.appRoot+'/workflow/siebel.jssm?method=getPage',
			reader : {
				type: 'json',
				root : 'D',
				totalProperty : 'P.T'
			},
			// sends single sort as multi parameter
			simpleSortMode : true
		},
		sorters : [ {
			property : 'name',
			direction : 'DESC'
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



var productCM = new Ext.grid.ColumnModel([
  	{id:'typename',header:'品牌',editable:false,dataIndex:'typename',width:400,editor: new Ext.form.TextField({allowBlank: false})},
	{id:'displayname',header:'显示名称',editable:false,dataIndex:'displayname',width:680,editor: new Ext.form.TextField({allowBlank: false})},
	{id:'catname',header:'目录名称',editable:false,hidden:true,dataIndex:'catname',width:330,editor: new Ext.form.TextField({allowBlank: false})}
]);