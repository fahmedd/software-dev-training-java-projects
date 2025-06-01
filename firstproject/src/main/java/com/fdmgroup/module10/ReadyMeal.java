package com.fdmgroup.module10;

public class ReadyMeal implements BasketItem,FoodItem{
	
	private int calories;
	private String cuisineType;
	private String name;
	private double price;
	
	public ReadyMeal (int calories, String cuisineType, String name, double price) {
		super();
		this.calories= calories;
		this.cuisineType= cuisineType;
		this.name= name;
		this.price= price;
	}
	
	public String getcuisineType() {
		return cuisineType;
	}
	
	public void setcuisineType(String cuisineType) {
		this.cuisineType= cuisineType;
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
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int calories) {
		this.calories= calories;
	}
}
