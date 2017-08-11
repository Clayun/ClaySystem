package com.mcylm.clay.securityservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Mikesam on 2017/8/4.
 */


@SpringBootApplication(scanBasePackages = "com.mcylm.clay.securityservice.*")
@MapperScan({"com.mcylm.clay.securityservice.mapper.*"})
@EnableEurekaClient
public class SecurityService {
    public static void main(String[] args) {
        SpringApplication.run(SecurityService.class, args);
    }




}
