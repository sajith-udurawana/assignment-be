package com.sajith.udurawana.CRUDDemo.service;

import com.sajith.udurawana.CRUDDemo.entity.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.entity.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;

public interface AuthService {
    public AuthenticationResponse authenticate(AuthenticationRequest request);

    public AuthenticationResponse register(RegisterRequest request);

}
