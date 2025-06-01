package com.fdmgroup.Bookshop.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.fdmgroup.Bookshop.exception.TitleException;
import com.fdmgroup.Bookshop.model.Book;
import com.fdmgroup.Bookshop.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImplementation implements BookService {

	private BookRepository bookRepositiory;
	//instead of autowired use constrctior
	
	
	public BookServiceImplementation(BookRepository bookRepositiory) {
		this.bookRepositiory = bookRepositiory;
	}
	
	@Override
	public Book createBook(Book book) {
		if (this.bookRepositiory.findByTitle(book.getTitle()) == null){
		 return this.bookRepositiory.save(book);
		} else {
			throw new TitleException("Title" + book.getTitle()+ "Already in use");
		}
	}
	
	@Override
	public Book findBookById(Long id) {
		// TODO Auto-generated method stub
		return this.bookRepositiory.findById(id).orElse(null);
		//cant find id - return me null
	}

	@Override
	public Iterable<Book> findAllBooks() {
		return this.bookRepositiory.findAll();
	}

	@Override
	public void deleteBookByTitle(String title) {
		this.bookRepositiory.deleteByTitle(title);
		
	}
	
	@Override
	public Long numberOfBooks() {
		return this.bookRepositiory.count();
	}
	
	@Override //same as save method- but must have primary key in the object- main difference with save method
	public Book updateBook(Book book) {
		return this.bookRepositiory.save(book);
		}
	
	
}
