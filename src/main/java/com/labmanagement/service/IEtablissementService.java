package com.labmanagement.service;

import java.util.List;

import com.labmanagement.model.entity.Etablissement;

public interface IEtablissementService {

	public Etablissement addEtablissement(Etablissement etablissement);

	public List<Etablissement> findAllEtablissement();

	public Etablissement findEtablissementById(Long id);

	public Etablissement updateEtablissement(Long id,Etablissement etablissement);

	public void deleteEtablissement(Long id);

}
