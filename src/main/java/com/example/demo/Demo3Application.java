package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication()
@ComponentScan({"com.example.demo"})
public class Demo3Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

}
