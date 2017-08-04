package com.mcylm.clay.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Mikesam on 2017/8/4.
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class Config {

    public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }
}
