package com.fdmgroup.Bookshop.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.Bookshop.model.Book;
import com.fdmgroup.Bookshop.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/books") //localhost:.. allows you to ee all
public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public ResponseEntity<?> saveBook(@Valid @RequestBody Book book, BindingResult bindingResult)//gets the errors
	{
	if(bindingResult.hasErrors()){// if errors with variables like title etc-  {
		Map <String, String> errors = new HashMap<>();
	
		for(FieldError error: bindingResult.getFieldErrors()) {
		errors.put(error.getField(), error.getDefaultMessage());
	}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<>(this.bookService.createBook(book), HttpStatus.CREATED); //201
		
	}

	//local host
	@GetMapping("/{id}") 
	public ResponseEntity<?> findBookById(@PathVariable Long id){
		return new ResponseEntity<>(this.bookService.findBookById(id),HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<?> findAllBooks(){
		return new ResponseEntity<>(this.bookService.findAllBooks(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{title}")
	public ResponseEntity<?> deleteByTitle(@PathVariable String title){
		this.bookService.deleteBookByTitle(title);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/numberOfBooks")
	public ResponseEntity<?> numberOfBooks(){
		return new ResponseEntity<>(this.bookService.numberOfBooks(),HttpStatus.OK);
	}
	
	@PutMapping // when updating need to use primary key- when creating a book itll give it a primarykey
	public ResponseEntity<?>updateBook (@RequestBody Book book){
		return new ResponseEntity<>(this.bookService.updateBook(book), HttpStatus.OK);
	}
}
