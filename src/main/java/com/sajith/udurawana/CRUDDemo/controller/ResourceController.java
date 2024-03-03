package com.sajith.udurawana.CRUDDemo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sajith.udurawana.CRUDDemo.service.ResourceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/resources")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ResourceController {
    private ResourceService resourceService;

    // Get text data from a given URL. This is to avoid CORS errors when download
    // map data.
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> postMethodName(@RequestBody String url) {
        try {
            String data = resourceService.getResource(url);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.ok("");
        }
    }
}
