package com.example.hack24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(basePackages = "com.example.hack24")
@SpringBootApplication
public class Hack24Application {

	public static void main(String[] args) {
		SpringApplication.run(Hack24Application.class, args);
	}

}
