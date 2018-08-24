package com.springboot.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserNameService {
	
	@RequestMapping("/api/user/name")
	public String getUserName() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "John Smith";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserNameService.class,
				"--spring.application.name=user-name-service",
				"--server.port=3001"
		);
	}


	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
