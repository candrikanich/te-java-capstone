package com.techelevator.model;

import java.time.LocalDate;

public class MealPlan {

	private int mealPlanId;
	private LocalDate mealPlanStartDate;
	private LocalDate mealPlanEndDate;
	private int userId;
	
	public int getMealPlanId() {
		return mealPlanId;
	}
	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}
	public LocalDate getMealPlanStartDate() {
		return mealPlanStartDate;
	}
	public void setMealPlanStartDate(LocalDate mealPlanStartDate) {
		this.mealPlanStartDate = mealPlanStartDate;
	}
	public LocalDate getMealPlanEndDate() {
		return mealPlanEndDate;
	}
	public void setMealPlanEndDate(LocalDate mealPlanEndDate) {
		this.mealPlanEndDate = mealPlanEndDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
