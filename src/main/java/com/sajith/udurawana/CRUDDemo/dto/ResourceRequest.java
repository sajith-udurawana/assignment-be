package com.sajith.udurawana.CRUDDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Data Transfer Object (DTO) for resource requests.
 * This class includes a field for the URL of the requested resource.
 * 
 * @param url The URL of the requested resource.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRequest {
    private String url;
}
