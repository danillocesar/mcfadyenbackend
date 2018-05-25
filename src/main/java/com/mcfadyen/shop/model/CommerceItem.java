package com.mcfadyen.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommerceItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private Product product;
	private Integer quantity;
	private BigDecimal amount;
	
	public CommerceItem(){
		this.amount = new BigDecimal(0);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getAmount() {
		return this.amount.add(product.getPrice().multiply(new BigDecimal(quantity)));
	}
	
}
