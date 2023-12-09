package com.shop.bean;

public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    
    public User() {
		// TODO Auto-generated constructor stub
	}
    
    public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
    
    public User(String username, String password, String email, String phoneNumber, String address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
    public User(String username, String password, String email, String phoneNumber) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
    
    //get set
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwordHash) {
		this.password = passwordHash;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
}

