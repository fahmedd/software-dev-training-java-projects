package com.fdmgroupCollectionsExercise;

import java.awt.Color;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.awt.Color;

public class CollectionsRunner {

	public static void main(String[] args) {
		
		CollectionsExercise exercise1= new CollectionsExercise();
		exercise1.namesMethod("Fatima");
		
		
		System.out.println(exercise1.coloursMethod());
		
		System.out.println(exercise1.duplicateWords("hi my name is sara sara"));
		
		LinkedList<String> list1= new LinkedList<String>();
		list1.add("hi my name is sara sara");
		System.out.println(exercise1.reversedOrder(list1));

		System.out.println(exercise1.tokenize("fatima ahmed is my name"));
		
		
		
		
		
		
		
		
		
	}
	

}
