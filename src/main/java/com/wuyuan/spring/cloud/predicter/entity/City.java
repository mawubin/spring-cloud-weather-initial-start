/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mawubin
 *
 */
@XmlRootElement(name="d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	public String getCityID() {
		return cityID;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@XmlAttribute(name="d1")
	private String cityID;
	
	@XmlAttribute(name="d2")
	private String cityName;
	
	@XmlAttribute(name="d3")
	private String cityCode;
	
	@XmlAttribute(name="d4")
	private String province;
	
}
