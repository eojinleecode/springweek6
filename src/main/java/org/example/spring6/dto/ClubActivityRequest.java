package org.example.spring6.dto;

public record ClubActivityRequest(
        String title,
        String clubName,
        String category,
        String activityDate,
        String location,
        Integer participants,
        String description
) {
}