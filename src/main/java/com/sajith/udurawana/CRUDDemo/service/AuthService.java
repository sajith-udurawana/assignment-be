package com.sajith.udurawana.CRUDDemo.service;

import com.sajith.udurawana.CRUDDemo.dto.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.dto.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;

/**
 * Service interface for user authentication and registration.
 * Defines methods for authenticating and registering users.
 */
public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse register(RegisterRequest request);
}
