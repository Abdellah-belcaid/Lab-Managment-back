package com.labmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.ExpressionBesoin;
import com.labmanagement.service.IExpressionBesoinService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/expression-besoins")
@RequiredArgsConstructor
public class ExpressionBesoinController {

    private final IExpressionBesoinService expressionBesoinService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ExpressionBesoin> getExpressionBesoinById(@PathVariable("id") Long id) {
        ExpressionBesoin expressionBesoin = expressionBesoinService.findById(id);
        if (expressionBesoin != null) {
            return ResponseEntity.ok(expressionBesoin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ExpressionBesoin>> getAllExpressionBesoins() {
        List<ExpressionBesoin> expressionBesoins = expressionBesoinService.findAll();
        return ResponseEntity.ok(expressionBesoins);
    }

    @PostMapping
    public ResponseEntity<ExpressionBesoin> createExpressionBesoin(@RequestBody ExpressionBesoin expressionBesoin) {
        ExpressionBesoin createdExpressionBesoin = expressionBesoinService.create(expressionBesoin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpressionBesoin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpressionBesoin> updateExpressionBesoin(
            @PathVariable("id") Long id,
            @RequestBody ExpressionBesoin expressionBesoin
    ) {
        ExpressionBesoin existingExpressionBesoin = expressionBesoinService.findById(id);
        if (existingExpressionBesoin != null) {
            expressionBesoin.setId(id);
            ExpressionBesoin updatedExpressionBesoin = expressionBesoinService.update(expressionBesoin);
            return ResponseEntity.ok(updatedExpressionBesoin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpressionBesoin(@PathVariable("id") Long id) {
        ExpressionBesoin existingExpressionBesoin = expressionBesoinService.findById(id);
        if (existingExpressionBesoin != null) {
            expressionBesoinService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
