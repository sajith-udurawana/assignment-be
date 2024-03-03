package com.sajith.udurawana.CRUDDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Represents a request for user authentication.
 * This class includes fields for email and password.
 * 
 * @param email    The email address of the user for authentication.
 * @param password The password associated with the user's account for
 *                 authentication.
 */
@Data
@Builder
@AllArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}
