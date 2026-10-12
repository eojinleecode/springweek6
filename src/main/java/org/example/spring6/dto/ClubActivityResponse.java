package org.example.spring6.dto;

public record ClubActivityResponse(
        Long id,
        String title,
        String clubName,
        String category,
        String activityDate,
        String location,
        Integer participants,
        String description
) {
}