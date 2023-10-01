package com.labmanagement.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.labmanagement.model.entity.RespoAffairesFinancier;
import com.labmanagement.repository.RespoAffairesFinancierRepository;
import com.labmanagement.service.IRespoAffairesFinancierService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RespoAffairesFinancierService implements IRespoAffairesFinancierService {

	private final RespoAffairesFinancierRepository respoAffairesFinancierRepository;

	@Override
	public RespoAffairesFinancier addRespoAffairesFinancier(RespoAffairesFinancier respoAffairesFinancier) {
		// Perform validation here
		// ...

		return respoAffairesFinancierRepository.save(respoAffairesFinancier);
	}

	@Override
	public List<RespoAffairesFinancier> findAllRespoAffairesFinancier() {
		return respoAffairesFinancierRepository.findAll();
	}

	@Override
	public RespoAffairesFinancier findRespoAffairesFinancierById(Long id) {
		Optional<RespoAffairesFinancier> optionalRespoAffairesFinancier = respoAffairesFinancierRepository.findById(id);
		if (optionalRespoAffairesFinancier.isEmpty()) {
			// throw new NotFoundException("RespoAffairesFinancier not found");
		}

		return optionalRespoAffairesFinancier.get();
	}

	@Override
	public RespoAffairesFinancier updateRespoAffairesFinancier(RespoAffairesFinancier respoAffairesFinancier) {
		// Perform validation here
		// ...

		return respoAffairesFinancierRepository.save(respoAffairesFinancier);
	}

	@Override
	public void deleteRespoAffairesFinancier(Long id) {
		Optional<RespoAffairesFinancier> optionalRespoAffairesFinancier = respoAffairesFinancierRepository.findById(id);
		if (optionalRespoAffairesFinancier.isEmpty()) {
			// throw ("RespoAffairesFinancier not found");
		}

		respoAffairesFinancierRepository.deleteById(id);
	}
}
