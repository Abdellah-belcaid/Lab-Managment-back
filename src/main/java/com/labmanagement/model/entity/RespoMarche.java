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
@DiscriminatorValue(value = "Marche")
@EqualsAndHashCode(callSuper = true)
public class RespoMarche extends Responsable {

	private static final long serialVersionUID = 1L;
	private String marketSegment;
	private int experienceYears;
}
