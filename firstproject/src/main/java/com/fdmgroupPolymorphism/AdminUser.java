package com.fdmgroupPolymorphism;

import com.fdmgroupInheritancecExercises.UserAccount;

public class AdminUser extends UserAccount{
	
	private static int minAdminPasswordLength;
	
	public AdminUser (String username, String password, String fullName) {
		super(username, password, fullName);
		
		}
	
	public void accessWebsite() {
		System.out.println("Acessing website with Admin access");
	}
	
	public boolean changePassword(String newPass,String confirmPass) {
//		ArrayList<String> passChars = new ArrayList <String>();
		//passChars.addAll(newPass.split("")); - to add array produced from split 
		//passChars.addAll(confirmPass.split(""));
		
		String[] newPasslist = newPass.split("");
		String[] confirmPassList = confirmPass.split("");
		if (newPass.equals(confirmPass) && newPasslist.length>=minAdminPasswordLength && confirmPassList.length>=minAdminPasswordLength) {
			return super.changePassword(newPass, confirmPass); // to use method from parent class
			} else {
				return false;
			}
	}
		
	public  boolean changePassword(String newPass,String confirmPass,UserAccount user) {
		return user.changePassword(newPass, confirmPass);
		
	}
	
	public void setMinAdminPasswordLength(int minAdminPasswordlength) {
		AdminUser.minAdminPasswordLength= minAdminPasswordLength;
		
	}
	
	public int getMinAdminPasswordLength() {
		return minAdminPasswordLength;
	}
	
	
	
	
}

	

