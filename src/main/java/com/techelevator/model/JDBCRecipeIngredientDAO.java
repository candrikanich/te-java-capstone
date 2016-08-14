package com.techelevator.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
		
	}
	
	@Override
	public void saveRecipeIngredientRecord(int recipeId, int ingredientId) {
		jdbcTemplate.update("INSERT INTO recipe_ingredient) VALUES (?, ?)", recipeId, ingredientId);
		
	}
}
