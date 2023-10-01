package com.labmanagement.model.entity;

import java.util.Collection;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Membre")
@EqualsAndHashCode(callSuper = true)
public class Membre extends User {

	private static final long serialVersionUID = 1L;

	private String designation; // Designation or role of the member in the lab
	private String phoneNumber;
	private String department; // Department or academic unit the member belongs to
	private String researchArea; // Research area or specialization of the member
	private String qualification; // Qualification or highest degree obtained by the member

	@ManyToOne
	@JoinColumn(nullable = true)
	@JsonIgnoreProperties("membres")
	private Laboratoire laboratoire;

	@OneToMany(mappedBy = "membre")
	@JsonIgnoreProperties("membre")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<ExpressionBesoin> expressionBesoins;

	@OneToMany(mappedBy = "membre")
	@JsonIgnoreProperties("membre")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Dotation_Project> dotationProjects;

	@OneToMany(mappedBy = "membre")
	@JsonIgnoreProperties("membre")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Dotation_Membre> dotation_Membres;

}
