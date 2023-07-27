package com.Spring.SpringBoot.GettingStarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootGettingStartedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGettingStartedApplication.class, args);
	}

}
/*
Deploying Application can be done below methods
1. Running the Spring-Boot Application file
2. On terminal run
	mvn spring-boot:run
3. On terminal
 	mvn clean install   ->to clean the repo and create a jar file
 	java -jar filename.jar --spring.profiles.active=req_profile
 */
