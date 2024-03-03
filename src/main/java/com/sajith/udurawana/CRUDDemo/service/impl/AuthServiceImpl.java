package com.sajith.udurawana.CRUDDemo.service.impl;

import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;
import com.sajith.udurawana.CRUDDemo.entity.Role;
import com.sajith.udurawana.CRUDDemo.entity.User;
import com.sajith.udurawana.CRUDDemo.model.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.model.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.repository.UserRepository;
import com.sajith.udurawana.CRUDDemo.service.AuthService;
import com.sajith.udurawana.CRUDDemo.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private JwtService jwtService;
    private AuthenticationManager authManager;
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("Request: " + request);
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
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

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        try {
            Optional<User> user = userRepository.findUserByEmail(request.getEmail());
            if (user.isPresent()) {
                return AuthenticationResponse.builder().error("User already exists!").build();
            } else {
                User newUser = User.builder().email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
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
