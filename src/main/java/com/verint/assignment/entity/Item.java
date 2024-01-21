package com.verint.assignment.entity;

public class Item {
	
	private int itemId;
    private String imageUrl;
    private String name;
    private String description;
    private double price;
    private double discountPercentage;
    
	public Item(int itemId, String imageUrl, String name, String description, double price, double discountPercentage) {
		super();
		this.itemId = itemId;
		this.imageUrl = imageUrl;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discountPercentage = discountPercentage;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

}
