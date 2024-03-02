package com.sajith.udurawana.CRUDDemo.controller;

import com.sajith.udurawana.CRUDDemo.dto.ProjectDTO;
import com.sajith.udurawana.CRUDDemo.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ProjectController {
    private ProjectService projectService;

    // Add project
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        ProjectDTO savedProject = projectService.createProject(dto);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    // Get project by ID
    @GetMapping("{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("id") Long id) {
        ProjectDTO dto = projectService.getProjectById(id);
        return ResponseEntity.ok(dto);
    }

    // Get all projects
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projectDTOS = projectService.getProjects();
        return ResponseEntity.ok(projectDTOS);
    }

    // Update project by ID
    @PutMapping("{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDTO dto) {
        ProjectDTO updatedProject = projectService.updateProject(id, dto);
        return ResponseEntity.ok(updatedProject);
    }

    // Delete project by ID
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        final Map<String, String> map = new HashMap<>();
        map.put("message", "Project deleted successfully!");
        return ResponseEntity.ok(map);
    }
}
