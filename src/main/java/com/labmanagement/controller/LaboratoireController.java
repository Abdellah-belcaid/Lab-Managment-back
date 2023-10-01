package com.labmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.Laboratoire;
import com.labmanagement.service.ILaboratoireService;

@RestController
@RequestMapping("/api/v1/laboratoires")
public class LaboratoireController {

	private final ILaboratoireService laboratoireService;

	public LaboratoireController(ILaboratoireService laboratoireService) {
		this.laboratoireService = laboratoireService;
	}

	@PostMapping
	public ResponseEntity<Laboratoire> addLaboratoire(@RequestBody Laboratoire laboratoire) {
		System.err.println(laboratoire);
		Laboratoire createdLaboratoire = laboratoireService.addLaboratoire(laboratoire);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdLaboratoire);
	}

	@GetMapping
	public ResponseEntity<List<Laboratoire>> getAllLaboratoire() {
		List<Laboratoire> laboratoires = laboratoireService.findAllLaboratoire();
		return ResponseEntity.ok(laboratoires);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable("id") Long id) {
		Laboratoire laboratoire = laboratoireService.findLaboratoireById(id);
		if (laboratoire != null) {
			return ResponseEntity.ok(laboratoire);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Laboratoire> updateLaboratoire(@PathVariable("id") Long id,
			@RequestBody Laboratoire laboratoire) {
		laboratoire.setId(id);
		Laboratoire updatedLaboratoire = laboratoireService.updateLaboratoire(laboratoire);
		if (updatedLaboratoire != null) {
			return ResponseEntity.ok(updatedLaboratoire);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLaboratoire(@PathVariable("id") Long id) {
		laboratoireService.deleteLaboratoire(id);
		return ResponseEntity.noContent().build();
	}
}
