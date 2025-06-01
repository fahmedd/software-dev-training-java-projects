package com.fdmgroup.Bookshop.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="Invalid title")
	@Size(min=5, max=200,message="Invalid title")
	@Column(unique= true)// database table layer validation
	private String title;
	
	private String author;
	private String isbn;
	
	@DecimalMin(value= "0.1", inclusive=false)
	@Digits(integer=3, fraction= 2) //999.99 int-3 fract-2 After decimal
	private BigDecimal price;
	private LocalDate publishDate;
	
	
	@PrePersist
	public void preInsert() {
		this.isbn= UUID.randomUUID().toString();
		this.publishDate= LocalDate.now();
				
	}

	public Book() {
		super();
	}
	public Book(String title, String author, String isbn, BigDecimal price, LocalDate publishDate) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
}
