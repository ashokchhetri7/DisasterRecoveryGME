package com.remit.banking.controller;

import com.remit.banking.dto.AccountBalance;
import com.remit.banking.service.BankingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Banking Services", description = "Secure Banking Operations")
public class BankingController {
    @Autowired
    private BankingService bankingService;

    @GetMapping("/balance")
    @Operation(
            summary = "Get Account Balance",
            description = "Retrieve current account balance"
//            ,security = @SecurityRequirement(name="bearerAuth")
    )
    public ResponseEntity<AccountBalance> getBalance(@RequestParam String accountNumber){
        return ResponseEntity.ok(bankingService.getAccountBalance(accountNumber));
    }

    @GetMapping("/{endpoint}")
    @Operation(summary="Maintenance Endpoint", description = "Endpoints under maintenance")
    public ResponseEntity<String> maintenanceEndpoint(@PathVariable String endpoint){
        if(!endpoint.equals("login") && !endpoint.equals("balance")){
            return ResponseEntity.ok("This Page is currently in maintenance");
        }
        return ResponseEntity.notFound().build();
    }
}
