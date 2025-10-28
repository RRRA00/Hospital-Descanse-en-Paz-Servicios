package com.cibertec.mcc_security_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MccSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MccSecurityServiceApplication.class, args);
	}

}
