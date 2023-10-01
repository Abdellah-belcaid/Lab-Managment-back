package com.labmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.DotationUcaRech;
import com.labmanagement.service.IDotationUcaRechService;

@RestController
@RequestMapping("/api/v1/dotation-uca-rech")
public class DotationUcaRechController {

	private final IDotationUcaRechService dotationUcaRechService;

	public DotationUcaRechController(IDotationUcaRechService dotationUcaRechService) {
		this.dotationUcaRechService = dotationUcaRechService;
	}

	@PostMapping
	public ResponseEntity<DotationUcaRech> addDotationUcaRech(@RequestBody DotationUcaRech dotationUcaRech) {
		DotationUcaRech createdDotationUcaRech = dotationUcaRechService.addDotationUcaRech(dotationUcaRech);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdDotationUcaRech);
	}

	@GetMapping
	public ResponseEntity<List<DotationUcaRech>> getAllDotationUcaRech() {
		List<DotationUcaRech> dotationUcaRechList = dotationUcaRechService.findAllDotationUcaRech();
		return ResponseEntity.ok(dotationUcaRechList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DotationUcaRech> getDotationUcaRechById(@PathVariable("id") Long id) {
		DotationUcaRech dotationUcaRech = dotationUcaRechService.findDotationUcaRechById(id);
		if (dotationUcaRech != null) {
			return ResponseEntity.ok(dotationUcaRech);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<DotationUcaRech> updateDotationUcaRech(@PathVariable("id") Long id,
			@RequestBody DotationUcaRech dotationUcaRech) {
		DotationUcaRech existingDotationUcaRech = dotationUcaRechService.findDotationUcaRechById(id);
		if (existingDotationUcaRech != null) {
			dotationUcaRech.setId(id);
			DotationUcaRech updatedDotationUcaRech = dotationUcaRechService.updateDotationUcaRech(dotationUcaRech);
			return ResponseEntity.ok(updatedDotationUcaRech);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDotationUcaRech(@PathVariable("id") Long id) {
		dotationUcaRechService.deleteDotationUcaRech(id);
		return ResponseEntity.noContent().build();
	}
}
