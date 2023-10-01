package com.labmanagement.repository;

import com.labmanagement.model.entity.User;
import com.labmanagement.model.enums.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String Password);
	Optional<User> findByUsername(String username);
	@Modifying
	@Query("update User set role = :role where username = :username")
	void updateUserRole(@Param("username") String username, @Param("role") Role role);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	User findByEmailIgnoreCase(String email);

}
