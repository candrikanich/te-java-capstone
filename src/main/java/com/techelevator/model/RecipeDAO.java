package com.techelevator.model;

import java.util.List;

public interface RecipeDAO {

	public List<Recipe>	getRecipesByUserId(int userId);
	
	public  void saveRecipe(Recipe r);
	
	public List<Recipe> getAllRecipes(); 
	
	public List<Recipe> getRecipeByType();
}
