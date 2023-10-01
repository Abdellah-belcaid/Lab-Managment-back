package com.labmanagement.service.serviceimpl;

import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.repository.DotationProjetRepository;
import com.labmanagement.service.IDotationProjectService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Service
@RequiredArgsConstructor
public class DotationProjectService implements IDotationProjectService {

    private final DotationProjetRepository dotationProjetRepository;

    @Override
    @CacheEvict(value = "dotationProjects", allEntries = true)
    public Dotation_Project saveDotationProject(Dotation_Project dotationProject) {
        return dotationProjetRepository.save(dotationProject);
    }

    @Override
    @Cacheable(value = "dotationProjects")
    public List<Dotation_Project> getAllDotationProjects() {
        return dotationProjetRepository.findAll();
    }

    @Override
    @Cacheable(value = "dotationProjects", key = "#projetId + '-' + #membreId")
    public Dotation_Project getDotationProjectById(Long projetId, Long membreId) {
        return dotationProjetRepository.findById(new Dotation_Project.DotationProjectId(projetId, membreId))
                .orElse(null);
    }

    @Override
    @CacheEvict(value = "dotationProjects", allEntries = true)
    public void deleteDotationProject(Long projetId, Long membreId) {
        dotationProjetRepository.deleteById(new Dotation_Project.DotationProjectId(projetId, membreId));
    }
    
    @Override
    @Cacheable(value = "dotationProjectsByProjetId", key = "#projetId")
    public List<Dotation_Project> getAllByProjetId(Long projetId) {
        return dotationProjetRepository.findAllById_ProjetId(projetId);
    }
    
    @Override
    @Cacheable(value = "dotationProjectsByMembreId", key = "#membreId")
    public List<Dotation_Project> getAllByMembreId(Long membreId) {
        return dotationProjetRepository.findAllById_MembreId(membreId);
    }
}
