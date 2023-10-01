package com.labmanagement.repository;

import com.labmanagement.model.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);

}
