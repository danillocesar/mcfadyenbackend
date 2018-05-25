package com.mcfadyen.service;

import java.util.List;

import com.mcfadyen.shop.model.Product;

public interface ProductService {
	List<Product> getProducts();
	Product getById(Integer id);
}
