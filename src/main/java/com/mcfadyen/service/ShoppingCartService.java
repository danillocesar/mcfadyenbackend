package com.mcfadyen.service;

import com.mcfadyen.shop.model.CommerceItem;
import com.mcfadyen.shop.model.ShoppingCart;

public interface ShoppingCartService {

	public ShoppingCart getCurrentShoppingCart();
	public CommerceItem addItem(Integer productId, Integer quantity);
	public void deleteItem(String id);
	
}
