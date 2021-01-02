package edu.poly.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.poly.spring.model.User;

@Controller
public class HomeController {
	@Autowired
	User user;
	
	@GetMapping("/user")
	public String home() {
		return "home";
	}
	
	@ModelAttribute("user")
	public User getUser() {
		return user;
	}
}
