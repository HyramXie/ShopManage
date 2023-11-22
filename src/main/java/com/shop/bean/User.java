package com.shop.bean;

public class User {
    private int userID;
    private String username;
    private String passwordHash;
    private String email;
    private String phoneNumber;
    
    public User() {
		// TODO Auto-generated constructor stub
	}
    
    public User(int userID, String username, String passwordHash, String email, String phoneNumber) {
		this.userID = userID;
		this.username = username;
		this.passwordHash = passwordHash;
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
		return passwordHash;
	}
	public void setPassword(String passwordHash) {
		this.passwordHash = passwordHash;
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

    
}

