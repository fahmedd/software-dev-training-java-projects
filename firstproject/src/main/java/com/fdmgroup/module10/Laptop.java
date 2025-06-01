package com.fdmgroup.module10;

public class Laptop implements BasketItem {
	
	private double cpuSpeed;
	private double memory;
	private double hardDrive;
	private String name;
	private double price;
	
	public Laptop (double cpuSpeed, double memory, double hardDrive, String name, double price) {
		super();
		this.cpuSpeed= cpuSpeed;
		this.memory= memory;
		this.hardDrive= hardDrive;
		this.name= name;
		this.price= price;
	}
	
	public double cpuSpeed() {
		return cpuSpeed;
	}
	
	public double memory() {
		return memory;
	}
	
	public double hardDrive() {
		return hardDrive;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price= price;
	}
	
	
	
	
	
	
	
	
	
	
}
