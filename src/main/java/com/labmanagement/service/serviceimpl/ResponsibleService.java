package com.labmanagement.service.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.labmanagement.model.entity.ExpressionBesoin;
import com.labmanagement.model.entity.Responsable;
import com.labmanagement.repository.ResponsableRepository;
import com.labmanagement.service.IResponsableService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResponsibleService implements IResponsableService {

	private final ResponsableRepository responsableRepository;

	@Override
	public Responsable addResponsable(Responsable responsable) {
		// Perform any necessary validation or business logic before saving
		// ...

		// Save the responsable
		return responsableRepository.save(responsable);
	}

	@Override
	public List<Responsable> findAllResponsables() {
		
		return responsableRepository.findAll();
	}

	@Override
	public Responsable findResponsableById(Long id) {
		Optional<Responsable> responsableOptional = responsableRepository.findById(id);
		return responsableOptional.orElse(null);
	}

	@Override
	public Responsable updateResponsable(Responsable responsable) {
		// Check if the responsable exists
		Optional<Responsable> existingResponsableOptional = responsableRepository.findById(responsable.getId());
		if (existingResponsableOptional.isEmpty()) {
			throw new IllegalArgumentException("Responsable with ID " + responsable.getId() + " does not exist.");
		}

		// Perform any necessary validation or business logic before updating
		// ...

		// Save the updated responsable
		return responsableRepository.save(responsable);
	}

	@Override
	public void deleteResponsable(Long id) {
		// Check if the responsable exists
		Optional<Responsable> existingResponsableOptional = responsableRepository.findById(id);
		if (existingResponsableOptional.isEmpty()) {
			throw new IllegalArgumentException("Responsable with ID " + id + " does not exist.");
		}

		// Delete the responsable
		responsableRepository.deleteById(id);
	}

	@Override
	public Collection<ExpressionBesoin> findExpressionBesoinsByResponsableId(Long id) {
		Optional<Responsable> responsableOptional = responsableRepository.findById(id);
		if (responsableOptional.isPresent()) {
			Responsable responsable = responsableOptional.get();
			return responsable.getExpressionBesoins();
		}
		return null;
	}
}
