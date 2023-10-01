package com.labmanagement.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.labmanagement.model.entity.Laboratoire;
import com.labmanagement.service.ILaboratoireService;
import com.labmanagement.repository.LaboratoireRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LaboratoireService implements ILaboratoireService {

	private final LaboratoireRepository laboratoireRepository;

	@Override
	@CacheEvict(value = "laboratoires", allEntries = true)
	public Laboratoire addLaboratoire(Laboratoire laboratoire) {
		return laboratoireRepository.save(laboratoire);
	}

	@Override
	@Cacheable(value = "laboratoires")
	public List<Laboratoire> findAllLaboratoire() {
		return laboratoireRepository.findAll();
	}

	@Override
	@Cacheable(value = "laboratoires", key = "#id")
	public Laboratoire findLaboratoireById(Long id) {
		Optional<Laboratoire> optionalLaboratoire = laboratoireRepository.findById(id);
		return optionalLaboratoire.orElse(null);
	}

	@Override
	@CacheEvict(value = "laboratoires", allEntries = true)
	public Laboratoire updateLaboratoire(Laboratoire laboratoire) {
		return laboratoireRepository.save(laboratoire);
	}

	@Override
	@CacheEvict(value = "laboratoires", allEntries = true)
	public void deleteLaboratoire(Long id) {
		laboratoireRepository.findById(id).ifPresent(laboratoire -> {
			// Set the lab of associated members to null
			laboratoire.getMembres().stream().forEach(membre -> membre.setLaboratoire(null));

			laboratoireRepository.delete(laboratoire);
		});
	}

}
