package com.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
