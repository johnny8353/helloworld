/**
 * 版权所有：版权所有(C) 2014，中兴通讯 
 * 文件编号：BL_PU2010101_DecryptPropertyPlaceholderConfigurer 
 * 文件名称：DecryptPropertyPlaceholderConfigurer.java
 * 系统编号：100000201191
 * 系统名称：移动CRM
 * 组件编号：MCRM_CJ001
 * 组件名称：MCRM_CJ001_Framework
 * 设计作者：JohnnyHuang 黄福强
 * 完成日期：2014-11-14
 * 设计文档：MCRM_CJ001_Framework.cat
 * 内容摘要：解密配置文件属性。 
 *
 * 修改记录：01
 * 修   改  人：JohnnyHuang 黄福强
 * 修改日期：2014-11-14
 * 活  动   号：XXX
 * 修改内容：新增
 *
 */
package com.zte.mcrm.framework.common.secure;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import com.zte.mcrm.framework.common.util.McrmDesSecretUtil;

/**
 * 类 编 号：BL_PU2010101_DecryptPropertyPlaceholderConfigurer
 * 类 名 称：DecryptPropertyPlaceholderConfigurer
 * 内容摘要：解密配置文件属性
 * 完成日期：2014-11-14
 * 编码作者：JohnnyHuang 黄福强
 */
public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{

    protected Resource[] locations;  
    private Set<String> encryptedProps = Collections.emptySet(); 
    
    public void setEncryptedProps(Set<String> encryptedProps) 
    { 
        this.encryptedProps = encryptedProps; 
    } 

    @Override    
    public void setLocations(Resource[] locations) 
    {         
    	super.setLocations(locations);         
    	this.locations = locations;     
    }       
    @Override    
    public void setLocation(Resource location) 
    {   
    	super.setLocation(location);         
    	this.locations = new Resource[]{location};     
    } 

	   @Override
	    protected String convertProperty(String propertyName, String propertyValue) 
	   { 
		   if (encryptedProps.contains(propertyName)) 
		   { 
			   //如果在加密属性名单中发现该属性 
			try
			{
				String encryPropertyValue=McrmDesSecretUtil.doDecrypt(propertyValue,McrmDesSecretUtil.ENCRYPT_KEY);
				if(encryPropertyValue!=null)
				{
					propertyValue=encryPropertyValue;
				}
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   return super.convertProperty(propertyName, propertyValue);
	   }
}
