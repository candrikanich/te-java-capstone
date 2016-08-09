package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component

public class JDBCIngredientDAO implements IngredientDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCIngredientDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Ingredient> getIngredientsByRecipeId(int recipeId) {
		String sqlForIngredientById = "SELECT * "+
									  "FROM ingredient "+
									  "WHERE ingredient_id IN ( SELECT recipe_ingredient.ingredient_id "+
									  "FROM recipe_ingredient WHERE recipe_ingredient.recipe_id = ? )";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForIngredientById, recipeId);
		List<Ingredient> ingredientsById = new ArrayList<Ingredient>();
			while(results.next()){
				Ingredient i = new Ingredient();
				i.setIngredientId(results.getInt("ingredient_id"));
				i.setIngredientName(results.getString("ingredient_name"));
				ingredientsById.add(i);
			}
			return ingredientsById;
		}

	@Override
	public String getIngredientById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIngredientByName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}