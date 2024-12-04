package com.remit.banking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Maintenance Endpoints", description = "Endpoints under maintenance")
public class MaintenanceController {

    @GetMapping("/{endpoint}")
    @Operation(summary = "Maintenance Endpoint", description = "Endpoints currently in maintenance")
    public ResponseEntity<String> maintenanceEndpoint(@PathVariable String endpoint) {
        if ("login".equals(endpoint)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
        }
        return ResponseEntity.ok("This Page is currently in maintenance.");
    }
}