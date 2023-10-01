package com.labmanagement.service;

import java.util.List;

import com.labmanagement.model.entity.Laboratoire;

public interface ILaboratoireService {
    Laboratoire addLaboratoire(Laboratoire laboratoire);
    List<Laboratoire> findAllLaboratoire();
    Laboratoire findLaboratoireById(Long id);
    Laboratoire updateLaboratoire(Laboratoire laboratoire);
    void deleteLaboratoire(Long id);
}
