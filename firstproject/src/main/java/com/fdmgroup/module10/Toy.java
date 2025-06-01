package com.fdmgroup.module10;

public class Toy implements BasketItem {
	
	private int minAge;
	private int maxAge;
	private String name;
	private double price;
	

	public Toy(int minAge,int maxAge, String name, double price) {
		super();
		this.minAge= minAge;
		this.maxAge=maxAge;
		this.name= name;
		this.price= price;
	}

	public int minAge() {
		return minAge;
	}
	
	public int maxAge() {
		return maxAge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price= price;
	}

	
	
	
	
	
	
	
}
