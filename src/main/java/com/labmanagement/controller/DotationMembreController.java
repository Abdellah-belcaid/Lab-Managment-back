package com.labmanagement.controller;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.service.serviceimpl.DotationMembreService;
import com.labmanagement.model.entity.Dotation_Membre;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dotation-membres")
public class DotationMembreController {

	private final DotationMembreService dotationMembreService;

	@PostMapping
	public ResponseEntity<Dotation_Membre> addDotationMembre(@RequestBody Dotation_Membre dotationMembre) {
		System.err.println(dotationMembre);
		Dotation_Membre createdDotationMembre = dotationMembreService.addDotationMembre(dotationMembre);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdDotationMembre);
	}

	@PutMapping
	public ResponseEntity<Dotation_Membre> updateDotationMembre(@RequestBody Dotation_Membre dotationMembre) {
		Dotation_Membre updatedDotationMembre = dotationMembreService.updateDotationMembre(dotationMembre);
		return ResponseEntity.ok(updatedDotationMembre);
	}

	@DeleteMapping("/{ucaRechId}/{membreId}")
	public ResponseEntity<Void> deleteDotationMembre(@PathVariable("ucaRechId") Long ucaRechId,
			@PathVariable("membreId") Long membreId) {
		dotationMembreService.deleteDotationMembre(ucaRechId, membreId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{ucaRechId}/{membreId}")
	public ResponseEntity<Dotation_Membre> getDotationMembreById(@PathVariable("ucaRechId") Long ucaRechId,
			@PathVariable("membreId") Long membreId) {
		Dotation_Membre dotationMembre = dotationMembreService.getDotationMembreById(ucaRechId, membreId);
		if (dotationMembre != null) {
			return ResponseEntity.ok(dotationMembre);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<Collection<Dotation_Membre>> getAllDotationMembres() {
		Collection<Dotation_Membre> dotationMembres = dotationMembreService.getAllDotationMembres();
		return ResponseEntity.ok(dotationMembres);
	}

	@GetMapping("/uca-rech/{ucaRechId}")
	public Collection<Dotation_Membre> getAllByUcaRechId(@PathVariable("ucaRechId") Long ucaRechId) {
		return dotationMembreService.getAllByUcaRechId(ucaRechId);
	}

	@GetMapping("/membre/{membreId}")
	public Collection<Dotation_Membre> getAllByMembreId(@PathVariable("membreId") Long membreId) {
		return dotationMembreService.getAllByMembreId(membreId);
	}

}
