package com.bd.eshopper.api.avion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableHystrix
public class ApiAvionApplication {
	
	private static final Logger LOGGER  =LoggerFactory.getLogger(ApiAvionApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ApiAvionApplication.class, args);
		LOGGER.info("#### Api Avion is running ");
	}

}
