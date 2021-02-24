package edu.poly.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spring.domain.User;

@Controller
@RequestMapping("users")
public class UserController {
	@GetMapping("/new")
	public String showNew() {
		return "users/addOrEdit";
	}
	
//	@RequestMapping(value = {"/article", "/article/{id}"})
//	public Article getArticle(@PathVariable Optional<Integer> optionalArticleId) {
//	    if (optionalArticleId.isPresent()) {
//	        Integer articleId = optionalArticleId.get();
//	        //...trang chi tiet 
//	    } else {
//	        //...trang toan bo
//	    }
//	}
	
	//cach 1
//	@PostMapping("/saveOrUpdate")
//	public String saveOrUpdate(HttpServletRequest request, ModelMap model) {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		return "users/detail";
//	}
	
	//cach 2
//		@PostMapping("/saveOrUpdate")
//		public String saveOrUpdate(ModelMap model,
//				@RequestParam("username") String username,
//				@RequestParam("password") String password){
//			
//			model.addAttribute("username", username);
//			model.addAttribute("password", password);
//			return "users/detail";
//		}
		
		//cach 3
				@PostMapping("/saveOrUpdate")
				public String saveOrUpdate(ModelMap model,User user){
					
					model.addAttribute("username",user.getUsername() + " 90");
					model.addAttribute("password",user.getPassword() + " 90");
					return "users/detail";
				}
				
				// http://localhost:8989/users/edit/Huyhue
				@GetMapping("/edit/{username}")
				public String showEdit(@PathVariable("username") String username) {
					System.out.println("username: "+username);
					return "users/addOrEdit";
				}
}
