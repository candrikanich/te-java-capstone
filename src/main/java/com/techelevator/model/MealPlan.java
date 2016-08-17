package com.techelevator.model;

public class MealPlan {

	private int mealPlanId;
	private String mealPlanStartDate;
	private int userId;
	
	public int getMealPlanId() {
		return mealPlanId;
	}
	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}
	public String getMealPlanStartDate() {
		return mealPlanStartDate;
	}
	public void setMealPlanStartDate(String mealPlanStartDate) {
		this.mealPlanStartDate = mealPlanStartDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
