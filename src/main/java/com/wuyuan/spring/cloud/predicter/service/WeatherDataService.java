/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.service;

import com.wuyuan.spring.cloud.predicter.entity.WeatherResponse;

/**
 * @author Mawubin
 *
 */
public interface WeatherDataService {

	/**
	 *
	 *根据城市ID查询天气数据
	 */
	WeatherResponse getDataByCityId(String cityID);
	/**
	
	 *根据城市名称查询天气数据
	 */
	WeatherResponse getDataByCityName(String cityName);
	/**
	 * 
	 *根据城市ID同步数据
	 */	
	void syncDataByCityID(String cityID);
		
}
