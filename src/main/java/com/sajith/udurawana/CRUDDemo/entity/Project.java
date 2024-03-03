package com.sajith.udurawana.CRUDDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a project entity.
 * This class is mapped to the "projects" table in the database.
 * 
 * @param id          The unique identifier of the project.
 * @param name        The name of the project.
 * @param description The description of the project.
 * @param mapURL      The URL to access the map associated with the project.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, name = "map_url")
    private String mapURL;
}
