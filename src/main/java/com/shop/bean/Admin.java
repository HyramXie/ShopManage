package com.shop.bean;

public class Admin {
    private int adminID;
    private String adminname;
    private String password;
    
    public Admin() {
    	
	}
    
    public Admin(String username, String password) {
		this.adminname = username;
		this.password = password;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}