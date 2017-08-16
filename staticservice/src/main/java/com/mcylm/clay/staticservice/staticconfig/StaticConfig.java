package com.mcylm.clay.staticservice.staticconfig;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lenovo on 2017/8/16.
 */
public class StaticConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(resourceHandlerRegistry);
    }
}
