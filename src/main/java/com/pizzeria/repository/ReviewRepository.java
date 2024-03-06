package com.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
