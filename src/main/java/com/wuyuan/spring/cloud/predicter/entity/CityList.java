/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.entity;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrator
 *
 */
@XmlRootElement(name="c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
	@XmlElement(name="d")
	public List<City> cityList;

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
}
