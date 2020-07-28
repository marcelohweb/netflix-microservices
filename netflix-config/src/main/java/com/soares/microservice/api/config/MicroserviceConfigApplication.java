package com.soares.microservice.api.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigApplication.class, args);
	}

}
