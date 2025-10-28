package com.example.mcc_divice_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MccDiviceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MccDiviceServiceApplication.class, args);
	}

}
