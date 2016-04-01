package com.zte.mcrm.system.access.workflow.vo;

import java.io.Serializable;

import com.zte.mcrm.framework.common.util.StringUtils;

public final class SchedulerObjectVO implements Serializable
{
	private static final long serialVersionUID = -5818506543325306484L;
	//根标签
	public static final String CONFIG_ROOT_TAG = "mcrm-config";
	//调度任务集合标签
	public static final String SCHEDULERS_TAG = "schedulers";
	//调度线程任务标签
	public static final String SCHEDULER_ITEM_TAG = "scheduler";
	//线程任务名
	public static final String SCHEDULER_NAME_TAG = "name";
	//线程任务类路径名
	public static final String SCHEDULER_TYPE_TAG = "type";
	//唤醒周期,单位(秒)
	public static final String SCHEDULER_PERIOD_TAG = "period";
	//相对整点偏移周期,单位(秒)
	public static final String SCHEDULER_OFFSET_TAG = "offset";
	//该线程任务是否挂起(true:挂起线程不执行  false:启用线程)
	public static final String SCHEDULER_SUSPEND_TAG = "suspend";
	//调度任务根标签路径
	public static final String SCHEDULER_TASK_TAG="mcrm-config/schedulers/scheduler";
	
    //线程调度基础类，所有线程调度任务继承该基础类进行业务扩展
	private String thread = null;
	private String name = "";
	private String desc = "";
	private String type = null;
	private int period = 15;
	private int offset = 0;
	private boolean suspend = true;
	//----------------------------------------------
	
	public String getName()
	{
		return this.name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public int getPeriod()
	{
		return this.period;
	}

	public void setPeriod(int period)
	{
		this.period = period;
	}

	public void setPeriod(String strPeriod)
	{
		this.period = StringUtils.parseInt(strPeriod, 15);
	}
	
	public int getOffset()
	{
		return this.offset;
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public void setOffset(String strOffset)
	{
		this.offset = StringUtils.parseInt(strOffset, 0);
	}
	
	public boolean getSuspend()
	{
		return this.suspend;
	}

	public void setSuspendt(boolean suspend)
	{
		this.suspend = suspend;
	}

	public void setSuspend(String strSuspend)
	{
		if (strSuspend != null && "true".equals(strSuspend.trim()))
			this.suspend = true;
		else if (strSuspend != null && "false".equals(strSuspend.trim()))
			this.suspend = false;
		else
			this.suspend = true;
	}


	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer("SchedulerObject[");
		sb.append("|name=");
		sb.append(name);
		sb.append("|type=");
		sb.append(type);
		sb.append("|period=");
		sb.append(period);
		sb.append("|offset=");
		sb.append(offset);
		sb.append("|suspend=");
		sb.append(suspend);
		sb.append("|thread=");
		sb.append(thread);
		sb.append("]");
		return sb.toString();
	}
}
