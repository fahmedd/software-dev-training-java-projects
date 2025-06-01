package com.fdmgroupForLoops;

import java.util.ArrayList;

public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] courses= {" UNIX"," SQL"," Java"," Python"," Web Apps"};
		
		for (String eachCourse: courses) {
		System.out.println("I love learning"+ eachCourse); 
		} 
		
		/// Section 1.2
		ArrayList<String> courseList = new ArrayList<String>();
		for (String course: courses) {
			courseList.add(course);
		}
	
		//section 1.3
		for (String eachCourses: courseList) {
		System.out.println(eachCourses);
		}
	
		//Section 1.4
		
		ArrayList<Double> prices= new ArrayList<Double>();
		prices.add(4.50);
		prices.add(1.99);
		prices.add(9.75);
		prices.add(3.15);
		prices.add(10.25);
		
		//must create new variable to store the total
		double total =0.0;
		
		for (double Price: prices) {
			total += Price;
		}
		System.out.println(total);
		
		//section 1.5
		double[] pricesArray= new double [5]; //when creating an empty array
		
		int index= 0;  
		
		for (double eachPrices2: pricesArray) {
			pricesArray[index]= eachPrices2;
			index ++;
		}
		
		// section 1.6
		String numberText= new String("10,7,25,3,8");
		String[] numberArray= numberText.split(",");
		
//		int numberTotals= 0;
//		for(String numbertotal:numberArray) {
//			numberTotals += Integer.parseInt(numbertotal);
//		}
//		System.out.println(numberTotals);
//		
		/// Section 1.7
		
		String reversedText="desrever neeb sah txet siht";
		char[] TextArray= reversedText.toCharArray();
		String unreveresedText= "";
		
		for (char text:TextArray) {
			System.out.println(text);
			unreveresedText = text + unreveresedText;
		}
		System.out.println(unreveresedText);
		
		//Section 2
		for (int x=1; x <1000000; x++) {
			//System.out.println(x);
		}
		
		//section 2.2
		long totalMillion=0;
		for (int x=1; x <1000000; x++) {
			totalMillion += x;
		}
		System.out.println(totalMillion);
		
		// section 2.3
		for (int x =1; x <=20; x+=2) {
			System.out.println(x);
		}
	
		// section 2.4
		int multipliedBy3=0;
		for (int x=1; x <=12; x++) {
			multipliedBy3= x *3;
		System.out.println(multipliedBy3);	}
		
		// other ways
		for (int x=1; x<=12; x++) {
			System.out.println( +(x*3));
		}
		
		// other ways
		for (int x= 3; x<=36; x+=3) {
			System.out.println((x/3)+ "x 3 =" + x);
		}
		
		
		//Section 2.5
		int[] scores={25,15,99,75,47,59,82};
		for (int i=1; i<scores.length; i+=2){
			scores[i]++;
		}
		for (int i= 0; i<scores.length; i++) {
			System.out.println(scores[i]); 
		}
		
		//section 2.6
		for (char alphabet= 'b'; alphabet <'z'; alphabet +=2) {
			System.out.println(alphabet);
		}
		
		
		//section 2.7
		for (int i= 2; i<=12; i+=2) {
			System.out.println((i/2)+"x 2="+ i);
		}
		
		for (int i= 12; i<=144; i+=12) {
			System.out.println((i/12)+"x 12="+ i);
		}
		
		// another way
		for (int table = 2; table <=12; table++){
			System.out.println(table+" times table");
			for (int multiple = 1; multiple <=12; multiple++){
				int result = multiple * table;
				System.out.println(multiple+" x "+table+" = "+result);
			}
							
			System.out.println();
		}
		
		//section 3.1
//		int oneMill= 100000;
//		while ((oneMill=1) && (oneMill<=100000)) {
//			int newMill = oneMill + newMill ;
//			System.out.println(newMill++);
//		}
		//sec
		int oneMill2= 0;
		while(oneMill2 <= 1000000)
		{ //System.out.println(oneMill2);
			oneMill2 = oneMill2 +1;
		}
	
		//section 3.2
		char alphabet= 'a';
		while (alphabet <='z') {
			System.out.println(alphabet);
			alphabet++;
		}
		
		// Section 3.3
		int num1=0;
		int num2=1;
		int fibSeq=1;
		while (num2 <= 1000) {
			System.out.println(num1+" ");
			int sumofNumbers= num1+num2;
			num1= num2;
			num2=sumofNumbers;
			}
		
		//Section 4
		String[] cities= {"Glasgow","London", "Birmingham", "Cardiff", "Manchester", "Newcastle"};
		for(String eachCities: cities) {
			String citiesChar = eachCities.substring(0, 1);
			if (citiesChar.equals("B")) {
				System.out.println(eachCities+"- Match");
				break; 
			} else {
				System.out.println(eachCities+"- Does not match");
			}
		} 
		
		//
		int[] numbers= {6, 15, 75, 32, 89, 24, 103, 17, 5, 250, 63, 91};
		for (int eachNumbers:numbers) {
			if (eachNumbers>100) {
				System.out.println(eachNumbers);
				break;
			}
		}
		
		
		
		
		
		
		}
}
