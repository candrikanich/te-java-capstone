package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.DAO.IngredientDAO;
import com.techelevator.model.DAO.RecipeDAO;
import com.techelevator.model.DAO.UserDAO;

@Transactional
@Controller
public class RecipeController {
	
	private UserDAO userDAO;
	private RecipeDAO recipeDAO; 
	private IngredientDAO ingredientDAO;
	
	@Autowired
	public RecipeController(UserDAO userDAO, RecipeDAO recipeDAO, IngredientDAO ingredientDAO) {
		this.userDAO = userDAO;
		this.recipeDAO = recipeDAO;
		this.ingredientDAO = ingredientDAO;
	}
	@RequestMapping(path="/recipeDetails", method=RequestMethod.GET)
	public String displayRecipeDetails() {
		return "recipeDetails";
	}
	
}
