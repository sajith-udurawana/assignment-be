package com.sajith.udurawana.CRUDDemo.dto;

import lombok.Builder;

/**
 * Represents an API response containing either a payload of type T or an error
 * message.
 * This record class is annotated with @Builder to enable convenient creation of
 * instances using the builder pattern.
 *
 * @param <T>     The type of payload contained in the API response.
 * @param payload The payload data of type T returned in the API response.
 * @param error   The error message indicating any failure occurred during API
 *                processing.
 */
@Builder
public record APIResponse<T>(T payload, String error) {
}
