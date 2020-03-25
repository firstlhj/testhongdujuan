package com.lzs.personalbio01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

@MapperScan("com.lzs.dao")
@ComponentScan("com.lzs")
public class Personalbio01Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Personalbio01Application.class, args);
	}
	//这里配置静态资源文件的路径导包都是默认的直接导入就可以
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/assets/");
//		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/resources")
				.addResourceLocations("classpath:/static")
				.addResourceLocations("classpath:/templates")
				.addResourceLocations("classpath:/public");
	}
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
//	}


}
