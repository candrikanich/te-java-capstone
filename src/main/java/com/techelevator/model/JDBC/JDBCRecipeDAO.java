package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Recipe;
import com.techelevator.model.DAO.RecipeDAO;

@Component
public class JDBCRecipeDAO implements RecipeDAO {

		private JdbcTemplate jdbcTemplate; 
		
		@Autowired 
		public JDBCRecipeDAO(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

		@Override
		public Recipe getRecipeByUserIdAndRecipeId(int userId, int recipeId) {
			String sqlSelectRecipeByUserAndRecipe = "SELECT * "+
					   								"FROM recipe "+
					   								"WHERE recipe_id IN (SELECT app_user_recipe.recipe_id FROM app_user_recipe "+
					   								"WHERE app_user_recipe.user_id = ? AND app_user_recipe.recipe_id = ?)";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRecipeByUserAndRecipe, userId, recipeId);
			Recipe recipeByUserAndId = new Recipe();
			while(results.next()) { 
				recipeByUserAndId = mapRowToRecipe(results);
			} return recipeByUserAndId;
		}
		
		@Override
		public List<Recipe> getRecipesByUserId(int userId) {
			String sqlSelectRecipeByUser = "SELECT * "+
										   "FROM recipe "+
										   "WHERE recipe_id IN ( SELECT app_user_recipe.recipe_id FROM app_user_recipe "+
										   "WHERE app_user_recipe.user_id = ?)";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRecipeByUser, userId);
			List<Recipe> recipesByUser = new ArrayList<Recipe>();
			while(results.next()) {
				recipesByUser.add(mapRowToRecipe(results));
			}
			return recipesByUser;
		}

		@Override
		public void addNewRecipe(Recipe recipe, int userId) {
				int id = getNextRecipeId();
				recipe.setRecipeId(id);
				jdbcTemplate.update("INSERT INTO recipe(recipe_id, recipe_name, instructions) VALUES (?, ?, ?)", 
						id, recipe.getRecipeName(), recipe.getInstructions());
				jdbcTemplate.update("INSERT INTO app_user_recipe(user_id, recipe_id) VALUES (?, ?)", 
						userId, recipe.getRecipeId());
		}

		@Override
		public void addIngredientsToRecipe(int recipeId, int ingredientId, int unitId, int quantityId) {
			jdbcTemplate.update("INSERT INTO recipe_ingredient(recipe_id, ingredient_id, unit_id, quantity_id) VALUES (?, ?, ?, ?)", 
					recipeId, ingredientId, unitId, quantityId);			
		}
		
		@Override
		public List<Recipe> getAllRecipes() {
			return null;
		}

		@Override
		public List<Recipe> getRecipeByType() {
			return null;
		}
		
		private Recipe mapRowToRecipe(SqlRowSet results) {
			Recipe r = new Recipe();
				r.setRecipeId(results.getInt("recipe_id"));
				r.setRecipeName(results.getString("recipe_name"));
				r.setInstructions(results.getString("instructions"));
			return r;
		}
		
		private int getNextRecipeId() {
			SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT nextval('recipe_recipe_id_seq')");
			result.next();
			int id = result.getInt(1);
			return id;
		}
}
