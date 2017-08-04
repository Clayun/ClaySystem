package com.mcylm.clay.controlcenter;

/**
 * Created by Mikesam on 2017/8/4.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Controlcenter {

    public static void main(String[] args) {
        SpringApplication.run(Controlcenter.class,args);
    }

}
