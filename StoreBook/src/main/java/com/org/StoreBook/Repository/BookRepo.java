package com.org.StoreBook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.StoreBook.Entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
