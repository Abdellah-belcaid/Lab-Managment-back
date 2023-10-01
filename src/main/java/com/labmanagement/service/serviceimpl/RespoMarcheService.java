package com.labmanagement.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.labmanagement.model.entity.RespoMarche;
import com.labmanagement.repository.RespoMarcheRepository;
import com.labmanagement.service.IRespoMarcheService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RespoMarcheService implements IRespoMarcheService {

    private final RespoMarcheRepository respoMarcheRepository;

    public RespoMarche addRespoMarche(RespoMarche respoMarche) {
        // Perform any necessary validation or business logic before saving
        // ...

        // Save the respoMarche
        return respoMarcheRepository.save(respoMarche);
    }

    public List<RespoMarche> findAllRespoMarche() {
        return respoMarcheRepository.findAll();
    }

    public RespoMarche findRespoMarcheById(Long id) {
        Optional<RespoMarche> respoMarcheOptional = respoMarcheRepository.findById(id);
        return respoMarcheOptional.orElse(null);
    }

    public RespoMarche updateRespoMarche(RespoMarche respoMarche) {
        // Check if the respoMarche exists
        Optional<RespoMarche> existingRespoMarcheOptional = respoMarcheRepository.findById(respoMarche.getId());
        if (existingRespoMarcheOptional.isEmpty()) {
            throw new IllegalArgumentException("RespoMarche with ID " + respoMarche.getId() + " does not exist.");
        }

        // Perform any necessary validation or business logic before updating
        // ...

        // Save the updated respoMarche
        return respoMarcheRepository.save(respoMarche);
    }

    public void deleteRespoMarche(Long id) {
        // Check if the respoMarche exists
        Optional<RespoMarche> existingRespoMarcheOptional = respoMarcheRepository.findById(id);
        if (existingRespoMarcheOptional.isEmpty()) {
            throw new IllegalArgumentException("RespoMarche with ID " + id + " does not exist.");
        }

        // Delete the respoMarche
        respoMarcheRepository.deleteById(id);
    }
}
