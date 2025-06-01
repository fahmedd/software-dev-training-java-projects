package com.fdmgroup.module10;

import java.util.ArrayList;

public class Runner10 {

	public static void main(String[] args) {
		
		
		Toy boardgame= new Toy(3,20,"Chess",5.00);
		Toy doll= new Toy(3,20,"Barbie",20.00);
		Laptop laptop1=new Laptop(9000, 500, 30, "Dell", 200.00);
		Snack crisp1= new Snack(700, 20, 50, "hoops", 2.00);
		Snack crisp2= new Snack(200, 30, 40, "Walkers", 2.00);
		ReadyMeal pastaBake= new ReadyMeal(700,"Pasta","Tomato pasta", 3.00);
		ReadyMeal sandWich= new ReadyMeal(500,"Sandwich","Tuna Mayo", 3.50);

//		crisp.setCalories(1000);
//		snackBar.setCalories(200);	
//		
//		sandwich.setCalories(600);
//		pastabake.setCalories(300);
		
		Basket basket1= new Basket(new ArrayList<BasketItem>(), "h", 4.00);
		CalorieCounter count1= new 	CalorieCounter (new ArrayList<FoodItem>());
		
//		BasketItem one = new BasketItem();
		
//		ArrayList<BasketItem> basketItems = new ArrayList<BasketItem>();
		
//		basketItem.add(one);
		
		basket1.addItem(pastaBake);
		basket1.addItem(sandWich);
		basket1.addItem(crisp1);
		basket1.addItem(crisp2);
		basket1.addItem(laptop1);
		basket1.addItem(boardgame);
		basket1.addItem(doll);
		basket1.removeItem(boardgame);
		
		//basket1.getAllItems();
//		for (BasketItem eachItems : basket1.getAllItems()) {
//			System.out.println(eachItems.getName());
//		}
		
//		for (BasketItem eachItems : basket1.getAllItems()) {
//			System.out.println(eachItems.getName());
//		}
//		
		//
		count1.addLowCaloriefood(crisp2);
		count1.addLowCaloriefood(pastaBake);
		count1.addLowCaloriefood(sandWich);
		count1.addLowCaloriefood(crisp1);
//		
		//
		for (FoodItem eachFood : count1.getAllLowCalorieFoods()) {
			System.out.println(eachFood.getCalories());
		}
		
		ArrayList<FoodItem> lowCalorieFoods = count1.getAllLowCalorieFoods();
		
		for (FoodItem eachFoods : lowCalorieFoods) {
			if (eachFoods instanceof Snack) {
				Snack snack1=(Snack)eachFoods;
			}
			
			if (eachFoods instanceof ReadyMeal) {				
				ReadyMeal readymeal1=(ReadyMeal)eachFoods;			
				}
			System.out.println(eachFoods.getName()+" "+eachFoods.getPrice()+" "+eachFoods.getCalories());
			
				}
		
		count1.removeHighCalorieFoodsFromBasket(basket1, 500);
			
		for (BasketItem eachItems : basket1.getAllItems()) {
			System.out.println(eachItems.getName());
		}
		
		
	}

}
