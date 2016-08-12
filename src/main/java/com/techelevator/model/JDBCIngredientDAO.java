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
		ingredientsById = mapRowSetToIngredients(results);
		return ingredientsById;
	}
	
	@Override 
	public List<Ingredient> getAllIngredients() {
		String sqlSelectAllIngredients = "SELECT * "+
				  					  	 "FROM ingredient";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllIngredients);
		List<Ingredient> allIngredients = new ArrayList<>();
		allIngredients = mapRowSetToIngredients(results);
		return allIngredients;
	}
	@Override
	public List<Ingredient> getAllQuantities(int ingredientId) {
		String sqlForAllQuantities = "SELECT quantity "+
									 "FROM recipe_ingredient "
									 "WHERE ingredient_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForAllQuantities);
		List<Ingredient> allQuantities = new ArrayList<>();
		while( results.next() ){
			Ingredient i = new Ingredient();
			i.setQuantity(results.getInt("quantity"));
			allQuantities.add(i);
		}
		return allQuantities;
	}
	
	@Override
	public String getIngredientById() {
		return null;
	}

	@Override
	public String getIngredientByName() {
		return null;
	}

	@Override
	public void saveIngredient(Ingredient ingredient) {
		if(ingredient.getIngredientId() == 0) {
			int id = getNextIngredientId();
			ingredient.setIngredientId(id);
			jdbcTemplate.update("INSERT INTO ingredient(ingredient_id, ingredient_name) VALUES (?, ?)", 
					id, ingredient.getIngredientName());
		} else { 
			jdbcTemplate.update("INSERT INTO ingredient(ingredient_id, ingredient_name) VALUES (?, ?)", 
					ingredient.getIngredientId(), ingredient.getIngredientName());
		}
	}
	
	private List<Ingredient> mapRowSetToIngredients(SqlRowSet results) {
		ArrayList<Ingredient> ingredientList = new ArrayList<>();
		while(results.next()) {
			Ingredient i = new Ingredient();
			i.setIngredientId(results.getInt("ingredient_id"));
			i.setIngredientName(results.getString("ingredient_name"));
			ingredientList.add(i);
		}
		return ingredientList;
	}
	
	private int getNextIngredientId() {
		SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT nextval('ingredient_ingredient_id_seq')");
		result.next();
		int id = result.getInt(1);
		return id;
	}

	
}
