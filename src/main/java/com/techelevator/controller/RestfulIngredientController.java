package com.techelevator.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.model.Ingredient;
import com.techelevator.model.DAO.IngredientDAO;

@RestController
public class RestfulIngredientController {

	private IngredientDAO ingredientDAO;
	
	@Autowired
	public RestfulIngredientController(IngredientDAO ingredientDAO) {
		this.ingredientDAO = ingredientDAO;
	}
	
	@RequestMapping(path="/addIngredientsToRecipe", method=RequestMethod.GET)
	public List<Ingredient> listIngredientsForRecipe() {
		return ingredientDAO.getAllIngredients();
	}
	
}
