package com.example.GroupProject_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GroupProject4Application {

	public static void main(String[] args) {
		SpringApplication.run(GroupProject4Application.class, args);
	}

}
