package com.labmanagement.service.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.model.entity.Projet;
import com.labmanagement.repository.ProjetRepository;
import com.labmanagement.service.IProjetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjetService implements IProjetService {

	private final ProjetRepository projetRepository;

	@Override
	@CacheEvict(value = "projets", allEntries = true)
	public Projet addProjet(Projet projet) {
		return projetRepository.save(projet);
	}

	@Override
	@Cacheable(value = "projets")
	public List<Projet> findAllProjets() {
		return projetRepository.findAll();
	}

	@Override
	@Cacheable(value = "projets", key = "#id")
	public Projet findProjetById(Long id) {
		Optional<Projet> projetOptional = projetRepository.findById(id);
		return projetOptional.orElse(null);
	}

	@Override
	@CacheEvict(value = "projets", key = "#projet.id")
	public Projet updateProjet(Projet projet) {
		Optional<Projet> existingProjetOptional = projetRepository.findById(projet.getId());
		if (existingProjetOptional.isEmpty()) {
			throw new IllegalArgumentException("Projet with ID " + projet.getId() + " does not exist.");
		}

		return projetRepository.save(projet);
	}

	@Override
	@CacheEvict(value = "projets", key = "#id")
	public void deleteProjet(Long id) {
		Optional<Projet> existingProjetOptional = projetRepository.findById(id);
		if (existingProjetOptional.isEmpty()) {
			throw new IllegalArgumentException("Projet with ID " + id + " does not exist.");
		}

		projetRepository.deleteById(id);
	}

	@Override
	@Cacheable(value = "dotationProjects", key = "#id")
	public Collection<Dotation_Project> findDotationProjectsByProjetId(Long id) {
		Optional<Projet> projetOptional = projetRepository.findById(id);
		if (projetOptional.isPresent()) {
			Projet projet = projetOptional.get();
			return projet.getDotationProjects();
		}
		return null;
	}
}
