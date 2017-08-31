package com.mcylm.clay.staticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by lenovo on 2017/8/16.
 *静态资源服务器
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableEurekaClient
public class StaticService {
    public static void main(String[] args) {
        SpringApplication.run(StaticService.class,args);
    }
}
