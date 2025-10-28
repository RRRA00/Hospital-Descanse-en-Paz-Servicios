package com.example.mcc_patient_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MccPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MccPatientServiceApplication.class, args);
	}

}
