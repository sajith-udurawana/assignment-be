package com.sajith.udurawana.CRUDDemo.mapper;

import com.sajith.udurawana.CRUDDemo.dto.ProjectDTO;
import com.sajith.udurawana.CRUDDemo.entity.Project;

/**
 * Utility class for mapping between Project and ProjectDTO objects.
 */
public class ProjectMapper {
    public static ProjectDTO mapToProjectDTO(Project project) {
        return new ProjectDTO(project.getId(), project.getName(), project.getDescription(), project.getMapURL());
    }

    public static Project mapToEmployee(ProjectDTO dto) {
        return new Project(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getMapURL());
    }
}
