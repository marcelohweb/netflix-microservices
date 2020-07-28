package com.soares.microservice.movie.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "com.soares.microservice.commons.entity")
@EnableJpaRepositories(basePackages = "com.soares.microservice.movie.api.repository")
public class MovieMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieMicroserviceApplication.class, args);
	}

}
