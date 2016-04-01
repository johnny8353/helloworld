package com.zte.mcrm.system.access.workflow.vo;

public class WorkFlowVO {
	private String Created;
	private String CreatedBy;
	private String Description;//说明
	private String ClassName;//类
	private String Method;//组件/作业
	private String RepeatingFlag;//是否重复？
	private String ActualServerName;//执行服务器
	private String BatchJobModeDisplayed;//模式
	private String StatusDisplayed;//状态
	private String SubmitDate;//提交日期
	private String ActualStartDate;//实际开始时间
	private String CompletionCode;//完成代码
	private String CompletionText;//完成信息 	
	private String TaskId;//任务 ID
	private String RepeatUnit;//重复单位
	private String RepeatInterval;//重复间隔
	private String RepeatingStartDate;//预计开始时间
	private String ExpirationDate;//到期时间
	private String ActualEndDate;//结束日期
	
	
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getRepeatingFlag() {
		return RepeatingFlag;
	}
	public void setRepeatingFlag(String repeatingFlag) {
		RepeatingFlag = repeatingFlag;
	}
	public String getActualServerName() {
		return ActualServerName;
	}
	public void setActualServerName(String actualServerName) {
		ActualServerName = actualServerName;
	}
	public String getBatchJobModeDisplayed() {
		return BatchJobModeDisplayed;
	}
	public void setBatchJobModeDisplayed(String batchJobModeDisplayed) {
		BatchJobModeDisplayed = batchJobModeDisplayed;
	}
	public String getStatusDisplayed() {
		return StatusDisplayed;
	}
	public void setStatusDisplayed(String statusDisplayed) {
		StatusDisplayed = statusDisplayed;
	}
	public String getSubmitDate() {
		return SubmitDate;
	}
	public void setSubmitDate(String submitDate) {
		SubmitDate = submitDate;
	}
	public String getActualStartDate() {
		return ActualStartDate;
	}
	public void setActualStartDate(String actualStartDate) {
		ActualStartDate = actualStartDate;
	}
	public String getCompletionCode() {
		return CompletionCode;
	}
	public void setCompletionCode(String completionCode) {
		CompletionCode = completionCode;
	}
	public String getCompletionText() {
		return CompletionText;
	}
	public void setCompletionText(String completionText) {
		CompletionText = completionText;
	}
	public String getTaskId() {
		return TaskId;
	}
	public void setTaskId(String taskId) {
		TaskId = taskId;
	}
	public String getRepeatUnit() {
		return RepeatUnit;
	}
	public void setRepeatUnit(String repeatUnit) {
		RepeatUnit = repeatUnit;
	}
	public String getRepeatInterval() {
		return RepeatInterval;
	}
	public void setRepeatInterval(String repeatInterval) {
		RepeatInterval = repeatInterval;
	}
	public String getRepeatingStartDate() {
		return RepeatingStartDate;
	}
	public void setRepeatingStartDate(String repeatingStartDate) {
		RepeatingStartDate = repeatingStartDate;
	}
	public String getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
	}
	public String getActualEndDate() {
		return ActualEndDate;
	}
	public void setActualEndDate(String actualEndDate) {
		ActualEndDate = actualEndDate;
	}
	
	
	

}
