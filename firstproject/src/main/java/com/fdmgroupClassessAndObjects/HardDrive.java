package com.fdmgroupClassessAndObjects;

public class HardDrive {
		
	private final String MODEL;
	private final double CAPACITY;
	private double usedSpace;
	
	public HardDrive(String mODEL, double capacity) {
		super();
		MODEL = mODEL;
		CAPACITY = capacity;
	}
	
	public String readData(String file) {
		return "data from" + file; 
	}
	
	public void writeData(String data, String file) {
		System.out.println("writing "+data+" to "+file);
	}
	
	// getters and setters
	public double getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(double usedSpace) {
		this.usedSpace = usedSpace;
	}

	public String getMODEL() {
		return MODEL;
	}

	public double getCAPACITY() {
		return CAPACITY;
	}
		
		
}
