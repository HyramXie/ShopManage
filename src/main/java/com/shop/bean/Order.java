package com.shop.bean;


public class Order {
    private int orderID;
    private int userID;
    private String orderDate;
	private int status;
	private double price;
	private String address;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(int userID, String orderDate, int status, double price, String address) {
		this.userID = userID;
		this.orderDate = orderDate;
		this.status = status;
		this.price = price;
		this.address = address;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

