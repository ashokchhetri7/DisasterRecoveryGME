package com.remit.banking.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class LoginResponse {
    @Schema(description = "JWT Authentication Token")
    private String token;

    @Schema(description = "Token Type")
    private String type = "Bearer";
}