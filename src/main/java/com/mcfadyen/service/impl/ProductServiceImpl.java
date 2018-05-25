package com.mcfadyen.service.impl;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcfadyen.dao.ProductDao;
import com.mcfadyen.service.ProductService;
import com.mcfadyen.shop.model.Product;
import com.mcfadyen.shop.model.ShoppingCart;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao dao;
	@Override
	public List<Product> getProducts(){
		return dao.listAll();
	}
	@Override
	public Product getById(Integer id) {
		return dao.getById(id);
	}

}
