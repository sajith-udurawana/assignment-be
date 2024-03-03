package com.sajith.udurawana.CRUDDemo.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    public String extractEmail(String jwToken);

    public boolean isValidToken(String jwToken, UserDetails details);

    public String generateToken(UserDetails details);
}
