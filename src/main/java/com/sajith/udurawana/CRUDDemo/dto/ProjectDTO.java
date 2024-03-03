package com.sajith.udurawana.CRUDDemo.dto;

import lombok.*;

/**
 * Represents a Data Transfer Object (DTO) for project details.
 * This class includes fields for project ID, name, description, and map URL.
 * 
 * @param id          The unique identifier of the project.
 * @param name        The name of the project.
 * @param description The description of the project.
 * @param mapURL      The URL to access the map associated with the project.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private String mapURL;
}
