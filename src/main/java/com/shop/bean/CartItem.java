package com.shop.bean;

public class CartItem {
    private int cartItemID;
    private int cartID;
    private int productID;
    private int quantity;
    
    public CartItem() {
		// TODO Auto-generated constructor stub
	}
    
	public CartItem(int cartItemID, int cartID, int productID, int quantity) {
		this.cartItemID = cartItemID;
		this.cartID = cartID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public int getCartItemID() {
		return cartItemID;
	}
	public void setCartItemID(int cartItemID) {
		this.cartItemID = cartItemID;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
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

    
}
