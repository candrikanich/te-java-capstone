package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.JoinedMealPlanRecipeRecord;

public interface JoinedMealPlanRecipeDAO {

	public List<JoinedMealPlanRecipeRecord> getJoinedRecipeInfoByMealPlanId(int mealPlanId);
}
