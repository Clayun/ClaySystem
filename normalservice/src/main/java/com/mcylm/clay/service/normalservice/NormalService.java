package com.mcylm.clay.service.normalservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Mikesam on 2017/8/4.
 */
@SpringBootApplication(scanBasePackages = "com.mcylm.clay.service.normalservice.*")
@MapperScan({"com.mcylm.clay.service.normalservice.mapper.*"})
@EnableRedisHttpSession
@EnableEurekaClient
public class NormalService {

    public static void main(String[] args) {
        SpringApplication.run(NormalService.class,args);
    }
}
