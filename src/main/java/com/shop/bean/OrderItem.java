package com.shop.bean;

public class OrderItem {
    private int orderItemID;
    private int orderID;
    private int productID;
    private int quantity;
    private String productName;
    
    public OrderItem() {
		// TODO Auto-generated constructor stub
	}
    
	public OrderItem(int orderID, int productID, int quantity) {
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public int getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
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

    
}
