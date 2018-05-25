package com.mcfadyen.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<CommerceItem> items;
	private BigDecimal amount;
	
	public ShoppingCart(){
		this.items = new ArrayList<CommerceItem>();
	}
	public List<CommerceItem> getItems() {
		return items;
	}
	public void setItems(List<CommerceItem> items) {
		this.items = items;
	}
	public BigDecimal getAmount() {
		this.amount = new BigDecimal(0);
		for(CommerceItem item : items){
			this.amount = this.amount.add(item.getAmount());
		}
		return this.amount;
	}
	public void updateItem(CommerceItem item){
		CommerceItem i = findItemById(item.getId());
		if(i != null){
			i = item;
		}
	}
	public void removeItem(CommerceItem item){
		CommerceItem i = findItemById(item.getId());
		this.items.remove(i);
	}
	public CommerceItem findItemById(String id) {
	    return this.items.stream().filter(item -> id.equals(item.getId())).findFirst().orElse(null);
	}
	public CommerceItem findItemByProduct(Integer productId) {
	    return this.items.stream().filter(item -> productId == item.getProduct().getId()).findFirst().orElse(null);
	}
}
