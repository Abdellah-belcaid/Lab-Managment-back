package com.labmanagement.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.ExpressionBesoin;
import com.labmanagement.model.entity.Laboratoire;
import com.labmanagement.model.entity.Membre;
import com.labmanagement.service.IMembreService;
import com.labmanagement.model.dao.MembreDTO;
import com.labmanagement.model.entity.Dotation_Project;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MembreController {

	private final IMembreService membreService;

	@PostMapping
	public ResponseEntity<MembreDTO> addMembre(@RequestBody Membre membre) {
		MembreDTO addedMembre = membreService.addMembre(membre);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedMembre);
	}

	@GetMapping
	public ResponseEntity<List<MembreDTO>> getAllMembres() {
		List<MembreDTO> membres = membreService.findAllMembres();
		return ResponseEntity.ok(membres);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MembreDTO> getMembreById(@PathVariable Long id) {
		MembreDTO membre = membreService.findMembreById(id);
		if (membre != null) {
			return ResponseEntity.ok(membre);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<MembreDTO> updateMembre(@PathVariable Long id, @RequestBody Membre membre) {
		membre.setId(id);
		MembreDTO updatedMembre = membreService.updateMembre(membre);
		return ResponseEntity.ok(updatedMembre);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMembre(@PathVariable Long id) {
		membreService.deleteMembre(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/laboratoire")
	public ResponseEntity<Laboratoire> getLaboratoireByMembreId(@PathVariable Long id) {
		Laboratoire laboratoire = membreService.findLaboratoireByMembreId(id);
		if (laboratoire != null) {
			return ResponseEntity.ok(laboratoire);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}/expressionbesoins")
	public ResponseEntity<Collection<ExpressionBesoin>> getExpressionBesoinsByMembreId(@PathVariable Long id) {
		Collection<ExpressionBesoin> expressionBesoins = membreService.findExpressionBesoinsByMembreId(id);
		if (!expressionBesoins.isEmpty()) {
			return ResponseEntity.ok(expressionBesoins);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}/dotationprojects")
	public ResponseEntity<Collection<Dotation_Project>> getDotationProjectsByMembreId(@PathVariable Long id) {
		Collection<Dotation_Project> dotationProjects = membreService.findDotationProjectsByMembreId(id);
		if (!dotationProjects.isEmpty()) {
			return ResponseEntity.ok(dotationProjects);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
