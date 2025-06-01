package testingCode;

public class RunnerBookStore {

	public static void main(String[] args) {
		
		Baskets basket3= new Baskets();
		Book book3= new Book("Six of Crows", 25.99);
		Book book4= new Book("Six of rows", 25.99);
		
		basket3.addBook(book3);
		basket3.addBook(book4);	
		basket3.addBook(book3);
		basket3.addBook(book4);
		
		basket3.addBook(book3);
		basket3.addBook(book3);
		basket3.addBook(book3);
		basket3.addBook(book3);
		basket3.addBook(book3);
		basket3.addBook(book3);
		basket3.addBook(book3);
		basket3.addBook(book4);
		basket3.addBook(book4);
	
		
		Checkout checkout2= new Checkout();
		
		System.out.println(basket3.getBooksInBasket().size());
		System.out.println(checkout2.calculatePrice(basket3));
		System.out.println(book4.getName());
		
		if (book4.getName().equals(book3)) {
			System.out.println("hi");
		} else {
			System.out.println("hello");
		}
	}

}
