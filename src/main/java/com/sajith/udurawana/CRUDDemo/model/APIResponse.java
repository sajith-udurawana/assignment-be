package com.sajith.udurawana.CRUDDemo.model;

import lombok.Builder;

@Builder
public record APIResponse<T>(T payload, String error) {
}
