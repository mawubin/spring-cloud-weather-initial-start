/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuyuan.spring.cloud.predicter.entity.WeatherResponse;

import ch.qos.logback.core.util.SystemInfo;

/**
 * ʵ���������ݷ���ĺ����ӿ�
 * @author Mawubin
 *
 */
@Service
public class WeatherDataServiceApl implements WeatherDataService{
	private static final String WEATHER_URL="http://wthrcdn.etouch.cn/weather_mini";
	private static final long TIME_OUT = 1000L;
	//�����ȥconfiguration����ȥɨ���Զ�ע��
	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	StringRedisTemplate stringredistemplate;
	@Override
	public WeatherResponse getDataByCityId(String cityID) {
		// ͨ��cityIDȥ��ȡ����
		String url=WEATHER_URL+"?citykey="+cityID;
		return this.getWeatherData(url);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		// ͨ�����ƻ�ȡ����
		String url=WEATHER_URL+"?city="+cityName;
		return this.getWeatherData(url);
	}
	/**
	 * ���ݳ���ID����ȡ����
	 */
	@Override
	public void syncDataByCityID(String cityID) {
		// TODO Auto-generated method stub
		String url=WEATHER_URL+"?citykey="+cityID;
		this.updateWeatherData(url);
	}
	//����url���»������ݺ���
	private void updateWeatherData(String url)
	{
		ValueOperations<String, String> vo= stringredistemplate.opsForValue();
		String strbody="";
		ResponseEntity<String> response=resttemplate.getForEntity(url, String.class);
		
		if(response!=null && response.getStatusCodeValue()==200)
		{
			strbody = response.getBody();
		}
		//������д�뻺��
		vo.set(url, strbody, TIME_OUT, TimeUnit.SECONDS);
		
	}
	//�ӻ����л�ȡ���ݣ��������û�У�������ȥ��
	private WeatherResponse getWeatherData(String url)
	{
		String key = url;
		String strbody=null;
		WeatherResponse wr= null;
		ValueOperations<String, String> vo= stringredistemplate.opsForValue();
		//���������������
		if(stringredistemplate.hasKey(key))
		{
			strbody=vo.get(key);
		}
		//����û�����ݣ���ȥ��
		else{
			ResponseEntity<String> response=resttemplate.getForEntity(url, String.class);
			if(response!=null && response.getStatusCodeValue()==200)
			{
				strbody = response.getBody();
			}
			//������д�뻺��
			vo.set(url, strbody, TIME_OUT, TimeUnit.SECONDS);
		}
		//json���л��İ�
		ObjectMapper mapper =new ObjectMapper();
		try {
			wr =mapper.readValue(strbody, WeatherResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wr;
	}
	
	
/*	
	//�ع������Ļ�ȡ���ݷ���
	private WeatherResponse dogetWeather(String url)
	{
		ResponseEntity<String> response=resttemplate.getForEntity(url, String.class);
		String weath_str=null;
		//System.out.print(url);
		if(response!=null && response.getStatusCodeValue()==200)
		{
			weath_str = response.getBody();
		}
		//�Դ���json�ַ�����ɶ���ķ���
		ObjectMapper mapper =new ObjectMapper();
		WeatherResponse wr=null;
		try {
			wr =mapper.readValue(weath_str, WeatherResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wr;
		
	}*/
	/**
	 * �����ݷ��뻺��
	 */
	

}
