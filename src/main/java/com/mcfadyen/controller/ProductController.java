package com.mcfadyen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcfadyen.service.ProductService;
import com.mcfadyen.shop.model.Product;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	List<Product> getProducts(){
		return productService.getProducts();
	}
}
