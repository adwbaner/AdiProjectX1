package com.product.dto;

import java.util.Date;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String category;
	private Date manufactureDate;
	
	
	
	public Product() {
		super();
	}

	public Product(String name, double price, String category, Date manufactureDate) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.manufactureDate = manufactureDate;
	}

	public Product(int id, String name, double price, String category, Date manufactureDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.manufactureDate = manufactureDate;
	}

	public Product(String string, int i, String string2, Date date) {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", manufactureDate=" + manufactureDate + "]";
	}
	
	

}
