package com.sajith.udurawana.CRUDDemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private String error;
}
