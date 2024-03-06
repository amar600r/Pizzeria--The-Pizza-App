package com.pizzeria.request;

import com.pizzeria.model.MenuItem;

import lombok.Data;

@Data
public class AddCartItemRequest {
	
	private Long menuItemId;
	private int quantity;

}
