package com.org.StoreBook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.org.StoreBook.Dao.BookDao;
import com.org.StoreBook.Dao.MyBookDao;
import com.org.StoreBook.Entity.Book;
import com.org.StoreBook.Entity.MyBooks;

@Controller
public class BookController {
	
	@Autowired
	 BookDao dao;
	
	@Autowired
	MyBookDao mydao;

	@GetMapping("/welcome")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String BookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView AvailableBooks() {
		List<Book> list = dao.getallBook();
		ModelAndView mav=new ModelAndView("availableBooks");
		mav.addObject("book", list);
		return mav;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		dao.saveBook(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBooks> listmy=mydao.getAllMyBooks();
		model.addAttribute("book", listmy);
	  return "mybooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book bo = dao.getBookById(id);
		MyBooks mbs=new MyBooks(bo.getId(), bo.getName(), bo.getAuthor(), bo.getPrice());
		mydao.SaveMybook(mbs);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/Editbook/{id}")
	public String EditBook(@PathVariable("id") int id,Model model) {
		Book b = dao.getBookById(id);
		model.addAttribute("book", b);
		return "Edit";
	}
	
	@RequestMapping("/deletebook/{id}")
	public String DeleteBookById(@PathVariable("id") int id) {
		dao.DeleteById(id);
		return "redirect:/available_books";
	}
	
}

