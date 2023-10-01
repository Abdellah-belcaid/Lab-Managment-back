package com.labmanagement.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.labmanagement.model.entity.DotationUcaRech;
import com.labmanagement.service.IDotationUcaRechService;
import com.labmanagement.repository.DotationUcaRechRepository;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Service
@AllArgsConstructor
public class DotationUcaRechService implements IDotationUcaRechService {

	private final DotationUcaRechRepository dotationUcaRechRepository;

	@Override
	@CacheEvict(value = "dotationUcaRechs", allEntries = true)
	public DotationUcaRech addDotationUcaRech(DotationUcaRech dotationUcaRech) {

		return dotationUcaRechRepository.save(dotationUcaRech);
	}

	@Override
	@Cacheable(value = "dotationUcaRechs")
	public List<DotationUcaRech> findAllDotationUcaRech() {
		return dotationUcaRechRepository.findAll();
	}

	@Override
	@Cacheable(value = "dotationUcaRechs", key = "#id")
	public DotationUcaRech findDotationUcaRechById(Long id) {
		Optional<DotationUcaRech> optionalDotationUcaRech = dotationUcaRechRepository.findById(id);
		return optionalDotationUcaRech.orElse(null);
	}

	@Override
	@CacheEvict(value = "dotationUcaRechs", allEntries = true)
	public DotationUcaRech updateDotationUcaRech(DotationUcaRech dotationUcaRech) {
		return dotationUcaRechRepository.save(dotationUcaRech);
	}

	@Override
	@CacheEvict(value = "dotationUcaRechs", allEntries = true)
	public void deleteDotationUcaRech(Long id) {
		dotationUcaRechRepository.deleteById(id);
	}
}
