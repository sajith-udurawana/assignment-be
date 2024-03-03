package com.sajith.udurawana.CRUDDemo.controller;

import com.sajith.udurawana.CRUDDemo.model.APIResponse;
import com.sajith.udurawana.CRUDDemo.service.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ResourceController {
    private ResourceService resourceService;

    // Get text data from a given URL. This is to avoid CORS errors when download
    // map data.
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<APIResponse<String>> getKMLData(@RequestBody String url) {
        try {
            String data = resourceService.getResource(url);
            System.out.println("Data: " + data);
            return ResponseEntity.ok(APIResponse.<String>builder().payload(data).build());
        } catch (Exception e) {
            return ResponseEntity.ok(APIResponse.<String>builder().payload("").build());
        }
    }
}
