package com.labmanagement.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.model.entity.Projet;
import com.labmanagement.service.IProjetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projets")
public class ProjetController {

	private final IProjetService projetService;

	@PostMapping
	public ResponseEntity<Projet> addProjet(@RequestBody Projet projet) {
		Projet addedProjet = projetService.addProjet(projet);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedProjet);
	}

	@GetMapping
	public ResponseEntity<List<Projet>> getAllProjets() {
		List<Projet> projets = projetService.findAllProjets();
		return ResponseEntity.ok(projets);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
		Projet projet = projetService.findProjetById(id);
		if (projet != null) {
			return ResponseEntity.ok(projet);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projet) {
		projet.setId(id);
		Projet updatedProjet = projetService.updateProjet(projet);
		return ResponseEntity.ok(updatedProjet);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
		projetService.deleteProjet(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/dotationprojects")
	public ResponseEntity<Collection<Dotation_Project>> getDotationProjectsByProjetId(@PathVariable Long id) {
		Collection<Dotation_Project> dotationProjects = projetService.findDotationProjectsByProjetId(id);
		if (!dotationProjects.isEmpty()) {
			return ResponseEntity.ok(dotationProjects);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
