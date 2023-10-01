package com.labmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labmanagement.model.entity.Director;


public interface DirectorRepository extends JpaRepository<Director, Long> {
    // Add any additional query methods specific to the Director entity
}

