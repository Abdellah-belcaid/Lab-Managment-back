package com.labmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.RespoMarche;
import com.labmanagement.service.IRespoMarcheService;

@RestController
@RequestMapping("/api/v1/respo-marche")
public class RespoMarcheController {

    private final IRespoMarcheService respoMarcheService;

    public RespoMarcheController(IRespoMarcheService respoMarcheService) {
        this.respoMarcheService = respoMarcheService;
    }

    @PostMapping
    public ResponseEntity<RespoMarche> addRespoMarche(@RequestBody RespoMarche respoMarche) {
        RespoMarche addedRespoMarche = respoMarcheService.addRespoMarche(respoMarche);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRespoMarche);
    }

    @GetMapping
    public ResponseEntity<List<RespoMarche>> getAllRespoMarche() {
        List<RespoMarche> respoMarches = respoMarcheService.findAllRespoMarche();
        return ResponseEntity.ok(respoMarches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespoMarche> getRespoMarcheById(@PathVariable Long id) {
        RespoMarche respoMarche = respoMarcheService.findRespoMarcheById(id);
        if (respoMarche != null) {
            return ResponseEntity.ok(respoMarche);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespoMarche> updateRespoMarche(@PathVariable Long id, @RequestBody RespoMarche respoMarche) {
        respoMarche.setId(id);
        RespoMarche updatedRespoMarche = respoMarcheService.updateRespoMarche(respoMarche);
        return ResponseEntity.ok(updatedRespoMarche);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRespoMarche(@PathVariable Long id) {
        respoMarcheService.deleteRespoMarche(id);
        return ResponseEntity.noContent().build();
    }
}
