package com.sajith.udurawana.CRUDDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a request for user registration.
 * This class includes fields for email, password, and user role.
 * 
 * @param email    The email address of the user for registration.
 * @param password The password associated with the user's account for
 *                 registration.
 * @param role     The role of the user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    public String email;
    public String password;
    public Role role;
}
