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
					   								"WHERE user_id =  ? AND meal_plan_id = ?)";
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
		
//		@Override
//		public void addNewMealPlan(MealPlan MealPlan, int userId) {
//				int id = getNextMealPlanId();
//				MealPlan.setMealPlanId(id);
//				jdbcTemplate.update("INSERT INTO MealPlan(MealPlan_id, MealPlan_name, instructions) VALUES (?, ?, ?)", 
//						id, MealPlan.getMealPlanName(), MealPlan.getInstructions());
//				jdbcTemplate.update("INSERT INTO app_user_MealPlan(user_id, MealPlan_id) VALUES (?, ?)", 
//						userId, MealPlan.getMealPlanId());
//				
//		}

		private MealPlan mapRowToMealPlan(SqlRowSet result) {
			MealPlan m = new MealPlan();
				m.setMealPlanId(result.getInt("MealPlan_id"));
				LocalDate startDate = result.getDate("meal_plan_start_date").toLocalDate();
				m.setStartDate(startDate);
				LocalDate endDate = result.getDate("meal_plan_end_date").toLocalDate();
				m.setEndDate(endDate);
				m.setUserId(result.getInt("user_id"));
			return m;
		}
		
		private int getNextMealPlanId() {
			SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT nextval('MealPlan_MealPlan_id_seq')");
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
