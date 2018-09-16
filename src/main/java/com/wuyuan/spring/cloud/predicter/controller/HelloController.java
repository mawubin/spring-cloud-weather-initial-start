
package com.wuyuan.spring.cloud.predicter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ma
 *
 */

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String Hello(){
		
		return "helloworld"; 
	}

}
