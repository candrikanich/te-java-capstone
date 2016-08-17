package com.techelevator.model.JDBC;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;
import com.techelevator.model.DAO.MealPlanDAO;

@Component
public class JDBCMealPlanDAO implements MealPlanDAO {

		private JdbcTemplate jdbcTemplate; 
		
		@Autowired 
		public JDBCMealPlanDAO(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		@Override
		public MealPlan getMealPlanByUserIdAndMealPlanId(int userId, int mealPlanId) {
			String sqlSelectMealPlanByUserAndMealPlan = "SELECT * "+
					   								"FROM meal_plan "+
					   								"WHERE user_id =  ? AND meal_plan_id = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMealPlanByUserAndMealPlan, userId, mealPlanId);
			MealPlan mealPlanByUserAndId = new MealPlan();
			while(results.next()) { 
				mealPlanByUserAndId = mapRowToMealPlan(results);
			} return mealPlanByUserAndId;
		}
		
		@Override
		public List<MealPlan> getMealPlansByUserId(int userId) {
			String sqlSelectMealPlansByUser = "SELECT * "+
										   "FROM meal_plan "+
										   "WHERE user_id = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMealPlansByUser, userId);
			List<MealPlan> mealPlansByUser = new ArrayList<MealPlan>();
			while(results.next()) {
				mealPlansByUser.add(mapRowToMealPlan(results));
			}
			return mealPlansByUser;
		}
		
		@Override
		public List<Recipe> getRecipesByMealPlanId(int mealPlanId) {
			String sqlSelectRecipesByMealPlanId =  "SELECT * " +
												   "FROM recipe " +
												   "WHERE recipe.recipe_id IN (" +
													   "SELECT meal_plan_recipe.recipe_id " +
													   "FROM meal_plan_recipe " +
													   "WHERE meal_plan_recipe.meal_plan_id = ?)";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectRecipesByMealPlanId, mealPlanId);
			List<Recipe> recipesByMealPlanId = new ArrayList<Recipe>();
			while(results.next()) {
				Recipe r = new Recipe();
				r.setRecipeId(results.getInt("recipe_id"));
				r.setRecipeName(results.getString("recipe_name"));
				r.setInstructions(results.getString("instructions"));
				recipesByMealPlanId.add(r);
			}
			return recipesByMealPlanId;
		}
		
		@Override
		public void addNewMealPlan(MealPlan mealPlan) {
				int id = getNextMealPlanId();
				mealPlan.setMealPlanId(id);
				
				jdbcTemplate.update("INSERT INTO meal_plan(meal_plan_id, meal_plan_start_date, user_id) VALUES (?, ?, ?)", 
						id, mealPlan.getMealPlanStartDate(), mealPlan.getUserId());
		}

		private MealPlan mapRowToMealPlan(SqlRowSet result) {
			MealPlan m = new MealPlan();
				m.setMealPlanId(result.getInt("meal_plan_id"));
				String startDate = result.getString("meal_plan_start_date");
				m.setMealPlanStartDate(startDate);
				m.setUserId(result.getInt("user_id"));
			return m;
		}
		
		private int getNextMealPlanId() {
			SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT nextval('meal_plan_meal_plan_id_seq')");
			result.next();
			int id = result.getInt(1);
			return id;
		}

//		@Override
//		public void addRecipesToMealPlan(int MealPlanId, int ingredientId, int unitId, int quantityId) {
//			jdbcTemplate.update("INSERT INTO MealPlan_ingredient(MealPlan_id, ingredient_id, unit_id, quantity_id) VALUES (?, ?, ?, ?)", 
//					MealPlanId, ingredientId, unitId, quantityId);			
//		}

}
