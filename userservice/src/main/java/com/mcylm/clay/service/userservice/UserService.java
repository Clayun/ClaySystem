package com.mcylm.clay.service.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Mikesam on 2017/8/4.
 */

@SpringBootApplication(scanBasePackages = "com.mcylm.clay.service.userservice")
@EnableEurekaClient
@EnableWebMvc
public class UserService {

    public static void main(String[] args) {
        SpringApplication.run(UserService.class, args);
    }
}
