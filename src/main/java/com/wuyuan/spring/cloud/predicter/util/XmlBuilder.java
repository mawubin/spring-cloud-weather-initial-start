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
 *��xmlתΪpojo�Ķ���
 */
public class XmlBuilder {
	public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception{
		Object xmlObject =null;
		Reader reader= null;
		
		JAXBContext jaxbcontext = JAXBContext.newInstance(clazz);	
		//XML תΪ����ӿ�
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
