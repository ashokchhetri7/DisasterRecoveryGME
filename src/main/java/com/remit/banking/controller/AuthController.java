package com.remit.banking.controller;

import com.remit.banking.dto.LoginRequest;
import com.remit.banking.dto.LoginResponse;
import com.remit.banking.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Authentication", description = "Login and Authentication Endpoints")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Authenticate user credentials and generate JWT")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

//    @GetMapping("/login")
//    @Operation(summary = "Login Endpoint", description = "Login Endpoint doesn not support GET Requests")
//    public ResponseEntity<String> loginGet(){
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
//                .body("Method not allowed");
//    }
}