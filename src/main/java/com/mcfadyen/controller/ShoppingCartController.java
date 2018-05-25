package com.mcfadyen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcfadyen.service.ShoppingCartService;
import com.mcfadyen.shop.model.CommerceItem;
import com.mcfadyen.shop.model.ShoppingCart;

@RestController
@CrossOrigin
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;
	
	@GetMapping("/shoppingcart")
	ShoppingCart getCurrentShoppingCart(HttpServletRequest request){
		return shoppingCartService.getCurrentShoppingCart();
	}
	@PostMapping("/shoppingcart/items")
	CommerceItem addItemToShoppingCart(@RequestParam(value = "product_id") Integer productId,  @RequestParam(value = "quantity") Integer quantity, HttpServletRequest request){
		return shoppingCartService.addItem(productId, quantity);
	}
	@DeleteMapping("/shoppingcart/item/{id}")
	void deleteItem(@PathVariable("id") String id){
		shoppingCartService.deleteItem(id);
	}
}
