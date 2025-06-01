package com.fdmgroupPolymorphism;

import java.util.ArrayList;

import com.fdmgroupInheritancecExercises.UserAccount;

public class UserAccountManager {

	private ArrayList <UserAccount> userAccounts;
	
	private ArrayList <UserAccount> getuserAccounts(){
		return userAccounts;
	}
	
	private void setuserAccounts(ArrayList <UserAccount> userAccounts) {
		this.userAccounts= userAccounts;
	}
	
	
	public void addUser(UserAccount user) {
		//ArrayList <UserAccount> UserAccounts.addUser(UserAccounts);
		userAccounts.add(user);
	};
	
	public boolean login(String username, String password) {
		boolean bo = false;
		for (UserAccount eachUser : userAccounts) {
			if ((eachUser.getUsername().equals(username)) && (eachUser.getPassword().equals(password))){
				bo = true;
			}
		}
		return bo;
	}
	
}
