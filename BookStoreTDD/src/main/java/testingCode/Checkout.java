package testingCode;

public class Checkout {
	

	public double calculatePrice(Baskets basket) {
		double prices=0.0;
		double newPrices1=0.0;
		boolean sameName= false;
		for (Book eachBook: basket.getBooksInBasket()) {
			prices+= eachBook.getPrice();
			for (Book eachBook2: basket.getBooksInBasket()) {
				if (eachBook2.getName().equals(eachBook.getName())) {
					newPrices1= prices-((prices/100)*50);
					sameName=true;
				} 
			}
//				else {
//					sameName=true;
//				}
		} 
		if (sameName== false) {
		newPrices1= prices-((prices/100)*18);
		}
		if (basket.getBooksInBasket().size() >= 3 && basket.getBooksInBasket().size() < 7 ) {
			newPrices1=prices-((prices/100)*1); 
		} else if (basket.getBooksInBasket().size() >= 7 && basket.getBooksInBasket().size() < 10 ) {
			newPrices1= prices-((prices/100)*2); 
		} else if (basket.getBooksInBasket().size() >= 10) {
			newPrices1= prices-((prices/100)*13);	
		} 
		return newPrices1; 
		} 
	
	
	
	
	
	
	
}
