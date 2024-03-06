package com.pizzeria.service;

import com.pizzeria.model.Order;
import com.pizzeria.model.Restaurant;
import com.pizzeria.model.User;

public interface NotificationService {
	
	public void sendOrderStatusNotification(User user, Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);

}
