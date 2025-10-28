package com.example.mcc_alert_service.exeption;

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }
}
