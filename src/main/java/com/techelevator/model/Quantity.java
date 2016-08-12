package com.techelevator.model;

public class Quantity {
	
	private int quantityId;
	private String quantityName;
	private double quantityValue;
	
	public int getQuantityId() {
		return quantityId;
	}
	public String getQuantityName() {
		return quantityName;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityId(int quantityId) {
		this.quantityId = quantityId;
	}
	public void setQuantityName(String quantityName) {
		this.quantityName = quantityName;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}

}
