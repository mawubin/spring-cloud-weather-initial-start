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
	 *���ݳ���ID��ѯ��������
	 */
	WeatherResponse getDataByCityId(String cityID);
	/**
	
	 *���ݳ������Ʋ�ѯ��������
	 */
	WeatherResponse getDataByCityName(String cityName);
	/**
	 * 
	 *���ݳ���IDͬ������
	 */	
	void syncDataByCityID(String cityID);
		
}
