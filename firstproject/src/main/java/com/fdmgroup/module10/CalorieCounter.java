package com.fdmgroup.module10;

import java.util.ArrayList;

public class CalorieCounter{

	private ArrayList<FoodItem> lowCalorieFoods;
	
	
	public CalorieCounter(ArrayList<FoodItem> lowCalorieFoods) {
		super();
		this.lowCalorieFoods= lowCalorieFoods;
	}
	
	
	public void addLowCaloriefood(FoodItem foodItem) {
		int amountOfCalories = foodItem.getCalories();
		if (amountOfCalories <= 500) {
			lowCalorieFoods.add(foodItem);
		}
	
	}
	public ArrayList<FoodItem> getAllLowCalorieFoods(){
		return lowCalorieFoods;
	}
	
	
	public void removeHighCalorieFoodsFromBasket(Basket basket, int calories) {
		System.out.println(basket.getAllItems().size());
		ArrayList<BasketItem> b = new ArrayList<>();
		for (BasketItem eachItems : basket.getAllItems()) {
			
			if (eachItems instanceof FoodItem) {

				if (eachItems instanceof Snack) {
				Snack basketItemss= (Snack)eachItems;
					if (basketItemss.getCalories()> calories) {
						b.add(eachItems);} 
				} else if (eachItems instanceof ReadyMeal) {
					ReadyMeal MealItem= (ReadyMeal)eachItems;
						if (MealItem.getCalories()> calories) {
						b.add(eachItems);}			
				}

			}
			
		}
		
		for (BasketItem eachItems2 : b) {
			basket.removeItem(eachItems2);
		}
		
		System.out.println(basket.getAllItems().size());
//			if (eachItems()>=calories) {
//				basket.removeItem(eachItems));
//			}
		//ArrayList<FoodItem> lowCalorieFoods = basket1.getAllLowCalorieFoods();
		//for (Basket eachBasketItem: basket1.getAllItems) {
//			if (eachBasketItem instanceof FoodItem) {
//				BasketItem basketItemss= (BasketItem)eachBasketItem;
//			}
//			
//			if ( eachItems.getAllLowCalorieFoods()>=500) {
//				basket.removeItem());
//			}
//		}
	}

	
}
