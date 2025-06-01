package com.fdmgroupPolymorphism;

public class Modulerunner11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	AdminUser User2= new AdminUser("FatimaA","car123","Fatima A");
	Customer Customer1= new Customer("Fa17", "sara123", "Fatima");
	User2.setMinAdminPasswordLength(10);
	Customer1.setMinCustomerPasswordLength(7);
	
	User2.changePassword("sara1234567","sara1234567");
	Customer1.changePassword("fatima","fatimaa");
	
	System.out.println(User2.getPassword());
	System.out.println(Customer1.getPassword());

	}
	

}