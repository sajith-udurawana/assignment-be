package com.sajith.udurawana.CRUDDemo.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sajith.udurawana.CRUDDemo.entity.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.entity.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;
import com.sajith.udurawana.CRUDDemo.entity.Role;
import com.sajith.udurawana.CRUDDemo.entity.User;
import com.sajith.udurawana.CRUDDemo.repository.UserRepository;
import com.sajith.udurawana.CRUDDemo.service.AuthService;
import com.sajith.udurawana.CRUDDemo.service.JwtService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private JwtService jwtService;
    private AuthenticationManager authManager;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found!"));
        String jwToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwToken).build();
    }

    @SuppressWarnings("null")
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder().email(request.getEmail())
                .password(new BCryptPasswordEncoder().encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String jwToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwToken).build();
    }

}
