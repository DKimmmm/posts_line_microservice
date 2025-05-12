package com.example.postsline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PostslineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostslineApplication.class, args);
	}

}
