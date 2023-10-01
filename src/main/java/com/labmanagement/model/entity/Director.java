package com.labmanagement.model.entity;

import java.sql.Date;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "Director")
@EqualsAndHashCode(callSuper = true)
public class Director extends Membre {

	private static final long serialVersionUID = 1L;
	private String officeNumber;	
	private String expertise;
	private Date shiftStartDate;
	private Date shiftEndDate;

	// Additional attributes specific to a director

	// Define any additional relationships specific to a director
}
