package com.alphaone.example.ui.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alphaone.example.ui.book.model.Book;
import com.alphaone.example.ui.book.service.BookServiceImpl;

@Controller
@RequestMapping("/books")
public class BookWebController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@GetMapping
	public String getBooks(Model model) {
		try {
			List<Book> books = bookService.findAll();
			model.addAttribute("books", books);
		} catch (Throwable t) {
			model.addAttribute("error", t.getMessage());
		}
		return "books";
	}	
}
