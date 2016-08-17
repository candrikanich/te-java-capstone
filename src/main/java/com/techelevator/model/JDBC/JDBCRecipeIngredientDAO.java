package com.techelevator.model.JDBC;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public List<RecipeIngredientRecord> getAllRecipeIngredientRecordsByRecipeId(int recipeId) {
		return null;
	}

	@Override
	public void addRecipeIngredientRecordToRecipe(RecipeIngredientRecord record, int recipeId) {
		jdbcTemplate.update("INSERT INTO recipe_ingredient(recipe_id, ingredient_id, unit_id, quantity_id)"
				+ " VALUES (?, ?, ?, ? )", recipeId, record.getIngredientId(), record.getUnitId(), record.getQuantityId());
		
	}
	
	@Override
	public void saveRecipeIngredientRecord(int recipeId, int ingredientId) {
		jdbcTemplate.update("INSERT INTO recipe_ingredient) VALUES (?, ?)", recipeId, ingredientId);
		
	}

	@Override
	public void removeIngredientFromRecipe(int recipeId, int ingredientId, int unitId) {
		jdbcTemplate.update("DELETE FROM recipe_ingredient WHERE recipe_ingredient.recipe_id = ? AND "
				+ "recipe_ingredient.ingredient_id = ? AND recipe_ingredient.unit_id = ?", recipeId, ingredientId, unitId);		
	}
}
