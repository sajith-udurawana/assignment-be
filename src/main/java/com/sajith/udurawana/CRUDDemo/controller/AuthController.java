package com.sajith.udurawana.CRUDDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sajith.udurawana.CRUDDemo.dto.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.dto.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;
import com.sajith.udurawana.CRUDDemo.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
