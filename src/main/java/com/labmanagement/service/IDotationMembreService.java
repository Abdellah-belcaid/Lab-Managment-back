package com.labmanagement.service;

import com.labmanagement.model.entity.Dotation_Membre;
import java.util.Collection;

public interface IDotationMembreService {
	Dotation_Membre addDotationMembre(Dotation_Membre dotationMembre);

	Dotation_Membre updateDotationMembre(Dotation_Membre dotationMembre);

	void deleteDotationMembre(Long ucaRechId, Long membreId);

	Dotation_Membre getDotationMembreById(Long ucaRechId, Long membreId);

	Collection<Dotation_Membre> getAllDotationMembres();

	Collection<Dotation_Membre> getAllByUcaRechId(Long ucaRechId);

	Collection<Dotation_Membre> getAllByMembreId(Long membreId);

}
