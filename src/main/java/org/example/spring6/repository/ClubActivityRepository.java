package org.example.spring6.repository;

import org.example.spring6.domain.ClubActivity;

import java.util.List;
import java.util.Optional;

public interface ClubActivityRepository {

    ClubActivity save(ClubActivity activity);

    List<ClubActivity> findAll();

    Optional<ClubActivity> findById(Long id);

    ClubActivity update(Long id, ClubActivity activity);

    void delete(Long id);

    List<ClubActivity> findByCategory(String category);
}