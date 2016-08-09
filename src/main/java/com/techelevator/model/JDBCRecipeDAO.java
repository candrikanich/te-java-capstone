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
		public List<Recipe> getRecipesByUserId(int userId) {
			String sqlSelectRecipeByUser = "SELECT *"+
										   " FROM Recipe"+
										   " WHERE recipe_id IN ( SELECT user_recipe.recipe_id FROM user_recipe"+
										   " WHERE user_recipe.user_recipe = ?)";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRecipeByUser, userId);
			List<Recipe> recipesByUser = new ArrayList<Recipe>();
			while( results.next() ) {
				Recipe r = new Recipe();
				r.setRecipeId(results.getInt("recipe_id"));
				r.setRecipeName(results.getString("recipe_name"));
				r.setInstructions(results.getString("instructions"));
				recipesByUser.add(r);
			}
			return recipesByUser;
		}

		@Override
		public void saveRecipe(Recipe r) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Recipe> getAllRecipes() {
			return null;
		}

		@Override
		public List<Recipe> getRecipeByType() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
}
