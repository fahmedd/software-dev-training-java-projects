package testingCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestingBaskets {
	
	@Test
	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded(){
		Baskets Basket1 = new Baskets();
		assertEquals(0, Basket1.getBooksInBasket().size());
	}

	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
		Baskets Basket2= new Baskets();
		Book Book1=new Book("Six of Crows", 25.99);
		Basket2.addBook(Book1);
		Basket2.addBook(Book1);
		assertEquals(2,Basket2.getBooksInBasket().size());
	}

	

}
