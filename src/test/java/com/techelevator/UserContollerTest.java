package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.techelevator.controller.UserAccountController;
import com.techelevator.model.DAO.IngredientDAO;
import com.techelevator.model.DAO.RecipeDAO;
import com.techelevator.model.DAO.UserDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserContollerTest {
	
	private UserAccountController controller;
	private UserDAO userDAO;
	private RecipeDAO recipeDAO;
	private IngredientDAO ingredientDAO;
	private ModelMap model;
	
	@Before
	public void setup() {
		userDAO = mock(UserDAO.class);
		recipeDAO = mock(RecipeDAO.class);
		ingredientDAO = mock(IngredientDAO.class);
		model = mock(ModelMap.class);
		controller = new UserAccountController(userDAO, recipeDAO, ingredientDAO);
	}
	
	@Test
	public void redirects_to_login_page_after_user_creation() {
		String viewName = controller.createUser("mr_rogers", "hello there!");
		assertThat(viewName, equalTo("redirect:/login"));
	}
	
	@Test
	public void creates_user() {
		String userName = "batman";
		String password = "gotham123";
		controller.createUser(userName, password);
		verify(userDAO).saveUser(userName, password);
	}
	
	@Test
	public void redirects_to_dashboard_after_login_authentication() {
		String userName = "robin";
		String displayDashboard = controller.displayDashboard(model, userName);
		assertThat(displayDashboard, equalTo("userDashboard"));
	}
	
	@Test
	public void redirects_to_new_user_form() {
		String newUserForm = controller.displayNewUserForm();
		assertThat(newUserForm, equalTo("newUser"));
	}
	
	@Test
	public void redirects_to_recipe_list() {
		String userName = "superman";
		String recipeList = controller.displayRecipeListByUser(model, userName);
		assertThat(recipeList, equalTo("recipeList")); 
	}
	
	@Test
	public void redirects_to_recipe_details() {
		String userName = "catwoman";
		int recipeId = 1;
		String recipeDetails = controller.displayRecipeDetails(model, recipeId, userName);
		assertThat(recipeDetails, equalTo("recipeDetails"));
	}

}
