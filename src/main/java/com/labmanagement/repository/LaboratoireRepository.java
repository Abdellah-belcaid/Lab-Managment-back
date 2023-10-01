package com.labmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labmanagement.model.entity.Laboratoire;

public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {

}
