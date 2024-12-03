package com.remit.banking.controller;

import com.remit.banking.dto.LoginRequest;
import com.remit.banking.service.UserDetailsServiceImpl;
import com.remit.banking.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Authentication", description = "Login and Authentication Endpoints")
public class AuthController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Authenticate user credentials")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            if (userDetails.getPassword().equals(loginRequest.getPassword())) {
                String token = jwtUtil.generateToken(userDetails.getUsername());
                return ResponseEntity.ok(token);
            }
        } catch (UsernameNotFoundException e) {
            // do nothing
        }
        return ResponseEntity.badRequest().body("Invalid Credentials");
    }
}