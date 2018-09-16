/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

/**
 * @author Mawubin
 *将xml转为pojo的对象
 */
public class XmlBuilder {
	public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception{
		Object xmlObject =null;
		Reader reader= null;
		
		JAXBContext jaxbcontext = JAXBContext.newInstance(clazz);	
		//XML 转为对象接口
		Unmarshaller unmaller= jaxbcontext.createUnmarshaller();
		
		reader = new StringReader(xmlStr);
		xmlObject=unmaller.unmarshal(reader);
		
		if(null != reader)
		{
			reader.close();
		}
		return xmlObject;
		
	}

}
