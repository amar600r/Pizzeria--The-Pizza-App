package com.pizzeria.service;

import java.util.List;

import com.pizzeria.Exception.CartException;
import com.pizzeria.Exception.OrderException;
import com.pizzeria.Exception.RestaurantException;
import com.pizzeria.Exception.UserException;
import com.pizzeria.model.Order;
import com.pizzeria.model.PaymentResponse;
import com.pizzeria.model.User;
import com.pizzeria.request.CreateOrderRequest;
import com.stripe.exception.StripeException;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId) throws OrderException, RestaurantException;
	 

}
