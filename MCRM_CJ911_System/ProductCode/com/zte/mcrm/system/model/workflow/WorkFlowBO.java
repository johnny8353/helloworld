package com.zte.mcrm.system.model.workflow;

import java.io.Serializable;
import java.util.Vector;

import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.system.access.workflow.vo.SchedulerObjectVO;

/**
 * 类 编 号：
 * 类 名 称：
 * 内容摘要：XXX 
 * 完成日期：2016-2-23
 * 编码作者：JohnnyHuang
 */

public class WorkFlowBO  extends SiebelBaseBO implements Serializable{
	/**1
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private static Vector<SchedulerObjectVO> schedulers ;

	/**
	 * 
	* 业务描述：
	* 作    者：Johnny Huang
	* 完成日期：2016-2-24 	上午10:49:24
	* @param @param schedulerObjects
	* @param @return
	* @return Vector<SchedulerObjectVO>
	 */
//	public static Vector<SchedulerObjectVO> getSchedulers(Vector<SchedulerObject> schedulerObjects) {
//		schedulers = new Vector<SchedulerObjectVO>();
//		for (int i = 0; i < schedulerObjects.size(); i++) {
//			SchedulerObjectVO objectVO  = new SchedulerObjectVO();
//			SchedulerObject object = schedulerObjects.get(i);
//			objectVO.setName(object.getName());
//			objectVO.setPeriod(object.getPeriod());
//			objectVO.setSuspend(String.valueOf(object.getSuspend()));
//			objectVO.setThread(object.getType().toString());
//			objectVO.setType(object.getType());
//			objectVO.setOffset(object.getOffset());
//			objectVO.setDesc(object.getDesc());
//			schedulers.add(objectVO);
//		}
//		return schedulers;
//	}
	
	
}
