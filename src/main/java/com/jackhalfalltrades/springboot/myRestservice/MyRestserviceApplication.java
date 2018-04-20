package com.jackhalfalltrades.springboot.myRestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.jackhalfalltrades.springboot","com.jackhalfalltrades.foundation"})
@SpringBootApplication
@EnableAutoConfiguration
public class MyRestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestserviceApplication.class, args);
	}
}
