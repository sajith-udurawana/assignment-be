package com.sajith.udurawana.CRUDDemo.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sajith.udurawana.CRUDDemo.dto.APIResponse;
import com.sajith.udurawana.CRUDDemo.dto.ProjectDTO;
import com.sajith.udurawana.CRUDDemo.service.ProjectService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
// For locally running front end
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ProjectController {
    private ProjectService projectService;

    /**
     * Handles POST requests to create a new project by accepting a ProjectDTO in
     * the request body.
     * Invokes the projectService to persist the project data and returns the saved
     * project encapsulated
     * within an APIResponse, either as payload or error message, wrapped within a
     * ResponseEntity.
     * 
     * @param dto The ProjectDTO containing the project data to be created.
     * @return ResponseEntity containing APIResponse with either the created project
     *         as payload or an error message.
     */
    @PostMapping
    public ResponseEntity<APIResponse<ProjectDTO>> createProject(@RequestBody ProjectDTO dto) {
        try {
            ProjectDTO savedProject = projectService.createProject(dto);
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().payload(savedProject).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().error(e.getLocalizedMessage()).build());
        }
    }

    /**
     * Handles GET requests to retrieve project details by the specified project ID.
     * Retrieves the project details from the projectService based on the provided
     * ID
     * and returns them encapsulated within an APIResponse, either as payload or
     * error message,
     * wrapped within a ResponseEntity.
     * 
     * @param id The unique identifier of the project to retrieve.
     * @return ResponseEntity containing APIResponse with either the retrieved
     *         project details as payload or an error message.
     */
    @GetMapping("{id}")
    public ResponseEntity<APIResponse<ProjectDTO>> getProjectById(@PathVariable("id") Long id) {
        try {
            ProjectDTO dto = projectService.getProjectById(id);
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().payload(dto).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().error(e.getLocalizedMessage()).build());
        }
    }

    /**
     * Handles GET requests to retrieve details of all projects.
     * Retrieves a list of project details from the projectService and returns them
     * encapsulated
     * within an APIResponse, either as payload or error message, wrapped within a
     * ResponseEntity.
     * 
     * @return ResponseEntity containing APIResponse with either the list of project
     *         details as payload or an error message.
     */
    @GetMapping
    public ResponseEntity<APIResponse<List<ProjectDTO>>> getAllProjects() {
        try {
            List<ProjectDTO> projectDTOS = projectService.getProjects();
            return ResponseEntity.ok(APIResponse.<List<ProjectDTO>>builder().payload(projectDTOS).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<List<ProjectDTO>>builder().error(e.getLocalizedMessage()).build());
        }
    }

    /**
     * Handles PUT requests to update project details for the specified project ID.
     * Updates the project details using the provided ProjectDTO and the
     * projectService,
     * and returns the updated project encapsulated within an APIResponse, either as
     * payload or error message,
     * wrapped within a ResponseEntity.
     * 
     * @param id  The unique identifier of the project to update.
     * @param dto The ProjectDTO containing the updated project data.
     * @return ResponseEntity containing APIResponse with either the updated project
     *         details as payload or an error message.
     */
    @PutMapping("{id}")
    public ResponseEntity<APIResponse<ProjectDTO>> updateProject(@PathVariable("id") Long id,
            @RequestBody ProjectDTO dto) {
        try {
            ProjectDTO updatedProject = projectService.updateProject(id, dto);
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().payload(updatedProject).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<ProjectDTO>builder().error(e.getLocalizedMessage()).build());
        }
    }

    /**
     * Handles DELETE requests to delete a project by the specified project ID.
     * Deletes the project identified by the given ID using the projectService,
     * and returns a success message encapsulated within an APIResponse, or an error
     * message,
     * wrapped within a ResponseEntity.
     * 
     * @param id The unique identifier of the project to delete.
     * @return ResponseEntity containing APIResponse indicating the success or
     *         failure of the deletion operation.
     */
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
