package com.mcylm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Mikesam on 2017/8/4.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableRedisHttpSession
@EnableEurekaClient
public class Gateway{
    public static void main(String[] args) {
        SpringApplication.run(Gateway.class,args);
    }
}