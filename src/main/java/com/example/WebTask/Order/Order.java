package com.example.WebTask.Order;

import java.util.List;

public class Order{ 
	
	private List<String> items;
	private String creditCard;
	

	public Order(List<String> items, String creditCard) {
		this.items = items;
		this.creditCard = creditCard;
	}
	
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

}
