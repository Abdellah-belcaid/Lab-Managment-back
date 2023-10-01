package com.labmanagement.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "Affaires_Financier")
public class RespoAffairesFinancier extends Responsable {

	private static final long serialVersionUID = 1L;
	private String department;
	private String financialQualification;
}
