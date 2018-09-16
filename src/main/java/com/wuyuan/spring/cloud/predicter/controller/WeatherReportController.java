
package com.wuyuan.spring.cloud.predicter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wuyuan.spring.cloud.predicter.entity.City;
import com.wuyuan.spring.cloud.predicter.entity.WeatherResponse;
import com.wuyuan.spring.cloud.predicter.service.CityDataService;
import com.wuyuan.spring.cloud.predicter.service.WeatherDataServiceApl;
import com.wuyuan.spring.cloud.predicter.service.WeatherReportServiceApl;

/**
 * @author Ma
 *
 */

@RestController
@RequestMapping("/weatherreport")
public class WeatherReportController {
	
	@Autowired
	WeatherDataServiceApl weatherdata;
	
	@Autowired
	CityDataService citydataservice;
	
	@Autowired
	WeatherReportServiceApl wrs;
	
	@GetMapping("/cityID/{cityID}")
	public ModelAndView getWeatherByCityID(@PathVariable("cityID") String cityID,Model model) throws Exception{
		ModelAndView mv= new ModelAndView("/report");
		model.addAttribute("title","ÌìÆøÔ¤±¨");
		model.addAttribute("cityID", cityID);
		List<City> cityList =citydataservice.listCity();
		model.addAttribute("cityList",cityList);
		model.addAttribute("weatherdata", wrs.getDataByCityID(cityID));	
		
		mv.addObject("reportModel", model);
		return mv;
		//return new ModelAndView("weather/report","reportModel",model);
		
		
	}
	

}
