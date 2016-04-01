/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmExceptionComm 
 * 文件名称：McrmExceptionComm.java
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
package com.zte.mcrm.framework.model.framework;

import java.io.IOException;
import java.sql.SQLException;
import java.util.zip.DataFormatException;

/**
 * 类 编 号：BL_PU2010101_McrmExceptionComm
 * 类 名 称：McrmExceptionComm
 * 内容摘要：提供给其它业务类调用的统一异常处理类 ，抛出异常throwMcrmException
 * 完成日期：2014-10-14
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmExceptionComm
{

    /**
     * 系统名称
     */
    public static final String APP_NAME = "MCRM";

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
    
	 /**
     * 方法编号：01
     * 方法名称: getMcrmException
     * 内容摘要: 抛出异常得静态公用方法
     * 
     * @param errorLayer 发生异常所在的代码曾级
     * @param moduleName 所属模块名
     * @param moduleCode 所属模块编码
     * @param className 发生异常的类名
     * @param exception 具体异常信息
     * @throws McrmException
     */
    public static synchronized void throwMcrmException(String errorLayer,String moduleName, String moduleCode, String className,
            Exception exception) throws McrmException
    {
        //判断异常是否已经是McrmException
        if (exception instanceof McrmException)
        {
            //直接抛出扑抓到得异常
            throw (McrmException) exception;
        }
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
        //构造异常
        McrmException pmInfoException = new McrmException(APP_NAME, errorLayer, moduleName, className, errorCode.toString(), exception);
        throw pmInfoException;
    }

    /**
     * 单纯生成McrmException错误对象而不抛出以便后续手工处理
     * @param errorLayer
     * @param moduleName
     * @param className
     * @param exception
     * @return
     */
    public static synchronized McrmException generateMcrmException(String errorLayer, String moduleName,String moduleCode,
    		String className, Exception exception)
    {
        McrmException McrmException = null;
        //判断异常是否已经是McrmException
        if (exception instanceof McrmException)
        {
            //直接抛出扑抓到得异常
            McrmException = (McrmException) exception;
            return McrmException;
        }
        //初始化异常码
        StringBuffer errorCode = new StringBuffer();
        //判断模块名称
        errorCode.append(moduleCode);
        //判断模块名称
//        if (PROJECT_MANAGE_MODULE_NAME.equals(moduleName))
//        {
//            errorCode.append(PROJECT_MANAGE_MODULE_CODE);
//        }
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
        //构造异常
        McrmException = new McrmException(APP_NAME, errorLayer, moduleName, className, errorCode.toString(),exception);
        return McrmException;
    }
}
