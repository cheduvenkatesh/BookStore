package com.org.StoreBook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.StoreBook.Dao.MyBookDao;

@Controller
public class MyBooksController {
	
	@Autowired
    MyBookDao dao;
	
	@RequestMapping("/deletemybooks/{id}")
	public String DeleteMyBooks(@PathVariable("id") int id) {
		
		dao.DeleteById(id);
		return "redirect:/my_books";
	}
}
