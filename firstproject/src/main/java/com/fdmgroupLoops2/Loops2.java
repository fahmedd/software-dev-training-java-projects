package com.fdmgroupLoops2;

import java.util.ArrayList;
import java.util.Arrays;

public class Loops2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.1
		String[] ArrayOfCourses= {"UNIX", "SQL", "Java", "Python", "Web Apps"};
		
		for (int i=0; i<ArrayOfCourses.length; i++) {
				System.out.println("I love learning " + ArrayOfCourses[i]);
				}
		
		//1.2 &1.3
		ArrayList<String> coursesList= new ArrayList<String>(Arrays.asList(ArrayOfCourses));
		
		for(String course: coursesList) {
			System.out.println(course);
		}
		
		//or 
		
		ArrayList<String> coursesList2= new ArrayList<String>();
		
		for (int i=0; i<ArrayOfCourses.length; i++) {
			coursesList2.add(ArrayOfCourses[i]);
		}
		
		// or
		for(String course: ArrayOfCourses) {
			coursesList2.add(course);
		}
		
		//1.4
		ArrayList<Double> prices= new ArrayList<Double>();
		prices.add(4.50);
		prices.add(1.99);
		prices.add(9.75);
		prices.add(3.15);
		prices.add(10.25);
		
		double total=0.0;
		for (Double price: prices) {
			total+=price;
		}
		System.out.println(total);
		
		//1.5
		double[] prices2= new double[5];
		
		int index=0;
		for(double eachprices :prices) {
			prices2[index]= eachprices;
			index++;
		}
		System.out.println(prices2[4]);
		
		//1.6
		String numbers= "10,7,25,3,8";
		String[] splitNumbers= numbers.split(",");
		int totals=0;
		for(String eachNumber: splitNumbers) {
			int numberString= Integer.parseInt(eachNumber);
			totals+=numberString;
		}
		System.out.println(totals);
		
		//1.7
		
		
		
		
	}

}
