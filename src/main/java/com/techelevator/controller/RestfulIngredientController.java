package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Ingredient;
import com.techelevator.model.DAO.IngredientDAO;
import com.techelevator.model.DAO.RecipeIngredientDAO;

@RestController
public class RestfulIngredientController {

	private IngredientDAO ingredientDAO;
	private RecipeIngredientDAO recipeIngredientDAO;
	
	@Autowired
	public RestfulIngredientController(IngredientDAO ingredientDAO, RecipeIngredientDAO recipeIngredientDAO) {
		this.ingredientDAO = ingredientDAO;
		this.recipeIngredientDAO = recipeIngredientDAO;
	}
	
	@RequestMapping(path="/addIngredientsToRecipe", method=RequestMethod.GET)
	public List<Ingredient> listIngredientsForRecipe() {
		return ingredientDAO.getAllIngredients();
	}
	
	@RequestMapping(path="/removeIngredient", method=RequestMethod.POST)
	public void removeIngredientFromRecipe(@RequestParam int recipeId, 
											@RequestParam int ingredientId, 
											@RequestParam int unitId) {
		recipeIngredientDAO.removeIngredientFromRecipe(recipeId, ingredientId, unitId);
	}
	
}
