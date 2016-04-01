/**
 * 
 */
 

/**
* 业务描述：解决保存图片中文乱码问题
* 作    者：Johnny Huang
* 完成日期：2016-2-24 	上午10:49:43
 */
var mySave = function(surface, config) {
	config = config || {};
	var exportTypes = {
			'image/png': 'Image',
			'image/jpeg': 'Image',
			'image/svg+xml': 'Svg'
		},
		prefix = exportTypes[config.type] || 'Svg',
		exporter = Ext.draw.engine[prefix + 'Exporter'];          
		exporter.defaultUrl = scriptGlobal.appRoot+'/report/response.jssm?method=getPage';
	return exporter.generate(surface, config);
};