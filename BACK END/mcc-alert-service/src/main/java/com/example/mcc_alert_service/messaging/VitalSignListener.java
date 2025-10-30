package com.example.mcc_alert_service.messaging;


import com.example.mcc_alert_service.configuration.RabbitMQConfig;
import com.example.mcc_alert_service.dto.VitalSignDTO;
import com.example.mcc_alert_service.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VitalSignListener {

    private final AlertService alertService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(VitalSignDTO dto) {
        System.out.println("📥 Recibido desde RabbitMQ: " + dto);
        alertService.processVitalSign(dto);
    }
}
