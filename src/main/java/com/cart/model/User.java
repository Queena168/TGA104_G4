package com.cart.model;

public class User {
	private int userNo;
	private String name;
	private String email;
	private String password;
	
	public User() {
	}
	public User(int userNo, String name, String email, String password) {
		this.userNo = userNo;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
