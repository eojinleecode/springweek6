package org.example.spring6.controller;

import org.example.spring6.dto.ClubActivityRequest;
import org.example.spring6.dto.ClubActivityResponse;
import org.example.spring6.service.ClubActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ClubActivityController {

    private final ClubActivityService service;

    public ClubActivityController(ClubActivityService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ClubActivityResponse> create(
            @RequestBody ClubActivityRequest request) {

        ClubActivityResponse response = service.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClubActivityResponse>> findAll(
            @RequestParam(required = false) String category) {

        if (category != null && !category.isBlank()) {
            return ResponseEntity.ok(service.findByCategory(category));
        }

        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClubActivityResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClubActivityResponse> update(
            @PathVariable Long id,
            @RequestBody ClubActivityRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}