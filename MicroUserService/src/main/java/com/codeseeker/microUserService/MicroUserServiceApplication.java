package com.codeseeker.microUserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class MicroUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroUserServiceApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
