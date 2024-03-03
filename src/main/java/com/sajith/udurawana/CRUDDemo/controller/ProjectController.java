package com.sajith.udurawana.CRUDDemo.controller;

import com.sajith.udurawana.CRUDDemo.dto.ProjectDTO;
import com.sajith.udurawana.CRUDDemo.model.APIResponse;
import com.sajith.udurawana.CRUDDemo.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ProjectController {
    private ProjectService projectService;

    // Add project
    @PostMapping
    public ResponseEntity<APIResponse<ProjectDTO>> createProject(@RequestBody ProjectDTO dto) {
        try {
            ProjectDTO savedProject = projectService.createProject(dto);
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().payload(savedProject).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().error(e.getLocalizedMessage()).build());
        }
    }

    // Get project by ID
    @GetMapping("{id}")
    public ResponseEntity<APIResponse<ProjectDTO>> getProjectById(@PathVariable("id") Long id) {
        try {
            ProjectDTO dto = projectService.getProjectById(id);
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().payload(dto).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().error(e.getLocalizedMessage()).build());
        }
    }

    // Get all projects
    @GetMapping
    public ResponseEntity<APIResponse<List<ProjectDTO>>> getAllProjects() {
        try {
            List<ProjectDTO> projectDTOS = projectService.getProjects();
            return ResponseEntity.ok(APIResponse.<List<ProjectDTO>>builder().payload(projectDTOS).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<List<ProjectDTO>>builder().error(e.getLocalizedMessage()).build());
        }
    }

    // Update project by ID
    @PutMapping("{id}")
    public ResponseEntity<APIResponse<ProjectDTO>> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDTO dto) {
        try {
            ProjectDTO updatedProject = projectService.updateProject(id, dto);
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().payload(updatedProject).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().error(e.getLocalizedMessage()).build());
        }
    }

    // Delete project by ID
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse<String>> deleteProject(@PathVariable("id") Long id) {
        try {
            projectService.deleteProject(id);
            return ResponseEntity.ok(APIResponse.<String>builder().payload("Success").build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<String>builder().error(e.getLocalizedMessage()).build());
        }
    }
}
