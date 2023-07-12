package com.zak.books.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zak.books.services.UserService;
import com.zak.books.services.BooksService;


@Controller
public class DashboardController {

	public final UserService userServ;
	public final BooksService bookServ;
	
	public DashboardController(UserService userServ, BooksService bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}
	
	@GetMapping("/home")
	public String dash(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("allBooks", bookServ.getAll());
		model.addAttribute("user", userServ.getOne((Long) session.getAttribute("user_id")));
		return "HomePage.jsp";
	}
}
