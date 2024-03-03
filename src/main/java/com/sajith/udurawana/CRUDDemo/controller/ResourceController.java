package com.sajith.udurawana.CRUDDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sajith.udurawana.CRUDDemo.dto.APIResponse;
import com.sajith.udurawana.CRUDDemo.dto.ResourceRequest;
import com.sajith.udurawana.CRUDDemo.service.ResourceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/resources")
@AllArgsConstructor
// For locally running front end
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ResourceController {
    private ResourceService resourceService;

    /**
     * Handles POST requests to generate KML (Keyhole Markup Language) data based on
     * the provided ResourceRequest.
     * Retrieves the resource data from the specified URL using the ResourceService
     * and returns it encapsulated
     * within an APIResponse, either as payload or error message, wrapped within a
     * ResponseEntity.
     * 
     * @param request The ResourceRequest containing the URL to fetch the resource.
     * @return ResponseEntity containing APIResponse with either the fetched data as
     *         payload or an error message.
     */
    @PostMapping("/kml")
    public ResponseEntity<APIResponse<String>> getKML(@RequestBody ResourceRequest request) {
        try {
            String data = resourceService.getResource(request.getUrl());
            return ResponseEntity.ok(APIResponse.<String>builder().payload(data).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<String>builder().error(e.getLocalizedMessage()).build());
        }
    }
}
