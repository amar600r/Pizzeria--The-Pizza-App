package com.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.Exception.MenuItemException;
import com.pizzeria.Exception.RestaurantException;
import com.pizzeria.Exception.UserException;
import com.pizzeria.model.MenuItem;
import com.pizzeria.model.User;
import com.pizzeria.request.CreateMenuItemRequest;
import com.pizzeria.service.MenuItemService;
import com.pizzeria.service.UserService;

@RestController
@RequestMapping("/api")
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;
	@Autowired
	private UserService userService;

	@GetMapping("/menu/filter")
	public ResponseEntity<List<MenuItem>> getItemByFilter(@RequestParam boolean isVegetarian,
			@RequestParam boolean isVegan, @RequestParam boolean isGlutenFree) throws MenuItemException {
		List<MenuItem> itemsByCriteria = menuItemService.getMenuItemsByCriteria(isVegetarian, isVegan, isGlutenFree);
		return ResponseEntity.ok(itemsByCriteria);
	}

	@GetMapping("/menu/search")
	public ResponseEntity<List<MenuItem>> getMenuItemByName(@RequestParam String name)  {
		List<MenuItem> menuItem = menuItemService.searchMenuItem(name);
		return ResponseEntity.ok(menuItem);
	}
	@GetMapping("/menu/restaurant/{restaurantId}")
	public ResponseEntity<List<MenuItem>> getMenuItemByRestaurantId(@PathVariable Long restaurantId) throws MenuItemException {
		List<MenuItem> menuItems= menuItemService.getRestaurantMenuItems(restaurantId);
		return ResponseEntity.ok(menuItems);
	}

}
