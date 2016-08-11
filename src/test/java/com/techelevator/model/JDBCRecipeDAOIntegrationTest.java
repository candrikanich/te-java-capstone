package com.techelevator.model;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCRecipeDAOIntegrationTest {
	

	private RecipeDAO recipeDAO;
	private static SingleConnectionDataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	@BeforeClass
	public static void setupDatabase() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		recipeDAO = new JDBCRecipeDAO(dataSource);
	}
	
	@After 
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void save_recipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(10);
		recipe.setRecipeName("Hamburger");
		recipe.setInstructions("Test Instruction for hamburger");
		recipeDAO.saveRecipe(recipe);
		
		
		assertEquals("Hamburger", recipeDAO.getRecipeById(10).getRecipeName());
		
		
		
	}
	

}
