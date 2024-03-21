package com.database.greatlistens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.database.greatlistens.repository")
// @ComponentScan(basePackages = { "com.database.greatlistens.*" })
// @EntityScan("com.database.greatlistens.model.*") 
public class GreatListensApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatListensApplication.class, args);
	}

}
