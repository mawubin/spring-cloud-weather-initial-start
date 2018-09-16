/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuyuan.spring.cloud.predicter.entity.Weather;

/**
 * @author Mawubin
 * @date 2018Äê9ÔÂ6ÈÕ
 */
@Service
public class WeatherReportServiceApl implements WeatherReportService {

	@Autowired
	WeatherDataService weatherdataservice;
	@Override
	public Weather getDataByCityID(String cityID) {
		// TODO Auto-generated method stub
		Weather weather=weatherdataservice.getDataByCityId(cityID).getData();
		return weather;
	}

}
