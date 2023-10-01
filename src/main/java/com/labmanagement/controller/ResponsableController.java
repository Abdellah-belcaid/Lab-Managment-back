package com.labmanagement.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.ExpressionBesoin;
import com.labmanagement.model.entity.Responsable;
import com.labmanagement.service.IResponsableService;

@RestController
@RequestMapping("/api/v1/responsables")
public class ResponsableController {

	private final IResponsableService responsableService;

	public ResponsableController(IResponsableService responsableService) {
		this.responsableService = responsableService;
	}

	@PostMapping
	public ResponseEntity<Responsable> addResponsable(@RequestBody Responsable responsable) {
		Responsable addedResponsable = responsableService.addResponsable(responsable);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedResponsable);
	}

	@GetMapping
	public ResponseEntity<List<Responsable>> getAllResponsables() {
		List<Responsable> responsables = responsableService.findAllResponsables();

		return ResponseEntity.ok(responsables);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Responsable> getResponsableById(@PathVariable Long id) {
		Responsable responsable = responsableService.findResponsableById(id);
		if (responsable != null) {
			return ResponseEntity.ok(responsable);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Responsable> updateResponsable(@PathVariable Long id, @RequestBody Responsable responsable) {
		responsable.setId(id);
		Responsable updatedResponsable = responsableService.updateResponsable(responsable);
		return ResponseEntity.ok(updatedResponsable);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteResponsable(@PathVariable Long id) {
		responsableService.deleteResponsable(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/expressionbesoins")
	public ResponseEntity<Collection<ExpressionBesoin>> getExpressionBesoinsByResponsableId(@PathVariable Long id) {
		Collection<ExpressionBesoin> expressionBesoins = responsableService.findExpressionBesoinsByResponsableId(id);
		if (!expressionBesoins.isEmpty()) {
			return ResponseEntity.ok(expressionBesoins);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
