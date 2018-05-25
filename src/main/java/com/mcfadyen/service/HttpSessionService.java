package com.mcfadyen.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcfadyen.shop.model.ShoppingCart;

@Service("httpSessionService")
public class HttpSessionService {

	@Autowired
	HttpSession httpSession;
	final String SHOPPING_CART = "shoppingCart";
	
	public ShoppingCart getCurrentShoppingCart(){
		if(httpSession.getAttribute(this.SHOPPING_CART) == null){
			updateShoppingCart(new ShoppingCart());
		}
		return (ShoppingCart) httpSession.getAttribute(this.SHOPPING_CART);
	}
	public void updateShoppingCart(ShoppingCart shoppingCart){
		httpSession.setAttribute(this.SHOPPING_CART, shoppingCart);
	}
}
