/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.service;

import java.util.List;

import com.wuyuan.spring.cloud.predicter.entity.City;

/**
 * @author Mawubin
 *
 */
public interface CityDataService {

/**
 * 获取城市列表
 * @return 城市数据
 *
 */
	List<City> listCity() throws Exception;
}
