/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmException 
 * 文件名称：McrmException.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-14
 * 设计文档：XXX
 * 内容摘要：统一异常处理对象 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-14
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.model.framework;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import com.zte.itp.ssb.framework.common.exception.JSONServiceException;
/**
 * 类 编 号：BL_PU2010101_McrmException
 * 类 名 称：McrmException
 * 内容摘要：统一异常处理对象 
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmException extends JSONServiceException
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -775639757037640542L;
	
	private McrmExceptionBO mcrmExceptionBO=new McrmExceptionBO();
	
	//语言标志,跟客户端的统一编码
	private String lan;
	//异常提示Code
	private String errorCode;
	
	public String getLan()
	{
		return lan;
	}

	public void setLan(String lan)
	{
		this.lan = lan;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * @return the mcrmExceptionBO
	 */
	public McrmExceptionBO getMcrmExceptionBO()
	{
		return mcrmExceptionBO;
	}

	/**
	 * @param mcrmExceptionBO the mcrmExceptionBO to set
	 */
	public void setMcrmExceptionBO(McrmExceptionBO mcrmExceptionBO)
	{
		this.mcrmExceptionBO = mcrmExceptionBO;
	}

	/**
	 * 方法编号：04
	 * 方法名称：McrmException
	 * 内容摘要：构造方法，含有异常信息和可抛出类型的入参，调用父类相同的构造方法
	 * 
	 * @param exceptionMessage
	 * @param throwable
	 */
	public McrmException(String exceptionMessage, Throwable throwable)
	{
		super(exceptionMessage);
	}

	/**
	 * 方法编号：03
	 * 方法名称：EccInfoException
	 * 内容摘要：构造方法，含有可抛出类型的入参，调用父类相同的构造方法
	 * 
	 * @param throwable
	 */
	public McrmException(Throwable throwable)
	{
		super();

	}

	/**
	 * 方法编号：02
	 * 方法名称：EccInfoException
	 * 内容摘要：构造方法，含有异常信息的入参，调用父类相同的构造方法
	 * 
	 * @param exceptionMessage
	 */
	public McrmException(String exceptionMessage)
	{
		super(exceptionMessage);

	}

	/**
	 * 方法编号：01 
	 * 方法名称：EccInfoException
	 * 内容摘要：空参构造方法，调用父类的空参构造方法
	 */
	public McrmException()
	{
		super();

	}
	
	/**
	 * 方法编号：05 
	 * 方法名称：EccInfoException
	 * 内容摘要：含异常信息的构造期
	 * @roseuid 4316C37E00FD
	 */
	public McrmException(
		String appName,
		String errorLayer,
		String moduleName,
		String className,
		String methodName,
		String errorCode,
		Exception exception)
	{
		//初始化异常
		getMcrmExceptionBO().getMcrmExceptionVO().setException(exception);
		//设置系统名称
		getMcrmExceptionBO().getMcrmExceptionVO().setAppName(appName);
		//设置异常发生的层
		getMcrmExceptionBO().getMcrmExceptionVO().setErrorLayer(errorLayer);
		//设置模块名称
		getMcrmExceptionBO().getMcrmExceptionVO().setModuleName(moduleName);
		//设置类名称
		getMcrmExceptionBO().getMcrmExceptionVO().setClassName(className);
		//初始化方法名称(调用私有方法自动获得)
		getMcrmExceptionBO().getMcrmExceptionVO().setMethodName(methodName);
		//设置异常码
		getMcrmExceptionBO().getMcrmExceptionVO().setErrorCode(errorCode);
		//初始化异常消息名称
		getMcrmExceptionBO().getMcrmExceptionVO().setExceptionMessage(getExceptionDetailsMessage(exception));
	}

	/**
	 * 方法编号：05 
	 * 方法名称：EccInfoException
	 * 内容摘要：含异常信息的构造期
	 * @roseuid 4316C37E00FD
	 */
	public McrmException(
		String appName,
		String errorLayer,
		String moduleName,
		String className,
		String errorCode,
		Exception exception)
	{
		//初始化异常
		getMcrmExceptionBO().getMcrmExceptionVO().setException(exception);
		//设置系统名称
		getMcrmExceptionBO().getMcrmExceptionVO().setAppName(appName);
		//设置异常发生的层
		getMcrmExceptionBO().getMcrmExceptionVO().setErrorLayer(errorLayer);
		//设置模块名称
		getMcrmExceptionBO().getMcrmExceptionVO().setModuleName(moduleName);
		//设置类名称
		getMcrmExceptionBO().getMcrmExceptionVO().setClassName(className);
		//初始化方法名称(调用私有方法自动获得)
		getMcrmExceptionBO().getMcrmExceptionVO().setMethodName(getMethodName(exception));
		//设置异常码
		getMcrmExceptionBO().getMcrmExceptionVO().setErrorCode(errorCode);
		//初始化异常消息名称
		getMcrmExceptionBO().getMcrmExceptionVO().setExceptionMessage(getExceptionDetailsMessage(exception));
	}
	
	/**
	 *方法编号：06
	 *方法名称：getMethodName
	 *内容摘要：返回调用该方法的方法名
	 *
	 *@param e
	 *@return methodname
	 */
	private String getMethodName(Exception e)
	{

		String input = getExceptionDetailsMessage(e);

		StringReader sr = new StringReader(input);

		BufferedReader br = new BufferedReader(sr);

		String line = "";
		String methodName = "";

		try
		{
			//读入一行数据
			br.readLine();
			line = br.readLine();
		}
		catch (IOException ex)
		{
			ex.printStackTrace(); 
		}
		//截取"("前的字符串
		int paren = line.indexOf('(');
		//判断是否存在左括号
		if(paren > 0)
		{
			line = line.substring(0, paren);
			//截取"."前的字符串
			int period = line.lastIndexOf('.');
			//判断是否存在点
			if(period > 0)
			{
				methodName = line.substring(period + 1);	
			}
			else
			{
				methodName = "SystemMethod";
			}
			//判断方法名称长度是否大于50字符
			if(methodName.length() >50)
			{
				methodName = "SystemMethod";
			}
		}
		else
		{
			methodName = "SystemMethod";
		}
		
		// 查找iBatis抛出的Exception
		if (methodName.equals("SystemMethod"))
		{
			try
			{
				// 读取所有异常信息
				while (true)
				{
					
					// 读取一行
					line = br.readLine();
					if (line == null)
						break;
					
					// 判断是否包含DAO.字样
					int nDAO = line.indexOf("DAO."); 
					if (nDAO > 0)
					{
						paren = line.indexOf('(', nDAO);
						// 是否有括号
						if (paren > 0)
						{
							//Debug.println("current line = " + line);
							
							// 取出方法名
							methodName = line.substring(nDAO+4, paren); 

							//判断方法名称长度是否大于50字符
							if(methodName.length() >50)
							{
								methodName = "SystemMethod";
							}
							
							break;
						}
					}
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace(); 
			}
		}	
		//返回处理后的字符串
		return methodName;
	}
	
	/**
	 * 
	 * 方法名称: getExceptionDetailsMessage
	 * 内容摘要: 获得堆栈信息
	 * 
	 * @param e 异常
	 * @return String
	 */
	public String getExceptionDetailsMessage(Exception e)
	{
		//声明输出信息
		String input = null;
		//初始化StringWriter
		StringWriter sw = new StringWriter();
		//初始化PrintWriter
		PrintWriter pw = new PrintWriter(sw);
		//打印堆栈
		e.printStackTrace(pw);
		//获得堆栈信息
		input = sw.getBuffer().toString();
		return input;
	}
	
}
