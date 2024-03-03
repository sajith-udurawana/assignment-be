package com.sajith.udurawana.CRUDDemo.service.impl;

import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;
import com.sajith.udurawana.CRUDDemo.entity.Role;
import com.sajith.udurawana.CRUDDemo.entity.User;
import com.sajith.udurawana.CRUDDemo.dto.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.dto.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.repository.UserRepository;
import com.sajith.udurawana.CRUDDemo.service.AuthService;
import com.sajith.udurawana.CRUDDemo.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the AuthService interface.
 * Provides methods for user authentication and registration.
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private JwtService jwtService;
    private AuthenticationManager authManager;
    private PasswordEncoder passwordEncoder;

    /**
     * Authenticates user credentials provided in the AuthenticationRequest.
     * Verifies the provided email and password using the authentication manager.
     * If authentication is successful, generates a JWT token for the authenticated
     * user.
     * 
     * @param request The AuthenticationRequest containing user login credentials.
     * @return An AuthenticationResponse with a token upon successful
     *         authentication,
     *         or an error message if authentication fails.
     */

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("Request: " + request);
        try {
            authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            Optional<User> user = userRepository.findUserByEmail(request.getEmail());
            if (user.isPresent()) {
                String jwToken = jwtService.generateToken(user.get());
                return AuthenticationResponse.builder().token(jwToken).build();
            } else {
                return AuthenticationResponse.builder().error("User not found!").build();
            }
        } catch (Exception e) {
            return AuthenticationResponse.builder().error(e.getLocalizedMessage()).build();
        }
    }

    /**
     * Registers a new user based on the provided RegisterRequest.
     * Encrypts the password, assigns the USER role, and saves the user to the
     * UserRepository.
     * Generates a JWT token for the registered user.
     * 
     * @param request The RegisterRequest containing user registration details.
     * @return An AuthenticationResponse with a token upon successful registration,
     *         or an error message if registration fails.
     */
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        try {
            Optional<User> user = userRepository.findUserByEmail(request.getEmail());
            if (user.isPresent()) {
                return AuthenticationResponse.builder().error("User already exists!").build();
            } else {
                User newUser = User.builder().email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
                userRepository.save(newUser);
                String jwToken = jwtService.generateToken(newUser);
                return AuthenticationResponse.builder().token(jwToken).build();
            }
        } catch (Exception e) {
            return AuthenticationResponse.builder().error(e.getLocalizedMessage())
                    .build();
        }
    }

}
