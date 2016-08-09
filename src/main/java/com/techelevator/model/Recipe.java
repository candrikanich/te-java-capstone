package com.techelevator.model;

public class Recipe {
	
	private String recipeName;
	private int recipeId;
	private int mealTypeId;
	private int categoryId;
	private String instructions;
	
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getMealTypeId() {
		return mealTypeId;
	}
	public void setMealTypeId(int mealTypeId) {
		this.mealTypeId = mealTypeId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	
}
