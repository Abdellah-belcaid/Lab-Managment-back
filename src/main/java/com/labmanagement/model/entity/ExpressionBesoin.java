package com.labmanagement.model.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpressionBesoin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Description;
	private Double montant_approximatif;
	private Double montant_effectif;
	private Date demandeDate;
	private Date validatDate;
	private Boolean isValid;

	@ManyToOne
	@JsonIgnoreProperties("expressionBesoins")
	private Membre membre;

	@ManyToOne
	@JsonIgnoreProperties("expressionBesoins")
	private Responsable responsable;

	@ManyToOne
	@JsonIgnoreProperties("expressionBesoins")
	private TypeBesoin typeBesoin;
}
