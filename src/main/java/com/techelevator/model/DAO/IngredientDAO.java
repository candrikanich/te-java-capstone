package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.Ingredient;

public interface IngredientDAO {
	
	public List<Ingredient> getIngredientsByRecipeId(int recipeId);
	
	public String getIngredientById();
	
	public String getIngredientByName();
	
	public void saveIngredient(Ingredient ingredient);

	public List<Ingredient> getAllIngredients();
	
	public List<Ingredient> getAllQuantities(int ingredientId);
	
	public List<Ingredient> getAllUnits();
	
	
}
