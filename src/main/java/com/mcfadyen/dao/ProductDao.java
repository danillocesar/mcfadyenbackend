package com.mcfadyen.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcfadyen.shop.model.Product;

@Repository
@Transactional
public class ProductDao extends AbstractDao<Integer, Product> {
}
