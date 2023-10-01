package com.labmanagement.service;

import java.util.List;

import com.labmanagement.model.entity.RespoAffairesFinancier;

public interface IRespoAffairesFinancierService {

    RespoAffairesFinancier addRespoAffairesFinancier(RespoAffairesFinancier respoAffairesFinancier);

    List<RespoAffairesFinancier> findAllRespoAffairesFinancier();

    RespoAffairesFinancier findRespoAffairesFinancierById(Long id);

    RespoAffairesFinancier updateRespoAffairesFinancier(RespoAffairesFinancier respoAffairesFinancier);

    void deleteRespoAffairesFinancier(Long id);
}
