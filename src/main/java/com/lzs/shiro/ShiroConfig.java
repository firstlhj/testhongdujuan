package com.lzs.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        bean.setSecurityManager(securityManager);
        Map map1 = new LinkedHashMap();
        map1.put("rememberMe",rememberAuthenticationFilter());
        bean.setFilters(map1);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // map.put("rememberMe","rememberAuthenticationFilter");
//        map.put("/themLefy","user");
//        map.put("/themlefy","anon");
//        map.put("/login","anon");
        map.put("/swaplogin","anon");
        map.put("/login3","anon");
        map.put("/failed","anon");
        map.put("/register","anon");
//        map.put("/homepage","user");
        map.put("/nomal/favicon.ico","anon");
        map.put("/favicon.ico","anon");
        // 静态资源放行
        map.put("/static/**", "anon");
        map.put("/static/css/**","anon");
        map.put("/assets/css/**","anon");
        map.put("/assets/images/**","anon");
        map.put("/js/**","anon");
        map.put("/assets/js/**","anon");
        map.put("/layui/**","anon");

        //swagger
//        map.put("/swagger-ui.html", "anon");
//        map.put("/swagger-resources/**", "anon");
//        map.put("/v2/**", "anon");
//        map.put("/webjars/**", "anon");


        //授权过滤
//        map.put("/add","perms[user:add]");
         map.put("/me","perms[user:update]");
        map.put("/**","rememberMe");
        map.put("/**","user");
        // map.put("/**","anon");

//        bean.setLoginUrl("/login");
        bean.setLoginUrl("/swaplogin");
        bean.setSuccessUrl("/homepage");
        bean.setUnauthorizedUrl("/failed");
        bean.setFilterChainDefinitionMap(map);

        return bean;

    }

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("shiroRealm")ShiroRealm shiroRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm);
        manager.setRememberMeManager(cookieRememberMeManager());
        return manager;
    }

    @Bean("shiroRealm")
    public ShiroRealm shiroRealm(){
        return  new ShiroRealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    @Bean("simpleCookie")
    public SimpleCookie rememberMeCookie(){
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(300);
        return cookie;
    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie());
        // rememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return rememberMeManager;
    }

    //    @Bean
//    public FormAuthenticationFilter formAuthenticationFilter() {
//        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
//        formAuthenticationFilter.setRememberMeParam("rememberMe");
//        return formAuthenticationFilter;
//    }
    @Bean("rememberAuthenticationFilter")
    public RememberAuthenticationFilter rememberAuthenticationFilter(){
        return new RememberAuthenticationFilter();
    }
}
