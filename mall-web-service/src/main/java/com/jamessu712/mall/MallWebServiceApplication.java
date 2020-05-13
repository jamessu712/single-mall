package com.jamessu712.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MallWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebServiceApplication.class, args);
    }

}
