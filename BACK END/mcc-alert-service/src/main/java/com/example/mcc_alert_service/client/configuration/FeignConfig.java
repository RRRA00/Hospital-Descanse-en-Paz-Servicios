package com.example.mcc_alert_service.client.configuration;



import com.example.mcc_alert_service.client.exception.RetreiveMessageErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public ErrorDecoder errorResponse() {
        return new RetreiveMessageErrorDecoder();
    }
}
