package com.techelevator.model;

public class JoinedMealPlanRecipeRecord {

	private String recipeName;
	private int recipeId;
	private String instructions;
	private int mealPlanId;
	private String mealDate;
	private String mealDayOfWeek;
	
	public String getRecipeName() {
		return recipeName;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public String getInstructions() {
		return instructions;
	}
	public int getMealPlanId() {
		return mealPlanId;
	}
	public String getMealDate() {
		return mealDate;
	}
	public String getMealDayOfWeek() {
		return mealDayOfWeek;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}
	public void setMealDate(String mealDate) {
		this.mealDate = mealDate;
	}
	public void setMealDayOfWeek(String mealDayOfWeek) {
		this.mealDayOfWeek = mealDayOfWeek;
	}
	
	
}
