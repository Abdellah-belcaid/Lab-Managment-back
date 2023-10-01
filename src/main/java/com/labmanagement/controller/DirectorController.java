package com.labmanagement.controller;

import com.labmanagement.model.dao.DirectorDTO;
import com.labmanagement.model.entity.Director;
import com.labmanagement.service.IDirectorService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/directors")
public class DirectorController {
	private final IDirectorService directorService;

	@GetMapping
	public ResponseEntity<List<DirectorDTO>> getAllDirectors() {
		List<DirectorDTO> directors = directorService.getAllDirectors();
		return ResponseEntity.ok(directors);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DirectorDTO> getDirectorById(@PathVariable Long id) {
		DirectorDTO director = directorService.getDirectorById(id);
		return ResponseEntity.ok(director);
	}

	@PostMapping
	public ResponseEntity<DirectorDTO> createDirector(@RequestBody Director director) {
		DirectorDTO savedDirector = directorService.saveDirector(director);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDirector);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
		directorService.deleteDirector(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<DirectorDTO> updateDirector(@PathVariable Long id, @RequestBody Director director) {
		DirectorDTO updatedDirector = directorService.updateDirector(id, director);
		return ResponseEntity.ok(updatedDirector);
	}

}
