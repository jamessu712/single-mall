package com.jamessu712.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;


//@EnableFeignClients(basePackages = {"com.jamessu712"})
@EnableDiscoveryClient
@SpringBootApplication
public class MallWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebServiceApplication.class, args);
    }

}
