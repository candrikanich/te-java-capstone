package com.techelevator.model;

import java.time.LocalDate;

public class MealPlan {

	private int mealPlanId;
	private LocalDate startDate;
	private LocalDate endDate;
	private int userId;
	
	public int getMealPlanId() {
		return mealPlanId;
	}
	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
