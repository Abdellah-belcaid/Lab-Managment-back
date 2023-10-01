package com.labmanagement.service.serviceimpl;

import com.labmanagement.model.entity.Dotation_Membre;
import com.labmanagement.model.entity.Dotation_Membre.DotationMembreId;
import com.labmanagement.service.IDotationMembreService;
import com.labmanagement.repository.DotationMembreRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Service
@Transactional
@AllArgsConstructor
public class DotationMembreService implements IDotationMembreService {

	private final DotationMembreRepository dotationMembreRepository;

	@Override
	@CacheEvict(value = "dotationMembres", allEntries = true)
	public Dotation_Membre addDotationMembre(Dotation_Membre dotationMembre) {
		return dotationMembreRepository.save(dotationMembre);
	}

	@Override
	@CacheEvict(value = "dotationMembres", allEntries = true)
	public Dotation_Membre updateDotationMembre(Dotation_Membre dotationMembre) {
		return dotationMembreRepository.save(dotationMembre);
	}

	@Override
	@CacheEvict(value = "dotationMembres", allEntries = true)
	public void deleteDotationMembre(Long ucaRechId, Long membreId) {
		dotationMembreRepository.deleteById(new DotationMembreId(ucaRechId, membreId));
	}

	@Override
	@Cacheable(value = "dotationMembres")
	public Dotation_Membre getDotationMembreById(Long ucaRechId, Long membreId) {
		return dotationMembreRepository.findById(new DotationMembreId(ucaRechId, membreId)).orElse(null);
	}

	@Override
	@Cacheable(value = "dotationMembres")
	public Collection<Dotation_Membre> getAllDotationMembres() {
		return dotationMembreRepository.findAll();
	}

	@Override
	@Cacheable(value = "dotationMembresByUcaRechId", key = "#ucaRechId")
	public Collection<Dotation_Membre> getAllByUcaRechId(Long ucaRechId) {
		return dotationMembreRepository.findAllById_UcaRechId(ucaRechId);
	}

	@Override
	@Cacheable(value = "dotationMembresByMembreId", key = "#membreId")
	public Collection<Dotation_Membre> getAllByMembreId(Long membreId) {
		return dotationMembreRepository.findAllById_MembreId(membreId);
	}
}
