package com.shop.bean;

public class ShopCart {
    private int cartID;
    private int userID;
    
    public ShopCart() {
		// TODO Auto-generated constructor stub
	}
    
	public ShopCart(int cartID, int userID) {
		this.cartID = cartID;
		this.userID = userID;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

    
}

