package fpt.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fpt.com.pojo.Users;
import fpt.com.services.UsersService;

@Controller
public class UserController {

	@Autowired
	public UsersService usersService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegisterView() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request) throws IllegalStateException {
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		Users user = new Users();
		user.setUserEmail(userEmail);
		user.setPassword(password);
		user.setType(type);
		try {
			Users u = usersService.save(user);
			if (u == null) {
				request.setAttribute("getAlert", "yes");
			} else {
				return "redirect:/login";
			}
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLoginView() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest request) throws IllegalStateException {
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		System.out.println("Login: " + userEmail + password + type);
		try {
			Users user = usersService.loginUser(userEmail, password, type);
			System.out.println("Login user: " + user.toString());
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("curUser", user);
				return "redirect:/hotels";
			} else {
				request.setAttribute("getAlert", "yes");
			}
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) throws IllegalStateException {
		HttpSession session = request.getSession(false);
		session.removeAttribute("curUser");
		return "redirect:/hotels";

	}
}
