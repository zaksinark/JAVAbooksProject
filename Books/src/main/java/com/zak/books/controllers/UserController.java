package com.zak.books.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zak.books.models.Login;
import com.zak.books.models.User;
import com.zak.books.services.UserService;


@Controller
@RequestMapping
public class UserController {
	private final UserService userServ;
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/")
	public String loginReg(@ModelAttribute("newUser") User user,@ModelAttribute("login") Login loginUser,HttpSession session) {
		System.out.println(session.getAttribute("user_id"));
		if(session.getAttribute("user_id") != null) {
			return "redirect:/";
		}
		return "Login.jsp";
	}
	
	@PostMapping("/process/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result,Model model,HttpSession session) {
		// to-do
		//		check if the passwords match
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Match", "passwords dont match");
		}
		//		reject if email is taken
		if(userServ.getOne(newUser.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email is already taken");
		}
		if(result.hasErrors()) {
			model.addAttribute("login", new Login());
			return "Login.jsp";
		}
		User newlyCreatedUser = userServ.registerUser(newUser);
		session.setAttribute("user_id", newlyCreatedUser.getId());
		return "redirect:/home";
	}

	@PostMapping("/process/login")
	public String processLogin(@Valid @ModelAttribute("login") Login loginUser, BindingResult result, Model model,HttpSession session) {
		User loggingUser = userServ.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "Login.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	

}