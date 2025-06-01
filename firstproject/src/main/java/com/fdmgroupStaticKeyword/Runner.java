package com.fdmgroupStaticKeyword;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(EnergyMatterCalculator.matterToEnergy(2));
		System.out.println(EnergyMatterCalculator.energyToMatter(7));
		
		
		Employee employee1= new Employee();
		Employee employee2= new Employee();
		Employee employee3= new Employee();
		
		Employee.setMinimumWage(9.53);

		employee1.setHourlyWage(7.25);
		employee1.setHourlyWage(7.15);
		employee1.setHourlyWage(10.40);
		
		System.out.println(employee1.getHourlyWage());
		System.out.println(employee2.getHourlyWage());
		System.out.println(employee3.getHourlyWage());
				
	}
}
