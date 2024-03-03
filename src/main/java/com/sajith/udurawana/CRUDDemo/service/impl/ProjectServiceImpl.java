package com.sajith.udurawana.CRUDDemo.service.impl;

import com.sajith.udurawana.CRUDDemo.dto.ProjectDTO;
import com.sajith.udurawana.CRUDDemo.entity.Project;
import com.sajith.udurawana.CRUDDemo.exception.ProjectNotFoundException;
import com.sajith.udurawana.CRUDDemo.mapper.ProjectMapper;
import com.sajith.udurawana.CRUDDemo.repository.ProjectRepository;
import com.sajith.udurawana.CRUDDemo.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Override
    public ProjectDTO createProject(ProjectDTO dto) {
        Project project = ProjectMapper.mapToEmployee(dto);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.mapToProjectDTO(savedProject);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid id!");
        }
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id %d not found!".formatted(id)));
        return ProjectMapper.mapToProjectDTO(project);
    }

    @Override
    public List<ProjectDTO> getProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(ProjectMapper::mapToProjectDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid id!");
        }
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id %d not found!".formatted(id)));
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setMapURL(dto.getMapURL());
        Project updatedProject = projectRepository.save(project);
        return ProjectMapper.mapToProjectDTO(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid id!");
        }
        projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id %d not found!".formatted(id)));
        projectRepository.deleteById(id);
    }

}
