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
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeIngredientRecord;
import com.techelevator.model.DAO.IngredientDAO;
import com.techelevator.model.DAO.QuantityDAO;
import com.techelevator.model.DAO.RecipeDAO;
import com.techelevator.model.DAO.RecipeIngredientDAO;
import com.techelevator.model.DAO.UnitDAO;

@Transactional
@Controller
public class UserRecipeController {
	
	private RecipeDAO recipeDAO;
	private IngredientDAO ingredientDAO;
	private UnitDAO unitDAO;
	private QuantityDAO quantityDAO;
	private RecipeIngredientDAO recipeIngredientDAO;
	private static final int NUMBER_ALLOWABLE_INGREDIENTS = 20;
	
	@Autowired
	public UserRecipeController(RecipeDAO recipeDAO, 
						  		IngredientDAO ingredientDAO, 
						  		UnitDAO unitDAO, 
						  		QuantityDAO quantityDAO,
						  		RecipeIngredientDAO recipeIngredientDAO) {
		this.recipeDAO = recipeDAO; 
		this.ingredientDAO = ingredientDAO;
		this.unitDAO = unitDAO;
		this.quantityDAO = quantityDAO;
		this.recipeIngredientDAO = recipeIngredientDAO;
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
		model.put("recipe", r);
		List<Ingredient> ingredients = ingredientDAO.getIngredientDetailsByRecipeId(r.getRecipeId());
		model.put("ingredients", ingredients);
		return "recipeDetails";
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
		String recipeName = allRequestParams.get("recipeName");
		String instructions = allRequestParams.get("instructions");
		int userId = Integer.valueOf(allRequestParams.get("userId"));
		
		Recipe recipe = new Recipe();
		recipe.setRecipeName(recipeName);
		recipe.setInstructions(instructions);
		recipeDAO.addNewRecipe(recipe, userId);
		int recipeId = recipe.getRecipeId();
		
		for(int i = 0; i < NUMBER_ALLOWABLE_INGREDIENTS; i++) {  
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
	
//	@RequestMapping(value = {"/search/", "/search"}, method = RequestMethod.GET)
//	public String search(@RequestParam Map<String,String> allRequestParams, ModelMap model) {
//		return "viewName";
//	}
	
	@RequestMapping(path="/user/{userName}/editRecipe", method=RequestMethod.GET)
	public String displayEditRecipe(){
//			ModelMap model, @RequestParam int recipeId, 
//									@RequestParam int userId, @PathVariable String userName) {
//		Recipe r = recipeDAO.getRecipeByUserIdAndRecipeId(userId, recipeId);
//		model.put("recipe", r);
//		List<Ingredient> recipeIngredients = ingredientDAO.getIngredientDetailsByRecipeId(r.getRecipeId());
//		model.put("recipeIngredients", recipeIngredients);
//		model.put("allIngredients", ingredientDAO.getAllIngredients());
//		model.put("allUnits", unitDAO.getAllUnits());
//		model.put("allQuantities", quantityDAO.getAllQuantities());
		return "editRecipe";
	}
	
}
