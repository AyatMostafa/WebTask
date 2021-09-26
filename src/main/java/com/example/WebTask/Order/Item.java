package com.example.WebTask.Order;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Basic(optional = false)
	@Column(unique=true)
	private String name;
	@NotNull
	private boolean isAvailable;
	@NotNull
	private float price;
	
	
	public Item() {

	}

	public Item(Long id, String name, boolean isAvailable, float price) {
		super();
		this.id = id;
		this.name = name;
		this.isAvailable = isAvailable;
		this.price = price;
	}
	
	public Item(String name, boolean isAvailable, float price) {
		super();
		this.name = name;
		this.isAvailable = isAvailable;
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Item{ " +
				"id = " + id +
				", isAvailable = " + isAvailable +
				", price = " + price +
				" }";
	}
}