package com.labmanagement.model.dao;

import java.time.LocalDateTime;
import java.util.Collection;

import com.labmanagement.model.entity.Dotation_Membre;
import com.labmanagement.model.entity.Dotation_Project;
import com.labmanagement.model.entity.ExpressionBesoin;
import com.labmanagement.model.entity.Laboratoire;
import com.labmanagement.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembreDTO {

	private Long id;
	private String name;
	private String email;
	private String username;
	private LocalDateTime createTime;
	private Role role;
	private String token;

	private String designation; // Designation or role of the member in the lab
	private String phoneNumber;
	private String department; // Department or academic unit the member belongs to
	private String researchArea; // Research area or specialization of the member
	private String qualification; // Qualification or highest degree obtained by the member

	private Laboratoire laboratoire;

	private Collection<ExpressionBesoin> expressionBesoins;

	private Collection<Dotation_Project> dotationProjects;

	private Collection<Dotation_Membre> dotation_Membres;

}
