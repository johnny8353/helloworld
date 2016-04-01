package com.zte.mcrm.framework.model.framework;

import java.io.IOException;
import java.sql.SQLException;
import java.util.zip.DataFormatException;

import com.zte.mcrm.framework.common.util.StringUtils;

/**
 * 
 * 类 编 号：
 * 类 名 称：SiebelExceptionComm
 * 内容摘要：提供给其它业务类调用的统一异常处理类 ，抛出异常
 * 完成日期：2016-1-12
 * 编码作者：JohnnyHuang
 */
public class SiebelExceptionComm {

	/**
     * 系统名称
     */
    public static final String APP_NAME = "SIEBEL";

    /**
     * 控制层
     */
    public static final String ERROR_LAYER_CONTROLER = "controler";

    /**
     * 业务逻辑层
     */
    public static final String ERROR_LAYER_SERVICE = "service";

    /**
     * 数据访问层
     */
    public static final String ERROR_LAYER_DAO = "dao";


    /**
     * 项目管理模块代码
     */
    private static final String PROJECT_MANAGE_MODULE_CODE = "10";

    /**
     * 数据访问层异常代码
     */
    private static final String DOA_EXCEPTION_CODE = "01";

    /**
     * 服务层异常代码
     */
    private static final String SERVICE_EXCEPTION_CODE = "02";

    /**
     * 控制层异常代码
     */
    private static final String ACTION_EXCEPTION_CODE = "03";

    /**
     * 定义外的异常
     */
    private static final String OTHER_EXCEPTION = "000";

    /**
     * SQL异常
     */
    private static final String SQL_EXCEPTION = "001";

    /**
     * IO异常
     */
    private static final String IO_EXCEPTION = "002";

    /**
     * 空指针异常
     */
    private static final String NULL_POINTER_EXCEPTION = "003";

    /**
     * 类运行期异常
     */
    private static final String CLASS_CAST_EXCEPTION = "004";

    /**
     * 数据格式异常
     */
    private static final String DATA_FORMAT_EXCEPTION = "005";

    /**
     * 非法参数异常
     */
    private static final String ILLEGAL_ARGUMENT_EXCEPTION = "006";

    /**
     * 下标越界异常
     */
    private static final String INDEX_OUTOF_BOUNDS_EXCEPTION = "007";

    /**
     * 类不存在异常
     */
    private static final String CLASS_NOT_FOUND_EXCEPTION = "008";

    /**
     * 方法不存在异常
     */
    private static final String NO_SUCH_METHOD_EXCEPTION = "009";

    /**
     * 属性域不存在异常
     */
    private static final String NO_SUCH_FIELD_EXCEPTION = "010";
    //宕机具体关键字
    private static final String SERVER_ERROR_INFO="(500)Internal Server Error";

    //字符串分隔符
    private static final String SPLITOR="_";
    //
	 /**
     * 方法编号：01
     * 方法名称: throwMcrmException
     * 内容摘要: 抛出异常得静态公用方法   2015-12-21  
     * @param errorCode  异常编号
     * @param errorLayer 发生异常所在的代码曾级
     * @param moduleName 所属模块名
     * @param moduleCode 所属模块编码
     * @param className 发生异常的类名
     * @param exception 具体异常信息
     * @throws McrmException
     */
    public static synchronized void throwSiebelException(String sysName,String methodName,String errorLayer,String moduleName, String moduleCode, String className,Exception exception) throws SiebelException
    {

            //初始化异常码
        String errorCode=getSysErrorCode(sysName,methodName,errorLayer,moduleCode,exception);

        SiebelException siebelException = null;
        //判断异常是否已经是McrmException
        if (exception instanceof SiebelException)
        {
            //直接抛出扑抓到得异常
        	siebelException = (SiebelException) exception;
            if(StringUtils.checkStrIsEmpty(siebelException.getErrorCode()))
            {
            	siebelException.setErrorCode(errorCode);
            }
            throw siebelException;
        }
        //构造异常
        siebelException = new SiebelException(sysName, errorLayer, moduleName, className,methodName, errorCode, exception);
        //
        throw siebelException;
    }

    /**
     * 单纯生成McrmException错误对象而不抛出以便后续手工处理 2015-12-21 
     * @param errorCode 异常编号
     * @param errorLayer
     * @param moduleName
     * @param className
     * @param exception
     * @return
     */
    public static synchronized SiebelException generateSiebelException(String sysName,String methodName,String errorLayer,String moduleName,String moduleCode,String className, Exception exception)
    {

		// 初始化异常码
		String errorCode = getSysErrorCode(sysName, methodName, errorLayer,moduleCode, exception);

		SiebelException siebelException = null;
		// 判断异常是否已经是SiebelException
		if (exception instanceof SiebelException)
		{
			// 直接抛出扑抓到得异常
			siebelException = (SiebelException) exception;
			if (StringUtils.checkStrIsEmpty(siebelException.getErrorCode()))
			{
				siebelException.setErrorCode(errorCode);
			}
			return siebelException;
		}

        //构造异常
		siebelException = new SiebelException(sysName, errorLayer, moduleName, className,methodName, errorCode, exception);
        return siebelException;
    }
    
    /**
     * 判断确定是哪种errorCode
     * 完成日期:2015-12-21
     * @param errorLayer
     * @param moduleCode
     * @param exception
     * @return
     */
    private static String getSysErrorCode(String sysName,String methodName,String errorLayer,String moduleCode,Exception exception)
    {
       String errorCode="";

       if(StringUtils.checkStrIsEmpty(sysName))
       {
    	   //没标志系统的统一为SmartSales的服务器异常
    	   errorCode=getSmartSalesErrorCode(errorLayer,moduleCode,exception);
       }
       else
       {
    	   //其它第三方系统调用的异常code
           errorCode=getSysErrorType(exception);
       }
       
       return errorCode;
    }
    

    /**
     * 
     * 判断其它系统的异常种类,得出具体的异常错误码
     * 完成日期:2016-1-4
     * @param exception
     * @param sysFlag
     * @return
     */
    private static String getSysErrorType(Exception exception)
    {
        //初始化异常码
        String errorCode ="";
        
//        //获取具体的异常堆栈信息
//        McrmException mec=new McrmException();
//        String ex=mec.getExceptionDetailsMessage(exception);
//        
//        //循环 关键词，确定异常类型
//        Map<String,DataDitionaryVO> errTypeMap=(Map<String,DataDitionaryVO>)SysDataConfig.getErrTypeMap();
//		if (ex != null && errTypeMap != null && errTypeMap.size() > 0)
//		{
//			Iterator<Map.Entry<String, DataDitionaryVO>> iter = errTypeMap.entrySet().iterator();
//			while (iter.hasNext())
//			{
//				Map.Entry<String, DataDitionaryVO> e = iter.next();
//
//				// 如果找到其中一种，就跳出循环
//				if (null != e.getValue().getAttrib1() && ex.indexOf(e.getValue().getAttrib1()) > -1)
//				{
//					errorCode = e.getValue().getAttrib2();
//					break;
//				}
//			}
//		}
//		if(StringUtils.checkStrIsEmpty(errorCode))
//		{
//			errorCode=SysConst.METHOD_ERROR;
//		}

        return errorCode;
    }
    
    /**
     * SmartSales判断确定是哪种errorCode
     * 完成日期:2015-12-21
     * @param errorLayer
     * @param moduleCode
     * @param exception
     * @return
     */
    private static String getSmartSalesErrorCode(String errorLayer,String moduleCode,Exception exception)
    {
        //初始化异常码
        StringBuffer errorCode = new StringBuffer();

        //判断模块名称
        errorCode.append(moduleCode);

        //判断是否控制层抛出的异常
        if (ERROR_LAYER_CONTROLER.equals(errorLayer))
        {
            errorCode.append(ACTION_EXCEPTION_CODE);
        }
        //判断是否服务层抛出的异常
        else if (ERROR_LAYER_SERVICE.equals(errorLayer))
        {
            errorCode.append(SERVICE_EXCEPTION_CODE);
        }
        //判断是否数据访问层抛出的异常
        else if (ERROR_LAYER_DAO.equals(errorLayer))
        {
            errorCode.append(DOA_EXCEPTION_CODE);
        }
        //判断是否为SQL异常异常
        if (exception instanceof SQLException)
        {
            errorCode.append(SQL_EXCEPTION);
        }
        //判断是否为IO异常
        else if (exception instanceof IOException)
        {
            errorCode.append(IO_EXCEPTION);
        }
        //判断是否为空指针异常
        else if (exception instanceof NullPointerException)
        {
            errorCode.append(NULL_POINTER_EXCEPTION);
        }
        //判断是否为类运行期异常
        else if (exception instanceof ClassCastException)
        {
            errorCode.append(CLASS_CAST_EXCEPTION);
        }
        //判断是否为数据格式异常
        else if (exception instanceof DataFormatException)
        {
            errorCode.append(DATA_FORMAT_EXCEPTION);
        }
        //判断是否为非法参数异常
        else if (exception instanceof IllegalArgumentException)
        {
            errorCode.append(ILLEGAL_ARGUMENT_EXCEPTION);
        }
        //判断是否为下标越界异常
        else if (exception instanceof IndexOutOfBoundsException)
        {
            errorCode.append(INDEX_OUTOF_BOUNDS_EXCEPTION);
        }
        //判断是否为类不存在异常
        else if (exception instanceof ClassNotFoundException)
        {
            errorCode.append(CLASS_NOT_FOUND_EXCEPTION);
        }
        //判断是否为方法不存在异常
        else if (exception instanceof NoSuchMethodException)
        {
            errorCode.append(NO_SUCH_METHOD_EXCEPTION);
        }
        //判断是否为属性域不存在异常
        else if (exception instanceof NoSuchFieldException)
        {
            errorCode.append(NO_SUCH_METHOD_EXCEPTION);
        }
        //判断是否为定义外的异常
        else
        {
            errorCode.append(OTHER_EXCEPTION);
        }
        return errorCode.toString();
    }

}
