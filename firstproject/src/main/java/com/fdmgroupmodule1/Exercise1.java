package com.fdmgroupmodule1;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String smallMessage= new String ("Hi, My name is ");
		System.out.println(smallMessage);
		
		String FirstName= new String ("Fatima");
		String LastName= new String ("Ahmed");
		String FullName= new String(FirstName + " " + LastName);
		System.out.println(FullName);
		
		String PersonTwo= new String("Sara");
		String PersonalMessage= new String("Hi " + PersonTwo + " How is your day?");
		System.out.println(PersonalMessage);
		
		System.out.println(FirstName.length());
		System.out.println(FirstName.toUpperCase());
		System.out.println(FirstName.charAt(0));
		System.out.println(LastName.charAt(0));
		
		String NewMessage= new String("this is a sentence");
		System.out.println(NewMessage.length());
		System.out.println(NewMessage.indexOf(" "));
		System.out.println(NewMessage.lastIndexOf(" ")); //Last index of which it is found
		System.out.println(NewMessage.substring(0,4));
		System.out.println(NewMessage.substring(10,18));
		System.out.println(NewMessage.substring(5,9));
		System.out.println(NewMessage.equals("a"));
		//not sure
		System.out.println(NewMessage.equals("x"));
		
		NewMessage= "Is " + NewMessage + "?";
		System.out.println(NewMessage);
		System.out.println(NewMessage.replace("t", "T"));
		
		int FavouriteNumber= 29;
		String YourFavouriteNumber= new String ("Your Favourite Number is= " + FavouriteNumber);
		System.out.println(YourFavouriteNumber);
		
		int NumberOne= 5;
		int NumberTwo= 3;
		System.out.println(NumberOne + NumberTwo);
		int counter= 0;
		counter += 1;
		counter += 5;
		counter -= 1;
		counter -= 2;
		counter *= 2;
		System.out.println(counter);
		
		
		int a= 5;
		int b= 2;
		double c= 5;
		double d= 2;
		
		System.out.println(a/b);
		System.out.println(c/d);
		System.out.println(c/b);
		System.out.println(a/d);
		
		char letter= 'a';
		int code= 98;
		System.out.println((int)letter);
		System.out.println((char)code);
		System.out.println((char)36);
		
		System.out.println((int)'c'-'a');
		System.out.println((int)'z'-'a');
		
		char char1= 'x';
		char char2= 'y';
		char char3= 'z';
		
		String String1= new String ("z");
		String String2= new String ("y");
		
		System.out.println(char1 + char2 + char3);
		System.out.println(char1 + char2 + String2);
		System.out.println(char1 +String1 + char3);
		
		//using "" counts as string whilst '' counts as number
		
		String number1 = new String("5");
		String number2= new String("3");
		
		int NewNumber1= Integer.parseInt(number1);
		int NewNumber2= Integer.parseInt(number2);
		System.out.println(NewNumber1+NewNumber2);
		//need to save into new variables
		
		String number3 = new String("5.3");
		String number4= new String("3.2");
		double NewNumber3= Double.parseDouble(number3);
		double NewNumber4= Double.parseDouble(number4);
		System.out.println(NewNumber3+NewNumber4);
		
		String string1= new String ("abc11");
		String string2= new String ("9xyz");
		String string3= new String ("abc7xyz");
		
		String NewString1= string1.substring(3);
		//or can do .replaceAll("[^a-zA-Z]", ""), ("[0-9]","")
		String NewString2= string2.substring(0,1);
		String NewString3= string3.substring(3,4);
		
		int Newstring1= Integer.parseInt(NewString1);
		int Newstring2= Integer.parseInt(NewString2);
		int Newstring3= Integer.parseInt(NewString3);
		System.out.println(Newstring1+ Newstring2+ Newstring3);
		
		
		
		
		
				
		
		
		
		
		
		
		
		

	}

}
