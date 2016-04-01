/**
 * 版权所有：版权所有(C) 2008，中兴通讯 
 * 文件编号：UI_PU0010101_MimsWebClientProbe.java 
 * 文件名称：MimsWebClientProbe.java
 * 系统编号：Z0001017
 * 系统名称：市场营销信息管理系统(系统用户)
 * 组件编号：MIMS_CJ001
 * 组件名称：框架组件
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2008-10-7
 * 设计文档：MIMS_CJ001_Framework 基础框架 组件设计模型.cat
 * 内容摘要：系统探针类，实现IClientProbe接口，监测系统的可用性等。
 */
package com.zte.mcrm.framework.common.run;

import com.zte.amp.capabilityprobe.service.IClientProbe;

/**
 * 类 编 号：UI_PU0010103_MimsWebClientProbe 
 * 类 名 称：MimsWebClientProbe 
 * 内容摘要：系统探针类，实现IClientProbe接口，监测系统的可用性等。
 * 完成日期：2008-10-7
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmWebClientProbe implements IClientProbe {

  /**
   * 可用性结果数据集，存在的如下几种结果编码
   *	003001：应用正常  
   *	003002：应用异常
   *
   */
	@Override
	public String getCapabilityData(String watch_objid) 
	{
		// TODO Auto-generated method stub
		return "003001";
	}

}
