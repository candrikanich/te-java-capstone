package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.DAO.GroceryListDAO;

@Transactional
@Controller
@SessionAttributes("currentUser")

public class GroceryListController {

	private GroceryListDAO groceryListDAO;
	
	@Autowired
	public GroceryListController(GroceryListDAO groceryListDAO) {
		this.groceryListDAO= groceryListDAO;
	}
	@RequestMapping(path="groceryList", method=RequestMethod.GET)
	public String displayGroceryList() {
		return "groceryList";
	}
	
	
}
