package com.sajith.udurawana.CRUDDemo.service;

import com.sajith.udurawana.CRUDDemo.dto.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.dto.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;

public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse register(RegisterRequest request);
}
