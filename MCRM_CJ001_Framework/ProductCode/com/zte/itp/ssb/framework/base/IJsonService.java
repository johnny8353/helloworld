/**
 * 版权所有：版权所有(C) 2015，中兴通讯 
 * 文件编号：BL_PU2010101_IJsonService 
 * 文件名称：IJsonService.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2015-1-10
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2015-1-10
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.itp.ssb.framework.base;

import javax.servlet.http.HttpServletRequest;

/**
 * 类 编 号：BL_PU2010101_IJsonService
 * 类 名 称：IJsonService
 * 内容摘要：XXX 
 * 完成日期：2015-1-10
 * 编码作者：JohnnyHuang 黄福强
 */
public abstract interface IJsonService
{
  public abstract void init(HttpServletRequest paramHttpServletRequest);

  public abstract String service();
  
  public abstract String service(HttpServletRequest request);
}
