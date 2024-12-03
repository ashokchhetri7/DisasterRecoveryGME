package com.remit.banking.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AccountBalance {
    @Schema(description ="Account number", example="12345678")
    private String accountNumber;

    @Schema(description = "Current Balance", example="23456.05")
    private double balance;
}
