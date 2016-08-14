package com.techelevator.model;

public class RecipeIngredientRecord {

	private int recipeId;
	private int ingredientId;
	private int unitId;
	private int quantityId;
	
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
