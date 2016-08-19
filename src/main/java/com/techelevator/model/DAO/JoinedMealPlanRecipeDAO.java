package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.JoinedMealPlanRecipeRecord;

public interface JoinedMealPlanRecipeDAO {

	List<JoinedMealPlanRecipeRecord> getJoinedRecipeInfoByMealPlanIdAndUserId(int mealPlanId, int userId);
	public void removeRecipesFromMealPlan(int mealPlanId);
}
