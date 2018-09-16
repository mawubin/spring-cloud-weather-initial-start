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
 * 实现天气数据服务的函数接口
 * @author Mawubin
 *
 */
@Service
public class WeatherDataServiceApl implements WeatherDataService{
	private static final String WEATHER_URL="http://wthrcdn.etouch.cn/weather_mini";
	private static final long TIME_OUT = 1000L;
	//这里会去configuration里面去扫描自动注入
	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	StringRedisTemplate stringredistemplate;
	@Override
	public WeatherResponse getDataByCityId(String cityID) {
		// 通过cityID去获取数据
		String url=WEATHER_URL+"?citykey="+cityID;
		return this.getWeatherData(url);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		// 通过名称获取数据
		String url=WEATHER_URL+"?city="+cityName;
		return this.getWeatherData(url);
	}
	/**
	 * 根据城市ID来获取天气
	 */
	@Override
	public void syncDataByCityID(String cityID) {
		// TODO Auto-generated method stub
		String url=WEATHER_URL+"?citykey="+cityID;
		this.updateWeatherData(url);
	}
	//根据url更新缓存数据函数
	private void updateWeatherData(String url)
	{
		ValueOperations<String, String> vo= stringredistemplate.opsForValue();
		String strbody="";
		ResponseEntity<String> response=resttemplate.getForEntity(url, String.class);
		
		if(response!=null && response.getStatusCodeValue()==200)
		{
			strbody = response.getBody();
		}
		//将数据写入缓存
		vo.set(url, strbody, TIME_OUT, TimeUnit.SECONDS);
		
	}
	//从缓存中获取数据，如果缓存没有，则重新去拿
	private WeatherResponse getWeatherData(String url)
	{
		String key = url;
		String strbody=null;
		WeatherResponse wr= null;
		ValueOperations<String, String> vo= stringredistemplate.opsForValue();
		//如果缓存中有数据
		if(stringredistemplate.hasKey(key))
		{
			strbody=vo.get(key);
		}
		//缓存没有数据，则去拿
		else{
			ResponseEntity<String> response=resttemplate.getForEntity(url, String.class);
			if(response!=null && response.getStatusCodeValue()==200)
			{
				strbody = response.getBody();
			}
			//将数据写入缓存
			vo.set(url, strbody, TIME_OUT, TimeUnit.SECONDS);
		}
		//json序列化的包
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
	//重构出来的获取数据方法
	private WeatherResponse dogetWeather(String url)
	{
		ResponseEntity<String> response=resttemplate.getForEntity(url, String.class);
		String weath_str=null;
		//System.out.print(url);
		if(response!=null && response.getStatusCodeValue()==200)
		{
			weath_str = response.getBody();
		}
		//自带将json字符串变成对象的方法
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
	 * 将数据放入缓存
	 */
	

}
