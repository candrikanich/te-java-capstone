package com.techelevator.model;

public class Ingredient {
	private String ingredientName;
	private int ingredientId;
	private double quantity; 
	private String unit; 
	
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public double getQuantity() {
		return quantity; 
	}
	public void setQuantity(double quantity) {
		this.quantity=quantity; 
	}
	public String getUnit(){
		return unit; 
	}
	public void setUnit(String unit){
		this.unit = unit;
		}
}
