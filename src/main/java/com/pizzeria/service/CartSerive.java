package com.pizzeria.service;

import com.pizzeria.Exception.CartException;
import com.pizzeria.Exception.CartItemException;
import com.pizzeria.Exception.MenuItemException;
import com.pizzeria.Exception.UserException;
import com.pizzeria.model.Cart;
import com.pizzeria.model.CartItem;
import com.pizzeria.model.MenuItem;
import com.pizzeria.model.User;
import com.pizzeria.request.AddCartItemRequest;
import com.pizzeria.request.UpdateCartItemRequest;

public interface CartSerive {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, MenuItemException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	

	

	

}
