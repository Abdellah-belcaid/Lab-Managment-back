package com.labmanagement.service.serviceimpl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.labmanagement.model.enums.Role;
import com.labmanagement.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.labmanagement.model.dao.MembreDTO;
import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.model.entity.ExpressionBesoin;
import com.labmanagement.model.entity.Laboratoire;
import com.labmanagement.model.entity.Membre;
import com.labmanagement.repository.MembreRepository;
import com.labmanagement.service.IMembreService;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Service
@AllArgsConstructor
public class MembreService implements IMembreService {

    private final MembreRepository membreRepository;
    private final IUserService userService;
    private final ModelMapper modelMapper;

    @Override
    @CacheEvict(value = "membres", allEntries = true)
    public MembreDTO addMembre(Membre membre) {
        membre.setRole(Role.MEMBER);
        membre.setCreateTime(LocalDateTime.now());
        return modelMapper.map(userService.register(membre), MembreDTO.class);
    }

    @Override
    @Cacheable(value = "membres")
    public List<MembreDTO> findAllMembres() {
        List<Membre> membres = membreRepository.findAll();
        return membres.stream().map(membre -> modelMapper.map(membre, MembreDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "membres", key = "#id")
    public MembreDTO findMembreById(Long id) {
        Optional<Membre> membreOptional = membreRepository.findById(id);
        return membreOptional.map(membre -> modelMapper.map(membre, MembreDTO.class)).orElse(null);
    }

    @Override
    @CacheEvict(value = "membres", key = "#membre.id")
    public MembreDTO updateMembre(Membre membre) {
        Optional<Membre> existingMembreOptional = membreRepository.findById(membre.getId());
        if (existingMembreOptional.isEmpty()) {
            throw new IllegalArgumentException("Member with ID " + membre.getId() + " does not exist.");
        }
        return modelMapper.map(membreRepository.save(membre), MembreDTO.class);
    }

    @Override
    @CacheEvict(value = "membres", key = "#id")
    public void deleteMembre(Long id) {
        Optional<Membre> existingMembreOptional = membreRepository.findById(id);
        if (existingMembreOptional.isEmpty()) {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist.");
        }
        membreRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "laboratoires", key = "#id")
    public Laboratoire findLaboratoireByMembreId(Long id) {
        Optional<Membre> membreOptional = membreRepository.findById(id);
        return membreOptional.map(Membre::getLaboratoire).orElse(null);
    }

    @Override
    @Cacheable(value = "expressionBesoins", key = "#id")
    public Collection<ExpressionBesoin> findExpressionBesoinsByMembreId(Long id) {
        Optional<Membre> membreOptional = membreRepository.findById(id);
        return membreOptional.map(Membre::getExpressionBesoins).orElse(null);
    }

    @Override
    @Cacheable(value = "dotationProjects", key = "#id")
    public Collection<Dotation_Project> findDotationProjectsByMembreId(Long id) {
        Optional<Membre> membreOptional = membreRepository.findById(id);
        return membreOptional.map(Membre::getDotationProjects).orElse(null);
    }
}
