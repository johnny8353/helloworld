<!--<script type="text/javascript" src="<%=path%>/scripts/extjs/ext-all.js"></script>-->
<!--<script type="text/javascript" src="<%=path%>/scripts/extjs/ext-all-debug.js"></script>-->
<!--<script type="text/javascript" src="<%=path%>/scripts/extjs/ext-all-debug-w-comments.js"></script>-->
<!--include-ext.js 保证firefox界面布局-->
<script type="text/javascript" src="<%=path%>/scripts/extjs/include-ext.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/extjs/extends/bugfix.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/extjs/locale/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/extjs/plugin/PreviewPlugin.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/default.css" />



<script type="text/javascript">
	//Ext.tip.QuickTipManager.init();//快速提示
	Ext.QuickTips.init();//
	if(css_style!="")
	{
		//Ext.util.CSS.swapStyleSheet('theme', scriptGlobal.appRoot+'/scripts/extjs/resources/css/'+css_style+'.css');
		//Ext.getBody().addCls(Ext.baseCSSPrefix + 'theme-' + Ext.themeName);
	}
	//Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
</script>

<script type="text/javascript" src="<%=path%>/scripts/common/common.js?sitever=${siteversion}"></script>
<script type="text/javascript" src="<%=path%>/scripts/common/util.js?sitever=${siteversion}"></script>