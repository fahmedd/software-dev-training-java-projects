package testingCode;

import java.util.ArrayList;

public class Baskets {

	private ArrayList<Book> booksinBasket= new ArrayList<Book>();
	
	public ArrayList<Book> getBooksInBasket() {
		return booksinBasket;	
	}

	public void addBook(Book book) {
		booksinBasket.add(book);
		
	}

}
