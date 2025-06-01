package com.fdmgroup.Bookshop.service;

import com.fdmgroup.Bookshop.model.Book;

public interface BookService {

	Book createBook(Book book);
	Book findBookById(Long id);
	
	Iterable<Book>findAllBooks();
	void deleteBookByTitle(String Title);
	
	Long numberOfBooks();
	
	Book updateBook(Book book);
	
}
