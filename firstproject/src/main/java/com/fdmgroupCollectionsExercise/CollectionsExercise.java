package com.fdmgroupCollectionsExercise;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsExercise {

	
	public HashSet<String> namesMethod(String...names){
		return new HashSet<String>(Arrays.asList(names));
	}
	
	public HashMap<String,Color> coloursMethod(){
		HashMap<String,Color> colours = new HashMap<String,Color>();
		
		colours.put("Blue", Color.BLUE);
		colours.put("Red", Color.RED);
		colours.put("Green", Color.GREEN);
		colours.put("Magenta", Color.MAGENTA);
		colours.put("Cyan", Color.CYAN);
		colours.put("Yellow", Color.YELLOW);
		colours.put("Black", Color.BLACK);
		colours.put("White", Color.WHITE);
		colours.put("Gray", Color.GRAY);
		colours.put("Dark Gray", Color.DARK_GRAY);
		colours.put("Light Gray", Color.LIGHT_GRAY);
		colours.put("Orange", Color.ORANGE);
		colours.put("Pink", Color.PINK);
		
		 return colours;
	}

	public Map<Character,Integer> getLetterCount(String string){
		string = string.toLowerCase();
		Map<Character,Integer> letterCount = new TreeMap<>(); //storing key-value pairs in sorted order
		
		char[] characters = string.toCharArray();
		
		for (char letter : characters) {
			if (letter < 'a' || letter > 'z') {
				continue;
			}
			
			if (letterCount.containsKey(letter)) {
				int currentCount = letterCount.get(letter);
				letterCount.put(letter, currentCount+1);
			} else {
				letterCount.put(letter, 1);
			}
		}
		/////////////////////////////////////////////////////
		
//		Set<String> chara= new HashSet<String>();
//		//sara
//		//s a r
//		for (String value: string.split(""))
//		{
//			chara.add(value);
//		}
//		
//		ArrayList<String> charstr = new ArrayList<String>(Arrays.asList(splitString));
//		HashMap<String, Integer> repeat = new HashMap<String, Integer>();
//		
//		for (String item: chara)
//		{
//			repeat.put(item,Collections.frequency(charstr, item));
//		}
//		
	
		return letterCount;
//		
		}

	public int duplicateWords(String word){
		word = word.replaceAll("[^a-zA-Z]", " ");
		word = word.replaceAll("( )+", " ");
		word = word.toLowerCase();
		
		String [] noPunctuation= word.split(" ");
		
		ArrayList<String> stringList= new ArrayList(Arrays.asList(noPunctuation));
		Set<String> counter= new HashSet<String>(stringList);
		int counters=0;
		
		
		for (String eachStrings: stringList) {
			int freq= Collections.frequency(stringList,eachStrings);
				
				if (freq >1) {
					counters++;
				}
		} return counters;	
	}

	public LinkedList<String> reversedOrder(LinkedList<String>list){
		LinkedList<String> reversed= new LinkedList<String>(list);
			
		Collections.reverse(reversed);
		
		return reversed ;
	}
	
	
	public TreeSet<String> tokenize(String token) {
		TreeSet<String> tokenized= new TreeSet<String>(Arrays.asList(token.split(" ")));
		
		return tokenized;
	}

	
}
