package com.org.StoreBook.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.StoreBook.Entity.MyBooks;
import com.org.StoreBook.Repository.MyBooksRepo;

@Service
public class MyBookDao {

	@Autowired
	MyBooksRepo repo;
	
	public void SaveMybook(MyBooks book) {
		repo.save(book);
	}
	public List<MyBooks> getAllMyBooks(){
		return repo.findAll();
	}
	
	public void DeleteById(int id) {
		repo.deleteById(id);
	}
}
