package com.pizzeria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pizzeria.model.Order;
import com.pizzeria.model.User;

public interface OrderRepository extends JpaRepository<Order,Long> {
	@Query("SELECT o FROM Order o WHERE o.customer.id = :userId")
	Optional<List<Order>> findAllUserOrders(@Param("userId")Long userId);
    
	@Query("SELECT o FROM Order o WHERE o.restaurant.id = :restaurantId")
	Optional<List<Order>> findOrdersByRestaurantId(@Param("restaurantId") Long restaurantId);
}
