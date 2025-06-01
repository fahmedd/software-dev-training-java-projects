package com.fdmgroupClassessAndObjects;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HardDrive HardDrive1= new HardDrive("Seagate", 2048);
		HardDrive HardDrive2= new HardDrive("Dell", 3072);
		HardDrive2.setUsedSpace(500);
		
		Processor Processor1= new Processor("Intel XEON", 2.93, 2);
		Processor Processor2= new Processor("Intel Celeron", 2.9, 2);
		
		Memory Memory1= new Memory("Kingston",4,1600);
		Memory Memory2= new Memory("Corsair",8 ,1333);
		
		System.out.println(Memory2.getMODEL());
		System.out.println(Memory1.getMODEL());
		System.out.println(Processor1.getMODEL());
		System.out.println(Processor2.getMODEL());
		System.out.println(HardDrive1.getMODEL());
		System.out.println(HardDrive2.getMODEL());
		
		// or for full thing 
		// System.out.println(drive1.getMODEL()+","
		//+drive1.getCAPACITY()+", "+drive1.getUsedSpace());
		
		
		HardDrive1.setUsedSpace(50);
		System.out.println("Used Driver space" + HardDrive1.getUsedSpace());
	}

}
