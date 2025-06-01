package Bookstore;

import java.util.ArrayList;

public class Catalogue {
	
	private ArrayList<Book> books;
	private ReadItemCommand command;
	private WriteItemCommand writecommand;

	
	
	public Catalogue(ReadItemCommand command,WriteItemCommand writecommand, ArrayList<Book> books) {
		this.books= books;
		this.command = command;
		this.writecommand= writecommand;
	}
	
	public ArrayList<Book> getAllBooks() {
		return command.readAll();
		
		
	}

	public void addBook(Book book) {
		writecommand.insertItem(book);
		
	}

	public void addBooks(ArrayList<Book> books) {
		for (Book eachBook: books) {
		writecommand.insertItem(eachBook);
		}
		
	}

	public Book getBook(String ISBN) {
		return command.getItem(ISBN); 
		
		
	}

	public void deleteBook(Book book) {
		writecommand.deleteItem(book);
	}

	public void deleteAllBooks() {
		ArrayList<Book> booksToDelete=command.readAll();
		for (Book eachBook: books) {
		writecommand.deleteItem(eachBook);
		}
	}
	

	
}