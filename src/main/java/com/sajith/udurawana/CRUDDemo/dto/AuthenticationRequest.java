package com.sajith.udurawana.CRUDDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}
