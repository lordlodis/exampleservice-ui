package com.alphaone.example.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExampleserviceUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleserviceUiApplication.class, args);
	}
	
}
