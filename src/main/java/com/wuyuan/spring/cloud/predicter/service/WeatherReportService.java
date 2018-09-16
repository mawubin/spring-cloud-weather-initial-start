
package com.wuyuan.spring.cloud.predicter.service;

import com.wuyuan.spring.cloud.predicter.entity.Weather;

/**
 * @author Mawubin
 * @date 2018��9��6��
 */
public interface WeatherReportService {
	/**
	 * 
	 * @param cityID
	 * @return
	 */
	public Weather getDataByCityID(String cityID);
}
