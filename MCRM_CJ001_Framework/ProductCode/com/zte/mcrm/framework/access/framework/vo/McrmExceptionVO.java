/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmExceptionVO 
 * 文件名称：McrmExceptionVO.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-14
 * 设计文档：XXX
 * 内容摘要：XXX。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-14
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.access.framework.vo;

/**
 * 类 编 号：BL_PU2010101_McrmExceptionVO
 * 类 名 称：McrmExceptionVO
 * 内容摘要：XXX 
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmExceptionVO
{
	/**
	 * 信息最大长度
	 */
	private static final int MAX_MESSAGE_LENGTH = 2000;

	/**
	 * 异常信息Id
	 */
	private int exceptionInfoId;

	/**
	 * 系统名称
	 */
	private String appName;

	/**
	 * 错误发生的层
	 */
	private String errorLayer;

	/**
	 * 模块名称
	 */
	private String moduleName;

	/**
	 * 类名称
	 */
	private String className;

	/**
	 * 异常抛出处方法名称
	 */
	private String methodName;

	/**
	 * 错误码，用于标识错误标号
	 */
	private String errorCode;

	/**
	 * 异常信息
	 */
	private String exceptionMessage;

	/**
	 * 抛出的异常
	 */
	private Exception exception;

	/**
	 * 创建人
	 */
	private String createdBy;
	
	/**
	 * 最后修改人
	 */
	private String lastUpdatedBy;
	
	/**
	 * 创建时间:2014-09-25 11:21:36
	 */
	private String createdDate;
	
	/**
	 * 最后时间:2014-09-25 11:21:36
	 */
	private String lastUpdateDate;
	
	/**
	 * 记录是否启用：Y N
	 */
	private String enableFlag;
	
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy)
	{
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate()
	{
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public String getLastUpdateDate()
	{
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(String lastUpdateDate)
	{
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the enableFlag
	 */
	public String getEnableFlag()
	{
		return enableFlag;
	}

	/**
	 * @param enableFlag the enableFlag to set
	 */
	public void setEnableFlag(String enableFlag)
	{
		this.enableFlag = enableFlag;
	}

	/**
	 * @roseuid 4330FBA10195
	 */
	public McrmExceptionVO()
	{

	}

	/**
	 * Access method for the exceptionInfoId property.
	 * 
	 * @return   the current value of the exceptionInfoId property
	 */
	public int getExceptionInfoId()
	{
		return exceptionInfoId;
	}

	/**
	 * Sets the value of the exceptionInfoId property.
	 * 
	 * @param aExceptionInfoId the new value of the exceptionInfoId property
	 */
	public void setExceptionInfoId(int aExceptionInfoId)
	{
		exceptionInfoId = aExceptionInfoId;
	}

	/**
	 * Access method for the appName property.
	 * 
	 * @return   the current value of the appName property
	 */
	public String getAppName()
	{
		return appName;
	}

	/**
	 * Sets the value of the appName property.
	 * 
	 * @param aAppName the new value of the appName property
	 */
	public void setAppName(String aAppName)
	{
		appName = aAppName;
	}

	/**
	 * Access method for the errorLayer property.
	 * 
	 * @return   the current value of the errorLayer property
	 */
	public String getErrorLayer()
	{
		return errorLayer;
	}

	/**
	 * Sets the value of the errorLayer property.
	 * 
	 * @param aErrorLayer the new value of the errorLayer property
	 */
	public void setErrorLayer(String aErrorLayer)
	{
		errorLayer = aErrorLayer;
	}

	/**
	 * Access method for the moduleName property.
	 * 
	 * @return   the current value of the moduleName property
	 */
	public String getModuleName()
	{
		return moduleName;
	}

	/**
	 * Sets the value of the moduleName property.
	 * 
	 * @param aModuleName the new value of the moduleName property
	 */
	public void setModuleName(String aModuleName)
	{
		moduleName = aModuleName;
	}

	/**
	 * Access method for the className property.
	 * 
	 * @return   the current value of the className property
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * Sets the value of the className property.
	 * 
	 * @param aClassName the new value of the className property
	 */
	public void setClassName(String aClassName)
	{
		className = aClassName;
	}

	/**
	 * Access method for the methodName property.
	 * 
	 * @return   the current value of the methodName property
	 */
	public String getMethodName()
	{
		return methodName;
	}

	/**
	 * Sets the value of the methodName property.
	 * 
	 * @param aMethodName the new value of the methodName property
	 */
	public void setMethodName(String aMethodName)
	{
		methodName = aMethodName;
	}

	/**
	 * Access method for the errorCode property.
	 * 
	 * @return   the current value of the errorCode property
	 */
	public String getErrorCode()
	{
		return errorCode;
	}

	/**
	 * Sets the value of the errorCode property.
	 * 
	 * @param aErrorCode the new value of the errorCode property
	 */
	public void setErrorCode(String aErrorCode)
	{
		errorCode = aErrorCode;
	}

	/**
	 * Access method for the exceptionMessage property.
	 * 
	 * @return   the current value of the exceptionMessage property
	 */
	public String getExceptionMessage()
	{
		//判断信息是否为空
		if(exceptionMessage != null)
		{
			//初始化行数
			int rowNum = 0;
			//退出循环点
			int breakPiont = 0;
			//获得信息长度
			int messageLength = exceptionMessage.length();
			//判断异常信息是否超长
			if(messageLength > MAX_MESSAGE_LENGTH)
			{
				//循环取异常信息
				for (int i = MAX_MESSAGE_LENGTH / 2; i < messageLength; i++)
				{
					//判断换行
					if (exceptionMessage.charAt(i) == '\n')
					{
						//行数累加
						rowNum++;
						//判断行数是否达到指定行数
						if (i > MAX_MESSAGE_LENGTH)
						{
							//截取异常信息
							exceptionMessage = exceptionMessage.substring(0, breakPiont);
							//退出循环
							break;
						}
						//记录循环点
						breakPiont = i;
					}
				}	
			}
		}
		return exceptionMessage;
	}

	/**
	 * Sets the value of the exceptionMessage property.
	 * 
	 * @param aExceptionMessage the new value of the exceptionMessage property
	 */
	public void setExceptionMessage(String aExceptionMessage)
	{
		exceptionMessage = aExceptionMessage;
	}

	/**
	 * Access method for the exception property.
	 * 
	 * @return   the current value of the exception property
	 */
	public Exception getException()
	{
		return exception;
	}

	/**
	 * Sets the value of the exception property.
	 * 
	 * @param aException the new value of the exception property
	 */
	public void setException(Exception aException)
	{
		exception = aException;
	}
}
