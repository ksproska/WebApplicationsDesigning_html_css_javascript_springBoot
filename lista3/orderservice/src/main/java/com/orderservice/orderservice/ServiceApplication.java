package com.orderservice.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.data.repository.query.QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND;

@SpringBootApplication
@EnableJpaRepositories(queryLookupStrategy = CREATE_IF_NOT_FOUND)
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}
