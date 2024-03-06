package com.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
