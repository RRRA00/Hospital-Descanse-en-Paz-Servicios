package com.cibertec.mcc_user_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseValidItem {
    private String campo;
    private String mensaje;
}
