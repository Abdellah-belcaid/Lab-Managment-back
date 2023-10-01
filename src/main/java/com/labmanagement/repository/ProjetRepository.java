package com.labmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labmanagement.model.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
