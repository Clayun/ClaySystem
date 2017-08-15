package com.mcylm.cley.service.userservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Mikesam on 2017/8/4.
 */

@SpringBootApplication(scanBasePackages = "com.mcylm.cley.service.userservice.*")
@MapperScan("com.mcylm.cley.service.userservice.mapper.*")
@EnableEurekaServer
public class UserService {

    public static void main(String[] args) {
        SpringApplication.run(UserService.class, args);
    }
}
