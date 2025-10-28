package com.example.mcc_patient_service.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "patient_notifications";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }
}
