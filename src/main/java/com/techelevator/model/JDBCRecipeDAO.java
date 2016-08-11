package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCRecipeDAO implements RecipeDAO {

		private JdbcTemplate jdbcTemplate; 
		
		@Autowired 
		public JDBCRecipeDAO(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

		@Override
		public Recipe getRecipeById(int recipeId) {
			String sqlSearchForRecipeById = "SELECT * " +
									  		"FROM recipe "+
									  		"WHERE recipe_id = ?";
			SqlRowSet results= jdbcTemplate.queryForRowSet(sqlSearchForRecipeById, recipeId);
			Recipe recipeById = new Recipe(); 
			while(results.next()) {
				mapRowToRecipe(results);
			}
			return recipeById;
		}
		@Override
		public List<Recipe> getRecipesByUserId(int userId) {
			String sqlSelectRecipeByUser = "SELECT *"+
										   "FROM recipe "+
										   "WHERE recipe_id IN ( SELECT app_user_recipe.recipe_id FROM app_user_recipe "+
										   "WHERE app_user_recipe.user_id = ?)";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRecipeByUser, userId);
			List<Recipe> recipesByUser = new ArrayList<Recipe>();
			while(results.next()) {
				Recipe r = mapRowToRecipe(results);
				recipesByUser.add(r);
			}
			return recipesByUser;
		}

		@Override
		public void saveRecipe(Recipe recipe) {
			if (recipe.getRecipeId() == 0) {
				int id = getNextRecipeId();
				recipe.setRecipeId(id);
				jdbcTemplate.update("INSERT INTO recipe(recipe_id, recipe_name, instructions) VALUES (?, ?, ?)", 
						id, recipe.getRecipeName(), recipe.getInstructions());
			} else {
				jdbcTemplate.update("INSERT INTO recipe(recipe_id, recipe_name, instructions) VALUES (?, ?, ?)", 
						recipe.getRecipeId(), recipe.getRecipeName(), recipe.getInstructions());
			}
		}

		@Override
		public List<Recipe> getAllRecipes() {
			return null;
		}

		@Override
		public List<Recipe> getRecipeByType() {
			return null;
		}

		@Override
		public void saveRecipeIngredients(int recipeId, int ingredientId) {
			jdbcTemplate.update("INSERT INTO recipe_ingredient) VALUES (?, ?)", recipeId, ingredientId);
			
		}
		
		private Recipe mapRowToRecipe(SqlRowSet results) {
			Recipe r = new Recipe();
			r.setRecipeId(results.getInt("recipe_id"));
			r.setRecipeName(results.getString("recipe_name"));
			r.setInstructions(results.getString("instructions"));
			return r;
		}
		
		private int getNextRecipeId() {
			SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT nextval('receipe_recipe_id_seq')");
			result.next();
			int id = result.getInt(1);
			return id;
		}
		
		
		
}
