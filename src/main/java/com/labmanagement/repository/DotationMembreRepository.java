package com.labmanagement.repository;

import com.labmanagement.model.entity.Dotation_Membre;
import com.labmanagement.model.entity.Dotation_Membre.DotationMembreId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DotationMembreRepository extends JpaRepository<Dotation_Membre, DotationMembreId> {

	List<Dotation_Membre> findAllById_UcaRechId(Long ucaRechId);

	List<Dotation_Membre> findAllById_MembreId(Long membreId);
}
