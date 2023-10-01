package com.labmanagement.controller;

import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.service.IDotationProjectService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dotation-projects")
@RequiredArgsConstructor
public class DotationProjectController {

    private final IDotationProjectService dotationProjectService;

    @PostMapping
    public ResponseEntity<Dotation_Project> createDotationProject(@RequestBody Dotation_Project dotationProject) {
        Dotation_Project createdDotationProject = dotationProjectService.saveDotationProject(dotationProject);
        return new ResponseEntity<>(createdDotationProject, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Dotation_Project>> getAllDotationProjects() {
        List<Dotation_Project> dotationProjects = dotationProjectService.getAllDotationProjects();
        return new ResponseEntity<>(dotationProjects, HttpStatus.OK);
    }

    
    @GetMapping("/{projetId}/{membreId}")
    public ResponseEntity<Dotation_Project> getDotationProjectById(@PathVariable Long projetId, @PathVariable Long membreId) {
        Dotation_Project dotationProject = dotationProjectService.getDotationProjectById(projetId, membreId);
        if (dotationProject != null) {
            return new ResponseEntity<>(dotationProject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{projetId}/{membreId}")
    public ResponseEntity<Void> deleteDotationProject(@PathVariable Long projetId, @PathVariable Long membreId) {
        dotationProjectService.deleteDotationProject(projetId, membreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add more endpoints as needed for your application
    
    @GetMapping("/projet/{projetId}")
    public List<Dotation_Project> getAllByProjetId(@PathVariable Long projetId) {
        return dotationProjectService.getAllByProjetId(projetId);
    }
    
    @GetMapping("/membre/{membreId}")
    public List<Dotation_Project> getAllByMembreId(@PathVariable Long membreId) {
        return dotationProjectService.getAllByMembreId(membreId);
    }

}
