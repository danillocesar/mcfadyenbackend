package com.mcfadyen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcfadyen.service.HttpSessionService;
import com.mcfadyen.service.ProductService;
import com.mcfadyen.service.ShoppingCartService;
import com.mcfadyen.shop.model.CommerceItem;
import com.mcfadyen.shop.model.Product;
import com.mcfadyen.shop.model.ShoppingCart;
import com.mcfadyen.utils.UUIDBean;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	HttpSessionService httpSessionService;
	@Autowired
	ProductService productService;
	@Autowired
	UUIDBean uuidUtil;
	@Override
	public ShoppingCart getCurrentShoppingCart() {
		return httpSessionService.getCurrentShoppingCart();
	}
	@Override
	public CommerceItem addItem(Integer productId, Integer quantity){
		Product product = productService.getById(productId);
		
		ShoppingCart currentShoppingCart = httpSessionService.getCurrentShoppingCart();
		
		CommerceItem item = currentShoppingCart.findItemByProduct(product.getId());
		if(item == null){
			item = new CommerceItem();
			item.setId(uuidUtil.generateUniqueId());
			item.setProduct(product);
			item.setQuantity(quantity);
			currentShoppingCart.getItems().add(item);
		}else{
			Integer qtd = item.getQuantity().intValue() + quantity.intValue();
			item.setQuantity(qtd);
		}
		
		
		httpSessionService.updateShoppingCart(currentShoppingCart);
		return item;
	}
	@Override
	public void deleteItem(String id) {
		ShoppingCart currentShoppingCart = httpSessionService.getCurrentShoppingCart();
		currentShoppingCart.getItems().remove(currentShoppingCart.findItemById(id));
	}

}
