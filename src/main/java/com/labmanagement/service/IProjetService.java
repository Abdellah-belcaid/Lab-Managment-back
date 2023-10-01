package com.labmanagement.service;

import java.util.Collection;
import java.util.List;

import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.model.entity.Projet;

public interface IProjetService {

	Projet addProjet(Projet projet);

	List<Projet> findAllProjets();

	Projet findProjetById(Long id);

	Projet updateProjet(Projet projet);

	void deleteProjet(Long id);

	Collection<Dotation_Project> findDotationProjectsByProjetId(Long id);

}
