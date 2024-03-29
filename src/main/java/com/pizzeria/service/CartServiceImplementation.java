package com.pizzeria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzeria.Exception.CartException;
import com.pizzeria.Exception.CartItemException;
import com.pizzeria.Exception.MenuItemException;
import com.pizzeria.Exception.UserException;
import com.pizzeria.model.Cart;
import com.pizzeria.model.CartItem;
import com.pizzeria.model.MenuItem;
import com.pizzeria.model.User;
import com.pizzeria.repository.CartItemRepository;
import com.pizzeria.repository.CartRepository;
import com.pizzeria.repository.MenuItemRepository;
import com.pizzeria.request.AddCartItemRequest;
import com.pizzeria.request.UpdateCartItemRequest;

@Service
public class CartServiceImplementation implements CartSerive {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, MenuItemException, CartException, CartItemException {

		User user = userService.findUserProfileByJwt(jwt);
		
		Optional<MenuItem> menuItem=menuItemRepository.findById(req.getMenuItemId());
		if(menuItem.isEmpty()) {
			throw new MenuItemException("Menu Item not exist with id "+req.getMenuItemId());
		}

		Cart cart = findCartByUserId(user.getId());

		for (CartItem cartItem : cart.getItems()) {
			if (cartItem.getMenuItem().equals(menuItem.get())) {

				int newQuantity = cartItem.getQuantity() + req.getQuantity();
				return updateCartItemQuantity(cartItem.getId(),newQuantity);
			}
		}

		CartItem newCartItem = new CartItem();
		newCartItem.setMenuItem(menuItem.get());
		newCartItem.setQuantity(req.getQuantity());
		newCartItem.setCart(cart);
		
		CartItem savedItem=cartItemRepository.save(newCartItem);
		cart.getItems().add(savedItem);
		cartRepository.save(cart);
		
		return savedItem;

	}

	@Override
	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException {
		Optional<CartItem> cartItem=cartItemRepository.findById(cartItemId);
		if(cartItem.isEmpty()) {
			throw new CartItemException("cart item not exist with id "+cartItemId);
		}
		cartItem.get().setQuantity(quantity);
		return cartItemRepository.save(cartItem.get());
	}

	@Override
	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, 
	CartException, CartItemException {

		User user = userService.findUserProfileByJwt(jwt);

		Cart cart = findCartByUserId(user.getId());
		
		Optional<CartItem> cartItem=cartItemRepository.findById(cartItemId);
		
		if(cartItem.isEmpty()) {
			throw new CartItemException("cart item not exist with id "+cartItemId);
		}

		cart.getItems().remove(cartItem.get());
		return cartRepository.save(cart);
	}

	@Override
	public Long calculateCartTotals(Cart cart) throws UserException {

		Long total = 0L;
		for (CartItem cartItem : cart.getItems()) {
			total += cartItem.getMenuItem().getPrice() * cartItem.getQuantity();
		}
		return total;
	}

	@Override
	public Cart findCartById(Long id) throws CartException {
		Optional<Cart> cart = cartRepository.findById(id);
		if(cart.isPresent()) {
			return cart.get();
		}
		throw new CartException("Cart not found with the id "+id);
	}

	@Override
	public Cart findCartByUserId(Long userId) throws CartException, UserException {
	
		Optional<Cart> opt=cartRepository.findByCustomer_Id(userId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CartException("cart not found");
		
	}

	

}
