package com.fdmgroupInheritancecExercises;

public class ModuleRunner9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminUser User1= new AdminUser("rosefatima","sara15","Fatima");
		Customer Customer1= new Customer("rosefatima","sara15","Fatima");
		
		AdminUser User2= new AdminUser("nahleahmed", "nahle", "sara22");
		Customer Customer2= new Customer("nahleahmed", "nahle", "sara22");
		
		User1.changePassword("sara89", "sara89");
		User2.accessWebsite();

	}

}
