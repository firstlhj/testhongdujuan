//package com.lzs.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
///*
//虚拟路径映射文件保存路径
//addResourceHandler：虚拟路径
//addResourceLocations：文件保存本地路径
// */
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //registry.addResourceHandler("/upload/**").addResourceLocations("file:C://upload/multilFiles/");
//        //docker 目录映射
//        registry.addResourceHandler("192.168.99.100:8080/upload/**").addResourceLocations("192.168.99.100:8080/home/uploads/");
//        //registry.addResourceHandler("/images/**").addResourceLocations("file:E://WorkSpaceTedu/IDEASVN/personalbio01/src/main/resources/static/");
//    }
//}