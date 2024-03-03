package com.sajith.udurawana.CRUDDemo.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Service interface for JWT token handling.
 * Defines methods for extracting email from a token, validating token validity,
 * and generating tokens.
 */
public interface JwtService {
    String extractEmail(String jwToken);

    boolean isValidToken(String jwToken, UserDetails details);

    String generateToken(UserDetails details);
}
