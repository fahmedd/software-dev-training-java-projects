package com.fdmgroupEquals;

public class Module5exercise {

	public int points= getPoints();
	public static String alienColour= "Green";
	
	public static int getPoints() {
		if (alienColour.equals("Green")) {
			return 5; 
		}
		if (alienColour.equals("Red")) {
			return 10;
		} 
		if (alienColour.equals("Yellow")) {
			return 15;
		} 
			return 0;
		}

	
	
	
	public int lastNumber;
	
	public static long sumOfNumbersUpTo(int LastNumber){
		long sumofNumbers=0;
		
		for (int x=1; x <LastNumber; x++) {
			sumofNumbers += x;
		}
		return sumofNumbers;
	}
		
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sumOfNumbersUpTo(5));

		
	}
		

		
}
