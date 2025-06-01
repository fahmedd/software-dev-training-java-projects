package com.fdmgroupPolymorphism;

import com.fdmgroupInheritancecExercises.UserAccount;

public class Customer extends UserAccount{
	
		private static int minCustomerPasswordLength;
		
		public Customer (String username, String password, String fullName) {
			super(username, password, fullName);
		}
		
		public void accessWebsite() {
			System.out.println("Acessing Website as Customer");
		}
		
		
		@Override
		public boolean changePassword(String newPass,String confirmPass) {
			String[] newPasslist = newPass.split("");
			String[] confirmPassList = confirmPass.split("");
			if (newPass.equals(confirmPass) && newPasslist.length>=minCustomerPasswordLength && confirmPassList.length>=minCustomerPasswordLength) {
				return super.changePassword(newPass, confirmPass); // to use method from parent class
				} else {
					return false;
				}
		}
		public void setMinCustomerPasswordLength(int minCustomerPasswordLength) {
			Customer.minCustomerPasswordLength = minCustomerPasswordLength;
		}
			
		public int getMinCustomerPasswordLength() {
			return minCustomerPasswordLength;
		}
}
