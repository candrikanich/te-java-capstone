package com.techelevator.model;

import java.util.List;

public interface RecipeIngredientDAO {

	public List<RecipeIngredientRecord> getAllRecipeIngredientRecordsByRecipeId(int recipeId);
	public void addRecipeIngredientRecordToRecipe(RecipeIngredientRecord record, int recipeId);
	void saveRecipeIngredientRecord(int recipeId, int ingredientId);
}
