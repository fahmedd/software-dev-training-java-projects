package com.fdmgroupInheritancecExercises;

public class Customer extends UserAccount{
		
		public Customer (String username, String password, String fullName) {
			super(username, password, fullName);
		}
		
		public void accessWebsite() {
			System.out.println("Acessing Website as Customer");
			
		}
	}
