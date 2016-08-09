package com.techelevator.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Ingredient;
import com.techelevator.model.IngredientDAO;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDAO;
import com.techelevator.model.UserDAO;
@Transactional
@Controller
public class UserController {
	
	private UserDAO userDAO;
	private RecipeDAO recipeDAO;
	private IngredientDAO ingredientDAO;
	
	@Autowired
	public UserController(UserDAO userDAO, RecipeDAO recipeDAO, IngredientDAO ingredientDAO) {
		this.userDAO = userDAO;
		this.recipeDAO = recipeDAO; 
		this.ingredientDAO = ingredientDAO;
	}
	@RequestMapping(path="/users/{userName}/recipeList", method=RequestMethod.GET)
	public String displayRecipeListByUser(ModelMap model, @PathVariable String userName) {
		int userId = userDAO.getUserIdByUsername(userName);
		List<Recipe> recipes = recipeDAO.getRecipesByUserId(userId);
		model.put("recipes", recipes);
		return "recipeList";
	}
	@RequestMapping(path="/users/{userName}/recipeDetails", method=RequestMethod.GET)
	public String displayRecipeDetails(ModelMap model, @RequestParam int recipeId,@PathVariable String userName){
		Recipe r = recipeDAO.getRecipeById(recipeId);
		model.put("recipe", r);
		List<Ingredient> ingredients = ingredientDAO.getIngredientsByRecipeId(recipeId);
		model.put("ingredients", ingredients);
		return "recipeDetails";
		
	}

	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@RequestParam String userName, @RequestParam String password) {
		userDAO.saveUser(userName, password);
		return "redirect:/login";
	}
	
	@RequestMapping(path="/users/{userName}", method=RequestMethod.GET)
	public String displayDashboard(Map<String, Object> model, @PathVariable String userName) {
		
		return "userDashboard";
	}
	
	@RequestMapping(path="/users/new", method=RequestMethod.GET)
	public String displayNewUserForm() {
		return "newUser";
	}
	
}