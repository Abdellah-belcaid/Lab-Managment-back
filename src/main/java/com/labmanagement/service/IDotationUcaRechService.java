package com.labmanagement.service;

import java.util.List;

import com.labmanagement.model.entity.DotationUcaRech;

public interface IDotationUcaRechService {
	DotationUcaRech addDotationUcaRech(DotationUcaRech dotationUcaRech);

	List<DotationUcaRech> findAllDotationUcaRech();

	DotationUcaRech findDotationUcaRechById(Long id);

	DotationUcaRech updateDotationUcaRech(DotationUcaRech dotationUcaRech);

	void deleteDotationUcaRech(Long id);
}
