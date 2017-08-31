package com.mcylm.clay.service.openstackService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Mikesam on 2017/8/9.
 */
@SpringBootApplication(scanBasePackages = "com.mcylm.clay.service.openstackService.*")
@MapperScan({"com.mcylm.clay.service.openstackService.mapper.*"})
@EnableRedisHttpSession
@EnableEurekaClient
public class OpenStackService {

    public static void main(String[] args) {
        SpringApplication.run(OpenStackService.class,args);
    }
}
