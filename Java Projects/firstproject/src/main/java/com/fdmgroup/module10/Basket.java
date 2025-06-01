package com.fdmgroup.module10;

import java.util.ArrayList;

public class Basket implements BasketItem{
	
	private String name;
	private double price;
	private ArrayList<BasketItem> basketItems;
	
	public Basket(ArrayList<BasketItem> basketItems,String name, double price) {
		super();
		this.name= name;
		this.price= price;
		this.basketItems= basketItems;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	};

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price= price;
	}
	
	public void addItem(BasketItem basketItem) {
		basketItems.add(basketItem);
	}
	
	public void removeItem(BasketItem basketItem ) {
		basketItems.remove(basketItem);
	}
	
	public ArrayList<BasketItem> getAllItems() {
		return basketItems;
	}

}
