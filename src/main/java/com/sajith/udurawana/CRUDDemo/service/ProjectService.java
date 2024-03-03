package com.sajith.udurawana.CRUDDemo.service;

import com.sajith.udurawana.CRUDDemo.dto.ProjectDTO;

import java.util.List;

/**
 * Service interface for managing projects.
 * Defines methods for creating, retrieving, updating, and deleting projects.
 */
public interface ProjectService {
    ProjectDTO createProject(ProjectDTO dto);

    ProjectDTO getProjectById(Long id);

    List<ProjectDTO> getProjects();

    ProjectDTO updateProject(Long id, ProjectDTO dto);

    void deleteProject(Long id);
}
