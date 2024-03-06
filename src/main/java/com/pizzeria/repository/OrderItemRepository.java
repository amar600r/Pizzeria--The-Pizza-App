package com.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
