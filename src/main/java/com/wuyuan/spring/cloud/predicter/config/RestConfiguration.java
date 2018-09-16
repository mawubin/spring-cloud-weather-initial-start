/**
 * 
 */
package com.wuyuan.spring.cloud.predicter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mawubin
 * @date 2018Äê9ÔÂ6ÈÕ
 */
@Configuration
public class RestConfiguration {
	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
	public RestTemplate restTemplate(){
		return builder.build();
	}
}
