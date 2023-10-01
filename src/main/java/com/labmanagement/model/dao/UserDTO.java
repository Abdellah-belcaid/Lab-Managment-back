package com.labmanagement.model.dao;

import java.time.LocalDateTime;

import com.labmanagement.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String username;
	private LocalDateTime createTime;
	private String Image_Path;
	private Role role;
	private String token;
	private String enabled;

}
