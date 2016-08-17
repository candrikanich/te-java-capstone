package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.MealPlanRecipeRecord;

public interface MealPlanRecipeDAO {
	
	public void addRecipeToMealPlan(int mealPlanId, int recipeId, String mealDate, String mealDayOfWeek);

	public List<MealPlanRecipeRecord> getMealPlanRecipeRecordsByMealPlanId(int mealPlanId);
}
