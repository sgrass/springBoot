package com.cx.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafController {

private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/test")
	public String test(Map<String,Object> map) {
		
		
		Map<String, String> resMap = new HashMap<>();
		resMap.put("11", "AAAAAAA");
		resMap.put("22", "BBBBBBB");
		resMap.put("33", "CCCCCCC");
		resMap.put("44", "DDDDDDDD");
		resMap.put("55", "EEEEEEEE");
		
		map.put("hello", "hello world.....");
		map.put("resMap", resMap);
		map.put("flag", false);
		map.put("date", new Date());
		map.put("url", "www.baidu.com");
		return "thymeleaf";
	}
	
	
	@RequestMapping(value="/layout")
	public String layout(Map<String,Object> map) {
		return "layout";
	}
}
