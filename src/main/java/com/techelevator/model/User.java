package com.techelevator.model;

public class User {
	
	private String userName;
	private String hash;
	private String salt;
	private int userId;
	
	public String getUserName() {
		return userName;
	}
	public String getHash() {
		return hash;
	}
	public String getSalt() {
		return salt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
