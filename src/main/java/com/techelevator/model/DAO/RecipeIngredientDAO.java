package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.RecipeIngredientRecord;

public interface RecipeIngredientDAO {

	public List<RecipeIngredientRecord> getAllRecipeIngredientRecordsByRecipeId(int recipeId);
	public void addRecipeIngredientRecordToRecipe(RecipeIngredientRecord record, int recipeId);
	void saveRecipeIngredientRecord(int recipeId, int ingredientId);
	public void removeIngredientFromRecipe(int recipeId, int ingredientId, int unitId);
	public void updateRecipe(int ingredientId, String ingredientName);
}
