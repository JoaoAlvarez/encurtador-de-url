package com.encurtadorurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.encurtadorurl.resources","com.encurtadorurl.services","com.encurtadorurl.repositories","com.encurtadorurl"})
public class EncurtadorUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncurtadorUrlApplication.class, args);
	}

}
