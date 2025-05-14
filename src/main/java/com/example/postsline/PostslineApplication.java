package com.example.postsline;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition
@EnableScheduling
public class PostslineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostslineApplication.class, args);
	}

}
