package com.fdmgroupInheritancecExercises;

public abstract class UserAccount {
	private String username;
	private String password;
	private String fullName;

	public UserAccount(String username, String password, String fullName) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
	}

		public boolean changePassword(String newPass, String confirmPass) {
		if (newPass.equals(confirmPass)){
			password = newPass;
			return true;
		}
		if (!newPass.equals(confirmPass)){
			System.out.println("error");
			}
		return false;
		
	}
	
	public abstract void accessWebsite();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFullname() {
		return fullName;
	}
	
	public void setFullname(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPassword () {
		return password;
	}
	
//	public void setPassword(String password) {
//		this.password= password;
//	}
	


}


