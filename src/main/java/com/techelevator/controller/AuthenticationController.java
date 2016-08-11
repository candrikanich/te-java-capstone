package com.techelevator.controller;

import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.User;
import com.techelevator.model.UserDAO;
@Transactional
@Controller
@SessionAttributes({"currentUser", "CSRF_TOKEN"})
public class AuthenticationController {
	
	private UserDAO userDAO;
	private SecureRandom rand = new SecureRandom();
	
	@Autowired
	public AuthenticationController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm() {
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@RequestParam String userName, 
						@RequestParam String password, 
						@RequestParam(required=false) String destination,
						ModelMap model, 
						HttpSession session,
						HttpServletRequest request) {
		if(userDAO.searchForUsernameAndPassword(userName, password)) {
			session.invalidate(); 
			
			model.put("currentUser", userDAO.getCurrentUser(userName, password));
			model.put("CSRF_TOKEN", generateCSRFToken());
			
			if (isValidRedirect(request, destination)) {
				return "redirect:"+destination;
			} else {
				return "redirect:/users/"+userName;				
			}
		} else {
			return "redirect:/login";
		}
	}
	
	private long generateCSRFToken() {
		return rand.nextLong();
	}
	
	private boolean isValidRedirect(HttpServletRequest request, String redirectURL) {
		String protocol = request.getProtocol();
		String host = request.getServerName();
		return  redirectURL != null && 
				redirectURL.equals("") == false && 
				redirectURL.startsWith(protocol+"//"+host);
	}

	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public String logout(ModelMap model, HttpSession session) {
		model.remove("currentUser");
		session.removeAttribute("currentUser");
		return "redirect:/";
	}
}
