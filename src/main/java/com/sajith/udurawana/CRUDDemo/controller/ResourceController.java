package com.sajith.udurawana.CRUDDemo.controller;

import com.sajith.udurawana.CRUDDemo.dto.APIResponse;
import com.sajith.udurawana.CRUDDemo.dto.ResourceRequest;
import com.sajith.udurawana.CRUDDemo.service.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ResourceController {
    private ResourceService resourceService;

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
