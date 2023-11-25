package com.shop.bean;

public class Product {
    private int productID;
    private String productName;
    private double price;
	private int stockQuantity;
    private int categoryID;

    public Product() {
		// TODO Auto-generated constructor stub
	}
    
    public Product(String productName, double price, int stockQuantity, int categoryID) {
		super();
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.categoryID = categoryID;
	}

	public Product(int productID, String productName, double price, int stockQuantity, int categoryID) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.categoryID = categoryID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
    
    
    
}

