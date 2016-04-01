/**
 * 
* @Name: main.js
* @Description:  首页
* @author huangfuqiang
* @date 2016-2-27 
*
 */
Ext.require([
    'Ext.tab.*'
]);
function readyFunction() {

    Ext.QuickTips.init();

    var currentItem;
    var tabs = Ext.widget('tabpanel', {
    	region: 'center', // a center region is ALWAYS required for border layout
        renderTo: 'center',
        resizeTabs: true,
        id: 'east-panel', // see Ext.getCmp() below
        enableTabScroll: true,
        defaults: {
            autoScroll: true,
            bodyPadding: 0
        },
        items: [{
            title: 'Tab 1',
            iconCls: 'tabs',
            style:'padding:0;',
            html: 'Tab Body<br/><br/>',
            closable: true
        }],
        plugins: Ext.create('Ext.ux.TabCloseMenu', {
            extraItemsTail: [
                '-',
                {
                    text: '可关闭',
                    checked: true,
                    hideOnClick: true,
                    handler: function (item) {
                        currentItem.tab.setClosable(item.checked);
                    }
                },
                '-',
                {
                    text: '可用',
                    checked: true,
                    hideOnClick: true,
                    handler: function(item) {
                        currentItem.tab.setDisabled(!item.checked);
                    }
                }
            ],
            listeners: {
                beforemenu: function (menu, item) {
                    var enabled = menu.child('[text="可用"]'); 
                    menu.child('[text="可关闭"]').setChecked(item.closable);
                    if (item.tab.active) {
                        enabled.disable();
                    } else {
                        enabled.enable();
                        enabled.setChecked(!item.tab.isDisabled());
                    }

                    currentItem = item;
                }
            }
        })
    });

    function addTab (tabs,title) {
    	if(CheckTabExists(tabs,title))
    	{
    		var theme = getQueryParam('theme') || 'neptune';
    		var url = scriptGlobal.hostUrl+"/app/report/reportSearch.jsp?theme="+theme;
            tabs.add({
                closable: true,
                html: '<iframe id=iframe'+title+' frameborder=0 src='+url+' width=100%  height=100% />',
                iconCls: 'tabs',
                title: title
            }).show();
    	}
    }
    
    function CheckTabExists(tabs,title)
    {
    	var flag = true;
    	for(var i = 0;i<tabs.items.items.length;i++)
		{
    		var temp = tabs.items.items[i].title;
    		if(title==temp){
    			return false;
    		}
		}
    	return flag;
    }
    
    
    var viewport = Ext.create('Ext.Viewport', {
        id: 'border-example',
        layout: 'border',
        items: [
        Ext.create('Ext.Component', {
            region: 'north',
            height: 50, // give north and south regions a height
            autoEl: {
                tag: 'div',
                style:'margin:0px;padding:10px;',
                html:'<div style="color:#FFF;font-weight:bold;font-size:20px;font-family:Verdana,Arial,Sans-serif;">CRM后台管理系统</div>'
            }
        }),Ext.create('Ext.Component', {
            region: 'south',
            height: 40, // give north and south regions a height
            autoEl: {
                tag: 'div',
                style:'margin:0px;padding:10px;',
                html:'<div style="color:#FFF;font-weight:bold;font-family:Verdana,Arial,Sans-serif; ">欢迎您  黄福强 先生/小姐</div>'
            }
        }), 
          {
            region: 'west',
            stateId: 'navigation-panel',
            id: 'west-panel', // see Ext.getCmp() below
            title: '菜单栏',
            split: true,
            width: 220,
            minWidth: 175,
            maxWidth: 400,
            collapsible: true,
            animCollapse: true,
            margins: '0 0 0 5',
            layout: 'accordion',
            items: [{
                contentEl: 'west',
                title: '报表',
                items: [{
                    xtype: 'toolbar',
                    layout: {
                        type:'vbox',
                        padding:'5',
                        align:'stretch'
                    },
                    enableOverflow: true,
                    dock: 'top',
                    defaults:{
                        margin:'5 0 0 0',
                        padding:'5',
                        pressed: false,
                        toggleGroup:'btns',
                        allowDepress: false
                    },
                    items: [
                            {text: '用户登录报表',
                        	handler: function () {
                                addTab(tabs,'用户登录报表');
                            },
                            xtype:'button'},
                            {text: '报表2',
                            xtype:'button'},
                            {text: '报表3',
                            xtype:'button'}]
                }],
                iconCls: 'nav' // see the HEAD section for style used
            }, {
                title: '报表2',
                items: [{
                    xtype: 'toolbar',
                    layout: {
                        type:'vbox',
                        padding:'5',
                        align:'stretch'
                    },
                    enableOverflow: true,
                    dock: 'top',
                    defaults:{
                        margin:'5 0 0 0',
                        padding:'5',
                        pressed: false,
                        toggleGroup:'btns',
                        allowDepress: false
                    },
                    items: [
                            {text: '报表1',
                            xtype:'button'},
                            {text: '报表2',
                            xtype:'button'},
                            {text: '报表3',
                            xtype:'button'}]
                }],
                iconCls: 'settings'
            }, {
                title: '报表3',
                items: [{
                    xtype: 'toolbar',
                    layout: {
                        type:'vbox',
                        padding:'5',
                        align:'stretch'
                    },
                    enableOverflow: true,
                    dock: 'top',
                    defaults:{
                        margin:'5 0 0 0',
                        padding:'5',
                        pressed: false,
                        toggleGroup:'btns',
                        allowDepress: false
                    },
                    items: [
                            {text: '报表1',
                            xtype:'button'},
                            {text: '报表2',
                            xtype:'button'},
                            {text: '报表3',
                            xtype:'button'}]
                }],
                iconCls: 'info'
            }]
        },
        tabs]
    });
}