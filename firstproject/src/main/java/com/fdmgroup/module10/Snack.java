package com.fdmgroup.module10;

public class Snack implements BasketItem,FoodItem{
	
	private int calories;
	private int fatContent;
	private int sugarContent;
	private String name;
	private double price;
	
	public Snack(int calories, int fatContent, int sugarContent, String name, double price) {
		super();
		this.calories=calories;
		this.fatContent= fatContent;
		this.sugarContent= sugarContent;
		this.name= name;
		this.price= price;
	}
	
	public int fatContent() {
		return fatContent;
	}
	
	public int sugarContent() {
		return sugarContent;
	}
	
	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories= calories;
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
