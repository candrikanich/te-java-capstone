package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.MealPlan;

public interface MealPlanDAO {

	public MealPlan getMealPlanByUserIdAndMealPlanId(int userId, int MealPlanId);
	
//	public void addNewMealPlan(MealPlan MealPlan, int userId);
	
//	public void addRecipeToMealPlan(int MealPlanId, int ingredientId, int unitId, int quantityId);

	List<MealPlan> getMealPlansByUserId(int userId);
		
}
