package com.cx.web;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping(value="/hello")
public class HelloController {
	
	private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	//从 application.properties 中读取配置，如取不到默认值为hello grass
  @Value("${application.hello:hello grass}")
	private String hello;
	
	@RequestMapping(value="/test")
	public String test(Map<String,Object> map) {
		log.info("123456789");
		map.put("hello", hello);
		return "index.jsp";
	}
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello() {
		System.out.println(123);
		return "aa.html";
	}
}
