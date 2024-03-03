package com.sajith.udurawana.CRUDDemo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a response to an authentication request.
 * This class includes fields for a token and an error message.
 * 
 * @param token The authentication token generated upon successful
 *              authentication.
 * @param error The error message indicating any failure occurred during
 *              authentication.
 */
@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private String error;
}
