package testingCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCheckout {

	@Test
	public void test_CalculatePrice_ReturnsPriceAsADoubleOfZeroPointZero_IfEmptyBasketPassed(){
		Baskets Basket4 =new Baskets();
		Checkout checkout1= new Checkout();
		double CalculatedPrice1= checkout1.calculatePrice(Basket4);
		assertEquals(0.0,CalculatedPrice1,0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfOneBookInBasket_WhenCalledWithBasketWithOneBook() {
		Baskets Basket5 =new Baskets();
		Book Book5=new Book("Six of Crows", 25.99);
		Checkout checkout2= new Checkout();
		
		Basket5.addBook(Book5);
		double calculatedPrice2= checkout2.calculatePrice(Basket5);
		assertEquals(0.0,calculatedPrice2,0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfThreeBookInBasket_MinusOnePercentFromTheTotalPrice() {
		Baskets Basket6 =new Baskets();
		Book Book6=new Book("Six of Crows", 25.99);
		Checkout checkout3= new Checkout();
		
		Book6.setPrice(25.99);
		
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		
		double calculatedPrice3= checkout3.calculatePrice(Basket6);
		assertEquals(77.19,calculatedPrice3,0.01);
	}
	
	@Test 
	public void test_CalculatePrice_ReturnsPriceOfSevenBooksInBasket_TotalPriceMinusTwoPercent(){
		Baskets Basket6 =new Baskets();
		Book Book6=new Book("Six of Crows", 25.99);

		Checkout checkout3= new Checkout();
	
		Book6.setPrice(25.99);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		
		double calculatedPrice4= checkout3.calculatePrice(Basket6);
		assertEquals(178.29, calculatedPrice4, 0.01);
	
	}
	
	@Test
	public void test_CalculatePrice_ReturnPriceOfTenBooksInBasket_MinusThirteenPercentFromTotalPrice() {
		Baskets Basket6 =new Baskets();
		Book Book6=new Book("Six of Crows", 25.99);
		Checkout checkout3= new Checkout();
		
		Book6.setPrice(25.99);;
		
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		Basket6.addBook(Book6);
		
		
		double calculatedPrice4= checkout3.calculatePrice(Basket6);
		assertEquals(226.113, calculatedPrice4, 0.01);
	}
}
