package com.fdmgroupArraysandArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] BestFriends= {"Ali","Sara","Nahle","Hina","Ghosia"};
		// ArrayList<String> BestFriends= new ArrayList<String>();
		//BestFriends.add("Ali");
		//BestFriends.add("Sara");
		//BestFriends.add("Nahle");
		//BestFriends.add("Hina");
		//BestFriends.add("Ghosia");
		System.out.println(BestFriends.length);
		//System.out.println(BestFriends.size());
		//System.out.println(BestFriends.get(0));
		//System.out.println(BestFriends.get(1));
		//System.out.println(BestFriends.get(2));
		//System.out.println(BestFriends.get(3));
		//System.out.println(BestFriends.get(4));
		
		System.out.println(BestFriends[0]);
		System.out.println(BestFriends[1]);
		System.out.println(BestFriends[2]);
		System.out.println(BestFriends[3]);
		System.out.println(BestFriends[4]);
		
		
		// BestFriends.remove(4);
		BestFriends[4]="Raf";
		//Collections.sort(BestFriends);
		Arrays.sort(BestFriends);
		BestFriends[1]="Null";
		
		//////////// 
		//Section 1.2:
		
		String[] pokerHand= new String[5]; // to specify length
		pokerHand[0]= "Queen of Hearts ";
		pokerHand[1]= ",3 of spades ";
		pokerHand[2]= ",3 of diamonds ";
		pokerHand[3]= ",9 of hearts ";
		pokerHand[4]= ",6 of clubs ";
		System.out.println(pokerHand[0]+ pokerHand[1]+pokerHand[2]+pokerHand[3]+pokerHand[4]);
		
		///////
		//Section 2:
		ArrayList<String> shoppingBasket= new ArrayList<String>();
		shoppingBasket.add("milk");
		shoppingBasket.add("cereals");
		shoppingBasket.add("apples");
		shoppingBasket.add("oranges");
		shoppingBasket.add("bread");
		System.out.println(shoppingBasket.size());
		System.out.println(shoppingBasket.get(0));
		System.out.println(shoppingBasket.get(4));
		shoppingBasket.remove(4);
		System.out.println(shoppingBasket.size());
		
		shoppingBasket.remove(2);
		System.out.println(shoppingBasket.get(0)+shoppingBasket.get(1)+ shoppingBasket.get(2));
		shoppingBasket.add("potatoes");
		shoppingBasket.add("olive oil");
		shoppingBasket.add("chicken");
		Collections.sort(shoppingBasket);
		System.out.println(shoppingBasket.get(0)+ shoppingBasket.get(5));
		
		
		/// Section 2.2
		ArrayList<Integer> salaries= new ArrayList<Integer>();
		salaries.add(75000);
		salaries.add(25000);
		salaries.add(42000);
		salaries.add(30000);
		salaries.add(55000);
		salaries.add(42000);
		salaries.add(39000);
		
		System.out.println(salaries.get(0));
		System.out.println(Collections. max(salaries));
		System.out.println(Collections.min(salaries));
		System.out.println(Collections.frequency(salaries,42000));
		
		Collections.sort(salaries);
		System.out.println(salaries.get(3));
		Collections.reverse(salaries);
		System.out.println(salaries.get(0));
		System.out.println(salaries.get(6));
		
		
		
		
		
		
		
		
		
		
	}

}
