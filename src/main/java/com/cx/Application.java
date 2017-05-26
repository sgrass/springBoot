package com.cx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.cx.*.mapper")
public class Application extends SpringBootServletInitializer{

	/**
	 * 打包为war的方式
	 * 继承SpringBootServletInitializer类，重载configure方法
	 * pom文件package修改为war
	 * 增加依赖 <artifactId>spring-boot-starter-tomcat</artifactId>
	 */
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
