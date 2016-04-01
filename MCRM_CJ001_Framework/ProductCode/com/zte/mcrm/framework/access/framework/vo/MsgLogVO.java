package com.zte.mcrm.framework.access.framework.vo;

import java.io.Serializable;

/**
 * 类 编 号：BL_PU2010101_MsgLogVO
 * 类 名 称：MsgLogVO
 * 内容摘要：调用接口记录实体类
 * 完成日期：2014-11-14
 */
public class MsgLogVO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3099046497414011544L;
	/**
	 * 操作记录ID
	 */
	private int msgLogId;
	/**
	 * 调用类名
	 */
	private String msgClass;
	/**
	 * 调用方法名
	 */
	private String msgMethod;
	/**
	 * 请求参数信息
	 */
	private String msgContent;
	/**
	 * 创建人
	 */
	private String createdBy;
	/**
	 * 创建时间
	 */
	private String creationDate;
	/**
	 * 接口调用URL
	 */
	private String msgURL;
	/**
	 * 最后更新时间
	 */
	private String lastUpdateDate;
	/**
	 *操作记录父id
	 */
	private int parentId;
	
	public int getMsgLogId() {
		return msgLogId;
	}
	public void setMsgLogId(int msgLogId) {
		this.msgLogId = msgLogId;
	}
	public String getMsgClass() {
		return msgClass;
	}
	public void setMsgClass(String msgClass) {
		this.msgClass = msgClass;
	}
	public String getMsgMethod() {
		return msgMethod;
	}
	public void setMsgMethod(String msgMethod) {
		this.msgMethod = msgMethod;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the lastUpdateData
	 */
	public String getLastUpdateDate()
	{
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateData the lastUpdateData to set
	 */
	public void setLastUpdateData(String lastUpdateDate)
	{
		this.lastUpdateDate = lastUpdateDate;
	}
	/**
	 * @return the parentId
	 */
	public int getParentId()
	{
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}
	/**
	 * @return the msgURL
	 */
	public String getMsgURL()
	{
		return msgURL;
	}
	/**
	 * @param msgURL the msgURL to set
	 */
	public void setMsgURL(String msgURL)
	{
		this.msgURL = msgURL;
	}
}
