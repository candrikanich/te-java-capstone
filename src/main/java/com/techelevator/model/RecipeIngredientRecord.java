package com.techelevator.model;

public class RecipeIngredientRecord {

	private int recipeId;
	private int ingredientId;
	private int unitId;
	private int quantityId;
	//additional items for edit recipe jsp
	private String recipeName;
	private String ingredientName;
	private String unitName;
	private String quantityName;
	
	
	public String getRecipeName() {
		return recipeName;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public String getUnitName() {
		return unitName;
	}
	public String getQuantityName() {
		return quantityName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public void setQuantityName(String quantityName) {
		this.quantityName = quantityName;
	}
	
	public int getRecipeId() {
		return recipeId;
	}
	public int getIngredientId() {
		return ingredientId;
	}
	public int getUnitId() {
		return unitId;
	}
	public int getQuantityId() {
		return quantityId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public void setQuantityId(int quantityId) {
		this.quantityId = quantityId;
	}
}
