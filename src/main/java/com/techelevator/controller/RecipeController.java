package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.JDBCUserDAO;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDAO;
import com.techelevator.model.UserDAO;

@Transactional
@Controller

public class RecipeController {
	private RecipeDAO recipeDAO; 
	private UserDAO userDAO;
	
	@Autowired
	public RecipeController(RecipeDAO recipeDAO) {
		this.recipeDAO = recipeDAO;
	}
	@RequestMapping(path="/recipeDetails", method=RequestMethod.GET)
	public String displayRecipeDetails() {
		return "recipeDetails";
	}
	
	
	
	
	
}
