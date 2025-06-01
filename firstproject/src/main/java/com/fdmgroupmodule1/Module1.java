package com.fdmgroupmodule1;

public class Module1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int age= 21;
		System.out.println("age is " + age);
		
		double price= 100.0;
		System.out.println("price is " + price);
		
		boolean valid=true;
		System.out.println("Valid is " +valid);
		
		age= 22;
		price=150.0;
		
		age+=1; //adds
		age -=1; //minus
		age *= 2; //multiply by 2 
		
		age= age + 1;
		System.out.println(age);
		
		
		long bigage= age;
		System.out.println(bigage);
		
		age = (int)bigage; //LONG - Cant be converted
						// but can be casted 
		System.out.println(age);
		
		String name= new String ("Adrian");
		String name1 = new String ("Adrian");
		
		System.out.println("are they equal " + name.equals(name1));
		System.out.println("length: " + name.length());
		System.out.println("first character" +name.charAt(0));
		System.out.println("whole name" + name.concat("oBrien"));
		System.out.println(name.indexOf("Adr"));
		System.out.println(name.substring(1,4));
		
		System.out.println(age == 45);
		
		System.out.println(name.equals(name1));
		System.out.println(name== name1); // compares object address from memory

	}

}
