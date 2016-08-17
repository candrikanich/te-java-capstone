package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.MealPlanRecipeRecord;
import com.techelevator.model.Recipe;
import com.techelevator.model.DAO.MealPlanRecipeDAO;

@Component
public class JDBCMealPlanRecipeDAO implements MealPlanRecipeDAO {

	private JdbcTemplate jdbcTemplate; 
	
	@Autowired 
	public JDBCMealPlanRecipeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addRecipeToMealPlan(int mealPlanId, int recipeId, String mealDate, String mealDayOfWeek) {
		String sqlAddRecipeToMealPlan = "INSERT INTO meal_plan_recipe(meal_plan_id, recipe_id, meal_date, meal_day_of_week) "+
										"VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sqlAddRecipeToMealPlan, mealPlanId, recipeId, mealDate, mealDayOfWeek);
	}

	@Override
	public List<MealPlanRecipeRecord> getMealPlanRecipeRecordsByMealPlanId(int mealPlanId) {
		
		String sqlSelectMealPlanRecipeRecordsByMealPlanId = "SELECT * " + 
															"FROM meal_plan_recipe " + 
															"WHERE meal_plan_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMealPlanRecipeRecordsByMealPlanId, mealPlanId);
		List<MealPlanRecipeRecord> mealPlanRecipeRecords = new ArrayList<>();
		while (results.next()) {
			MealPlanRecipeRecord record = new MealPlanRecipeRecord();
			record.setRecipeId(results.getInt("recipe_id"));
			record.setMealPlanId(results.getInt("meal_plan_id"));
			record.setMealDate(results.getString("meal_date"));
			record.setMealDayOfWeek(results.getString("meal_day_of_week"));
			mealPlanRecipeRecords.add(record);
		}
		return mealPlanRecipeRecords;
	}
	
	

}
