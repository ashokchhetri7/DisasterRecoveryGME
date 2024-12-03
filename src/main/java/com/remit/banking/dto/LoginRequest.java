package com.remit.banking.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequest {
    @Schema(description = "User's login username", example = "Ashok")
    private String username;

    @Schema(description = "User's login password")
    private String password;

}
