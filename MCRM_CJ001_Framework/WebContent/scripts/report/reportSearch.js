/**
* @Name: 
* @Description: 报表查询界面类
* @author huangfuqiang
* @date 2016-3-1 
*/
document.write("<script language=javascript src='"+scriptGlobal.appRoot+"/scripts/extjs/extends/chart.js' charset='utf-8'></script>");

var readyFunction =function(){

	var typeStore =  getLocalStore(typeLOVDatas);
	var modeStore =  getLocalStore(modeLOVDatas);
	
	var startText = {
		xtype:'datefield',
		fieldLabel: '起始日期',
		margin:5,
		afterLabelTextTpl: required,
		allowBlank: false,
		name: 'startTextId',
		id:'startTextId',
		columnWidth: 0.5
	};
	var endText = {
		xtype:'datefield',
		fieldLabel: '结束日期',
		margin:5,
		name: 'endTextId',
		id:'endTextId',
		columnWidth: 0.5
	};
	var typeCombo = getLocalCombo('报表类型',typeStore,'ReportType','Line');
	var modeCombo = getLocalCombo('时间粒度',modeStore,'ReportMode','Month');
	
	var searchBtn = {
		text: '查询',
		handler: function() {
			 var form = this.up('form').getForm();
			 if (true||form.isValid()) {
				var myMask = new Ext.LoadMask(Ext.getBody(),{msg:msg});
				myMask.show();
				var getStr = "{'data':["+getIdItem("fieldSetFormId")+"]}";
				
				Ext.Ajax.request({
					url: scriptGlobal.appRoot+'/serverReport/siebel.jssm?method=search',
					params: { 'obj': getStr},
					method: 'POST',
					success: function (response, options) {
						var json = eval("("+decodeURIComponent(response.responseText)+")");
						var status = json.S;//true
						var message = json.errorMsg;
						if(status=="true")
						{
							var typename = getStateNamebyValue(typeLOVDatas,extGetRowValue("ReportTypeId"));
							if(typename=="Line"){
								window.location.href = "/siebel/app/reportLine.jsp";
							}else if(typename=="Area")
							{
								window.location.href = "/siebel/app/reportArea.jsp";
							}else if(typename=="Pie")
							{
								window.location.href = "/siebel/app/reportPie.jsp";
							}else if(typename=="Column")
							{
								window.location.href = "/siebel/app/reportColumn.jsp";
							}else if(typename=="Radar")
							{
								window.location.href = "/siebel/app/reportRadar.jsp";
							}else
							{
								window.location.href = "/siebel/app/reportGrid.jsp";
							}
						}
						else
						{
							myMask.hide();
							Ext.Msg.alert(messageBoxTitle, systemErrorText + message);
						}
					},
					failure: function (response, options) {
						myMask.hide();
						Ext.Msg.alert(messageBoxTitle, timeoutErrorText + response.status);
					}
				});
			 }
		}
	};
	
	var fsf = Ext.widget({
        xtype: 'form',
        id: 'fieldSetFormId',
//        collapsible: true,
        frame: true,//粗边框
        title: '查询条件',
        border:0,//边框
        bodyPadding: '5',
		margin:'10 10 10 10',
        width: getGWidth(),
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 75
        },
        items: [{
            xtype:'fieldset',
//            title: '查询条件',
//            collapsible: true,
            defaultType: 'textfield',
            layout: 'vbox',
			border:0,//边框
            defaults: {
                anchor: '100%'
            },
            items :[{
                xtype: 'container',
                width: getGWidth()-50,
                layout: 'column',
                items: [startText,endText ]
            },{
                xtype: 'container',
                width: getGWidth()-50,
                layout: 'column',
                items: [typeCombo,modeCombo]
            }
            ]
        }],

        buttons: [searchBtn,{
            text: '重置',
            handler: function() {
                this.up('form').getForm().reset();
            }
        }]
    });
	
    fsf.render(document.body);
}

