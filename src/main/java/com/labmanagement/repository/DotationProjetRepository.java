package com.labmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.model.entity.Dotation_Project.DotationProjectId;;

public interface DotationProjetRepository extends JpaRepository<Dotation_Project, DotationProjectId> {

	List<Dotation_Project> findAllById_ProjetId(Long projetId);

	List<Dotation_Project> findAllById_MembreId(Long membreId);
}
