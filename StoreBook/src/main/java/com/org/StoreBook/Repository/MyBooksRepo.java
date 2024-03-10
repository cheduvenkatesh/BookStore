package com.org.StoreBook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.StoreBook.Entity.MyBooks;

public interface MyBooksRepo extends JpaRepository<MyBooks, Integer>{

}
