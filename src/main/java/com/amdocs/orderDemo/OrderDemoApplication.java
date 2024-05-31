package com.amdocs.orderDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Collections;

@SpringBootApplication
@EnableFeignClients
public class OrderDemoApplication {


	private static final Logger log = LoggerFactory.getLogger(OrderDemoApplication.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OrderDemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8085"));
		app.run(args);
		log.info("Mercy Jacqueline Trujillo Rodriguezzzzzz");


	}

}
