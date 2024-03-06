package com.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
