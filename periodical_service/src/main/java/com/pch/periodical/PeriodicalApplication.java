package com.pch.periodical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PeriodicalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeriodicalApplication.class,args);
    }
}
