package com.fdmgroupJSON;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book implements Comparable<Book>{
	

	private String title;
	private String author;
	private String isbn;
	
	
	public Book() {
		
	}
	
	@JsonCreator
	public Book( @JsonProperty("book-id") String title, @JsonProperty("Author") String author, @JsonProperty("book-isbn") String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public int compareTo(Book book) {
		return this.getTitle().compareTo(book.getTitle());
	}
	
	
	
}

