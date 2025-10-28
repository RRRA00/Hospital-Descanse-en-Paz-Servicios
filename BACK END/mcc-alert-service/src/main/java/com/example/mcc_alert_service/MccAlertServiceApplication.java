package com.example.mcc_alert_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MccAlertServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MccAlertServiceApplication.class, args);
	}

}
