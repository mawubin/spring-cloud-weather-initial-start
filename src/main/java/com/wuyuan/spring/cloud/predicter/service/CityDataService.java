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
 * ��ȡ�����б�
 * @return ��������
 *
 */
	List<City> listCity() throws Exception;
}
