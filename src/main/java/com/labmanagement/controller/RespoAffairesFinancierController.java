package com.labmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.RespoAffairesFinancier;
import com.labmanagement.service.IRespoAffairesFinancierService;

@RestController
@RequestMapping("/api/v1/respo-affaire-financiers")
public class RespoAffairesFinancierController {

	private final IRespoAffairesFinancierService respoAffairesFinancierService;

	public RespoAffairesFinancierController(IRespoAffairesFinancierService respoAffairesFinancierService) {
		this.respoAffairesFinancierService = respoAffairesFinancierService;
	}

	@PostMapping
	public ResponseEntity<RespoAffairesFinancier> addRespoAffairesFinancier(
			@RequestBody RespoAffairesFinancier respoAffairesFinancier) {
		RespoAffairesFinancier createdRespoAffairesFinancier = respoAffairesFinancierService
				.addRespoAffairesFinancier(respoAffairesFinancier);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRespoAffairesFinancier);
	}

	@GetMapping
	public ResponseEntity<List<RespoAffairesFinancier>> getAllRespoAffairesFinancier() {
		List<RespoAffairesFinancier> respoAffairesFinanciers = respoAffairesFinancierService
				.findAllRespoAffairesFinancier();
		return ResponseEntity.ok(respoAffairesFinanciers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespoAffairesFinancier> getRespoAffairesFinancierById(@PathVariable("id") Long id) {
		RespoAffairesFinancier respoAffairesFinancier = respoAffairesFinancierService
				.findRespoAffairesFinancierById(id);
		return ResponseEntity.ok(respoAffairesFinancier);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RespoAffairesFinancier> updateRespoAffairesFinancier(@PathVariable("id") Long id,
			@RequestBody RespoAffairesFinancier respoAffairesFinancier) {
		respoAffairesFinancier.setId(id);
		RespoAffairesFinancier updatedRespoAffairesFinancier = respoAffairesFinancierService
				.updateRespoAffairesFinancier(respoAffairesFinancier);
		return ResponseEntity.ok(updatedRespoAffairesFinancier);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRespoAffairesFinancier(@PathVariable("id") Long id) {
		respoAffairesFinancierService.deleteRespoAffairesFinancier(id);
		return ResponseEntity.noContent().build();
	}
}
