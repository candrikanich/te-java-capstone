package com.techelevator.model;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.techelevator.model.DAO.IngredientDAO;
import com.techelevator.model.DAO.RecipeDAO;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("/test-config.xml")
@Transactional
public class JDBCIngredientDAOIntegrationTest {
	
	@Autowired private BasicDataSource dataSource;
	@Autowired private IngredientDAO ingredientDAO;
	@Autowired private RecipeDAO recipeDAO;
	
	@After 
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void returns_list_of_ingredients_by_recipe() {
		createRecipe(1,"Cheeseburger");
		createRecipe(2,"Chilli dog");
		
		createIngredient(1, "cheese");
		createIngredient(2, "beef");
		createIngredient(3, "chilli");
		createIngredient(4, "hotdog");
		
		saveRecipeIngredients(1, 1);
		saveRecipeIngredients(1, 2);
		saveRecipeIngredients(2, 3);
		saveRecipeIngredients(2, 4);
		
		
		
		
		
		
	}
	
	private void createRecipe(int recipeId, String recipeName) {
		Recipe r = new Recipe();
		r.setRecipeId(recipeId);
		r.setRecipeName(recipeName);
		recipeDAO.addNewRecipe(r);
	}
	
	private void createIngredient(int ingredientId, String ingredientName) {
		Ingredient i = new Ingredient();
		i.setIngredientId(ingredientId);
		i.setIngredientName(ingredientName);
		ingredientDAO.saveIngredient(i);
	}
	
	private void saveRecipeIngredients(int recipeId, int ingredientId) {
		recipeDAO.saveReceipIngredients(recipeId, ingredientId);
	}

}
