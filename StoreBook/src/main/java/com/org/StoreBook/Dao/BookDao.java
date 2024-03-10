package com.org.StoreBook.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.StoreBook.Entity.Book;
import com.org.StoreBook.Repository.BookRepo;

@Service
public class BookDao {

	@Autowired
	BookRepo repo;
	
	public void saveBook(Book b) {
		repo.save(b);
	}
	public List<Book> getallBook(){
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
		return repo.findById(id).get();
	}
	public void DeleteById(int id) {
		repo.deleteById(id);
	}
}
