package com.shop.bean;

import java.sql.Date;

public class Order {
    private int orderID;
    private int userID;
    private Date orderDate;
	private String status;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(int orderID, int userID, Date orderDate, String status) {
		this.orderID = orderID;
		this.userID = userID;
		this.orderDate = orderDate;
		this.status = status;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

