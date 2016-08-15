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
import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeIngredientRecord;
import com.techelevator.model.DAO.IngredientDAO;
import com.techelevator.model.DAO.MealPlanDAO;
import com.techelevator.model.DAO.QuantityDAO;
import com.techelevator.model.DAO.RecipeDAO;
import com.techelevator.model.DAO.RecipeIngredientDAO;
import com.techelevator.model.DAO.UnitDAO;
import com.techelevator.model.DAO.UserDAO;
@Transactional
@Controller
public class UserController {
	
	private UserDAO userDAO;
	private RecipeDAO recipeDAO;
	private IngredientDAO ingredientDAO;
	private UnitDAO unitDAO;
	private QuantityDAO quantityDAO;
	private RecipeIngredientDAO recipeIngredientDAO;
	private MealPlanDAO mealPlanDAO;
	
	@Autowired
	public UserController(UserDAO userDAO, 
						  RecipeDAO recipeDAO, 
						  IngredientDAO ingredientDAO, 
						  UnitDAO unitDAO, 
						  QuantityDAO quantityDAO,
						  RecipeIngredientDAO recipeIngredientDAO,
						  MealPlanDAO mealPlanDAO) {
		this.userDAO = userDAO;
		this.recipeDAO = recipeDAO; 
		this.ingredientDAO = ingredientDAO;
		this.unitDAO = unitDAO;
		this.quantityDAO = quantityDAO;
		this.recipeIngredientDAO = recipeIngredientDAO;
		this.mealPlanDAO = mealPlanDAO;
	}
	
	@RequestMapping(path="/users/{userName}/recipeList", method=RequestMethod.GET)
	public String displayRecipeListByUser(ModelMap model, @PathVariable String userName, @RequestParam int userId) {
		List<Recipe> recipes = recipeDAO.getRecipesByUserId(userId);
		model.put("recipes", recipes);
		return "recipeList";
	}
	
	@RequestMapping(path="/users/{userName}/recipeDetails", method=RequestMethod.GET)
	public String displayRecipeDetails(ModelMap model, @RequestParam int recipeId, @RequestParam int userId, 
										@PathVariable String userName){
		Recipe r = recipeDAO.getRecipeByUserIdAndRecipeId(userId, recipeId);
		//Recipe r = recipeDAO.getRecipeById(recipeId);
		model.put("recipe", r);
		List<Ingredient> ingredients = ingredientDAO.getIngredientDetailsByRecipeId(r.getRecipeId());
		model.put("ingredients", ingredients);
		return "recipeDetails";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.GET)
	public String showLoginPage() {
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
	
	@RequestMapping(path="/users/new", method=RequestMethod.POST)
	public String createUser(@RequestParam String userName, @RequestParam String password) {
		userDAO.saveUser(userName, password);
		return "redirect:/login";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.GET)
	public String displayChangePasswordForm(Map<String, Object> model, @PathVariable String userName) {
		model.put("userName", userName);
		return "changePassword";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.POST)
	public String changePassword(@PathVariable String userName, @RequestParam String password) {
		userDAO.updatePassword(userName, password);
		return "userDashboard";
	}
	
	@RequestMapping(path="/users/{userName}/addNewRecipe", method=RequestMethod.GET)
	public String displaySaveRecipeForm(@PathVariable String userName, ModelMap model) {
		model.put("allIngredients", ingredientDAO.getAllIngredients());
		model.put("allUnits", unitDAO.getAllUnits());
		model.put("allQuantities", quantityDAO.getAllQuantities());
		return "addNewRecipe";
	}
	
	@RequestMapping(path="/users/{userName}/addNewRecipe", method=RequestMethod.POST)
	public String addNewRecipe(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
//							 @RequestParam String recipeName, 
//							 @RequestParam String instructions,
//							 @RequestParam int userId,
//							 @RequestParam int ingredientId1,
//							 @RequestParam int unitId1,
//							 @RequestParam (required=false) int quantityId1,
//							 @RequestParam int ingredientId2,
//							 @RequestParam int unitId2,
//							 @RequestParam (required=false) int quantityId2) {
//		Recipe recipe = new Recipe();
//		recipe.setRecipeName(recipeName);
//		recipe.setInstructions(instructions);
//		recipeDAO.addNewRecipe(recipe, userId);
//		String query = "?userId=" + userId;
//		return "redirect:/users/{userName}/recipeList"+query;
		
		String recipeName = allRequestParams.get("recipeName");
		String instructions = allRequestParams.get("instructions");
		int userId = Integer.valueOf(allRequestParams.get("userId"));
		
		Recipe recipe = new Recipe();
		recipe.setRecipeName(recipeName);
		recipe.setInstructions(instructions);
		recipeDAO.addNewRecipe(recipe, userId);
		int recipeId = recipe.getRecipeId();
		
		for(int i = 0; i < 20; i++) {
			// if requestParam + that index exists (e.g. "ingredientId1", then create a RecipeIngredientRecord out of it
			RecipeIngredientRecord record = new RecipeIngredientRecord();
			boolean recordExists = allRequestParams.containsKey("ingredientId" + i) &&
								   allRequestParams.containsKey("unitId" + i);
			boolean quantityExists = allRequestParams.containsKey("quantityId" + i);
			
			if(recordExists) {
				int ingredientId = Integer.valueOf(allRequestParams.get("ingredientId" + i));
				int unitId = Integer.valueOf(allRequestParams.get("unitId" + i));
				record.setIngredientId(ingredientId);
				record.setUnitId(unitId);
				
				if(quantityExists) {
					int quantityId = Integer.valueOf(allRequestParams.get("quantityId" + i));
					record.setQuantityId(quantityId);
				}
				recipeIngredientDAO.addRecipeIngredientRecordToRecipe(record, recipeId);
			}
		}
		
		String query = "?userId=" + userId;
		return "redirect:/users/{userName}/recipeList" + query;
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
	
	
	@RequestMapping(value = {"/search/", "/search"}, method = RequestMethod.GET)
	public String search(@RequestParam Map<String,String> allRequestParams, ModelMap model) {
	return "viewName";
	}
	
}
