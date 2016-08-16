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

// BE CAREFUL, this was copied/borrowed/inspired from the uncompleted Tic-Tac-Toe game

@RestController
public class RestfulIngredientController {

	private IngredientDAO ingredientDAO;
	
	@Autowired
	public RestfulIngredientController(IngredientDAO ingredientDAO) {
		this.ingredientDAO = ingredientDAO;
	}
	
	@RequestMapping(path="/addIngredientsToRecipe", method=RequestMethod.GET)
	public List<Ingredient> listIngredients() {
		return ingredientDAO.getAllIngredients();
	}
	
//	@RequestMapping(path="/games", method=RequestMethod.POST)
//	public Ingredient createIngredient(@RequestParam String ingredientName) {
//		Ingredient newIngredient = new Ingredient();
//		newIngredient.setIngredientName(ingredientName);
//		ingredientDAO.saveIngredient(newIngredient);
//		return newIngredient;
//	}

//	@RequestMapping(path="/games/{ingredientId}", method=RequestMethod.GET)
//	public Ingredient getIngredientInfo(@PathVariable Long ingredientId) {
//		return ingredientDAO.getIngredientById(ingredientId);
//	}
	
}
