package com.labmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labmanagement.model.entity.ExpressionBesoin;

public interface ExpressionBesoinRepository extends JpaRepository<ExpressionBesoin, Long> {

	List<ExpressionBesoin> findByMembreId(Long membreId);

	List<ExpressionBesoin> findByResponsableId(Long responsableId);
	

}
