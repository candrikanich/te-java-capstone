package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.DAO.IngredientDAO;

@Controller
public class HomeController {
	
	private IngredientDAO ingredientDAO;
	
	@Autowired
	public HomeController(IngredientDAO ingredientDAO) {
		this.ingredientDAO = ingredientDAO;
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		return "index";
	}
	
}
