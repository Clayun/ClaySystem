package com.mcylm.clay.service.consoleservice.config;

import com.mcylm.clay.service.consoleservice.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:Mr_Shen
 * @Description: 新写的拦截器注册一下!
 * @Date:2017/8/25/025
 * @Modified By:None one
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig(){
        super();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/*").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/*").addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：除了/index，/system/user/validate其他都拦截判断
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("*//**").excludePathPatterns("/login");
        super.addInterceptors(registry);
    }
}