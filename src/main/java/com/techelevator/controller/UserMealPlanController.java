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

import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;
import com.techelevator.model.DAO.MealPlanDAO;
import com.techelevator.model.DAO.RecipeDAO;

@Transactional
@Controller
public class UserMealPlanController {

	private RecipeDAO recipeDAO;
	private MealPlanDAO mealPlanDAO;
	
	@Autowired
	public UserMealPlanController(RecipeDAO recipeDAO, 
						  		MealPlanDAO mealPlanDAO) {
		this.recipeDAO = recipeDAO; 
		this.mealPlanDAO = mealPlanDAO;
	}
	
	@RequestMapping(path="/users/{userName}/mealPlanList", method=RequestMethod.GET)
	public String displayMealPlanListByUser(ModelMap model, @PathVariable String userName, @RequestParam int userId) {
		List<MealPlan> mealPlans = mealPlanDAO.getMealPlansByUserId(userId);
		model.put("mealPlans", mealPlans);
		return "mealPlanList";
	}
	
	@RequestMapping(path="/users/{userName}/mealPlanDetails", method=RequestMethod.GET)
	public String displayMealPlanDetails(ModelMap model, @RequestParam int mealPlanId, @RequestParam int userId, 
										@PathVariable String userName){
		MealPlan m = mealPlanDAO.getMealPlanByUserIdAndMealPlanId(userId, mealPlanId);
		model.put("mealPlan", m);
		List<Recipe> recipes = mealPlanDAO.getRecipesByMealPlanId(m.getMealPlanId());
		model.put("mealPlanRecipes", recipes);
		return "mealPlanDetails";
	}
	
	@RequestMapping(path="/users/{userName}/createNewMealPlan", method=RequestMethod.GET)
	public String displayCreateMealPlanForm(@PathVariable String userName, ModelMap model, @RequestParam int userId) {
		List<Recipe> userRecipes = recipeDAO.getRecipesByUserId(userId);
		model.put("userRecipes", userRecipes);
		return "createNewMealPlan";
	}
}
