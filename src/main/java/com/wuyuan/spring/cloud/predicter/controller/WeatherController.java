
package com.wuyuan.spring.cloud.predicter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wuyuan.spring.cloud.predicter.entity.WeatherResponse;
import com.wuyuan.spring.cloud.predicter.service.WeatherDataServiceApl;

/**
 * @author Ma
 *
 */

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	WeatherDataServiceApl weatherdata;
	
	@GetMapping("/cityID/{cityID}")
	public WeatherResponse getWeatherByCityID(@PathVariable("cityID") String cityID){
		return	weatherdata.getDataByCityId(cityID);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
		return	weatherdata.getDataByCityName(cityName);
	}

}
