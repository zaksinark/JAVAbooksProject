package com.zak.books.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.zak.books.models.Books;
import com.zak.books.services.BooksService;


@Controller
public class BooksController {
	private final BooksService bookServ;
	public BooksController(BooksService bookServ) {
		this.bookServ = bookServ;
	}

	@GetMapping("/create")
	public String createBook(@ModelAttribute("book") Books book,HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
		}
		return "CreateBook.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreateBook(@Valid @ModelAttribute("book") Books book, BindingResult result) {
		if(result.hasErrors()) {
			return "CreateBook.jsp";
		}
		bookServ.create(book);
		return "redirect:/home";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
		return "Edit.jsp";
	}

	@PutMapping("/process/{id}")
	public String processEditBook(@Valid @ModelAttribute("book")Books book, BindingResult result) {
		if(result.hasErrors()) {
			return "Edit.jsp";
		}
		bookServ.update(book);
		return "redirect:/{id}";
	}
	
	@GetMapping("/{id}")
	public String displayOneBook(@PathVariable("id") Long id, Model model) {
		Books book = bookServ.getOne(id);
		model.addAttribute("book", book);
		return "ShowOne.jsp";
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/home";
	}
}
