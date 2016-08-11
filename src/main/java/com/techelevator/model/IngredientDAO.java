package com.techelevator.model;

import java.util.List;

public interface IngredientDAO {
	
	public List<Ingredient> getIngredientsByRecipeId(int recipeId);
	
	public String  getIngredientById();
	
	public String getIngredientByName();
	
	public void saveIngredient(Ingredient ingredient);
	
}
