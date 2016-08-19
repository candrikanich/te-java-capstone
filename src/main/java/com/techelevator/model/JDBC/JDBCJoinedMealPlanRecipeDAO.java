package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.JoinedMealPlanRecipeRecord;
import com.techelevator.model.DAO.JoinedMealPlanRecipeDAO;

@Component
public class JDBCJoinedMealPlanRecipeDAO implements JoinedMealPlanRecipeDAO {

	private JdbcTemplate jdbcTemplate; 
	
	@Autowired 
	public JDBCJoinedMealPlanRecipeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<JoinedMealPlanRecipeRecord> getJoinedRecipeInfoByMealPlanIdAndUserId(int mealPlanId, int userId) {
		String sqlSelectRecipeInfoByMealPlanId = "SELECT * " +
												 "FROM recipe " +
												 "JOIN meal_plan_recipe " +
												 "ON recipe.recipe_id = meal_plan_recipe.recipe_id " +
												 "JOIN app_user_recipe ON app_user_recipe.recipe_id = recipe.recipe_id " +
												 "WHERE meal_plan_recipe.meal_plan_id = ? " +
												 "AND app_user_recipe.user_id = ? " +
												 "ORDER BY meal_plan_recipe.meal_date";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRecipeInfoByMealPlanId, mealPlanId, userId);
		
		List <JoinedMealPlanRecipeRecord> recipeRecords = new ArrayList<>();
		while(results.next()) { 
			JoinedMealPlanRecipeRecord record = new JoinedMealPlanRecipeRecord();
			record.setRecipeId(results.getInt("recipe_id"));
			record.setRecipeName(results.getString("recipe_name"));
			record.setInstructions(results.getString("instructions"));
			record.setMealPlanId(results.getInt("meal_plan_id"));
			record.setMealDate(results.getString("meal_date"));
			record.setMealDayOfWeek(results.getString("meal_day_of_week"));
			recipeRecords.add(record);
			
		} return recipeRecords; 
	}
	
	@Override
	public void removeRecipesFromMealPlan(int mealPlanId) {
		jdbcTemplate.update("DELETE FROM meal_plan_recipe WHERE meal_plan_id = ?", mealPlanId);		
	}
}
