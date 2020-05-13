package com.jamessu712.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayServerApplication.class, args);
	}

}
