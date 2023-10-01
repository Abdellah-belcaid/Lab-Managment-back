package com.labmanagement.service;

import java.util.List;

import com.labmanagement.model.entity.RespoMarche;

public interface IRespoMarcheService {

    RespoMarche addRespoMarche(RespoMarche respoMarche);

    List<RespoMarche> findAllRespoMarche();

    RespoMarche findRespoMarcheById(Long id);

    RespoMarche updateRespoMarche(RespoMarche respoMarche);

    void deleteRespoMarche(Long id);
}
