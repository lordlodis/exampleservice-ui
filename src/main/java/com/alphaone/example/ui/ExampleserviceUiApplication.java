package com.alphaone.example.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExampleserviceUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleserviceUiApplication.class, args);
	}

}
