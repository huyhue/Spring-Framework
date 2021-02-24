package edu.poly.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public String showForm(HttpServletRequest request) {
		request.setAttribute("name", "HuyTP");
		return "welcome";
	}
	
	//kieu .../requestParam?user=huy&age=9
	@RequestMapping(value = "requestParam")
	public void testrequestParam(@RequestParam String user, @RequestParam int age) {
		System.out.println("test1: "+user+age);
	}
	
	//kieu .../pathVariable/8/lan
	@RequestMapping(value = "pathVariable/{id}/{name}")
	public void testpathVariable(@PathVariable int id, @PathVariable String name) {
		System.out.println("test2: "+id+name);
	}
}
