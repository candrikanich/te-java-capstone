package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.Ingredient;

public interface GroceryListDAO {
	public List<Ingredient> getAllIngredientsByMealPlan(int mealPlanId);
}
