package com.sajith.udurawana.CRUDDemo.dto;

import lombok.Builder;

@Builder
public record APIResponse<T>(T payload, String error) {
}
