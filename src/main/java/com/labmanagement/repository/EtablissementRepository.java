package com.labmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labmanagement.model.entity.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

}
