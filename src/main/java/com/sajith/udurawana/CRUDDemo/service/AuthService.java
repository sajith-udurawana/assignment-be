package com.sajith.udurawana.CRUDDemo.service;

import com.sajith.udurawana.CRUDDemo.model.AuthenticationRequest;
import com.sajith.udurawana.CRUDDemo.model.AuthenticationResponse;
import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;

public interface AuthService {
    public AuthenticationResponse authenticate(AuthenticationRequest request);

    public AuthenticationResponse register(RegisterRequest request);

}
