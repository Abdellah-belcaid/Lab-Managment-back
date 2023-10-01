package com.labmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labmanagement.model.entity.Membre;

public interface MembreRepository extends JpaRepository<Membre, Long> {

}
