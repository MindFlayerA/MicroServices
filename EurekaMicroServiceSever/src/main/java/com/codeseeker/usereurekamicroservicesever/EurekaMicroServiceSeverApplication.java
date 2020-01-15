package com.codeseeker.usereurekamicroservicesever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaMicroServiceSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMicroServiceSeverApplication.class, args);
	}

}
