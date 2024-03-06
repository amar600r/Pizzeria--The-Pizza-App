package com.pizzeria.service;

import java.util.List;

import com.pizzeria.Exception.RestaurantException;
import com.pizzeria.dto.RestaurantDto;
import com.pizzeria.model.Restaurant;
import com.pizzeria.model.User;
import com.pizzeria.request.CreateRestaurantRequest;

public interface RestaurantService {

	public Restaurant createRestaurant(CreateRestaurantRequest req,User user);

	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant)
			throws RestaurantException;

	public void deleteRestaurant(Long restaurantId) throws RestaurantException;

	public Restaurant findRestaurantByName(String Name) throws RestaurantException;

	public List<Restaurant> getRestaurantsByName(String name);
	
	public List<Restaurant>getAllRestaurant();
	
	public Restaurant findRestaurantById(Long id) throws RestaurantException;
//	 public  List<Restaurant> getRestaurantsByLocation(String location);
	public List<Restaurant> getRestaurantsByUserId(Long userId) throws RestaurantException;
	
	public RestaurantDto addToFavorites(Long restaurantId,User user) throws RestaurantException;

}
