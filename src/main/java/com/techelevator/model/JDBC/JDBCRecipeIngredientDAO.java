package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.RecipeIngredientRecord;
import com.techelevator.model.DAO.RecipeIngredientDAO;

@Component
public class JDBCRecipeIngredientDAO implements RecipeIngredientDAO {

	private JdbcTemplate jdbcTemplate; 
	
	@Autowired 
	public JDBCRecipeIngredientDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<RecipeIngredientRecord> getAllRecipeIngredientRecordsByRecipeIdAndUserId(int recipeId, int userId) {
		String sqlSelectRecipeIngredientsByRecipe = "(SELECT recipe_ingredient.recipe_id, recipe.recipe_name, "
				+ "recipe_ingredient.ingredient_id, ingredient.ingredient_name, recipe_ingredient.unit_id, "
				+ "unit.unit_name, recipe_ingredient.quantity_id, quantity.quantity_name "
				+ "FROM recipe_ingredient JOIN recipe ON recipe_ingredient.recipe_id = recipe.recipe_id "
				+ "JOIN ingredient ON recipe_ingredient.ingredient_id = ingredient.ingredient_id "
				+ "JOIN unit ON recipe_ingredient.unit_id = unit.unit_id "
				+ "JOIN quantity ON recipe_ingredient.quantity_id = quantity.quantity_id "
				+ "JOIN app_user_recipe ON app_user_recipe.recipe_id = recipe.recipe_id "
				+ "WHERE recipe_ingredient.recipe_id = ? "
				+ "AND app_user_recipe.user_id = ?)";
		List<RecipeIngredientRecord> recipeIngrdientsList = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRecipeIngredientsByRecipe, recipeId, userId);
		while (results.next()) {
			RecipeIngredientRecord record = new RecipeIngredientRecord();
			record.setRecipeId(results.getInt("recipe_id"));
			record.setRecipeName(results.getString("recipe_name"));
			record.setIngredientId(results.getInt("ingredient_id"));
			record.setIngredientName(results.getString("ingredient_name"));
			record.setUnitId(results.getInt("unit_id"));
			record.setUnitName(results.getString("unit_name"));
			record.setQuantityId(results.getInt("quantity_id"));
			record.setQuantityName(results.getString("quantity_name"));
			recipeIngrdientsList.add(record);			
			
		}		
		return recipeIngrdientsList;
	}

	@Override
	public void addRecipeIngredientRecordToRecipe(RecipeIngredientRecord record, int recipeId) {
		jdbcTemplate.update("INSERT INTO recipe_ingredient(recipe_id, ingredient_id, unit_id, quantity_id)"
				+ " VALUES (?, ?, ?, ? )", recipeId, record.getIngredientId(), record.getUnitId(), record.getQuantityId());
	}
	
//	@Override
//	public void saveRecipeIngredientRecord(int recipeId, int ingredientId) {
//		jdbcTemplate.update("INSERT INTO recipe_ingredient) VALUES (?, ?)", recipeId, ingredientId);	
//	}

	@Override
	public void removeIngredientsFromRecipe(int recipeId) {
		jdbcTemplate.update("DELETE FROM recipe_ingredient WHERE recipe_ingredient.recipe_id = ?", recipeId);		
	}
	
	@Override
	public void updateRecipe(int ingredientId, String ingredientName){
		jdbcTemplate.update("UPDATE recipe_ingredient"+
							"SET ingredient_id = ?"+
							", ingredient_name = ?", ingredientId, ingredientName);	
	}
}
