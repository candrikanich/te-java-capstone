package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.GroceryList;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.User;
import com.techelevator.model.DAO.GroceryListDAO;

@Controller
@SessionAttributes("currentUser")
public class GroceryListController {

	private GroceryListDAO groceryListDAO;
	
	@Autowired
	public GroceryListController(GroceryListDAO groceryListDAO) {
		this.groceryListDAO= groceryListDAO;
	}
	@RequestMapping(path="/users/{userName}/groceryList", method=RequestMethod.GET)
	public String displayGroceryList(@RequestParam Integer mealPlanId, ModelMap model) {
		
		List<Ingredient> groceryList = groceryListDAO.getAllIngredientsByMealPlan(mealPlanId);
		model.put("groceryList", groceryList);
		
		return "groceryList";
	}
	
}
