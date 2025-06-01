package com.fdmgroupInheritancecExercises;

public class AdminUser extends UserAccount{
	
	public AdminUser (String username, String password, String fullName) {
		super(username, password, fullName);
		}
	
	public void accessWebsite() {
		System.out.println("Acessing website with Admin access");
	}
}

