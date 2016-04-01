/**
 * 版权所有：版权所有(C) 2016，中兴通讯 
 * 文件编号：BL_PU2010101_IUnitTestParamsDAO 
 * 文件名称：IUnitTestParamsDAO.java
 * 系统编号：100000201191
 * 系统名称：SmartSales 智慧营销
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2016-1-13
 * 设计文档：<如有rose的设计文件则需要填写设计文件名称>
 * 内容摘要：<描写该文件主要功能职责和后续扩展范围> 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2016-1-13
 * 活  动   号：<填写在EC上的开发活动号和名称或版本号>
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.access.framework.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zte.mcrm.framework.access.framework.vo.UnitTestParamsVO;

/**
 * 内容摘要：单元测试数据处理
 * 完成日期：2016-1-13
 * 编码作者：JohnnyHuang 黄福强
 */
@Repository
public interface IUnitTestParamsDAO
{
	/**
	 * 
	 * 获取所有需要测试的测试场景记录
	 * 编码作者:JohnnyHuang 黄福强
	 * 完成日期:2016-1-13
	 * @return
	 */
   public List<UnitTestParamsVO> searchAllParams(String testType);
   
   /**
    * 
    * 测试结果回写
    * 编码作者:JohnnyHuang 黄福强
    * 完成日期:2016-1-13
    * @param list
    * @return
    */
   public int updateList(List<UnitTestParamsVO> list);
   
   /**
    * 
    * 按beanId和testType更新记录
    * 编码作者:JohnnyHuang 黄福强
    * 完成日期:2016-2-19
    * @param uvo
    * @return
    */
   public int updateByBeanId(UnitTestParamsVO uvo);
   
   /**
    * 
    * 根据传入beanKey获取单元测试参数配置信息
    * 编码作者:6011000109
    * 完成日期:2016-2-3
    * @param beanKey
    * @return
    */
   public List<UnitTestParamsVO> getUnitTestParamsByBeanKey(String beanKey);
}
