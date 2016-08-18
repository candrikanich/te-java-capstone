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

import com.techelevator.model.JoinedMealPlanRecipeRecord;
import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;
import com.techelevator.model.DAO.JoinedMealPlanRecipeDAO;
import com.techelevator.model.DAO.MealPlanDAO;
import com.techelevator.model.DAO.MealPlanRecipeDAO;
import com.techelevator.model.DAO.RecipeDAO;

@Transactional
@Controller
public class UserMealPlanController {

	private RecipeDAO recipeDAO;
	private MealPlanDAO mealPlanDAO;
	private MealPlanRecipeDAO mealPlanRecipeDAO;
	private JoinedMealPlanRecipeDAO joinedMealPlanRecipeDAO;
	private static final int NUMBER_ALLOWABLE_MEAL_PLANS = 7;
	
	@Autowired
	public UserMealPlanController(RecipeDAO recipeDAO, 
						  		MealPlanDAO mealPlanDAO,
						  		MealPlanRecipeDAO mealPlanRecipeDAO,
						  		JoinedMealPlanRecipeDAO joinedMealPlanRecipeDAO) {
		this.recipeDAO = recipeDAO; 
		this.mealPlanDAO = mealPlanDAO;
		this.mealPlanRecipeDAO = mealPlanRecipeDAO;
		this.joinedMealPlanRecipeDAO = joinedMealPlanRecipeDAO;
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
		
		List<JoinedMealPlanRecipeRecord> joinedRecipeRecords = joinedMealPlanRecipeDAO.getJoinedRecipeInfoByMealPlanId(m.getMealPlanId());
		model.put("joinedRecipeRecords", joinedRecipeRecords);
		
		return "mealPlanDetails";
	}
	
	@RequestMapping(path="/users/{userName}/createNewMealPlan", method=RequestMethod.GET)
	public String displayCreateMealPlanForm(@PathVariable String userName, ModelMap model, @RequestParam int userId) {
		List<Recipe> userRecipes = recipeDAO.getRecipesByUserId(userId);
		model.put("userRecipes", userRecipes);
		return "createNewMealPlan";
	}
	
	@RequestMapping(path="/users/{userName}/createNewMealPlan", method=RequestMethod.POST)
	public String addMealPlan(@PathVariable String userName, 
							  @RequestParam Map<String, String> allRequestParams) {
		
		int userId = Integer.valueOf(allRequestParams.get("userId"));
		String startDate = allRequestParams.get("mealPlanStartDate");
		
		MealPlan mealPlan = new MealPlan();
		mealPlan.setMealPlanStartDate(startDate);
		mealPlan.setUserId(userId);
		mealPlanDAO.addNewMealPlan(mealPlan);
		
		for(int i = 1; i <= NUMBER_ALLOWABLE_MEAL_PLANS; i++) {
			boolean mealPlanDayExists = allRequestParams.containsKey("mealPlanDay" + i);
			
			if (mealPlanDayExists) {
				int mealPlanId = mealPlan.getMealPlanId();
				int recipeId = Integer.valueOf(allRequestParams.get("mealPlanDay" + i));
				String mealDate = allRequestParams.get("mealDate" + i);
				String mealDayOfWeek = allRequestParams.get("mealDayOfWeek" + i);
				mealPlanRecipeDAO.addRecipeToMealPlan(mealPlanId, recipeId, mealDate, mealDayOfWeek);
			}
		}
		String query = "?userId=" + userId;
		return "redirect:/users/{userName}/mealPlanList" + query;
	}
	
	@RequestMapping(path="/users/{userName}/editMealPlan", method=RequestMethod.GET) 
	public String displayEditMealPlan(ModelMap model,
									  @RequestParam int mealPlanId,
									  @RequestParam int userId,
									  @PathVariable String userName) {
		MealPlan mp = mealPlanDAO.getMealPlanByUserIdAndMealPlanId(userId, mealPlanId);
		model.put("mealPlan", mp);
		
		List<JoinedMealPlanRecipeRecord> joinedRecipeRecords = joinedMealPlanRecipeDAO.getJoinedRecipeInfoByMealPlanId(mealPlanId);
		model.put("joinedRecipeRecords", joinedRecipeRecords);
		
		List<Recipe> recipes = mealPlanDAO.getRecipesByMealPlanId(mealPlanId);
		model.put("recipes", recipes);
		
		return "editMealPlan";
	}
	
	@RequestMapping(path="/users/{userName}/editMealPlan", method=RequestMethod.POST)
	public String addEditedMealPlan(@PathVariable String userName,
								@RequestParam Map<String, String> allRequestParams,
								ModelMap model) {
		
		int userId = Integer.valueOf(allRequestParams.get("userId"));
		int mealPlanId = Integer.valueOf(allRequestParams.get("mealPlanId"));
		
		joinedMealPlanRecipeDAO.removeRecipesFromMealPlan(mealPlanId);
		
		for(int i = 1; i <= NUMBER_ALLOWABLE_MEAL_PLANS; i++) {
			boolean mealPlanDayExists = allRequestParams.containsKey("mealPlanDay" + i);
			
			if (mealPlanDayExists) {
				int recipeId = Integer.valueOf(allRequestParams.get("mealPlanDay" + i));
				String mealDate = allRequestParams.get("mealDate" + i);
				String mealDayOfWeek = allRequestParams.get("mealDayOfWeek" + i);
				mealPlanRecipeDAO.addRecipeToMealPlan(mealPlanId, recipeId, mealDate, mealDayOfWeek);
			}
		}
		
		String query = "?userId=" + userId;
		return "redirect:/users/{userName}/mealPlanList" + query;
	}
	
}
