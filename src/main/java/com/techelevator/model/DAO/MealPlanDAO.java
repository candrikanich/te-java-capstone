package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;

public interface MealPlanDAO {

	public MealPlan getMealPlanByUserIdAndMealPlanId(int userId, int MealPlanId);
	
	List<MealPlan> getMealPlansByUserId(int userId);
	
	void addNewMealPlan(MealPlan mealPlan);

	public List<Recipe> getRecipesByMealPlanId(int mealPlanId);
}
