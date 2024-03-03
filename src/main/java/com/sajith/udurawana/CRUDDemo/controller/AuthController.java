package com.sajith.udurawana.CRUDDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sajith.udurawana.CRUDDemo.dto.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.dto.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;
import com.sajith.udurawana.CRUDDemo.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
// For locally running front end
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class AuthController {
    private AuthService authService;

    /**
     * Handles POST requests for user login.
     * Authenticates user credentials provided in the AuthenticationRequest by
     * invoking the authService,
     * and returns the authentication response encapsulated within a ResponseEntity.
     * 
     * @param request The AuthenticationRequest containing user login credentials.
     * @return ResponseEntity containing the AuthenticationResponse for the
     *         authenticated user.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    /**
     * Handles POST requests for user registration.
     * Registers a new user based on the provided RegisterRequest by invoking the
     * authService,
     * and returns the authentication response encapsulated within a ResponseEntity.
     * 
     * @param request The RegisterRequest containing user registration details.
     * @return ResponseEntity containing the AuthenticationResponse for the
     *         registered user.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
