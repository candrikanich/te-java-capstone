package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.DAO.GroceryListDAO;

@Component
public class JDBCGroceryListDAO implements GroceryListDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public JDBCGroceryListDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Ingredient> getAllIngredientsByMealPlan(int mealPlanId) {
		String sqlForAllIngredients = "SELECT ingredient_name "+
									  "FROM recipe_ingredient "+
									  "JOIN ingredient "+
									  		"ON recipe_ingredient.ingredient_id = ingredient.ingredient_id "+
									  "WHERE recipe_id IN (SELECT recipe_id "+
									  					"FROM meal_plan_recipe "+
									  					"WHERE meal_plan_recipe.meal_plan_id = ? "+
									  					"ORDER BY ingredient_name)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForAllIngredients, mealPlanId);
		ArrayList<Ingredient> allIngredients = new ArrayList<>();
		while(results.next() ) {
			Ingredient i = new Ingredient();
			i.setIngredientName(results.getString("ingredient_name"));
			allIngredients.add(i);
		}
		return allIngredients;
	
	}
	
}
