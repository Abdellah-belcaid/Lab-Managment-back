package com.labmanagement.model.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dotation_Membre {

	@EmbeddedId
	private DotationMembreId id;

	private Double montant;
	private Integer AnneAffecter;

	@ManyToOne
	@JoinColumn(name = "uca_rech_id", insertable = false, updatable = false)
	@JsonIgnoreProperties("dotation_Membres")
	private DotationUcaRech ucaRech;

	@ManyToOne
	@JoinColumn(name = "membre_id", insertable = false, updatable = false)
	@JsonIgnoreProperties("dotation_Membres")
	private Membre membre;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Embeddable
	public static class DotationMembreId implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name = "uca_rech_id")
		private Long ucaRechId;

		@Column(name = "membre_id")
		private Long membreId;
	}
}
