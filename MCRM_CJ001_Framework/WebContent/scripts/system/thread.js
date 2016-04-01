/**
* @Name: 
* @Description: 数据列表
* @author huangfuqiang
* @date 2016-3-1 
*/
document.write("<script language=javascript src='"+scriptGlobal.appRoot+"/scripts/extjs/extends/chart.js' charset='utf-8'></script>");

var readyFunction =function(){
	var columns = [{ text: '编码', dataIndex: 'rowId', align: 'left', minWidth:50,field:'textfield', hidden:false,renderer:''},
	               { text: '说明', dataIndex: 'descText', align: 'left', minWidth:200,field:'textfield', hidden:false,renderer:''},
	               { text: '状态', dataIndex: 'status', align: 'left', minWidth:50,field:'textfield', hidden:false,renderer:''},
	               { text: '是否重复？', dataIndex: 'rptFlag', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '重复间隔', dataIndex: 'rptInterval', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '重复单位', dataIndex: 'rptUom', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '完成信息', dataIndex: 'completionText', align: 'left', minWidth:200,field:'textarea', hidden:false,renderer:''},
	               { text: '类名', dataIndex: 'className', align: 'left', minWidth:300,field:'textfield', hidden:false,renderer:''},
	               { text: '方法', dataIndex: 'method', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '实际开始时间', dataIndex: 'actlStartDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '实际结束时间', dataIndex: 'actlEndDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '到期日期', dataIndex: 'expirationDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '计划开始时间', dataIndex: 'schedStartDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '提交时间', dataIndex: 'submitDate', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '完成代码', dataIndex: 'completionCd', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '执行服务器', dataIndex: 'execSrvrName', align: 'left', minWidth:150,field:'textfield', hidden:false,renderer:''},
	               { text: '模式', dataIndex: 'tmodel', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '任务Id', dataIndex: 'taskPid', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '创建日期', dataIndex: 'created', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '创建人', dataIndex: 'createdBy', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '最后更新日期', dataIndex: 'lastUpd', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '最后更新人', dataIndex: 'lastUpdBy', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''}];
	var columns2 = [{ text: '编码', dataIndex: 'rowId', align: 'left', minWidth:50,field:'textfield', hidden:false,renderer:''},
	               { text: '说明', dataIndex: 'descText', align: 'left', minWidth:200,field:'textfield', hidden:true,renderer:''},
	               { text: '状态', dataIndex: 'status', align: 'left', minWidth:50,field:'textfield', hidden:false,renderer:''},
	               { text: '完成信息', dataIndex: 'completionText', align: 'left', minWidth:200,field:'textarea', hidden:false,renderer:''},
	               { text: '类名', dataIndex: 'className', align: 'left', minWidth:200,field:'textfield', hidden:true,renderer:''},
	               { text: '实际开始时间', dataIndex: 'actlStartDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '实际结束时间', dataIndex: 'actlEndDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '到期日期', dataIndex: 'expirationDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '计划开始时间', dataIndex: 'schedStartDt', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '提交时间', dataIndex: 'submitDate', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '完成代码', dataIndex: 'completionCd', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '执行服务器', dataIndex: 'execSrvrName', align: 'left', minWidth:150,field:'textfield', hidden:false,renderer:''},
	               { text: '方法', dataIndex: 'method', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '模式', dataIndex: 'tmodel', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '是否重复？', dataIndex: 'rptFlag', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '重复间隔', dataIndex: 'rptInterval', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '重复单位', dataIndex: 'rptUom', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '任务Id', dataIndex: 'taskPid', align: 'left', minWidth:100,field:'textfield', hidden:true,renderer:''},
	               { text: '创建日期', dataIndex: 'created', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '创建人', dataIndex: 'createdBy', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''},
	               { text: '最后更新日期', dataIndex: 'lastUpd', align: 'left', minWidth:150,field:'datefield', hidden:false,renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s')},
	               { text: '最后更新人', dataIndex: 'lastUpdBy', align: 'left', minWidth:100,field:'textfield', hidden:false,renderer:''}];

	var fieldArray = new Array();
	for(var i = 0;i<columns.length;i++){
		fieldArray.push(columns[i].dataIndex);
	}
	Ext.define('dataModel', {extend : 'Ext.data.Model',fields : fieldArray,idProperty : columns[0].dataIndex});
	var store1 = getStore('dataModel','/workflow/siebel.jssm?method=getThreadPage',"gridId");
	var store2 = getStore('dataModel','/workflow/siebel.jssm?method=getThreadRpdPage',"gridId2");
	
	var backBtn = getBackBtn();
	var reloadBtn = {
			text: '重新加载',
			handler: function() {
				var myMask = new Ext.LoadMask(Ext.getBody(),{msg:msg});
				myMask.show();
				store1.reload({params:{obj:''},callback:function(){
					grid.getSelectionModel().select(editRowArray["gridId"]);
				}});
				myMask.hide();
			}
		};
	var testCaseBtn = {
			text: '测试用例发送邮件2hand',
			handler: function() {
				SyncRequest('/workflow/siebel.jssm?method=testcase2Hand');
				store1.load({params:{obj:''}});
			}
		};
	var testCase2AllBtn = {
			text: '发送邮件2All',
			handler: function() {
				 Ext.Msg.confirm("警告", "确定要执行该操作吗？", function (button) {
                     if (button == "yes") {
						SyncRequest('/workflow/siebel.jssm?method=sendMail2All');
						store1.load({params:{obj:''}});
                     }
                 });
			}
		};
	var stoptBtn = {
			text: '取消',
			handler: function() {
				var selModel = grid.getSelectionModel();
                if (selModel.hasSelection()) {
                    Ext.Msg.confirm("警告", "确定要取消吗？", function (button) {
                        if (button == "yes") {
                        	var json = getSelectedJson(grid.getSelectionModel().getSelection()[0].raw,columns);
                            
                            SyncRequest('/workflow/siebel.jssm?method=stopThread&obj='+json);
            				store1.load({params:{obj:''}});
                          //  alert(Ids);

                        }
                    });
                }
                else {
                    Ext.Msg.alert("错误", "没有任何行被选中，无法进行操作！");
                }
			}
		};
	var suspendBtn = {
			text: '挂起',
			handler: function() {
				var selModel = grid.getSelectionModel();
                if (selModel.hasSelection()) {
                    Ext.Msg.confirm("警告", "确定要挂起吗？", function (button) {
                        if (button == "yes") {
                        	var json = getSelectedJson(grid.getSelectionModel().getSelection()[0].raw,columns);
                            SyncRequest('/workflow/siebel.jssm?method=suspendThread&obj='+json);
            				store1.load({params:{obj:''}});
                          //  alert(Ids);

                        }
                    });
                }
                else {
                    Ext.Msg.alert("错误", "没有任何行被选中，无法进行操作！");
                }
			}
		};
	var resumeBtn = {
			text: '恢复',
			handler: function() {
				var selModel = grid.getSelectionModel();
                if (selModel.hasSelection()) {
                    Ext.Msg.confirm("警告", "确定要恢复吗？", function (button) {
                        if (button == "yes") {
                        	var json = getSelectedJson(grid.getSelectionModel().getSelection()[0].raw,columns);
                            
                            SyncRequest('/workflow/siebel.jssm?method=resumeThread&obj='+json);
            				store1.load({params:{obj:''}});
                          //  alert(Ids);

                        }
                    });
                }
                else {
                    Ext.Msg.alert("错误", "没有任何行被选中，无法进行操作！");
                }
			}
		};
	var tbar = [backBtn,reloadBtn,testCaseBtn,testCase2AllBtn,suspendBtn,resumeBtn,stoptBtn];

	var reloadBtn2 ={
			text: '重新加载',
			handler: function() {
				var json = getSelectedJson(grid.getSelectionModel().getSelection()[0].raw,columns);
				var myMask = new Ext.LoadMask(Ext.getBody(),{msg:msg});
				myMask.show();
				store2.load({params:{obj:json}});
				myMask.hide();
			}
		};
	var tbar2 = [reloadBtn2];
	var grid = getGrid(tbar,store1,columns,"gridId", "工作",1200,400);
	var grid2 = getGrid(tbar2,store2,columns2,"gridId2", "重复实例",1200,400);
	//var win = getChartWindow(1000,600,tbar,grid,titleName);
	store1.load({params:{obj:''}});
	
	grid.getSelectionModel().on("selectionchange",function(model,selected ){
		var json = getSelectedJson(selected[0].raw,columns);
//		alert(formatDate('f'));//0NaN-NaN-NaN NaN:NaN:NaN
		editRowArray["gridId"] = selected[0].index;
		store2.load({params:{obj:json}});
//		for(var i=0;i<cm.getColumnCount();i++){
//			var name = cm.getDataIndex(i);
//			var value = cm.getColumnHeader(i);
//			if(Ext.getCmp(name)){
//				Ext.getCmp(name).setValue(r.get(name));
//			}
//		}
	});
	
};
