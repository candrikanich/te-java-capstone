package com.techelevator.model;

import java.util.List;

public interface RecipeDAO {

	public List<Recipe>	getRecipesByUserId(int userId);
	
	public void saveRecipe(Recipe recipe );
	
	public List<Recipe> getAllRecipes(); 
	
	public List<Recipe> getRecipeByType();

	Recipe getRecipeById(int recipeId);
	
	public void saveRecipeIngredients(int recipeId, int ingredientId);
	
	public Recipe getRecipeByUserIdAndRecipeId(int userId, int recipeId);
}
