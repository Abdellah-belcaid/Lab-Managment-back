package com.labmanagement.model.entity;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "Responsable")
public class Responsable extends User {
	private static final long serialVersionUID = 1L;

	private int tel;

	@OneToMany(mappedBy = "responsable")
	@JsonIgnoreProperties("responsable")
	private Collection<ExpressionBesoin> expressionBesoins;

}
