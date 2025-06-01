package com.fdmgroup.Bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.Bookshop.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {

	Book findByTitle(String title);
	
	void deleteByTitle(String title);
	
}
