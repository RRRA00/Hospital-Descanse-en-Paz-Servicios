package com.example.mcc_patient_service.messaging;

import com.example.mcc_patient_service.configuration.RabbitMQConfig;
import com.example.mcc_patient_service.dto.VitalSignDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VitalSignPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publish(VitalSignDTO dto) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, dto);
        System.out.println("📤 Enviado a RabbitMQ: " + dto);
    }
}
