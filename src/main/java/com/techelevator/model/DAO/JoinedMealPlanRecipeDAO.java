package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.JoinedMealPlanRecipeRecord;

public interface JoinedMealPlanRecipeDAO {

	List<JoinedMealPlanRecipeRecord> getJoinedRecipeInfoByMealPlanIdAndUserId(int userId, int mealPlanId);
	public void removeRecipesFromMealPlan(int mealPlanId);
}
