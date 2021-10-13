package com.pch.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//激活eureka server
@EnableEurekaServer
public class AgricultureEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgricultureEurekaServerApplication.class, args);
    }

}
