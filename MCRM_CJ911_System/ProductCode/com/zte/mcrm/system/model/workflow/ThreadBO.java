package com.zte.mcrm.system.model.workflow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.f;

import com.zte.mcrm.framework.model.framework.SiebelBaseBO;
import com.zte.mcrm.system.access.workflow.vo.ThreadVO;
import com.zte.mcrm.system.common.run.system.BaseThread;

public class ThreadBO   extends SiebelBaseBO implements Serializable{
	private List<ThreadVO> threadVOs;

	private ThreadVO threadVO;
//  //线程调度基础类，所有线程调度任务继承该基础类进行业务扩展
	private BaseThread thread = null;
	
	public String getColumnNameByField(String field){
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("rowId","ROW_ID");
		maps.put("created","CREATED");
		maps.put("createdBy","CREATED_BY");
		maps.put("lastUpd","LAST_UPD");
		maps.put("lastUpdBy","LAST_UPD_BY");
		maps.put("modificationNum","MODIFICATION_NUM");
		maps.put("conflictId","CONFLICT_ID");
		maps.put("actlEndDt","ACTL_END_DT");
		maps.put("actlStartDt","ACTL_START_DT");
		maps.put("dbLastUpd","DB_LAST_UPD");
		maps.put("expirationDt","EXPIRATION_DT");
		maps.put("schedStartDt","SCHED_START_DT");
		maps.put("submitDate","SUBMIT_DATE");
		maps.put("className","CLASS_NAME");
		maps.put("completionCd","COMPLETION_CD");
		maps.put("completionText","COMPLETION_TEXT");
		maps.put("dbLastUpdSrc","DB_LAST_UPD_SRC");
		maps.put("descText","DESC_TEXT");
		maps.put("execSrvrName","EXEC_SRVR_NAME");
		maps.put("method","METHOD");
		maps.put("tmodel","TMODEL");
		maps.put("rptFlag","RPT_FLAG");
		maps.put("rptInterval","RPT_INTERVAL");
		maps.put("rptUom","RPT_UOM");
		maps.put("status","STATUS");
		maps.put("taskPid","TASK_PID");
		return maps.get(field);
	}
    public BaseThread getThread() {
		return thread;
	}

	public void setThread(BaseThread thread) {
		this.thread = thread;
	}


	
	public List<ThreadVO> getThreadVOs() {
		return threadVOs;
	}

	public void setThreadVOs(List<ThreadVO> threadVOs) {
		this.threadVOs = threadVOs;
	}

	public ThreadVO getThreadVO() {
		return threadVO;
	}

	public void setThreadVO(ThreadVO threadVO) {
		this.threadVO = threadVO;
	}


	
} 
