package com.fdmgroupIfStatments;

public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String alienColour = "Green";
		
		if (alienColour.equals("Green")) {
			System.out.println("You just earned 5 points");
		} else if (alienColour.equals("Red")) {
			System.out.println("You just earned 10 points");
		} else if (alienColour.equals("Yellow")) {
			System.out.println("You just earned 15 points");
		} else {
			System.out.println("Invalid Colour");
		}
		
		/// Section 1.4
		
		int age= 3;
		
		if (age < 2) {
			System.out.println("This person is a baby");
		} else if (age>=2 && age < 4){
			System.out.println("This person is a toddler");
		} else if (age>=4 && age < 13) {
			System.out.println("This person is a child");
		} else if (age>=13 && age < 20) {
			System.out.println("This person is a teenager");
		} else if (age>=20 && age < 65) {
			System.out.println("This person is a working age adult");
		} else if (age== 65) {
			System.out.println("This person is a pensioner");
		} else {
			System.out.println("Invalid");
		}
		
		//section 1.5
		
		int salary = 20000;
		
		if (salary<=12500) {
			System.out.println("0% Tax");
		} else if (salary> 12500 && salary<=50000) {
			System.out.println("20% tax");
		} else if (salary> 50000 && salary<=150000) {
			System.out.println( "40% tax");
		} else {
			System.out.println("45% tax");
		}
		
		//section 2
		int accountNumber= 70000000;
		
		if (accountNumber>=10000000 && accountNumber<=99999999) {
			System.out.println("Valid Account Number");
		} else {
			System.out.println("Invalid Account Number");
		}
		
		/// section 2.2
		String flightCode= "FA5432 (Ryanair)";
		String airlineCode= flightCode.substring(0,2);
		
		
		if (airlineCode.equals("LH")|| airlineCode.equals("BA")
				|| airlineCode.equals("FR")) {
			System.out.println("Valid airline");
		} else {
			System.out.println("Invalid airline");
		}
		
		///2.4
		
		if (!airlineCode.equals("LH")&& !airlineCode.equals("BA")
				&& !airlineCode.equals("FR")) {
			System.out.println("Invalid airline"); }
		
		///2.5 
		boolean validPassport= false;
		boolean validDrivingLicence= true;
		
		if (validPassport || validDrivingLicence) {
			System.out.println("ID verified");
		} else {
			System.out.println("Unable to verify ID");
		}
			
		//2.6 
		 boolean hasLicence = true;
		 boolean isDead= false;
		 boolean hasPassedEyeTest =true;
		 
		 //or can write it as if (hasLicence && ! isDead && hasPassedEyeTest)
		 if (hasLicence==true&& isDead==false &&hasPassedEyeTest==true) {
			 System.out.println("can still drive");
		 } else {
			 System.out.println("Cannot drive");
		 }
	
		
	}

}
