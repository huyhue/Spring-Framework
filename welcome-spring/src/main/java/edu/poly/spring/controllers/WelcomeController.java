package edu.poly.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	public String showForm(HttpServletRequest request) {
		request.setAttribute("name", "HuyTP");
		return "welcome";
	}
}
