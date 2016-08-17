package com.techelevator.model;

public class MealPlanRecipeRecord {

	private int mealPlanId;
	private int recipeId;
	private String mealDate;
	private String mealDayOfWeek;
	
	public int getMealPlanId() {
		return mealPlanId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public String getMealDate() {
		return mealDate;
	}
	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public void setMealDate(String mealDate) {
		this.mealDate = mealDate;
	}
	public String getMealDayOfWeek() {
		return mealDayOfWeek;
	}
	public void setMealDayOfWeek(String mealDayOfWeek) {
		this.mealDayOfWeek = mealDayOfWeek;
	}
	
}
