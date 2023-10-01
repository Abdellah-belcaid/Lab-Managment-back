package com.labmanagement.service;

import java.util.List;

import com.labmanagement.model.entity.ExpressionBesoin;

public interface IExpressionBesoinService {
	ExpressionBesoin findById(Long id);

	List<ExpressionBesoin> findAll();

	List<ExpressionBesoin> findByMembreId(Long membreId);

	List<ExpressionBesoin> findByResponsableId(Long responsableId);


	ExpressionBesoin create(ExpressionBesoin expressionBesoin);

	ExpressionBesoin update(ExpressionBesoin expressionBesoin);

	void delete(Long id);
}
