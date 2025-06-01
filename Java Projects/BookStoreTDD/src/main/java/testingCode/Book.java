package testingCode;

public class Book {
	

	private double price;
	private String name;
//	private final long ISBN = nextISBN;
//	private static long nextISBN= 9000000;
	
	public Book(String name, double price) {
		this.name=name;
		this.price=price;
//		if (name.equals(name) && price==price) {
//			if (ISBN >= 9000000) {
//				Book.nextISBN+=ISBN+15000;
//		} else {
//			if (ISBN >= 9000000) {
//				Book.nextISBN+=ISBN+15000;} // IN THIS CASE WOULD MAKE A SEPERATE CLASS
//		}
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price= price;
	}

//	public long getISBN() {
//		return ISBN;
//	}
//	
//	public long getnextISBN() {
//		return nextISBN;
//	}
//	
}
