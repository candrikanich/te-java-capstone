package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.Recipe;

public interface RecipeDAO {

	public List<Recipe>	getRecipesByUserId(int userId);
	
	public void addNewRecipe(Recipe recipe, int userId);
	
	public void addIngredientsToRecipe(int recipeId, int ingredientId, int unitId, int quantityId);
	
	public List<Recipe> getAllRecipes(); 
	
	public List<Recipe> getRecipeByType();
	
	public Recipe getRecipeByUserIdAndRecipeId(int userId, int recipeId);
	
	public void updateRecipe(Recipe recipe, String recipeName, String instructions);
	
	public void deleteRecipe(int recipeId);
		
}
