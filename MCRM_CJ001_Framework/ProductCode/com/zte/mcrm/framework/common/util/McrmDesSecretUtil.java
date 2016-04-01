/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_McrmDesSecret 
 * 文件名称：McrmDesSecret.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJXXX
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-10-20
 * 设计文档：XXX
 * 内容摘要：加密解密工具类。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-10-20
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.common.util;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.axis.encoding.Base64;

/**
 * 类 编 号：BL_PU2010101_McrmDesSecret
 * 类 名 称：McrmDesSecret
 * 内容摘要：加密解密工具类
 * 完成日期：2014-10-20
 * 编码作者：JohnnyHuang 黄福强
 */
public class McrmDesSecretUtil
{
	private final static String ALGORITHM_DES="DES/CBC/PKCS5Padding";
	private final static String DES = "DES"; 
	public final static String ENCRYPT_KEY="12345678";
	   /**
	    * 字串加密
	    * @param message 需要加密的字串
	    * @param key 加密密钥
	    * @return 加密后的字串
	    * @throws Exception
	    */
	   public static String doEncrypt(String message,String key) throws Exception
	   {
		   return encode(key, message.getBytes());
	   }
	   
	   
	   /**
	     * 获取解密的值
	     * @param key
	     * @param data
	     * @return
	     * @throws Exception 
	     * @throws Exception
	     */
	    public static String doDecrypt(String message,String key) throws Exception 
	    {
	       byte[] datas;
	       String value = null;

	       datas = decode(key, Base64.decode(message));

	       value = new String(datas,"utf-8");//解决tomcat下乱码问题
	       if (value.equals(""))
	       {
	          throw new Exception();
	       }
	       return value;
	    }

	    /**
	     * DES算法，加密
	     *
	     * @param data 待加密字符串
	     * @param key  加密私钥，长度不能够小于8位
	     * @return 加密后的字节数组，一般结合Base64编码使用
	     * @throws CryptException 异常
	     */
	    public static String encode(String key,byte[] data) throws Exception
	    {
	        try
	        {
	      DESKeySpec dks = new DESKeySpec(key.getBytes());

	      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	            //key的长度不能够小于8位字节
	            Key secretKey = keyFactory.generateSecret(dks);
	            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
	            IvParameterSpec iv = new IvParameterSpec("********".getBytes());
	            AlgorithmParameterSpec paramSpec = iv;
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey,paramSpec);

	            byte[] bytes = cipher.doFinal(data);
	            return Base64.encode(bytes);
	        } catch (Exception e)
	        {
	            throw new Exception(e);
	        }
	    }

	    
	    
	    
	    /**
	     * DES算法，解密
	     *
	     * @param data 待解密字符串
	     * @param key  解密私钥，长度不能够小于8位
	     * @return 解密后的字节数组
	     * @throws Exception 异常
	     */
	    public static byte[] decode(String key,byte[] data) throws Exception
	    {
	        try
	        {
	            SecureRandom sr = new SecureRandom();
	            DESKeySpec dks = new DESKeySpec(key.getBytes());
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
	            //key的长度不能够小于8位字节
	            Key secretKey = keyFactory.generateSecret(dks);
	            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
	            IvParameterSpec iv = new IvParameterSpec("********".getBytes());
	            AlgorithmParameterSpec paramSpec = iv;
	            cipher.init(Cipher.DECRYPT_MODE, secretKey,paramSpec);
	            return cipher.doFinal(data);
	        } 
	        catch (Exception e)
	        {
	            throw new Exception(e);
	        }
	    }

	   public static void main(String[] args)
	   {
//		   String message="SIEBEL";
//		   String message="{\"C\":\"CompSearch\",\"L\":\"2052\",\"P\":{\"PNO\":\"1\",\"PSIZE\":\"15\"},\"U\":\"6011000000\",\"F\":[{\"K\":\"speSearchType\",\"V\":\"04\"},{\"K\":\"searchType\",\"V\":\"02\"},{\"K\":\"str\",\"V\":\"\"},{\"K\":\"quickType\",\"V\":\"02\"},{\"K\":\"quickLevel\",\"V\":\"01\"},{\"K\":\"dataId\",\"V\":\"1-D63BI\"},{\"K\":\"selectCode\",\"V\":\"\"},{\"K\":\"lstupd\",\"V\":\"2016-11-11 11:11:11\"},{\"K\":\"orderby\",\"V\":\"\"},{\"K\":\"selectCode\",\"V\":\"\"}]}";
		   String message="3+qIT719aK8WIfOcXi44kus/mD71GQIWKdSqU1IYIK0CMcadbC+R1LB8PejgeTTauuhc7rwo6yszE3odoA8ObQJZqnHjRnQqhU442TEEtH14Ga1vZmwaKgTSRs+xUJAwFrVtlQl+LBWF6iNhIfWta5fHItbpKmBqIzXLlTGl6xYyS7s8Qa1VNVcdfEyZvJOB3IQlXTc/ra8HnTBOh9N/rCSQr1VdgkbuvNI89gP4lqAqSRNjwDV4Elzev382FZaDLuLjgITPYAASKgSoOOjfhHAMablJhwevz2qK/vu79KDzw28mx9OzvMIRemVfB+2yKInpX+pKMGQj6XdVnY+GAgFd5KUPD+b8+oRmZXwwZLUZ87IDqsXmI91cJzKtHN6vP9OT47o5NGtkCvumC87BwehPKtTLiFHDhCRmzkh3WiOt8Dw1TWfuFYow28/jbqJnnrayO7tjK5ZlUv3dsexsUK3OESqsftnWitn3JbrD0Kx62UscTZORzQ==";
		   String key="12345678";
		   String pwd="sieBel_803873";
		   try
		   {
//			  String mesEncrypt=McrmDesSecretUtil.doEncrypt(message, key);
//			  System.out.println("mesEncrypt="+mesEncrypt);
			  
			  String pwdEncrypt=McrmDesSecretUtil.doEncrypt(pwd,key);
			  System.out.println("pwdEncrypt="+pwdEncrypt);
			  
			  
			  String mesDecrypt=McrmDesSecretUtil.doDecrypt(message,key);
			  System.out.println("message="+mesDecrypt);
			  
			  String pwdDecrypt=McrmDesSecretUtil.doDecrypt(pwdEncrypt,key);
			  System.out.println("pwd="+pwdDecrypt);
			  
			 String requestJsonObject = McrmDesSecretUtil.doDecrypt("3+qIT719aK8WIfOcXi44kus/mD71GQIWKdSqU1IYIK0CMcadbC+R1LB8PejgeTTauuhc7rwo6yszE3odoA8ObQJZqnHjRnQqhU442TEEtH14Ga1vZmwaKgTSRs+xUJAwFrVtlQl+LBWF6iNhIfWta5fHItbpKmBqIzXLlTGl6xYyS7s8Qa1VNVcdfEyZvJOB3IQlXTc/ra8HnTBOh9N/rCSQr1VdgkbuvNI89gP4lqAqSRNjwDV4Elzev382FZaDLuLjgITPYAASKgSoOOjfhHAMablJhwevz2qK/vu79KDzw28mx9OzvMIRemVfB+2yKInpX+pKMGQj6XdVnY+GAgFd5KUPD+b8+oRmZXwwZLUZ87IDqsXmI91cJzKtHN6vP9OT47o5NGtkCvumC87BwehPKtTLiFHDhCRmzkh3WiOt8Dw1TWfuFYow28/jbqJnnrayO7tjK5ZlUv3dsexsUK3OESqsftnWitn3JbrD0Kx62UscTZORzQ==",key);
				System.out.println(requestJsonObject);

		   }
		   catch (Exception e)
		   {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		   }
	   }
}
