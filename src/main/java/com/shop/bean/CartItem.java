package com.shop.bean;

public class CartItem {
    private int cartItemID;
    private int userID;
    private int productID;
    private int quantity;
    private double price;
    private String productName;
    
    public CartItem() {
		// TODO Auto-generated constructor stub
	}
    
	public CartItem(int userID, int productID, int quantity) {
		this.userID = userID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public CartItem(int cartItemID, int quantity) {
		super();
		this.cartItemID = cartItemID;
		this.quantity = quantity;
	}

	public int getCartItemID() {
		return cartItemID;
	}
	public void setCartItemID(int cartItemID) {
		this.cartItemID = cartItemID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

    
}
