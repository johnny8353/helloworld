package com.zte.mcrm.framework.ui.framework;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.zte.mcrm.framework.common.util.Env;
import com.zte.mcrm.framework.common.util.McrmDesSecretUtil;

/**
 * 单元测试基类,所有单元测试继承它
 * 
 * @author JohnnyHuang 黄福强
 */
public class AbstractTestBase extends TestCase
{
	// 日志信息，每个类都应该使用日志类，打印必要的信息
	private static Logger log = Logger.getLogger(AbstractTestBase.class);
	protected ApplicationContext ctx = null;

	/**
	 * 加载spring的配置文件
	 * 
	 * @param appCtxUrl
	 */
	public AbstractTestBase() {
		if (ctx == null) {
			ctx = ConfigResource.getInstance().sctx;
		}
	}
	
	/**
	 * 加载spring的配置文件
	 * @param appCtxUrl
	 */
   public AbstractTestBase(String s)
   {
	   super(s);
	   ctx=ConfigResource.getInstance().sctx;
   }
   
   
   /**
    * 判断指定的字符串是否是空(null或""或"null"或"NULL"都是空)
    * @param str
    * @return 空：true;非空:false
    */
   public  boolean checkStrIsEmpty(String str)
   {
   	boolean bln=false;
   	if(str==null || "".equals(str)||"NULL".equalsIgnoreCase(str))
   	{
   		bln=true;
   	}
   	return bln;
   }
	

	public String doEncrypt(String message) {
		String key = "12345678";
		String result = "";
		try{
			key = Env.getInstance().getProperty("SECRET_KEY");
			result = McrmDesSecretUtil.doEncrypt(message, key);
		}catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		return result;
	}

	public String doDecrypt(String message) {
		String key = "12345678";
		String result = "";
		try{
			key = Env.getInstance().getProperty("SECRET_KEY");
			result = McrmDesSecretUtil.doEncrypt(message, key);
		}catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		return result;
	}
}
