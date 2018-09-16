/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.catalina.connector.InputBuffer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.wuyuan.spring.cloud.predicter.entity.City;
import com.wuyuan.spring.cloud.predicter.entity.CityList;
import com.wuyuan.spring.cloud.predicter.util.XmlBuilder;

/**
 * @author Administrator
 *
 */
@Service
public class CityDataServiceApl implements CityDataService{

	@Override
	public List<City> listCity() throws Exception {
		// 读取XML文件
		Resource resource = new ClassPathResource("hunancitylist.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line ="";
		while((line=br.readLine())!=null)
		{
			buffer.append(line);
		}
		br.close();
		//XML数据转换JAVA对象
		CityList citylist= (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
		
		return citylist.getCityList();
	}

}
