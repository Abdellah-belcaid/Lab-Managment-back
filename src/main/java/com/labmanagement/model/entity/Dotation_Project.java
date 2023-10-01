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
@AllArgsConstructor
@NoArgsConstructor
public class Dotation_Project {

	@EmbeddedId
	private DotationProjectId id;
	private String status;
	private String source;
	private String purpose;
	private Double endowmentAmount;

	@ManyToOne
	@JoinColumn(name = "projet_id", insertable = false, updatable = false)
	@JsonIgnoreProperties("dotationProjects")
	private Projet projet;

	@ManyToOne
	@JoinColumn(name = "membre_id", insertable = false, updatable = false)
	@JsonIgnoreProperties("dotationProjects")
	private Membre membre;

	@Embeddable
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DotationProjectId implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name = "projet_id")
		private Long projetId;

		@Column(name = "membre_id")
		private Long membreId;
	}

}
